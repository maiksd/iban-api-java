package org.as.iban.exception;

/**
 * Defines a exception that can occur during the process of generating oder validating an IBAN
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
public class IbanException extends Exception {

	//	Define possible exception messages
    public static final String IBAN_EXCEPTION_MESSAGE_LENGTH = "Invalid IBAN length for Country";
    public static final String IBAN_EXCEPTION_MESSAGE_FORMAT = "Invalid IBAN format for Country";
    public static final String IBAN_EXCEPTION_MESSAGE_KTO_LENGTH = "Invalid KtoIdent for Country";
    public static final String IBAN_EXCEPTION_MESSAGE_BANK_LENGTH = "Invalid BankIdent for Country";
    public static final String IBAN_EXCEPTION_UNSUPPORTED_COUNTRY = "Country code ist not supported in this version";
    public static final String IBAN_EXCEPTION_NO_IBAN_CALCULATION = "No Iban Calculation for this accountnumber";
    public static final String IBAN_EXCEPTION_INVALID_BANKIDENT = "No existing bank with this BLZ";
    
    /**
     * Constructor
     * @param message	Message of the exception
     */
    public IbanException(String message){
    	super(message);
    }
}
