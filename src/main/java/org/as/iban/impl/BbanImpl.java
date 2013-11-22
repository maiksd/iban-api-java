/*
   Copyright 2013 AVENTUM SOLUTIONS GmbH (www.aventum-solutions.de)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.as.iban.impl;

import java.util.Locale;

import org.as.iban.Iban;
import org.as.iban.exception.IbanException;
import org.as.iban.model.BankGerman;
import org.as.iban.model.IbanFormat;
import org.as.iban.model.IbanRuleGerman;

/**
 * Represents the basic bank account number (BBan)
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
class BbanImpl {
    
	//	local variables
    private String bankIdent;
    private String ktoIdent;
    private String country;
    private BankGerman bankGerman = null;
    private IbanRuleGerman ruleGerman;
    IbanFormat ibanFormat;
    
    private final int BANKIDENT_LENGTH;
    private final int KTOIDENT_LENGTH;
    
    /**
     * Constructor setting up the BBan for a specific country
     * @param country	The country code of the bank
     * @param bban		The given BBan (Basic Bank account number)
     * @throws IbanException
     */
    protected BbanImpl (String country, String bban) throws IbanException{
	ibanFormat = new IbanFormat(country);
	BANKIDENT_LENGTH = ibanFormat.getBankIdentLength();
	KTOIDENT_LENGTH = ibanFormat.getKtoIdentLength();
		
	this.country = country.toUpperCase(Locale.ENGLISH);
	this.bankIdent = bban.substring(0, BANKIDENT_LENGTH);
	this.ktoIdent = bban.substring(BANKIDENT_LENGTH, bban.length());
	if (country.equals(Iban.COUNTRY_CODE_GERMAN))
	    this.bankGerman = new BankGerman(bankIdent);
    }
    
    /**
     * Constructor setting up the BBan from the given parameters
     * @param country		The country of the bank
     * @param bankIdent		The bank identifier number
     * @param ktoIdent		The account number
     * @throws IbanException
     */
    protected BbanImpl (String country, String bankIdent, String ktoIdent) throws IbanException {
	ibanFormat = new IbanFormat(country);
	BANKIDENT_LENGTH = ibanFormat.getBankIdentLength();
	KTOIDENT_LENGTH = ibanFormat.getKtoIdentLength();
	
	this.country = country.toUpperCase(Locale.ENGLISH);
	if (country.equals(Iban.COUNTRY_CODE_GERMAN)) {
	    this.bankGerman = new BankGerman(bankIdent);
	    this.ruleGerman = bankGerman.getIbanRule();
	}
	buildBban(bankIdent, ktoIdent);
    }

    /**
     * Get the bank identifier
     * @return	The bank identifier as String
     */
    public String getBankIdent() {
        return bankIdent;
    }

    /**
     * Get the bank object of the specific german bank
     * @return	The bank object of the specific german bank, otherwise null
     */
    protected BankGerman getBankGerman() {
	return this.bankGerman;
    }

    /**
     * Set the bank identifier number
     * @param bankIdent	The bank identifier number
     */
    private void setBankIdent(String bankIdent) {
	this.bankIdent = bankIdent;
    }

    /**
     * Get the account number
     * @return	The account number as String
     */
    public String getKtoIdent() {
        return ktoIdent;
    }

    /**
     * Set the account number. There are some validations and mappings for german banks
     * @param ktoIdent	The account number
     * @param length	The max length of the account number
     * @throws IbanException 
     */
    private void setKtoIdent(String ktoIdent, int length) throws IbanException {
	// Consider Iban rules for Germany
	if (country.equals(Iban.COUNTRY_CODE_GERMAN)) {
	    // Only not standard rules
	    String ruleId = bankGerman.getRuleId();

	    if (ruleId.equals("000100"))
		throw new IbanException(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION);
		    
	    if (!ruleId.equals("000000")){
		// Remove leading '0'
		ktoIdent = ktoIdent.replaceAll("\\b[0]{1,9}(\\d*)\\Z", "$1");
				
		if (ruleGerman.isNoCalculation(bankIdent)){
		    // check Excluded accounts
		    for (int i = 0; i < ruleGerman.getRegexpNoCalculation(bankIdent).size(); i++) {
			if (ktoIdent.matches(ruleGerman.getRegexpNoCalculation(bankIdent).get(i)))
			    throw new IbanException(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION);
		    }
		}
				
		// Account mapping
		if (ruleGerman.isMappingKto(bankIdent)){
		    // remember the unmapped account number
		    String ktoIdentOld = ktoIdent;
		    if (ruleGerman.getMappedKto(bankIdent, ktoIdent) != null) 
			ktoIdent = ruleGerman.getMappedKto(bankIdent, ktoIdent);
		    
		    // in case of new bank identifier for account number set it here
		    if (ruleGerman.getMappedBlz(bankIdent, ktoIdentOld) != null) {
			setBankIdent(ruleGerman.getMappedBlz(bankIdent, ktoIdentOld));
			bankGerman.setBlz(bankIdent);
		    }
		}
				
		// KtoKr Mapping
		if (ruleGerman.isMappingKtoKr(ktoIdent)) {
		    if (ruleGerman.getMappedKtoKr(ktoIdent) != null) {
			setBankIdent(ruleGerman.getMappedKtoKr(ktoIdent));
			bankGerman.setBlz(bankIdent);
		    }
		}
				
		// BLZ mapping
		if (ruleGerman.isMappingBlz(bankIdent)) {
		    if (ruleGerman.getMappedBlz(bankIdent) != null)
			setBankIdent(ruleGerman.getMappedBlz(bankIdent));
		    	bankGerman.setBlz(bankIdent);
		}
				
		// Kto Modification
		if (ruleGerman.isModification(bankIdent)) {
		    for (int i = 0; i < ruleGerman.getRegexpModification(bankIdent).size(); i++) {
			String[] segs = ruleGerman.getRegexpModification(bankIdent).get(i).split(";");
			ktoIdent = ktoIdent.replaceAll(segs[0], segs[1]);
		    }
		}
	    }
	}
		
	if (ktoIdent.length() < length){
	    for (int i = ktoIdent.length(); i < length; i++)
		ktoIdent = "0" + ktoIdent;
	}
	        
	this.ktoIdent = ktoIdent;
    }

    /** Return the String representation of the BBan
     * @return The String representation of the BBan (format: bank identifier + account number)
     */
    public String toString() {
    	return bankIdent + ktoIdent;
    }
    
    /**
     * Build the BBan code.
     * @param bankIdent	The given bank identifier
     * @param ktoIdent	The given account number
     * @throws IbanException
     */
    private void buildBban (String bankIdent, String ktoIdent) throws IbanException {
	if (bankIdent.length() != BANKIDENT_LENGTH)
	    throw new IbanException(IbanException.IBAN_EXCEPTION_MESSAGE_BANK_LENGTH);
	else
	    setBankIdent(bankIdent);

	if (ktoIdent.length() > KTOIDENT_LENGTH)
	    throw new IbanException(IbanException.IBAN_EXCEPTION_MESSAGE_KTO_LENGTH);
	else 
	    setKtoIdent(ktoIdent, KTOIDENT_LENGTH);
    }
}
