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

    @Test
    public void rule005300()
    {
    	//	BLZ 55050000
    	bankIdent = "55050000";
    	ktoIdent = "35000";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE94600501017401555913", iban.toString());
    	
    	//	BLZ 60020030
    	bankIdent = "60020030";
    	ktoIdent = "1003340500";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE06600501010002001155", iban.toString());
    	
    	// BLZ 60050000
    	bankIdent = "60050000";
    	ktoIdent = "3002";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE23600501010001367924", iban.toString());
    	
    	// BLZ 66020020
    	bankIdent = "66020020";
    	ktoIdent = "4002015800";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE02600501017495530102", iban.toString());
    	
    	// BLZ 66050000
    	bankIdent = "66050000";
    	ktoIdent = "85304";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE15600501017402045439", iban.toString());
    	
    	// BLZ 86050000
    	bankIdent = "86050000";
    	ktoIdent = "3535";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE61600501017461505611", iban.toString());
    }
}
