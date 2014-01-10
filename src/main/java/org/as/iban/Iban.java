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
    @Override
	public String toString();
    
    /**
     * Get the BIC refers to the IBAN
     * @return The BIC for German banks, otherwise NULL
     */
    public String getBic();
}
