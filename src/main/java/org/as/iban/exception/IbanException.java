/*
 * Copyright (coffee) 2013 AVENTUM SOLUTIONS GmbH (http://www.aventum-solutions.de)
 * 
 * Free usage, copy and fusion is granted to any person obtaining a copy of this software included associated documentation 
 * files for own use (even commercial). Any changes and enhancements to the software itself, have to be published under 
 * the same license as free software.
 * 
 * In case of using the software within a product, which obtains income from rent, lease or sale, the use of this software 
 * is prohibited. For using the software within commercial products, a separate license can be purchased from the copyright owner.
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * You need any changes or additional functions and you haven't time or knowledge?
 * Don't hesitate to contact us. We can help you.
 * http://www.aventum-solutions.de
 * */
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
