package org.as.iban.exception;

public class IbanException extends RuntimeException {

    public static final String IBAN_EXCEPTION_MESSAGE_LENGTH = "Wrong IBAN length for Country";
    public static final String IBAN_EXCEPTION_MESSAGE_FORMAT = "Wrong IBAN format for Country";
    
    public IbanException(){}
    
    public IbanException(String message){
	super(message);
    }
}
