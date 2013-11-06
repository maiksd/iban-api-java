/***
 * 2013-10-xx	RG: new
 */

package org.as.iban.impl;

import java.util.LinkedList;
import java.util.Locale;

import org.as.iban.Iban;
import org.as.iban.exception.IbanException;
import org.as.iban.model.BankGerman;
import org.as.iban.model.IbanFormat;
import org.as.iban.model.IbanRuleGerman;

/**
 * Represents the basic bank account number (Bban)
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
class BbanImpl {
    
	//	local variables
    private String bankIdent;
    private String ktoIdent;
    private String country;
    private BankGerman bankGerman;
    private IbanRuleGerman ruleGerman;
    IbanFormat ibanFormat;
    
    private final int BANKIDENT_LENGTH;
    private final int KTOIDENT_LENGTH;
    
    /**
     * Constructor which sets information for validation.
     * @param country	The country of the bank account.
     * @param bban		The given bban which should be validated.
     * @throws IbanException
     */
    BbanImpl (String country, String bban) throws IbanException{
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
     * Constructor which sets information for generation.
     * @param country		The country of the bank account.
     * @param bankIdent		The bank ident number.
     * @param ktoIdent		The account number.
     * @throws IbanException
     */
    BbanImpl (String country, String bankIdent, String ktoIdent) throws IbanException {
	ibanFormat = new IbanFormat(country);
	BANKIDENT_LENGTH = ibanFormat.getBankIdentLength();
	KTOIDENT_LENGTH = ibanFormat.getKtoIdentLength();
	
	this.country = country.toUpperCase(Locale.ENGLISH);
	if (country == Iban.COUNTRY_CODE_GERMAN) {
	    this.bankGerman = new BankGerman(bankIdent);
	    this.ruleGerman = bankGerman.getIbanRule();
	}
	buildBban(bankIdent, ktoIdent);
    }

    /**
     * Gets the bank ident.
     * @return	The bank ident number as String.
     */
    private String getBankIdent() {
        return bankIdent;
    }

    /**
     * Gets the BICs of the bank.
     * @return	A LinkedList of BICs.
     */
    public String getBic() {
    	return bankGerman.getBic();
    }
    
    /**
     * Sets the bank ident number
     * @param bankIdent	The bank ident number.
     */
    private void setBankIdent(String bankIdent) {
	this.bankIdent = bankIdent;
    }

    /**
     * Gets the account number.
     * @return	The account number as String.
     */
    private String getKtoIdent() {
        return ktoIdent;
    }

    /**
     * Sets the account number. There are some validations and mappings.
     * @param ktoIdent	The account number
     * @param length	How long should the account number be.
     */
    private void setKtoIdent(String ktoIdent, int length) {
	// Consider Iban rules for Germany
	if (country == Iban.COUNTRY_CODE_GERMAN) {
	    // Only not standard rules
	    String ruleId = bankGerman.getRuleId();
		    
	    if (ruleId.equals("000100"))
		throw new IbanException(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION);
		    
	    if (!ruleId.equals("000000")){
		// Remove leading '0'
		ktoIdent = ktoIdent.replaceAll("\\b[0]{1,9}(\\d*)\\Z", "$1");
				
		if (ruleGerman.isNoCalculation(bankIdent)){
		    // check Excluded accounts
		    for (int i = 0; i < ruleGerman.getRegexpNoCalculation(bankIdent).size(); i++) {
			if (ktoIdent.matches(ruleGerman.getRegexpNoCalculation(bankIdent).get(i)))
			    throw new IbanException(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION);
		    }
		}
				
		// Account mapping
		if (ruleGerman.isMappingKto(bankIdent)){
		    if (ruleGerman.getMappedKto(bankIdent, ktoIdent) != null)
			ktoIdent = ruleGerman.getMappedKto(bankIdent, ktoIdent);
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

    @Override
    public String toString() {
    	return bankIdent + ktoIdent;
    }
    
    /**
     * Builds the bban code.
     * @param bankIdent	The given bank ident.
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
