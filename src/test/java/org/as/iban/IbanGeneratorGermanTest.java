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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.as.iban.exception.IbanException;
import org.as.iban.impl.IbanImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for IbanImpl. Tests all iban rules.
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
public class IbanGeneratorGermanTest {

    private String bankIdent;
    private String ktoIdent;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void rule000100(){
	bankIdent = "35451460";
	ktoIdent = "12345678";
	try{
	    Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
	}
	catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
	}
    }
    @Test
    public void rule000200() {
		// BLZ 72020700
		bankIdent = "72020700";
		ktoIdent = "12345678";
		Iban iban = null;
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE05720207000012345678", iban.toString());	
		
		bankIdent = "72020700";
		ktoIdent = "1234567690";
		try{
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		    assertTrue("Asserting exception", false);
		}
		catch (IbanException e) {
		    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
		}
	
		bankIdent = "72020700";
		ktoIdent = "1234567860";
		try{
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		    assertTrue("Asserting exception", false);
		}
		catch (IbanException e) {
		    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
		}
    }
    
    @Test
    public void rule000300() {
		bankIdent = "51010800";
		ktoIdent = "6161604670";
		try{
		    Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		    assertTrue("Asserting exception", false);
		}
		catch (IbanException e) {
		    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
		}
    }
    
    @Test
    public void rule000400() {
		bankIdent = "10050000";
		ktoIdent = "135";
		Iban iban = null;
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e) {
		    e.printStackTrace();
		}
		assertEquals("DE86100500000990021440", iban.toString());	
    }
    
    @Test 
    public void rule000502() {
		bankIdent = "26580070";
		ktoIdent = "732502200";
		Iban iban = null;
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE32265800700732502200", iban.toString());
		assertEquals("DRESDEFF265", iban.getBic());
	
		bankIdent = "26580070";
		ktoIdent = "7325022";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE32265800700732502200", iban.toString());
		assertEquals("DRESDEFF265", iban.getBic());
	
		bankIdent = "26580070";
		ktoIdent = "8732502200";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE60265800708732502200", iban.toString());
		assertEquals("DRESDEFF265", iban.getBic());
	
		bankIdent = "26580070";
		ktoIdent = "4820379900";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE37265800704820379900", iban.toString());
		assertEquals("DRESDEFF265", iban.getBic());
	
		bankIdent = "50080000";
		ktoIdent = "7814706100";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE32500800007814706100", iban.toString());
		assertEquals("DRESDEFFXXX", iban.getBic());
	
		bankIdent = "50080000";
		ktoIdent = "231654";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE42500800000023165400", iban.toString());
		assertEquals("DRESDEFFXXX", iban.getBic());
	
		bankIdent = "50080000";
		ktoIdent = "43503";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE21500800000004350300", iban.toString());
		assertEquals("DRESDEFFXXX", iban.getBic());
	
		bankIdent = "10080000";
		ktoIdent = "998761700";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e1) {
		    e1.printStackTrace();
		}
		assertEquals("DE73100800000998761700", iban.toString());
		assertEquals("DRESDEFF100", iban.getBic());
	
		bankIdent = "12080000";
		ktoIdent = "998761700";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		    assertTrue("Asserting exception", false);
		}
		catch (IbanException e) {
		    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
		}
		
		bankIdent = "50540028";
		ktoIdent = "4217386";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e) {
		    e.printStackTrace();
		}
		assertEquals("DE24505400280421738600", iban.toString());
		assertEquals("COBADEFFXXX", iban.getBic());
		
		bankIdent = "20041111";
		ktoIdent = "130023500";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e) {
		    e.printStackTrace();
		}
		assertEquals("DE81200411110130023500", iban.toString());
		assertEquals("COBADEHDXXX", iban.getBic());
	
		bankIdent = "37080040";
		ktoIdent = "111";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e) {
		    e.printStackTrace();
		}
		assertEquals("DE69370800400215022000", iban.toString());
		assertEquals("DRESDEFF370", iban.getBic());
	
		bankIdent = "50040000";
		ktoIdent = "101010";
		try {
		    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
		} catch (IbanException e) {
		    e.printStackTrace();
		}
		assertEquals("DE46500400000311011100", iban.toString());
		assertEquals("COBADEFFXXX", iban.getBic());
	}
    
    @Test
    public void rule000600(){
    	// BLZ 70150000 Kto 1111111
    	bankIdent = "70150000";
    	ktoIdent = "1111111";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE62701500000020228888", iban.toString());
    	
    	
    	// BLZ 70150000 Kto 7777777
    	bankIdent = "70150000";
    	ktoIdent = "7777777";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE48701500000903286003", iban.toString());
    	
    	
    	// BLZ 70150000 Kto 34343434
    	bankIdent = "70150000";
    	ktoIdent = "34343434";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE30701500001000506517", iban.toString());
    	
    	
    	// BLZ 70150000 Kto 70000
    	bankIdent = "70150000";
    	ktoIdent = "70000";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE64701500000018180018", iban.toString());
    }
    
    @Test
    public void rule000700(){
    	// BLZ 37050198 Kto 221
    	bankIdent = "37050198";
    	ktoIdent = "221";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE25370501980023002157", iban.toString());
    	
    	
    	// BLZ 37050198 Kto 3636
    	bankIdent = "37050198";
    	ktoIdent = "3636";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE52370501980023002447", iban.toString());
    	
    	
    	// BLZ 37050198 Kto 43430
    	bankIdent = "37050198";
    	ktoIdent = "43430";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE56370501981901693331", iban.toString());
    	
    	
    	// BLZ 37050198 Kto 222222
    	bankIdent = "37050198";
    	ktoIdent = "222222";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE85370501980002222222", iban.toString());
    	
    	
    	// BLZ 37050198 Kto 7777777
    	bankIdent = "37050198";
    	ktoIdent = "7777777";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE85370501980002222222", iban.toString());
    	
    	
    	// BLZ 37050198 Kto 200820082
    	bankIdent = "37050198";
    	ktoIdent = "200820082";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE54370501981901783868", iban.toString());
    }
    
    @Test
    public void rule000800(){
    	// BLZ 50020200 Kto 38000
    	bankIdent = "50020200";
    	ktoIdent = "38000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE80500202000000038000", iban.toString());
    	assertEquals("BHFBDEFF500", iban.getBic());
    	
    	// BLZ 51020000 Kto 30009963
    	bankIdent = "51020000";
    	ktoIdent = "30009963";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE46500202000030009963", iban.toString());
    	assertEquals("BHFBDEFF500", iban.getBic());
    	
    	
    	// BLZ 30020500 Kto 40033086
    	bankIdent = "30020500";
    	ktoIdent = "40033086";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE02500202000040033086", iban.toString());
    	assertEquals("BHFBDEFF500", iban.getBic());
    	
    	
    	// BLZ 20120200 Kto 50017409
    	bankIdent = "20120200";
    	ktoIdent = "50017409";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE55500202000050017409", iban.toString());
    	assertEquals("BHFBDEFF500", iban.getBic());
    	
    	
    	// BLZ 70220200 Kto 55036107
    	bankIdent = "70220200";
    	ktoIdent = "55036107";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE38500202000055036107", iban.toString());
    	assertEquals("BHFBDEFF500", iban.getBic());
    	
    	
    	// BLZ 10020200 Kto 70049754
    	bankIdent = "10020200";
    	ktoIdent = "70049754";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE98500202000070049754", iban.toString());
    	assertEquals("BHFBDEFF500", iban.getBic());
    }
    
    @Test
    public void rule000900(){
    	// BLZ 683 519 76 Kto 1116232594
    	bankIdent = "68351976";
    	ktoIdent = "1116232594";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE03683515573047232594", iban.toString());
    	assertEquals("SOLADES1SFH", iban.getBic());
    	
    	// BLZ 683 519 76 Kto 0016005845
    	bankIdent = "68351976";
    	ktoIdent = "0016005845";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE10683515570016005845", iban.toString());
    	assertEquals("SOLADES1SFH", iban.getBic());
    }
    
    @Test
    public void rule001001(){
    	// BLZ 50050201 Kto 2000
    	bankIdent = "50050201";
    	ktoIdent = "2000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE42500502010000222000", iban.toString());
    	
    	
    	// BLZ 32050000 Kto 800000
    	bankIdent = "50050201";
    	ktoIdent = "800000";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE89500502010000180802", iban.toString());
    	
    	
    	bankIdent = "50050222";
    	ktoIdent = "1241539870";
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	assertEquals("DE45500502011241539870", iban.toString());
    }
    
    @Test
    public void rule001100(){
    	// BLZ 32050000 Kto 1000
    	bankIdent = "32050000";
    	ktoIdent = "1000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE44320500000008010001", iban.toString());
    	
    	
    	// BLZ 32050000 Kto 47800
    	bankIdent = "32050000";
    	ktoIdent = "47800";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE36320500000000047803", iban.toString());
    }
    
    @Test public void rule001201(){
    	// BLZ 508 500 49 Kto 5000002096
    	bankIdent = "50850049";
    	ktoIdent = "5000002096";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE95500500005000002096", iban.toString());
    	assertEquals("HELADEFFXXX", iban.getBic());
    }
    
    @Test
    public void rule001301(){
    	// BLZ 40050000 Kto 60624
    	bankIdent = "40050000";
    	ktoIdent = "60624";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE15300500000000060624", iban.toString());
    	assertEquals("WELADEDDXXX", iban.getBic());
    	
    	
    	// BLZ 44050000 Kto 1564896
    	bankIdent = "44050000";
    	ktoIdent = "60624";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE15300500000000060624", iban.toString());
    	assertEquals("WELADEDDXXX", iban.getBic());
    }
    
    @Test
    public void rule001400(){
    	// BLZ 44060604 Kto 456456789
    	bankIdent = "44060604";
    	ktoIdent = "456456789";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE46300606010456456789", iban.toString());
    	assertEquals("DAAEDEDDXXX", iban.getBic());
    	
    	
    	// BLZ 67090617 Kto 1564896
    	bankIdent = "67090617";
    	ktoIdent = "1564896";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE36300606010001564896", iban.toString());
    	assertEquals("DAAEDEDDXXX", iban.getBic());
    	
    	
    	// BLZ 10090603 Kto 78976
    	bankIdent = "10090603";
    	ktoIdent = "78976";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE94300606010000078976", iban.toString());
    	assertEquals("DAAEDEDDXXX", iban.getBic());
    	
    	
    	// BLZ 30060601 Kto 4561238
    	bankIdent = "30060601";
    	ktoIdent = "4561238";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE03300606010004561238", iban.toString());
    	assertEquals("DAAEDEDDXXX", iban.getBic());
    }
    
    @Test
    public void rule001501(){
    	// BLZ 37060193 Kto 888
    	bankIdent = "37060193";
    	ktoIdent = "888";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE94370601930031870011", iban.toString());
    	
    	
    	// BLZ 37060193 Kto 444555
    	bankIdent = "37060193";
    	ktoIdent = "444555";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE38370601930032230016", iban.toString());
    	
    	
    	// BLZ 37060193 Kto 80868086
    	bankIdent = "37060193";
    	ktoIdent = "80868086";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE42370601934007375013", iban.toString());
    }
    
    @Test
    public void rule001600(){
    	// BLZ 37160087 Kto 300000
    	bankIdent = "37160087";
    	ktoIdent = "300000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE68371600870018128012", iban.toString());
    }
    
    @Test
    public void rule001700(){
    	// BLZ 38060186 Kto 111
    	bankIdent = "38060186";
    	ktoIdent = "111";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE38380601862111111017", iban.toString());
    	
    	
    	// BLZ 38060186 Kto 333333
    	bankIdent = "38060186";
    	ktoIdent = "333333";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE06380601862033333016", iban.toString());
    }
    
    @Test
    public void rule001800(){
    	// BLZ 390 601 80 Kto 2157
    	bankIdent = "39060180";
    	ktoIdent = "2157";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE07390601800121787016", iban.toString());
    	
    	
    	// BLZ 390 601 80 Kto 5435435430
    	bankIdent = "39060180";
    	ktoIdent = "5435435430";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE37390601800543543543", iban.toString());
    }
    
    @Test
    public void rule001900(){
    	// BLZ 501 301 00 Kto 20475000
    	bankIdent = "50130100";
    	ktoIdent = "20475000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE82501203830020475000", iban.toString());
    	assertEquals("DELBDE33XXX", iban.getBic());
    }
    
    @Test
    public void rule002002(){
    	// BLZ 50070010 Kto 9999
    	bankIdent = "50070010";
    	ktoIdent = "9999";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE80500700100092777202", iban.toString());
    	assertEquals("DEUTDEFFXXX", iban.getBic());
    	
    	// BLZ 20070000 Kto 600103660
    	bankIdent = "20070000";
    	ktoIdent = "600103660";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE83200700000600103660", iban.toString());
    	assertEquals("DEUTDEHHXXX", iban.getBic());
    	
    	// BLZ 10070000 Kto 350002200
    	bankIdent = "10070000";
    	ktoIdent = "350002200";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE72100700000350002200", iban.toString());
    	assertEquals("DEUTDEBBXXX", iban.getBic());
    	
    	// BLZ 25070024 Kto 12345
    	bankIdent = "25070024";
    	ktoIdent = "12345";
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	assertEquals("DE59250700240001234500", iban.toString());

    	// BLZ 36070024 Kto 123456
    	bankIdent = "36070024";
    	ktoIdent = "123456";
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	assertEquals("DE35360700240012345600", iban.toString());

    	// BLZ 36070024 Kto 1234567
    	bankIdent = "36070024";
    	ktoIdent = "1234567";
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	assertEquals("DE39360700240123456700", iban.toString());

    }
    
    @Test
    public void rule002101(){
    	// BLZ 350 200 30 Kto 305200
    	bankIdent = "35020030";
    	ktoIdent = "305200";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE81360200300000305200", iban.toString());
    	assertEquals("NBAGDE3EXXX", iban.getBic());
    	
    	// BLZ 362 200 30 Kto 900826
    	bankIdent = "36220030";
    	ktoIdent = "900826";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE03360200300000900826", iban.toString());
    	assertEquals("NBAGDE3EXXX", iban.getBic());
    	
    	
    	// BLZ 365 200 30 Kto 705020
    	bankIdent = "36520030";
    	ktoIdent = "705020";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE71360200300000705020", iban.toString());
    	assertEquals("NBAGDE3EXXX", iban.getBic());
    	
    	
    	// BLZ 360 200 30 Kto 9197354
    	bankIdent = "36020030";
    	ktoIdent = "9197354";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE18360200300009197354", iban.toString());
    	assertEquals("NBAGDE3EXXX", iban.getBic());
    	
    	
    	// BLZ 360 200 30 Kto 12345
    	bankIdent = "36020030";
    	ktoIdent = "12345";
    	
    	try {
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    }
    
    @Test
    public void rule002200(){
    	// BLZ 43060967 Kto 1111111
    	bankIdent = "43060967";
    	ktoIdent = "1111111";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE22430609672222200000", iban.toString());
    }
    
    @Test
    public void rule002300(){
    	// BLZ 265 900 25 Kto 700
    	bankIdent = "26590025";
    	ktoIdent = "700";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE76265900251000700800", iban.toString());
    }
    
    @Test
    public void rule002400(){
    	// BLZ 360 602 95 Kto 94
    	bankIdent = "36060295";
    	ktoIdent = "94";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE48360602950000001694", iban.toString());
    	
    	
    	// BLZ 360 602 95 Kto 345
    	bankIdent = "36060295";
    	ktoIdent = "345";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE03360602950000017345", iban.toString());
    }
    
    @Test
    public void rule002500(){
    	// BLZ 641 501 82 Kto 2777939
    	bankIdent = "64150182";
    	ktoIdent = "2777939";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE81600501010002777939", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 644 502 88 Kto 7893500686
    	bankIdent = "64450288";
    	ktoIdent = "7893500686";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE80600501017893500686", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    }
    
    @Test
    public void rule002600(){
    	//	TODO
    }
    
    @Test
    public void rule002700(){
    	//	TODO
    }
    
    @Test
    public void rule002800(){
    	// BLZ 250 502 99 Kto 17095
    	bankIdent = "25050299";
    	ktoIdent = "17095";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE69250501800000017095", iban.toString());
    	assertEquals("SPKHDE2HXXX", iban.getBic());
    }
    
    @Test
    public void rule002900(){
    	// BLZ 51210800 Kto 2600123456
    	bankIdent = "51210800";
    	ktoIdent = "2600123456";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE02512108000260123456", iban.toString());
    	
    	
    	// BLZ 51210800 Kto 1410123456
    	bankIdent = "51210800";
    	ktoIdent = "1410123456";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE35512108000141123456", iban.toString());
    }
    
    @Test
    public void rule003000(){
    	//	TODO
    }
    
    @Test
    public void rule003101(){
    	//	Testfall A
    	// BLZ 790 203 25 Kto 1210100047
    	bankIdent = "79020325";
    	ktoIdent = "1210100047";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE70762200731210100047", iban.toString());
    	assertEquals("HYVEDEMM419", iban.getBic());
    	
    	// Testfall B
    	// BLZ 700 200 01 Kto 1210100047
    	bankIdent = "70020001";
    	ktoIdent = "1210100047";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE70762200731210100047", iban.toString());
    	assertEquals("HYVEDEMM419", iban.getBic());
    	
    	
    	// Testfall C
    	// BLZ 760 202 14 Kto 1210100047
    	bankIdent = "76020214";
    	ktoIdent = "1210100047";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE70762200731210100047", iban.toString());
    	assertEquals("HYVEDEMM419", iban.getBic());
    	
    	
    	// Testfall F
    	// BLZ 630 204 50 Kto 44613352
    	bankIdent = "63020450";
    	ktoIdent = "44613352";
    	
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	
    	// Testfall G
    	// BLZ 660 201 50 Kto 1457032621
    	bankIdent = "66020150";
    	ktoIdent = "1457032621";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE92660202861457032621", iban.toString());
    	assertEquals("HYVEDEMM475", iban.getBic());
    }
    
    @Test
    public void rule003200(){
    	// Testfall J
    	// BLZ 762 200 73 Kto 1210100047
    	bankIdent = "76220073";
    	ktoIdent = "1210100047";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE70762200731210100047", iban.toString());
    	assertEquals("HYVEDEMM419", iban.getBic());
  	
    	
    	// Testfall K
    	// BLZ 660 202 86 Kto 1457032621
    	bankIdent = "66020286";
    	ktoIdent = "1457032621";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE92660202861457032621", iban.toString());
    	assertEquals("HYVEDEMM475", iban.getBic());
    	
    	
    	// Testfall L
    	// BLZ 762 200 73 Kto 3200000012
    	bankIdent = "76220073";
    	ktoIdent = "3200000012";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE06710221823200000012", iban.toString());
    	assertEquals("HYVEDEMM453", iban.getBic());
   	
    	
    	// Testfall M
    	// BLZ 100 208 90 Kto 5951950
    	bankIdent = "10020890";
    	ktoIdent = "5951950";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE07100208900005951950", iban.toString());
    	assertEquals("HYVEDEMM488", iban.getBic());
    	
    	
    	// Testfall O
    	// BLZ 850 200 86 Kto 847321750
    	bankIdent = "85020086";
    	ktoIdent = "847321750";
    	
    	try {
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    }
    
    @Test
    public void rule003301(){
    	// Testfall P1
    	// BLZ 700 202 70 Kto 2950219435
    	bankIdent = "70020270";
    	ktoIdent = "2950219435";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE76700202702950219435", iban.toString());
    	assertEquals("HYVEDEMMXXX", iban.getBic());
    	
    	
    	// Testfall P2
    	// BLZ 700 202 70 Kto 1457032621
    	bankIdent = "70020270";
    	ktoIdent = "1457032621";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE92660202861457032621", iban.toString());
    	assertEquals("HYVEDEMM475", iban.getBic());
    	
    	
    	// Testfall P3
    	// BLZ 700 202 70 Kto 897
    	bankIdent = "70020270";
    	ktoIdent = "897";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE55700202700000000897", iban.toString());
    	assertEquals("HYVEDEMMXXX", iban.getBic());

    	
    	// Testfall P4
    	// BLZ 700 202 70 Kto 847321750
    	bankIdent = "70020270";
    	ktoIdent = "847321750";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE36700202700847321750", iban.toString());
    	assertEquals("HYVEDEMMXXX", iban.getBic());
    	
    	
    	// Testfall Sonder
    	// BLZ 700 202 70 Kto 1111111
    	bankIdent = "70020270";
    	ktoIdent = "1111111";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE88700202700039908140", iban.toString());
    	assertEquals("HYVEDEMMXXX", iban.getBic());
    }
    
    @Test
    public void rule003400(){
    	// Testfall Q1
    	// BLZ 600 202 90 Kto 1320815432
    	bankIdent = "60020290";
    	ktoIdent = "1320815432";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE69600202901320815432", iban.toString());
    	assertEquals("HYVEDEMM473", iban.getBic());
    	
    	
    	// Testfall Q2
    	// BLZ 600 202 90 Kto 1457032621
    	bankIdent = "60020290";
    	ktoIdent = "1457032621";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE92660202861457032621", iban.toString());
    	assertEquals("HYVEDEMM475", iban.getBic());
    	
    	
    	// Testfall Q3
    	// BLZ 600 202 90 Kto 5951950
    	bankIdent = "60020290";
    	ktoIdent = "5951950";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE67600202900005951950", iban.toString());
    	assertEquals("HYVEDEMM473", iban.getBic());
    	
    	
    	// Testfall Q4
    	// BLZ 600 202 90 Kto 847321750
    	bankIdent = "60020290";
    	ktoIdent = "847321750";
    	
    	try {
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	
    	// Testfall Pseudo
    	// BLZ 600 202 90 Kto 500500500
    	bankIdent = "60020290";
    	ktoIdent = "500500500";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE82600202904340111112", iban.toString());
    	assertEquals("HYVEDEMM473", iban.getBic());
   }
    
    @Test
    public void rule003501(){
    	// Testfall R1
    	// BLZ 790 200 76 Kto 1050958422
    	bankIdent = "79020076";
    	ktoIdent = "1050958422";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE42790200761050958422", iban.toString());
    	assertEquals("HYVEDEMM455", iban.getBic());
    	
    	
    	// Testfall R2
    	// BLZ 790 200 76 Kto 1320815432
    	bankIdent = "79020076";
    	ktoIdent = "1320815432";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE69600202901320815432", iban.toString());
    	assertEquals("HYVEDEMM473", iban.getBic());
    	
    	
    	// Testfall R3
    	// BLZ 790 200 76 Kto 5951950
    	bankIdent = "79020076";
    	ktoIdent = "5951950";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE56790200760005951950", iban.toString());
    	assertEquals("HYVEDEMM455", iban.getBic());
    	
    	
    	// Testfall R4
    	// BLZ 790 200 76 Kto 847321750
    	bankIdent = "79020076";
    	ktoIdent = "847321750";
    	
    	try {
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	
    	// Testfall Sonder
    	// BLZ 790 200 76 Kto 9696
    	bankIdent = "79020076";
    	ktoIdent = "9696";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE29790200761490196966", iban.toString());
    	assertEquals("HYVEDEMM455", iban.getBic());
    }
       
    @Test
    public void rule003600(){
    	// *** Variante 1 *** 
    	// BLZ 20050000 Kto 0000101105
    	bankIdent = "20050000";
    	ktoIdent = "0000101105";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE32210500000101105000", iban.toString());
    	
    	// BLZ 21050000 Kto 0000840132
    	bankIdent = "21050000";
    	ktoIdent = "0000840132";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE91210500000840132000", iban.toString());
    	
    	// BLZ 23050000 Kto 0000631879
    	bankIdent = "23050000";
    	ktoIdent = "0000631879";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE81210500000631879000", iban.toString());
    	// *** Ende Variante 1 ***
    	
    	
    	// *** Variante 2 ***
    	// * 8 stellig *
    	// BLZ 20050000 Kto 0030000025
    	bankIdent = "20050000";
    	ktoIdent = "0030000025";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE75210500000030000025", iban.toString());
    	
    	// BLZ 23050000 Kto 0051300528
    	bankIdent = "23050000";
    	ktoIdent = "0051300528";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE76210500000051300528", iban.toString());
    	// * Ende 8 stellig *
    	
    	// * 9 stellig *
    	// BLZ 20050000 Kto 0100271010
    	bankIdent = "20050000";
    	ktoIdent = "0100271010";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE85210500000100271010", iban.toString());
    	
    	// BLZ 23050000 Kto 0319574000
    	bankIdent = "23050000";
    	ktoIdent = "0319574000";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE55210500000319574000", iban.toString());
    	// * Ende 9 stellig *
    	
    	// * 10 stellig, 1. Stelle = 1, 3, 4, 5, 6 *
    	// BLZ 20050000 Kto 3060000035
    	bankIdent = "20050000";
    	ktoIdent = "3060000035";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE13210500003060000035", iban.toString());
    	
    	// BLZ 23050000 Kto 3070010313
    	bankIdent = "23050000";
    	ktoIdent = "3070010313";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE09210500003070010313", iban.toString());
    	
    	// BLZ 21050000 Kto 1100001928
    	bankIdent = "21050000";
    	ktoIdent = "1100001928";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE51210500001100001928", iban.toString());
    	// * Ende 10 stellig, 1. Stelle = 1, 3, 4, 5, 6 *
    	
    	// * 10 stellig, 1.+ 2. Stelle = 70 *
    	// BLZ 20050000 Kto 7052000037
    	bankIdent = "20050000";
    	ktoIdent = "7052000037";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE82210500007052000037", iban.toString());
    	
    	// BLZ 23050000 Kto 7053001166
    	bankIdent = "23050000";
    	ktoIdent = "7053001166";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE07210500007053001166", iban.toString());
    	// * Ende 10 stellig, 1.+ 2. Stelle = 70 *
    	
    	// * 10 stellig, 1.+ 2. Stelle = 85 *
    	// BLZ 20050000 Kto 8553002045
    	bankIdent = "20050000";
    	ktoIdent = "8553002045";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE20210500008553002045", iban.toString());
    	
    	// BLZ 23050000 Kto 8553009087
    	bankIdent = "23050000";
    	ktoIdent = "8553009087";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE06210500008553009087", iban.toString());
    	// * Ende 10 stellig, 1.+ 2. Stelle = 85 *
    	
    	// * 10 stellig, 1. Stelle = 9 *
    	// BLZ 20050000 Kto 9000010040
    	bankIdent = "20050000";
    	ktoIdent = "9000010040";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE37210500009000010040", iban.toString());
    	
    	// BLZ 23050000 Kto 9000906093
    	bankIdent = "23050000";
    	ktoIdent = "9000906093";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE55210500009000906093", iban.toString());
    	// * Ende 10 stellig, 1. Stelle = 9 *
    	// *** Ende Variante 2 ***
    	
    	
    	// *** Variante 3 (keine Berechnung) ***
    	// BLZ 20050000 Kto 0000000000
    	bankIdent = "20050000";
    	ktoIdent = "0000000000";
    	try {
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 20050000 Kto 0000099999
    	bankIdent = "20050000";
    	ktoIdent = "0000099999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 20050000 Kto 0000900000
    	bankIdent = "20050000";
    	ktoIdent = "0000900000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 20050000 Kto 0029999999
    	bankIdent = "20050000";
    	ktoIdent = "0029999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
   	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 20050000 Kto 0060000000
    	bankIdent = "20050000";
    	ktoIdent = "0060000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 21050000 Kto 0099999999
    	bankIdent = "21050000";
    	ktoIdent = "0099999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
   	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 21050000 Kto 0900000000
    	bankIdent = "21050000";
    	ktoIdent = "0900000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
   	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 21050000 Kto 0999999999
    	bankIdent = "21050000";
    	ktoIdent = "0999999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
 	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 21050000 Kto 2000000000
    	bankIdent = "21050000";
    	ktoIdent = "2000000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
   	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 2999999999
    	bankIdent = "23050000";
    	ktoIdent = "2999999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
   	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 7100000000
    	bankIdent = "23050000";
    	ktoIdent = "7100000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
  	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 8499999999
    	bankIdent = "23050000";
    	ktoIdent = "8499999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
   	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 8600000000
    	bankIdent = "23050000";
    	ktoIdent = "8600000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
  	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 8999999999
    	bankIdent = "23050000";
    	ktoIdent = "8999999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
  	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	// *** Ende Variante 3 ***
    }
    
    @Test
    public void rule003700(){
    	// BLZ 201 107 00, Kto 0000123456
    	bankIdent = "20110700";
    	ktoIdent = "0000123456";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE41300107000000123456", iban.toString());
    	assertEquals("BOTKDEDXXXX", iban.getBic());
    	
    	
    	// BLZ 300 107 00, Kto 0000654321
    	bankIdent = "30010700";
    	ktoIdent = "0000654321";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE85300107000000654321", iban.toString());
    	assertEquals("BOTKDEDXXXX", iban.getBic());
    }
    
    @Test
    public void rule003800(){
    	// BLZ 26691213, Kto 1234567890
    	bankIdent = "26691213";
    	ktoIdent = "1234567890";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE25285900751234567890", iban.toString());
    	assertEquals("GENODEF1LER", iban.getBic());
    	
    	
    	// BLZ 28591579, Kto 88654578
    	bankIdent = "28591579";
    	ktoIdent = "88654578";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE32285900750088654578", iban.toString());
    	assertEquals("GENODEF1LER", iban.getBic());
    	
    	// BLZ 25090300, Kto 7789845
    	bankIdent = "25090300";
    	ktoIdent = "7789845";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE43285900750007789845", iban.toString());
    	assertEquals("GENODEF1LER", iban.getBic());
    }
    
    @Test
    public void rule003900(){
    	// BLZ 26621413, Kto 1234567890
    	bankIdent = "26621413";
    	ktoIdent = "1234567890";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE13280200501234567890", iban.toString());
    	assertEquals("OLBODEH2XXX", iban.getBic());
    	
    	
    	// BLZ 26621413, Kto 1234567890
    	bankIdent = "28320014";
    	ktoIdent = "88654578";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE20280200500088654578", iban.toString());
    	assertEquals("OLBODEH2XXX", iban.getBic());
    }
    
    @Test
    public void rule004001(){
    	// BLZ 680 513 10, Kto 6015002
    	bankIdent = "68051310";
    	ktoIdent = "6015002";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE17680523280006015002", iban.toString());
    	assertEquals("SOLADES1STF", iban.getBic());
    }
    
    @Test
    public void rule004100(){
    	// BLZ 10000000, Kto 50462000
    	bankIdent = "62220000";
    	ktoIdent = "0062220000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE96500604000000011404", iban.toString());
    	assertEquals("GENODEFFXXX", iban.getBic());
    }
    
    @Test
    public void rule004200(){
    	//	BLZ 10000000, Kto 50462000
    	bankIdent = "10000000";
    	ktoIdent = "50462000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE08100000000050462000", iban.toString());
    	
    	//	BLZ 45000000, Kto 10001000
    	bankIdent = "45000000";
    	ktoIdent = "10001000";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE26450000000010001000", iban.toString());
    	
    	//	2 Bsp. für eine KtoNr, die nicht konvertiert werden darf
    	bankIdent = "60000000";
    	ktoIdent = "123456";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
 	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    	
    	bankIdent = "82000000";
    	ktoIdent = "65400111";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
 	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    }
    
    @Test
    public void rule004301(){
    	// BLZ 60651070, Kto 868
    	bankIdent = "60651070";
    	ktoIdent = "868";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE49666500850000000868", iban.toString());
    	assertEquals("PZHSDE66XXX", iban.getBic());

    	// BLZ 60651070, Kto 12602
    	bankIdent = "60651070";
    	ktoIdent = "12602";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE33666500850000012602", iban.toString());
    	assertEquals("PZHSDE66XXX", iban.getBic());
    }
    
    @Test
    public void rule004400(){
    	// BLZ 68050101
    	bankIdent = "68050101";
    	ktoIdent = "202";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE51680501010002282022", iban.toString());
    }
    
    @Test
    public void rule004501(){
    	// BLZ 68050101
    	bankIdent = "50210142";
    	ktoIdent = "12345678";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE08502101420012345678", iban.toString());
    	assertEquals("ESSEDE5FXXX", iban.getBic());
    }
    
    @Test
    public void rule004600(){
    	// BLZ 101 206 00
    	bankIdent = "10120600";
    	ktoIdent = "1234567890";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE68101206001234567890", iban.toString());
    	assertEquals("SCFBDE33XXX", iban.getBic());
    	
    	bankIdent = "25020600";
    	ktoIdent = "1234567890";
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	assertEquals("DE62310108331234567890", iban.toString());
    	assertEquals("CCBADE31XXX", iban.getBic());
    }
    
    @Test
    public void rule004700(){
    	// BLZ 10033300
	bankIdent = "10033300";
	ktoIdent = "12345678";
	
	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	assertEquals("DE73100333001234567800", iban.toString());
	

	bankIdent = "10033300";
	ktoIdent = "123456789";
	
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	assertEquals("DE39100333000123456789", iban.toString());
	
    }
    
    @Test
    public void rule004800(){
    	// BLZ 101 208 00
    	bankIdent = "10120800";
    	ktoIdent = "1231234567";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE12360102001231234567", iban.toString());
    	assertEquals("VONEDE33XXX", iban.getBic());
    }
    
    @Test
    public void rule004900(){
    	// BLZ 30060010
	bankIdent = "30060010";
	ktoIdent = "0001991182";
	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE26300600109911820001", iban.toString());

	bankIdent = "30060010";
	ktoIdent = "36";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE57300600100002310113", iban.toString());

	
	bankIdent = "30060010";
	ktoIdent = "1234967890";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE12300600109678901234", iban.toString());

	// BLZ 40060000
	bankIdent = "40060000";
	ktoIdent = "1234967890";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE91400600009678901234", iban.toString());

	bankIdent = "40060000";
	ktoIdent = "999";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE89400600000001310113", iban.toString());
    
	// BLZ 57060000
	bankIdent = "57060000";
	ktoIdent = "967891";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE52570600009678910000", iban.toString());
	
	bankIdent = "57060000";
	ktoIdent = "6060";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE50570600000000160602", iban.toString());
    }
        
    @Test
    public void rule005000(){
	
	bankIdent = "28252760";
	ktoIdent = "130084981";
	
	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	assertEquals("DE24285500000130084981", iban.toString());
	assertEquals("BRLADE21LER", iban.getBic());
    }
    
    @Test
    public void rule005100(){
    	//	BLZ 60050101
    	bankIdent = "60050101";
    	ktoIdent = "0500500500";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE25600501010005005000", iban.toString());
    }
    
    @Test
    public void rule005200()
    {
    	//	Erst die, die funktionieren müssen
    	// BLZ 67220020
    	bankIdent = "67220020";
    	ktoIdent = "5308810004";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE38600501010002662604", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 69421020
    	bankIdent = "69421020";
    	ktoIdent = "6208908100";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE85600501017481501341", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 66620020
    	bankIdent = "66620020";
    	ktoIdent = "4840404000";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE13600501017498502663", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 64120030
    	bankIdent = "64120030";
    	ktoIdent = "1201200100";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE28600501017477501214", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 64020030
    	bankIdent = "64020030";
    	ktoIdent = "1408050100";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE82600501017469534505", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 64020030
    	bankIdent = "63020130";
    	ktoIdent = "1112156300";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE69600501010004475655", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 62030050
    	bankIdent = "62030050";
    	ktoIdent = "7002703200";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE72600501017406501175", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 69220020
    	bankIdent = "69220020";
    	ktoIdent = "6402145400";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e1) {
	    e1.printStackTrace();
	}
    	
    	assertEquals("DE91600501017485500252", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	//	Jetzt noch ein Beispiel, das nicht konvertiert werden darf
    	// BLZ 69220020
    	bankIdent = "67220020";
    	ktoIdent = "1234567890";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
  	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    }
    
    @Test
    public void rule005300()
    {
    	//	BLZ 55050000
    	bankIdent = "55050000";
    	ktoIdent = "35000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE94600501017401555913", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	//	BLZ 60020030
    	bankIdent = "60020030";
    	ktoIdent = "1003340500";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE06600501010002001155", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 60050000
    	bankIdent = "60050000";
    	ktoIdent = "3002";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE23600501010001367924", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 66020020
    	bankIdent = "66020020";
    	ktoIdent = "4002015800";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE02600501017495530102", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 66050000
    	bankIdent = "66050000";
    	ktoIdent = "85304";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE15600501017402045439", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 86050000
    	bankIdent = "86050000";
    	ktoIdent = "3535";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE61600501017461505611", iban.toString());
    	assertEquals("SOLADEST600", iban.getBic());
    	
    	// BLZ 55050000 (no account mapping)
    	bankIdent = "55050000";
    	ktoIdent = "4658732104";
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE85550500004658732104", iban.toString());
    	assertEquals("SOLADEST550", iban.getBic());
    }
    
    @Test
    public void rule005400(){
    	bankIdent = "10060237";
    	ktoIdent = "16307000";
    	
    	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE26100602370163107000", iban.toString());
    	
    	bankIdent = "21060237";
    	ktoIdent = "12796740";
    	
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	
    	assertEquals("DE92210602370012796743", iban.toString());
    }
    
    @Test
    public void rule005500() {
	bankIdent = "25410300";
	ktoIdent = "7456123400";
	
	Iban iban = null;
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
	
	assertEquals("DE47254102007456123400", iban.toString());
    }
    
    @Test
    public void rule005600() {
	bankIdent = "38010111";
	ktoIdent = "12345678";
	Iban iban = null;
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
  	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}

    	
    	bankIdent = "38010111";
    	ktoIdent = "36";
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	assertEquals("DE29380101111010240003", iban.toString());
    	
    	
    	bankIdent = "67010111";
    	ktoIdent = "6800";
    	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	} catch (IbanException e) {
	    e.printStackTrace();
	}
    	assertEquals("DE02670101111296401301", iban.toString());
    	
    	bankIdent = "68310111";
    	ktoIdent = "12345678";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	    assertTrue("Asserting exception", false);
  	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULATION, e.getMessage());
    	}
    }
}
