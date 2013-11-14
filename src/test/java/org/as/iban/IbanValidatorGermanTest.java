package org.as.iban;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule000300() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE00510108006161604670");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule000400() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE89100500000000112233");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule000501() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE00257800220999499999");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	try {
	    iban = new IbanImpl("DE00500400330012345678");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	try {
	    iban = new IbanImpl("DE87370800400000182002");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule000600() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE47701500000034343434");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule000700() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE77370501980002602024");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
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
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_INVALID_BANKIDENT, e.getMessage());
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

    @Test
    public void rule000900() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE56683519761116232594");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE28683519760016005845");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void rule001000() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE53500502010000002000");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE81500502010000800000");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule001100() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE98320500000000001000");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE44320500000008010001");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE20320500000000047800");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE36320500000000047803");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule001201() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE44508500495000002096");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE95500500005000002096");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule001301() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE56400500000000060624");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE15300500000000060624");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test 
    public void rule001400() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE74100906030012345678");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
    }
    
    @Test
    public void rule001500() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE44370601930002120041");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test 
    public void rule001600() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE03371600870000300000");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule001700() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE07380601860000102030");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule001800() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE03390601800000202050");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule001900() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE95501301000020475000");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE82501203830020475000");
	    assertTrue(iban.validate());
	    assertEquals("DELBDE33XXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule002001() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE58500700100000009999");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE80500700100092777202");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE76500700100000123456");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule002101() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE81360200300000305200");
	    assertTrue(iban.validate());
	    assertEquals("NBAGDE3EXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE09350200300000305200");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE03360200300000900826");
	    assertTrue(iban.validate());
	    assertEquals("NBAGDE3EXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE95360200300000900826");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE71360200300000705020");
	    assertTrue(iban.validate());
	    assertEquals("NBAGDE3EXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE10365200300000705020");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE18360200300009197354");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE12362200300000012345");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule002200() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE36430609670001111111");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule002300() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE43265900250000000700");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule002400() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE14360602950000000345");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule002500() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE49641501820002777939");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule002800() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE63250502990000017095");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE69250501800000017095");
	    assertTrue(iban.validate());
	    assertEquals("SPKHDE2HXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule002900() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE81512108002600123456");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE02512108000260123456");
	    assertTrue(iban.validate());
	    assertEquals("SOGEDEFFXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule003101() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE90790203251210100047");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE70762200731210100047");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM419", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE33700200011210100047");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE70762200731210100047");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM419", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE63760202141210100047");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE70762200731210100047");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM419", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE46630204500044613352");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	try {
	    iban = new IbanImpl("DE85660201501457032621");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE92660202861457032621");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM475", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule003200() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE70762200731210100047");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM419", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE92660202861457032621");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM475", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE06710221823200000012");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM453", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE07100208900005951950");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM488", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE11850200860847321750");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule003301() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE76700202702950219435");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMMXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE92660202861457032621");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM475", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE55700202700000000897");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMMXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE36700202700847321750");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMMXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE67720200700847321750");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	try {
	    iban = new IbanImpl("DE00700202700007777777");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule003400() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE69600202901320815432");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM473", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE91600202901457032621");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE16600202900847321750");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	try {
	    iban = new IbanImpl("DE85600202900500500500");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule003501() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE42790200761050958422");
	    assertTrue(iban.validate());
	    assertEquals("HYVEDEMM455", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE58790200761320815432");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE05790200760847321750");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule003600() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE91210500000840132000");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE55210500000000101105");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE19200500000840132000");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE76210500000051300528");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE31210500000101105000");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE26230500000051300528");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE55210500000319574000");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE05230500000319574000");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE84210500000100271010");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE09210500003070010313");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE52210500001100001928");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE82210500007052000037");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE10200500007052000037");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE06210500008553009087");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE53230500008553009087");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE37210500009000010040");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE38210500009000010040");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}

	try {
	    iban = new IbanImpl("DE89210500000000000001");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}

	try {
	    iban = new IbanImpl("DE10230500008765432101");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule003700() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE41300107000000123456");
	    assertTrue(iban.validate());
	    assertEquals("BOTKDEDXXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE46201107000000123456");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule003800() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE25285900751234567890");
	    assertTrue(iban.validate());
	    assertEquals("GENODEF1LER", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE82250903001234567890");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule003900() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE13280200501234567890");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE29266214131234567890");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004001() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE17680523280006015002");
	    assertTrue(iban.validate());
	    assertEquals("SOLADES1STF", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE83680513100006015002");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004100() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE96500604000000011404");
	    assertTrue(iban.validate());
	    assertEquals("GENODEFFXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE27622200001234567890");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004200() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE61694000000123456789");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	try {
	    iban = new IbanImpl("DE79773000000050463999");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE61850000000012345678");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	try {
	    iban = new IbanImpl("DE24545000000012300123");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule004300() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE49666500850000000868");
	    assertTrue(iban.validate());
	    assertEquals("PZHSDE66XXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE29606510700000012602");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004400() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE29680501010000000202");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004500() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE40505101750012345678");
	    assertTrue(iban.validate());
	    assertEquals("ESSEDE5FXXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004600() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE62310108331234567890");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE68101206001234567890");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004700() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE47601333000001234567");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE33601333001234567800");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE80550333000012345678");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004800() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE12360102001231234567");
	    assertTrue(iban.validate());
	    assertEquals("VONEDE33XXX", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE04101208001231234567");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule004900() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE26300600109911820001");
	    assertTrue(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE19300600100001991182");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE39570600001234967890");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule005000() {
	// Regel nicht ausgeführt im BLZ-Verzeichnis -> Standard

	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE24285500000130084981");
	    assertTrue(iban.validate());
	    assertEquals("BRLADE21LER", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule005100() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE13600501010502502502");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule005200() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE30694210207481501341");
	    iban.validate();
	    assertTrue("Asserting exception", false);
	} catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
    }
    
    @Test
    public void rule005300() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE85550500001234567890");
	    assertTrue(iban.validate());
	    assertEquals("SOLADEST550", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE64550500000119345106");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void rule005400() {
	Iban iban = null;
	
	try {
	    iban = new IbanImpl("DE42210602370163107000");
	    assertTrue(iban.validate());
	    assertEquals("GENODEF1EDG", iban.getBic());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	try {
	    iban = new IbanImpl("DE42100602370024796740");
	    assertFalse(iban.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
}
