package org.as.iban.exception;

public class IbanException extends RuntimeException {

    public static final String IBAN_EXCEPTION_MESSAGE_LENGTH = "Invalid IBAN length for Country";
    public static final String IBAN_EXCEPTION_MESSAGE_FORMAT = "Invalid IBAN format for Country";
    public static final String IBAN_EXCEPTION_MESSAGE_KTO_LENGTH = "Invalid KtoIdent for Country";
    public static final String IBAN_EXCEPTION_MESSAGE_BANK_LENGTH = "Invalid BankIdent for Country";
    
    public IbanException(){}
    
    public IbanException(String message){
	super(message);
    }
}
