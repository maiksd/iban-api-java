package org.as.iban;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.as.iban.exception.IbanException;
import org.as.iban.impl.IbanImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IbanValidatorGermanTest {

    private String bankIdent;
    private String ktoIdent;
    private Iban iban;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void rule000200() {
//	fail("Not yet implemented");
//    }
    
    @Test
    public void rule000300() {
	bankIdent = "51010800";
	ktoIdent = "6161604670";
	try{
	    Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	}
	catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule000400() {
	bankIdent = "10050000";
	ktoIdent = "135";
	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE86100500000990021440", iban.toString());	
    }
    
    @Test
    public void rule005400(){
    	bankIdent = "10060237";
    	ktoIdent = "16307000";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE26100602370163107000", iban.toString());
    	
    	bankIdent = "21060237";
    	ktoIdent = "12796740";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE92210602370012796743", iban.toString());
    }

}
