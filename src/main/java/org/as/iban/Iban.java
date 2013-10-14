package org.as.iban;

public interface Iban {
    
    public static final String COUNTRY_CODE_GERMAN = "DE";
    public static final String COUNTR_CODE_SPAIN = "ES";

    public boolean validate();
    
    public void generate ();
    
    public String toString();
}
