package org.as.iban.impl;

import java.util.Locale;

import org.as.iban.Iban;
import org.as.iban.exception.IbanException;

public class IbanImpl implements Iban {
    
    private String country;
    private String checkDigit;
    private BbanImpl bban;

    public IbanImpl(String ibanString) throws IbanException{
	this.setCountry(ibanString);
	this.setCheckDigit(ibanString);
	this.setBban(new BbanImpl(country, ibanString.substring(4, ibanString.length())));
    }

    public IbanImpl(String country, String bankIdent, String ktoIdent) throws IbanException{
	this.country = country;
	this.bban = new BbanImpl(country, bankIdent, ktoIdent);
	this.checkDigit = "00";
	this.generate();
    }

    @Override
    public boolean validate() throws IbanException {
	validateFormat();
	String ascii = asciiToNumber(shiftIbanToString());
	if (mod97(ascii) == 1)
	    return true;
	else
	    return false;
    }

    @Override
    public void generate() {
	String ascii = asciiToNumber(shiftIbanToString());
	checkDigit = String.valueOf(98 - mod97(ascii));
	if (checkDigit.length() == 1)
	    checkDigit = "0" + checkDigit;
    }
    
    @Override
    public String toString() {
	return this.country + this.checkDigit + this.bban.toString();
    }

    private int length() {
	return this.country.length() + this.checkDigit.length() + this.bban.toString().length();
    }
    
    private String shiftIbanToString() {
	return bban.toString() + country + checkDigit;
    }

    private String asciiToNumber(String shiftedIban){
	char ch;
	String tmpStr = ""; 
	
	shiftedIban.toUpperCase(Locale.ENGLISH);
	
	for (int i=0; i <= shiftedIban.length() - 1; i++) {
	    ch = shiftedIban.charAt(i);
	    
	    if ((int)ch >= 48 && (int)ch <= 57)
		tmpStr = tmpStr + ch;
	    
	    if ((int)ch >= 65 && (int)ch <= 90)
		tmpStr = tmpStr + ((int)ch - 55);
		
	}
	return tmpStr;
    }
    
    private int mod97 (String modString) {
	String part = "";
	int modPart;
	
	for (int i = 0; i < modString.length(); i++){
	    if (part.length() < 9)
		part = part + modString.charAt(i);
	    else {
		modPart = (int)Long.parseLong(part)%97;
		part = Integer.toString(modPart) + modString.charAt(i);
	    }
	}
	
	return (int)Long.parseLong(part)%97;
    }

    private void setCountry(String ibanString) {
	this.country = ibanString.substring(0, 2).toUpperCase(Locale.ENGLISH);
    }

    private void setCheckDigit(String ibanString) {
        this.checkDigit = ibanString.substring(2, 4);
    }

    private void setBban(BbanImpl bban) {
        this.bban = bban;
    }
 
    private void validateFormat() throws IbanException {
	switch (country){
	case Iban.COUNTRY_CODE_GERMAN:
	    if (!this.toString().matches("DE\\d{2}\\d{8}\\d{10}"))
		throw new IbanException(IbanException.IBAN_EXCEPTION_MESSAGE_FORMAT);
	    break;
	default:
	    
	}
    }
}
