package org.as.iban.impl;

import java.util.Locale;

import org.as.iban.Iban;
import org.as.iban.exception.IbanException;

class BbanImpl {
    
    private static final int BANKIDENT_GERMAN_LENGTH = 8;
    private static final int KTOIDENT_GERMAN_LENGTH = 10;
    
    private String bankIdent;
    private String ktoIdent;
    private String country;
    
    BbanImpl (String country, String bban) throws IbanException{
	this.country = country.toUpperCase(Locale.ENGLISH);
	switch (country) {
	case Iban.COUNTRY_CODE_GERMAN:
	    this.bankIdent = bban.substring(0, BANKIDENT_GERMAN_LENGTH);
	    this.ktoIdent = bban.substring(BANKIDENT_GERMAN_LENGTH, bban.length());
	    break;
	default:
    	    throw new IbanException(IbanException.IBAN_EXCEPTION_UNSUPPORTED_COUNTRY);
	}
    }
    
    BbanImpl (String country, String bankIdent, String ktoIdent) throws IbanException {
	this.country = country.toUpperCase(Locale.ENGLISH);
	buildBban(bankIdent, ktoIdent);
    }

    private String getBankIdent() {
        return bankIdent;
    }

    private void setBankIdent(String bankIdent) {
        this.bankIdent = bankIdent;
    }

    private String getKtoIdent() {
        return ktoIdent;
    }

    private void setKtoIdent(String ktoIdent, int length) {
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
	switch (country) {
    	case Iban.COUNTRY_CODE_GERMAN:
    	    if (bankIdent.length() != BANKIDENT_GERMAN_LENGTH)
    		throw new IbanException(IbanException.IBAN_EXCEPTION_MESSAGE_BANK_LENGTH);
    	    else
    		setBankIdent(bankIdent);
    	    
    	    if (ktoIdent.length() > KTOIDENT_GERMAN_LENGTH)
    		throw new IbanException(IbanException.IBAN_EXCEPTION_MESSAGE_KTO_LENGTH);
    	    else 
    		setKtoIdent(ktoIdent, KTOIDENT_GERMAN_LENGTH);
    	    break;
    	default:
    	    throw new IbanException(IbanException.IBAN_EXCEPTION_UNSUPPORTED_COUNTRY);
	}
    }

}
