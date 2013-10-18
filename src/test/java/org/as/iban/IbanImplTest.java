package org.as.iban;

import static org.junit.Assert.*;

import org.as.iban.impl.IbanImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IbanImplTest {
    
    private String bankIdent;
    private String ktoIdent;
    private Iban iban;
    
    private Iban ibanValid;
    private Iban ibanInvalid;
    

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIbanImplConstructorAustria() {
	bankIdent = "19043";
	ktoIdent = "234573201";
	iban = new IbanImpl(Iban.COUNTRY_CODE_AUSTRIA, bankIdent, ktoIdent);
	assertEquals("AT611904300234573201", iban.toString());
    }

    @Test
    public void testValidateAustria() {
	ibanValid = new IbanImpl("AT611904300234573201");
	ibanInvalid = new IbanImpl("AT611904300234573200");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorBelgium() {
	bankIdent = "539";
	ktoIdent = "7547034";
	iban = new IbanImpl(Iban.COUNTRY_CODE_BELGIUM, bankIdent, ktoIdent);
	assertEquals("BE68539007547034", iban.toString());
    }

    @Test
    public void testValidateBelgium() {
	ibanValid = new IbanImpl("BE68539007547034");
	ibanInvalid = new IbanImpl("BE68539007547035");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
    }
    
    @Test
    public void testIbanImplConstructorBulgeria() {
	bankIdent = "BNBG9661";
	ktoIdent = "1020345678";
	iban = new IbanImpl(Iban.COUNTRY_CODE_BULGARIA, bankIdent, ktoIdent);
	assertEquals("BG80BNBG96611020345678", iban.toString());
    }
    
    @Test
    public void testValidateBulgeria() {
	ibanValid = new IbanImpl("BG80BNBG96611020345678");
	ibanInvalid = new IbanImpl("BG80BNBG96611020345679");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
    }
    
    @Test
    public void testIbanImplConstructorCroatia() {
	bankIdent = "1001005";
	ktoIdent = "1863000160";
	iban = new IbanImpl(Iban.COUNTRY_CODE_CROATIA, bankIdent, ktoIdent);
	assertEquals("HR1210010051863000160", iban.toString());
    }
    
    @Test
    public void testValidateCroatia() {
	ibanValid = new IbanImpl("HR1210010051863000160");
	ibanInvalid = new IbanImpl("HR1210010051863000161");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorCyprus() {
	bankIdent = "00200128";
	ktoIdent = "1200527600";
	iban = new IbanImpl(Iban.COUNTRY_CODE_CYPRUS, bankIdent, ktoIdent);
	assertEquals("CY17002001280000001200527600", iban.toString());
    }
    
    @Test
    public void testValidateCyprus() {
	ibanValid = new IbanImpl("CY17002001280000001200527600");
	ibanInvalid = new IbanImpl("CY17002001280000001200527601");
	assertTrue(ibanValid.validate());
	assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorGerman() {
	bankIdent = "37040044";
	ktoIdent = "532013000";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE89370400440532013000", iban.toString());

	bankIdent = "12070000";
	ktoIdent = "350002200";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DEUTDEBB160", iban.getBic().getFirst().toString());
    }
    
    @Test
    public void testValidateGerman() {
	ibanValid = new IbanImpl("DE89370400440532013000");
	ibanInvalid = new IbanImpl("DE89370400440532013001");
	assertTrue(ibanValid.validate());
	assertEquals("COBADEFF370", ibanValid.getBic().getFirst().toString());
	assertFalse(ibanInvalid.validate());
    }
}
