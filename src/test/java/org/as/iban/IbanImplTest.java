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
	
	// German
	String blz = "37040044";
	String kto = "532013000";
	Iban ibanGerman = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, blz, kto);
	assertEquals("DE89370400440532013000", ibanGerman.toString());
    }

    @Test
    public void testValidate() {

	// German
	// Standardrule
	Iban ibanGermanValid = new IbanImpl("DE89370400440532013000");
	Iban ibanGermanInvalid = new IbanImpl("DE89370400440532013001");
	
	assertTrue(ibanGermanValid.validate());
	assertFalse(ibanGermanInvalid.validate());
    }

}
