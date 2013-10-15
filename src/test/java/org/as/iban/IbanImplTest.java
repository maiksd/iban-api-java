package org.as.iban;

import static org.junit.Assert.*;

import org.as.iban.impl.IbanImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IbanImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIbanImplStringStringString() {
	
	String bankIdent;
	String ktoIdent;
	Iban iban;
	
	/*
	 * Austria
	 */
	bankIdent = "19043";
	ktoIdent = "234573201";
	iban = new IbanImpl(Iban.COUNTRY_CODE_AUSTRIA, bankIdent, ktoIdent);
	assertEquals("AT611904300234573201", iban.toString());
	
	/*
	 * Belgium
	 */
	bankIdent = "539";
	ktoIdent = "7547034";
	iban = new IbanImpl(Iban.COUNTRY_CODE_BELGIUM, bankIdent, ktoIdent);
	assertEquals("BE68539007547034", iban.toString());
	
	/*
	 * Bulgaria
	 */
	bankIdent = "BNBG9661";
	ktoIdent = "1020345678";
	iban = new IbanImpl(Iban.COUNTRY_CODE_BULGARIA, bankIdent, ktoIdent);
	assertEquals("BG80BNBG96611020345678", iban.toString());
	
	/*
	 * Croatia
	 */
	bankIdent = "1001005";
	ktoIdent = "1863000160";
	iban = new IbanImpl(Iban.COUNTRY_CODE_CROATIA, bankIdent, ktoIdent);
	assertEquals("HR1210010051863000160", iban.toString());
	
	/* 
	 * German
	 */
	// Regel 0000
	bankIdent = "37040044";
	ktoIdent = "532013000";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE89370400440532013000", iban.toString());
    }

    @Test
    public void testValidate() {

	Iban ibanValid;
	Iban ibanInvalid;

	/*
	 * Austria
	 */
	ibanValid = new IbanImpl("AT611904300234573201");
	ibanInvalid = new IbanImpl("AT611904300234573200");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
	
	/*
	 * Belgium
	 */
	ibanValid = new IbanImpl("BE68539007547034");
	ibanInvalid = new IbanImpl("BE68539007547035");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
	
	/*
	 * Bulgaria
	 */
	ibanValid = new IbanImpl("BG80BNBG96611020345678");
	ibanInvalid = new IbanImpl("BG80BNBG96611020345679");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
	
	/*
	 * Croatia
	 */
	ibanValid = new IbanImpl("HR1210010051863000160");
	ibanInvalid = new IbanImpl("HR1210010051863000161");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());

	/* 
	 * German
	 */
	// Regel 0000
	ibanValid = new IbanImpl("DE89370400440532013000");
	ibanInvalid = new IbanImpl("DE89370400440532013001");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
    }

}
