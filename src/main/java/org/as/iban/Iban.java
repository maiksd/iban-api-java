package org.as.iban;

import org.as.iban.exception.IbanException;


public interface Iban {
    
    public static final String COUNTRY_CODE_GERMAN = "DE";
    public static final String COUNTR_CODE_SPAIN = "ES";

    public boolean validate() throws IbanException;
    
    public void generate ();
    
    public String toString();
}
