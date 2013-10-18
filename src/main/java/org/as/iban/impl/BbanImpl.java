package org.as.iban.impl;

import java.util.Locale;

import org.as.iban.Iban;
import org.as.iban.exception.IbanException;

class BbanImpl {
    
    private String bankIdent;
    private String ktoIdent;
    private String country;
    private BankGermanImpl bankGerman;

    IbanFormatImpl ibanFormat;
    
    private final int BANKIDENT_LENGTH;
    private final int KTOIDENT_LENGTH;
    
    BbanImpl (String country, String bban) throws IbanException{
	ibanFormat = new IbanFormatImpl(country);
	BANKIDENT_LENGTH = ibanFormat.getBankIdentLength();
	KTOIDENT_LENGTH = ibanFormat.getKtoIdentLength();
	
	this.country = country.toUpperCase(Locale.ENGLISH);
	this.bankIdent = bban.substring(0, BANKIDENT_LENGTH);
	this.ktoIdent = bban.substring(BANKIDENT_LENGTH, bban.length());
	if (country == Iban.COUNTRY_CODE_GERMAN)
	    this.bankGerman = new BankGermanImpl(bankIdent);
    }
    
    BbanImpl (String country, String bankIdent, String ktoIdent) throws IbanException {
	ibanFormat = new IbanFormatImpl(country);
	BANKIDENT_LENGTH = ibanFormat.getBankIdentLength();
	KTOIDENT_LENGTH = ibanFormat.getKtoIdentLength();

	this.country = country.toUpperCase(Locale.ENGLISH);
	buildBban(bankIdent, ktoIdent);
	if (country == Iban.COUNTRY_CODE_GERMAN)
	    this.bankGerman = new BankGermanImpl(bankIdent);
    }

    private String getBankIdent() {
        return bankIdent;
    }

    public String getBic() {
	return bankGerman.getBic();
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
