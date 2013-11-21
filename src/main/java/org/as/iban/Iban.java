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
package org.as.iban;

import org.as.iban.exception.IbanException;

/**
 * Interface declaring an Iban
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
public interface Iban {
    
	//	Defining country codes
    public static final String COUNTRY_CODE_AUSTRIA = "AT";
    public static final String COUNTRY_CODE_BELGIUM = "BE";
    public static final String COUNTRY_CODE_BULGARIA = "BG";
    public static final String COUNTRY_CODE_CROATIA = "HR";
    public static final String COUNTRY_CODE_CYPRUS = "CY";
    public static final String COUNTRY_CODE_CZECH_REPUBLIC = "CZ";
    public static final String COUNTRY_CODE_DENMARK = "DK";
    public static final String COUNTRY_CODE_ESTONIA = "EE";
    public static final String COUNTRY_CODE_FINLAND = "FI";
    public static final String COUNTRY_CODE_FRANCE = "FR";
    public static final String COUNTRY_CODE_GERMAN = "DE";
    public static final String COUNTRY_CODE_GREECE = "GR";
    public static final String COUNTRY_CODE_HUNGARY = "HU";
    public static final String COUNTRY_CODE_ICELAND = "IS";
    public static final String COUNTRY_CODE_IRELAND = "IE";
    public static final String COUNTRY_CODE_ITALY = "IT";
    public static final String COUNTRY_CODE_LATVIA = "LV";
    public static final String COUNTRY_CODE_LIECHTENSTEIN ="LI";
    public static final String COUNTRY_CODE_LITHUANIA = "LT";
    public static final String COUNTRY_CODE_LUXEMBOURG = "LU";
    public static final String COUNTRY_CODE_MALTA = "MT";
    public static final String COUNTRY_CODE_MONACO = "MC";
    public static final String COUNTRY_CODE_NETHERLANDS = "NL";
    public static final String COUNTRY_CODE_NORWAY = "NO";
    public static final String COUNTRY_CODE_POLAND = "PL";
    public static final String COUNTRY_CODE_PORTUGAL = "PT";
    public static final String COUNTRY_CODE_ROMANIA = "RO";
    public static final String COUNTRY_CODE_SLOVAKIA = "SK";
    public static final String COUNTRY_CODE_SLOVENIA  = "SI";
    public static final String COUNTRY_CODE_SPAIN = "ES";
    public static final String COUNTRY_CODE_SWEDEN = "SE";
    public static final String COUNTRY_CODE_SWITZERLAND = "CH";
    public static final String COUNTRY_CODE_UNITED_KINGDOM = "GB";
    
    
    /**
     * Validates a IBAN
     * @return true in case of successfully validation, otherwise false
     * @throws IbanException
     */
    public boolean validate() throws IbanException;
       
    
    /**
     * Returns the string representation of the IBAN
     * @return The IBAN in the format "country-code|checkdigit|bank-ident|kto-ident", for example "DE62701500000020228888"
     */
    public String toString();
    
    /**
     * Get the BIC refers to the IBAN
     * @return The BIC for German banks, otherwise NULL
     */
    public String getBic();
}
