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
