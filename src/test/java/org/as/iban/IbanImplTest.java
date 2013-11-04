/**
 * 2013-10-xx	RG: new
 */

package org.as.iban;

import static org.junit.Assert.*;

import org.as.iban.impl.IbanImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for IbanImpl. Tests generation and validation for different countries.
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
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
    public void testIbanImplConstructorCzechRepublic() {
		bankIdent = "0800";
		ktoIdent = "192000145399";
		iban = new IbanImpl(Iban.COUNTRY_CODE_CZECH_REPUBLIC, bankIdent, ktoIdent);
		assertEquals("CZ6508000000192000145399", iban.toString());
    }
    
    @Test
    public void testValidateCzechRepublic() {
		ibanValid = new IbanImpl("CZ9455000000001011038930");
		ibanInvalid = new IbanImpl("CZ9455000000001011038931");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorDenmark() {
		bankIdent = "0040";
		ktoIdent = "440116243";
		iban = new IbanImpl(Iban.COUNTRY_CODE_DENMARK, bankIdent, ktoIdent);
		assertEquals("DK5000400440116243", iban.toString());
    }
    
    @Test
    public void testValidateDenmark() {
		ibanValid = new IbanImpl("DK5000400440116243");
		ibanInvalid = new IbanImpl("DK5000400440116244");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorEstonia() {
		bankIdent = "22";
		ktoIdent = "221020145685";
		iban = new IbanImpl(Iban.COUNTRY_CODE_ESTONIA, bankIdent, ktoIdent);
		assertEquals("EE382200221020145685", iban.toString());
    }
    
    @Test
    public void testValidateEstonia() {
		ibanValid = new IbanImpl("EE382200221020145685");
		ibanInvalid = new IbanImpl("EE382200221020145684");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorFinland() {
		bankIdent = "123";
		ktoIdent = "45600000785";
		iban = new IbanImpl(Iban.COUNTRY_CODE_FINLAND, bankIdent, ktoIdent);
		assertEquals("FI2112345600000785", iban.toString());
    }
    
    @Test
    public void testValidateFinland() {
		ibanValid = new IbanImpl("FI5542345670000081");
		ibanInvalid = new IbanImpl("FI5542345670000080");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorFrance() {
		bankIdent = "20041";
		ktoIdent = "010050500013M02606";
		iban = new IbanImpl(Iban.COUNTRY_CODE_FRANCE, bankIdent, ktoIdent);
		assertEquals("FR1420041010050500013M02606", iban.toString());
    }
    
    @Test
    public void testValidateFrance() {
		ibanValid = new IbanImpl("FR1420041010050500013M02606");
		ibanInvalid = new IbanImpl("FR1420041010050500013M02607");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorGerman() {
		bankIdent = "50010517";
		ktoIdent = "648489890";
		iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		assertEquals("DE12500105170648489890", iban.toString());
		assertEquals("INGDDEFFXXX", iban.getBic().getFirst().toString());
    }
    
    @Test
    public void testValidateGerman() {
		ibanValid = new IbanImpl("DE89370400440532013000");
		ibanInvalid = new IbanImpl("DE89370400440532013001");
		assertTrue(ibanValid.validate());
		assertEquals("COBADEFF370", ibanValid.getBic().getFirst().toString());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorGreece() {
		bankIdent = "0110125";
		ktoIdent = "0000000012300695";
		iban = new IbanImpl(Iban.COUNTRY_CODE_GREECE, bankIdent, ktoIdent);
		assertEquals("GR1601101250000000012300695", iban.toString());
    }
    
    @Test
    public void testValidateGreece() {
		ibanValid = new IbanImpl("GR1601101250000000012300695");
		ibanInvalid = new IbanImpl("GR1601101250000000012300694");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorHungary() {
		bankIdent = "1177301";
		ktoIdent = "61111101800000000";
		iban = new IbanImpl(Iban.COUNTRY_CODE_HUNGARY, bankIdent, ktoIdent);
		assertEquals("HU42117730161111101800000000", iban.toString());
    }
    
    @Test
    public void testValidateHungary() {
		ibanValid = new IbanImpl("HU42117730161111101800000000");
		ibanInvalid = new IbanImpl("HU42117730161111101800000001");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorIceland() {
		bankIdent = "0159";
		ktoIdent = "260076545510730339";
		iban = new IbanImpl(Iban.COUNTRY_CODE_ICELAND, bankIdent, ktoIdent);
		assertEquals("IS140159260076545510730339", iban.toString());
    }
    
    @Test
    public void testValidateIceland() {
		ibanValid = new IbanImpl("IS140159260076545510730339");
		ibanInvalid = new IbanImpl("IS140159260076545510730338");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorIreland() {
		bankIdent = "AIBK931152";
		ktoIdent = "12345678";
		iban = new IbanImpl(Iban.COUNTRY_CODE_IRELAND, bankIdent, ktoIdent);
		assertEquals("IE29AIBK93115212345678", iban.toString());
    }
    
    @Test
    public void testValidateIreland() {
		ibanValid = new IbanImpl("IE29AIBK93115212345678");
		ibanInvalid = new IbanImpl("IE29AIBK93115212345677");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

    @Test
    public void testIbanImplConstructorItaly() {
		bankIdent = "X0542811101";
		ktoIdent = "123456";
		iban = new IbanImpl(Iban.COUNTRY_CODE_ITALY, bankIdent, ktoIdent);
		assertEquals("IT60X0542811101000000123456", iban.toString());
    }
    
    @Test
    public void testValidateItaly() {
		ibanValid = new IbanImpl("IT60X0542811101000000123456");
		ibanInvalid = new IbanImpl("IT60X0542811101000000123455");
		assertTrue(ibanValid.validate());
		assertFalse(ibanInvalid.validate());
    }

}
