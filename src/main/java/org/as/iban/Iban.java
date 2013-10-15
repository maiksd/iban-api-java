package org.as.iban;

import org.as.iban.exception.IbanException;


public interface Iban {
    
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
    public static final String COUNTR_CODE_SPAIN = "ES";
    public static final String COUNTRY_CODE_SWEDEN = "SE";
    public static final String COUNTRY_CODE_SWITZERLAND = "CH";
    public static final String COUNTRY_CODE_UNITED_KINGDOM = "GB";
    
    
    public boolean validate() throws IbanException;
    
    public void generate ();
    
    public String toString();
}
