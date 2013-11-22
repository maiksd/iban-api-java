/*
   Copyright 2013 AVENTUM SOLUTIONS GmbH (www.aventum-solutions.de)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.as.iban;

import static org.junit.Assert.*;

import org.as.iban.exception.IbanException;
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
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_AUSTRIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("AT611904300234573201", iban.toString());
    }

    @Test
    public void testValidateAustria() {
	try {
	    ibanValid = new IbanImpl("AT611904300234573201");
	    ibanInvalid = new IbanImpl("AT611904300234573200");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorBelgium() {
	bankIdent = "539";
	ktoIdent = "7547034";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_BELGIUM, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("BE68539007547034", iban.toString());
    }

    @Test
    public void testValidateBelgium() {
	try {
	    ibanValid = new IbanImpl("BE68539007547034");
	    ibanInvalid = new IbanImpl("BE68539007547035");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void testIbanImplConstructorBulgeria() {
	bankIdent = "BNBG9661";
	ktoIdent = "1020345678";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_BULGARIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("BG80BNBG96611020345678", iban.toString());
    }
    
    @Test
    public void testValidateBulgeria() {
	try {
	    ibanValid = new IbanImpl("BG80BNBG96611020345678");
	    ibanInvalid = new IbanImpl("BG80BNBG96611020345679");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void testIbanImplConstructorCroatia() {
	bankIdent = "1001005";
	ktoIdent = "1863000160";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_CROATIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("HR1210010051863000160", iban.toString());
    }
    
    @Test
    public void testValidateCroatia() {
	try {
	    ibanValid = new IbanImpl("HR1210010051863000160");
	    ibanInvalid = new IbanImpl("HR1210010051863000161");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorCyprus() {
	bankIdent = "00200128";
	ktoIdent = "1200527600";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_CYPRUS, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("CY17002001280000001200527600", iban.toString());
    }
    
    @Test
    public void testValidateCyprus() {
	try {
	    ibanValid = new IbanImpl("CY17002001280000001200527600");
	    ibanInvalid = new IbanImpl("CY17002001280000001200527601");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorCzechRepublic() {
	bankIdent = "0800";
	ktoIdent = "192000145399";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_CZECH_REPUBLIC, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("CZ6508000000192000145399", iban.toString());
    }
    
    @Test
    public void testValidateCzechRepublic() {
	try {
	    ibanValid = new IbanImpl("CZ9455000000001011038930");
	    ibanInvalid = new IbanImpl("CZ9455000000001011038931");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorDenmark() {
	bankIdent = "0040";
	ktoIdent = "440116243";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_DENMARK, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DK5000400440116243", iban.toString());
    }
    
    @Test
    public void testValidateDenmark() {
	try {
	    ibanValid = new IbanImpl("DK5000400440116243");
	    ibanInvalid = new IbanImpl("DK5000400440116244");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorEstonia() {
	bankIdent = "22";
	ktoIdent = "221020145685";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_ESTONIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("EE382200221020145685", iban.toString());
    }
    
    @Test
    public void testValidateEstonia() {
	try {
	    ibanValid = new IbanImpl("EE382200221020145685");
	    ibanInvalid = new IbanImpl("EE382200221020145684");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorFinland() {
	bankIdent = "123";
	ktoIdent = "45600000785";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_FINLAND, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("FI2112345600000785", iban.toString());
    }
    
    @Test
    public void testValidateFinland() {
	try {
	    ibanValid = new IbanImpl("FI5542345670000081");
	    ibanInvalid = new IbanImpl("FI5542345670000080");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorFrance() {
	bankIdent = "20041";
	ktoIdent = "010050500013M02606";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_FRANCE, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("FR1420041010050500013M02606", iban.toString());
    }
    
    @Test
    public void testValidateFrance() {
	try {
	    ibanValid = new IbanImpl("FR1420041010050500013M02606");
	    ibanInvalid = new IbanImpl("FR1420041010050500013M02607");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorGerman() {
	bankIdent = "50010517";
	ktoIdent = "648489890";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE12500105170648489890", iban.toString());
	assertEquals("INGDDEFFXXX", iban.getBic());
    }
    
    @Test
    public void testValidateGerman() {
	try {
	    ibanValid = new IbanImpl("DE98458510200012345678");
	    ibanInvalid = new IbanImpl("DE98458510200012345679");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("WELADED1PLB", ibanValid.getBic());
    }

    @Test
    public void testIbanImplConstructorGreece() {
	bankIdent = "0110125";
	ktoIdent = "0000000012300695";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GREECE, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("GR1601101250000000012300695", iban.toString());
    }
    
    @Test
    public void testValidateGreece() {
	try {
	    ibanValid = new IbanImpl("GR1601101250000000012300695");
	    ibanInvalid = new IbanImpl("GR1601101250000000012300694");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorHungary() {
	bankIdent = "1177301";
	ktoIdent = "61111101800000000";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_HUNGARY, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("HU42117730161111101800000000", iban.toString());
    }
    
    @Test
    public void testValidateHungary() {
	try {
	    ibanValid = new IbanImpl("HU42117730161111101800000000");
	    ibanInvalid = new IbanImpl("HU42117730161111101800000001");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorIceland() {
	bankIdent = "0159";
	ktoIdent = "260076545510730339";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_ICELAND, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("IS140159260076545510730339", iban.toString());
    }
    
    @Test
    public void testValidateIceland() {
	try {
	    ibanValid = new IbanImpl("IS140159260076545510730339");
	    ibanInvalid = new IbanImpl("IS140159260076545510730338");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorIreland() {
	bankIdent = "AIBK931152";
	ktoIdent = "12345678";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_IRELAND, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("IE29AIBK93115212345678", iban.toString());
    }
    
    @Test
    public void testValidateIreland() {
	try {
	    ibanValid = new IbanImpl("IE29AIBK93115212345678");
	    ibanInvalid = new IbanImpl("IE29AIBK93115212345677");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorItaly() {
	bankIdent = "X0542811101";
	ktoIdent = "123456";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_ITALY, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("IT60X0542811101000000123456", iban.toString());
    }
    
    @Test
    public void testValidateItaly() {
	try {
	    ibanValid = new IbanImpl("IT60X0542811101000000123456");
	    ibanInvalid = new IbanImpl("IT60X0542811101000000123455");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorLatvia() {
	bankIdent = "BANK";
	ktoIdent = "435195001";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_LATVIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("LV80BANK0000435195001", iban.toString());
    }
    
    @Test
    public void testValidateLatvia() {
	try {
	    ibanValid = new IbanImpl("LV80BANK0000435195001");
	    ibanInvalid = new IbanImpl("LV80BANK0000435195000");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorLiechtenstein() {
	bankIdent = "08810";
	ktoIdent = "2324013AA";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_LIECHTENSTEIN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("LI21088100002324013AA", iban.toString());
    }
    
    @Test
    public void testValidateLiechtenstein() {
	try {
	    ibanValid = new IbanImpl("LI21088100002324013AA");
	    ibanInvalid = new IbanImpl("LI21088100002324013AB");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorLithuania() {
	bankIdent = "10000";
	ktoIdent = "11101001000";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_LITHUANIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("LT121000011101001000", iban.toString());
    }
    
    @Test
    public void testValidateLithuania() {
	try {
	    ibanValid = new IbanImpl("LT121000011101001000");
	    ibanInvalid = new IbanImpl("LT121000011101001001");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorLuxembourg() {
	bankIdent = "001";
	ktoIdent = "9400644750000";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_LUXEMBOURG, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("LU280019400644750000", iban.toString());
    }
    
    @Test
    public void testValidateLuxembourg() {
	try {
	    ibanValid = new IbanImpl("LU280019400644750000");
	    ibanInvalid = new IbanImpl("LU280019400644750001");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorMalta() {
	bankIdent = "MALT01100";
	ktoIdent = "12345MTLCAST001S";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_MALTA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("MT84MALT011000012345MTLCAST001S", iban.toString());
    }
    
    @Test
    public void testValidateMalta() {
	try {
	    ibanValid = new IbanImpl("MT84MALT011000012345MTLCAST001S");
	    ibanInvalid = new IbanImpl("MT84MALT011000012345MTLCAST001T");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorMonaco() {
	bankIdent = "1122200001";
	ktoIdent = "123456789030";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_MONACO, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("MC5811222000010123456789030", iban.toString());
    }
    
    @Test
    public void testValidateMonaco() {
	try {
	    ibanValid = new IbanImpl("MC5811222000010123456789030");
	    ibanInvalid = new IbanImpl("MC5811222000010123456789031");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorNetherlands() {
	bankIdent = "ABNA";
	ktoIdent = "417164300";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_NETHERLANDS, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("NL91ABNA0417164300", iban.toString());
    }
    
    @Test
    public void testValidateNetherlands() {
	try {
	    ibanValid = new IbanImpl("NL91ABNA0417164300");
	    ibanInvalid = new IbanImpl("NL91ABNA0417164301");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorNorway() {
	bankIdent = "8601";
	ktoIdent = "1117947";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_NORWAY, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("NO9386011117947", iban.toString());
    }
    
    @Test
    public void testValidateNorway() {
	try {
	    ibanValid = new IbanImpl("NO9386011117947");
	    ibanInvalid = new IbanImpl("NO9386011117946");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorPoland() {
	bankIdent = "10901014";
	ktoIdent = "71219812874";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_POLAND, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("PL61109010140000071219812874", iban.toString());
    }
    
    @Test
    public void testValidatePoland() {
	try {
	    ibanValid = new IbanImpl("PL61109010140000071219812874");
	    ibanInvalid = new IbanImpl("PL61109010140000071219812873");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorPortugal() {
	bankIdent = "00020123";
	ktoIdent = "1234567890154";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_PORTUGAL, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("PT50000201231234567890154", iban.toString());
    }
    
    @Test
    public void testValidatePortugal() {
	try {
	    ibanValid = new IbanImpl("PT50000201231234567890154");
	    ibanInvalid = new IbanImpl("PT50000201231234567890153");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorRomania() {
	bankIdent = "AAAA";
	ktoIdent = "1B31007593840000";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_ROMANIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("RO49AAAA1B31007593840000", iban.toString());
    }
    
    @Test
    public void testValidateRomania() {
	try {
	    ibanValid = new IbanImpl("RO49AAAA1B31007593840000");
	    ibanInvalid = new IbanImpl("RO49AAAA1B31007593840001");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorSlovakia() {
	bankIdent = "1200";
	ktoIdent = "198742637541";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_SLOVAKIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("SK3112000000198742637541", iban.toString());
    }
    
    @Test
    public void testValidateSlovakia() {
	try {
	    ibanValid = new IbanImpl("SK3112000000198742637541");
	    ibanInvalid = new IbanImpl("SK3112000000198742637540");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorSlovenia() {
	bankIdent = "26330";
	ktoIdent = "12039086";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_SLOVENIA, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("SI56263300012039086", iban.toString());
    }
    
    @Test
    public void testValidateSlovenia() {
	try {
	    ibanValid = new IbanImpl("SI56263300012039086");
	    ibanInvalid = new IbanImpl("SI56263300012039085");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorSpain() {
	bankIdent = "21000418";
	ktoIdent = "450200051332";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_SPAIN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("ES9121000418450200051332", iban.toString());
    }
    
    @Test
    public void testValidateSpain() {
	try {
	    ibanValid = new IbanImpl("ES9121000418450200051332");
	    ibanInvalid = new IbanImpl("ES9121000418450200051331");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorSweden() {
	bankIdent = "500";
	ktoIdent = "58398257466";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_SWEDEN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("SE4550000000058398257466", iban.toString());
    }
    
    @Test
    public void testValidateSweden() {
	try {
	    ibanValid = new IbanImpl("SE4550000000058398257466");
	    ibanInvalid = new IbanImpl("SE4550000000058398257465");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorSwitzerland() {
	bankIdent = "00762";
	ktoIdent = "11623852957";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_SWITZERLAND, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("CH9300762011623852957", iban.toString());
    }
    
    @Test
    public void testValidateSwitzerland() {
	try {
	    ibanValid = new IbanImpl("CH9300762011623852957");
	    ibanInvalid = new IbanImpl("CH9300762011623852956");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testIbanImplConstructorUnitedKingdom() {
	bankIdent = "NWBK601613";
	ktoIdent = "31926819";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_UNITED_KINGDOM, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("GB29NWBK60161331926819", iban.toString());
    }
    
    @Test
    public void testValidateUnitedKingdom() {
	try {
	    ibanValid = new IbanImpl("GB29NWBK60161331926819");
	    ibanInvalid = new IbanImpl("GB29NWBK60161331926818");
	    assertTrue(ibanValid.validate());
	    assertFalse(ibanInvalid.validate());
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    }

}
