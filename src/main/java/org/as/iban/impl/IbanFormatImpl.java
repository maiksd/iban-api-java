package org.as.iban.impl;

class IbanFormatImpl {
    
    private String countryCode;
    private String regexp;
    private int bankIdentLength;
    private int ktoIdentLength;
    
    IbanFormatImpl(String countryCode) {
	this.countryCode = countryCode;
	readFormatConfig();
    }

    private void readFormatConfig() {
	
    }

    private String getRegexp() {
        return regexp;
    }

    private int getBankIdentLength() {
        return bankIdentLength;
    }

    private int getKtoIdentLength() {
        return ktoIdentLength;
    }

}
