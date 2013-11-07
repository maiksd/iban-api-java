package org.as.iban.impl;

import java.util.Locale;

import org.as.iban.Iban;
import org.as.iban.exception.IbanException;
import org.as.iban.model.IbanFormat;

/**
 * Implements the @see org.as.iban.Iban interface
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
public class IbanImpl implements Iban {
    
	//	local variables
    private String country;
    private String checkDigit;
    private BbanImpl bban;

    /**
     * Constructor for validating a given IBAN
     * @param ibanString	A iban-code with format "country-code|checkdigit|bank-ident|kto-ident", for example "DE62701500000020228888"
     * @throws IbanException
     */
    public IbanImpl(String ibanString) throws IbanException{
	this.setCountry(ibanString);
	this.setCheckDigit(ibanString);
	this.setBban(new BbanImpl(country, ibanString.substring(4, ibanString.length())));
    }

    /**
     * Constructor generating the IBAN for a specific country with the given bank identifier and account number
     * @param country		The country code
     * @param bankIdent		The bank identifier
     * @param ktoIdent		The account number
     * @throws IbanException
     */
    public IbanImpl(String country, String bankIdent, String ktoIdent) throws IbanException{
	this.country = country;
	this.bban = new BbanImpl(country, bankIdent, ktoIdent);
	this.checkDigit = calcCheckDigit(bban);
    }

    /* (non-Javadoc)
     * @see org.as.iban.Iban#validate()
     */
    public boolean validate() throws IbanException {
	validateFormat();
	if (country.equals(Iban.COUNTRY_CODE_GERMAN)) {
	    BbanImpl bbanTmp = new BbanImpl(country, bban.getBankIdent(), bban.getKtoIdent());
	    String checkDigitTmp = calcCheckDigit(bbanTmp);
	    if (this.checkDigit.equals(checkDigitTmp))
		return true;
	    else
		return false;
	}
	else {
	    String ascii = asciiToNumber(shiftIbanToString(bban, this.checkDigit));
	    if (mod97(ascii) == 1)
		return true;
	    else
		return false;
	}
    }

    /**
     * @param bban	The BBan (local bank identifier and account number)
     * @return		The check digit for the IBAN
     * @throws IbanException
     */
    private String calcCheckDigit(BbanImpl bban) throws IbanException {
	String checkDigit = "00";
	String ascii = asciiToNumber(shiftIbanToString(bban, checkDigit));
	checkDigit = String.valueOf(98 - mod97(ascii));
	if (checkDigit.length() == 1)
	    checkDigit = "0" + checkDigit;
	
	return checkDigit;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	return this.country + this.checkDigit + this.bban.toString();
    }

    /* (non-Javadoc)
     * @see org.as.iban.Iban#getBic()
     */
    public String getBic() {
    	return bban.getBankGerman().getBic();
    }
    
    /**
     * Generates the shifted iban code (bank-ident|kto-ident|country-code|check-digit)
     * @param bban 
     * @return The shifted code
     */
    private String shiftIbanToString(BbanImpl bban, String checkDigit) {
    	return bban.toString() + country + checkDigit;
    }

    /**
     * Convert iban code to a string of numbers (the ascii code numbers)
     * @param shiftedIban	The shifted iban code
     * @return The shifted iban code as a string of numbers (the ascii code numbers)
     */
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
    
    /**
     * Calculates the mod97 of the iban code for the check digit
     * @param modString	The given String
     * @return	The mod97 of the given String
     */
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

    /**
     * Sets the country of a given IBAN string representation
     * @param ibanString	The string representation of the IBAN
     */
    private void setCountry(String ibanString) {
    	this.country = ibanString.substring(0, 2).toUpperCase(Locale.ENGLISH);
    }

    /**
     * Sets the check digit of a given IBAN string representation
     * @param ibanString	The string representation of the IBAN
     */
    private void setCheckDigit(String ibanString) {
        this.checkDigit = ibanString.substring(2, 4);
    }

    /**
     * Sets the @see org.as.iban.impl.BbanImpl
     * @param bban	The @see org.as.iban.impl.BbanImpl
     */
    private void setBban(BbanImpl bban) {
        this.bban = bban;
    }
 
    /**
     * Validates if the current IBAN format is a valid one
     * @throws IbanException
     */
    private void validateFormat() throws IbanException {
	
	IbanFormat ibanFormat = new IbanFormat(country);
		
	// Validation common IBAN-Format
	if (!this.toString().matches(ibanFormat.getRegexp()))
	    throw new IbanException(IbanException.IBAN_EXCEPTION_MESSAGE_FORMAT);
		
	// Special Validation for countries
	if (country == Iban.COUNTRY_CODE_GERMAN){
	    System.out.println("ValidationConfig read");
	}
    }

}
