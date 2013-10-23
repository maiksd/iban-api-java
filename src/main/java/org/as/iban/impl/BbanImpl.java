package org.as.iban.impl;

import java.util.LinkedList;
import java.util.Locale;

import org.as.iban.Iban;
import org.as.iban.exception.IbanException;
import org.as.iban.model.BankGerman;
import org.as.iban.model.IbanFormat;
import org.as.iban.model.IbanRuleGerman;

class BbanImpl {
    
    private String bankIdent;
    private String ktoIdent;
    private String country;
    private BankGerman bankGerman;

    IbanFormat ibanFormat;
    
    private final int BANKIDENT_LENGTH;
    private final int KTOIDENT_LENGTH;
    
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
    
    BbanImpl (String country, String bankIdent, String ktoIdent) throws IbanException {
	ibanFormat = new IbanFormat(country);
	BANKIDENT_LENGTH = ibanFormat.getBankIdentLength();
	KTOIDENT_LENGTH = ibanFormat.getKtoIdentLength();

	this.country = country.toUpperCase(Locale.ENGLISH);
	if (country == Iban.COUNTRY_CODE_GERMAN)
	    this.bankGerman = new BankGerman(bankIdent);
	buildBban(bankIdent, ktoIdent);
    }

    private String getBankIdent() {
        return bankIdent;
    }

    public LinkedList getBic() {
	return bankGerman.getBic();
    }
    
    private void setBankIdent(String bankIdent) {
        this.bankIdent = bankIdent;
    }

    private String getKtoIdent() {
        return ktoIdent;
    }

    private void setKtoIdent(String ktoIdent, int length) {
	// Consider Iban rules for Germany
	if (country == Iban.COUNTRY_CODE_GERMAN) {
	    // Only not standard rules
	    String ruleId = bankGerman.getRule();
	    if (!ruleId.equals("000000")){
		
		IbanRuleGerman rule = new IbanRuleGerman("_" + ruleId);

		if (rule.isNoCalculation(bankIdent)){
		    // check Excluded accounts
		    for (int i = 0; i < rule.getRegexpNoCalculation(bankIdent).size(); i++) {
			if (ktoIdent.matches(rule.getRegexpNoCalculation(bankIdent).get(i)))
			    throw new IbanException(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION);
		    }
		}
		
		if (rule.isMappingKto(bankIdent)){
		    if (rule.getMappedKto(bankIdent, ktoIdent) != null)
			ktoIdent = rule.getMappedKto(bankIdent, ktoIdent);
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
