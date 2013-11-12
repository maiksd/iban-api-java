package org.as.iban;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.as.iban.exception.IbanException;
import org.as.iban.impl.IbanImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IbanValidatorGermanTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void rule000000() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE17100900000532013011");
	    assertTrue(iban.validate());
	    assertEquals("BEVODEBBXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void rule000200() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE98720207001234567860");
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    /**
     * 
     */
    @Test
    public void rule000300() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE00510108006161604670");
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule000501() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE00257800220999499999");
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	try {
	    iban = new IbanImpl("DE00500400330012345678");
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule000800() {
	Iban iban = null;
	
	// Bsp. 2
	try {
	    iban = new IbanImpl("DE46500202000030009963");
	    assertTrue(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE05510200000030009963");
	    assertFalse(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	// Bsp. 3
	try {
	    iban = new IbanImpl("DE02500202000040033086");
	    assertTrue(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE41300205000040033086");
	    assertFalse(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	// Bsp. 4
	try {
	    iban = new IbanImpl("DE55500202000050017409");
	    assertTrue(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE75201202000050017409");
	    assertFalse(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	// Bsp. 5
	try {
	    iban = new IbanImpl("DE38500202000055036107");
	    assertTrue(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE187052202000055036107");
	} catch (IbanException e) {
	    assertEquals(e.getMessage(), IbanException.IBAN_EXCEPTION_INVALID_BANKIDENT);
	}

	// Bsp. 6
	try {
	    iban = new IbanImpl("DE98500202000070049754");
	    assertTrue(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE31100202000070049754");
	    assertFalse(iban.validate());
	    assertEquals("BHFBDEFF500", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

    }
}
