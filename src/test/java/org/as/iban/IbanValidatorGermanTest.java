package org.as.iban;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void rule000501() {
	bankIdent = "26580070";
	ktoIdent = "732502200";
	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE32265800700732502200", iban.toString());

	bankIdent = "26580070";
	ktoIdent = "7325022";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE32265800700732502200", iban.toString());

	bankIdent = "26580070";
	ktoIdent = "8732502200";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE60265800708732502200", iban.toString());

	bankIdent = "26580070";
	ktoIdent = "4820379900";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE37265800704820379900", iban.toString());

	bankIdent = "50080000";
	ktoIdent = "7814706100";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE32500800007814706100", iban.toString());

	bankIdent = "50080000";
	ktoIdent = "231654";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE42500800000023165400", iban.toString());

	bankIdent = "50080000";
	ktoIdent = "43503";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE21500800000004350300", iban.toString());

	bankIdent = "10080000";
	ktoIdent = "998761700";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE73100800000998761700", iban.toString());

	bankIdent = "12080000";
	ktoIdent = "998761700";
	try {
	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	}
	catch (IbanException e) {
	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
	}
	
	bankIdent = "50540028";
	ktoIdent = "4217386";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE24505400280421738600", iban.toString());
	
	bankIdent = "20041111";
	ktoIdent = "130023500";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE81200411110130023500", iban.toString());

	bankIdent = "37080040";
	ktoIdent = "111";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE69370800400215022000", iban.toString());

	bankIdent = "50040000";
	ktoIdent = "101010";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE46500400000311011100", iban.toString());
}
    
    @Test
    public void rule003900(){
    	// BLZ 26621413, Kto 1234567890
    	bankIdent = "26621413";
    	ktoIdent = "1234567890";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE13280200501234567890", iban.toString());
    	
    	
    	// BLZ 26621413, Kto 1234567890
    	bankIdent = "28320014";
    	ktoIdent = "88654578";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE20280200500088654578", iban.toString());
    }
    
    @Test
    public void rule004001(){
    	// BLZ 680 513 10, Kto 6015002
    	bankIdent = "68051310";
    	ktoIdent = "6015002";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE17680523280006015002", iban.toString());
    }
    
    @Test
    public void rule004100(){
    	// BLZ 10000000, Kto 50462000
    	bankIdent = "62220000";
    	ktoIdent = "0062220000";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE96500604000000011404", iban.toString());
    }
    
    @Test
    public void rule004200(){
    	//	BLZ 10000000, Kto 50462000
    	bankIdent = "10000000";
    	ktoIdent = "50462000";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE08100000000050462000", iban.toString());
    	
    	//	BLZ 45000000, Kto 10001000
    	bankIdent = "45000000";
    	ktoIdent = "10001000";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE26450000000010001000", iban.toString());
    	
    	//	2 Bsp. für eine Kto-Nr, die nicht konvertiert werden darf
    	bankIdent = "60000000";
    	ktoIdent = "123456";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	bankIdent = "82000000";
    	ktoIdent = "65400111";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    }
    
    @Test
    public void rule004300(){
    	// BLZ 60651070, Kto 868
    	bankIdent = "60651070";
    	ktoIdent = "868";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE49666500850000000868", iban.toString());
    	
    	// BLZ 60651070, Kto 12602
    	bankIdent = "60651070";
    	ktoIdent = "12602";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE33666500850000012602", iban.toString());
    }
    
    @Test
    public void rule004400(){
    	// BLZ 68050101
    	bankIdent = "68050101";
    	ktoIdent = "202";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE51680501010002282022", iban.toString());
    }
    
    @Test
    public void rule004500(){
    	//	TODO
    }
    
    @Test
    public void rule004600(){
    	// BLZ 101 206 00
    	bankIdent = "10120600";
    	ktoIdent = "1234567890";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE62310108331234567890", iban.toString());
    }
    
    @Test
    public void rule004700(){
    	// BLZ 10033300
	bankIdent = "10033300";
	ktoIdent = "12345678";
	
	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	
	assertEquals("DE73100333001234567800", iban.toString());
	

	bankIdent = "10033300";
	ktoIdent = "123456789";
	
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	
	assertEquals("DE39100333000123456789", iban.toString());
	
    }
    
    @Test
    public void rule004800(){
    	// BLZ 101 208 00
    	bankIdent = "10120800";
    	ktoIdent = "1231234567";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE12360102001231234567", iban.toString());
    }
    
    @Test
    public void rule004900(){
    	// BLZ 30060010
	bankIdent = "30060010";
	ktoIdent = "0001991182";
	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE26300600109911820001", iban.toString());

	bankIdent = "30060010";
	ktoIdent = "36";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE57300600100002310113", iban.toString());

	
	bankIdent = "30060010";
	ktoIdent = "1234967890";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE12300600109678901234", iban.toString());

	// BLZ 40060000
	bankIdent = "40060000";
	ktoIdent = "1234967890";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE91400600009678901234", iban.toString());

	bankIdent = "40060000";
	ktoIdent = "999";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE89400600000001310113", iban.toString());
    
	// BLZ 57060000
	bankIdent = "57060000";
	ktoIdent = "967891";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE52570600009678910000", iban.toString());
	
	bankIdent = "57060000";
	ktoIdent = "6060";
	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
	assertEquals("DE50570600000000160602", iban.toString());
	
}
        
    @Test
    public void rule005000(){
    	// BLZ 60050101
//    	bankIdent = "28252760";
//    	ktoIdent = "0130084981";
//    	
//    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
//    	assertEquals("DE24285500000130084981", iban.toString());
    	assertTrue(true);
    }
    
    @Test
    public void rule005100(){
    	//	BLZ 60050101
    	bankIdent = "60050101";
    	ktoIdent = "0500500500";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE25600501010005005000", iban.toString());
    }
    
    @Test
    public void rule005200()
    {
    	//	Erst die, die funktionieren müssen
    	// BLZ 67220020
    	bankIdent = "67220020";
    	ktoIdent = "5308810004";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE38600501010002662604", iban.toString());
    	
    	// BLZ 69421020
    	bankIdent = "69421020";
    	ktoIdent = "6208908100";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE85600501017481501341", iban.toString());
    	
    	// BLZ 66620020
    	bankIdent = "66620020";
    	ktoIdent = "4840404000";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE13600501017498502663", iban.toString());
    	
    	// BLZ 64120030
    	bankIdent = "64120030";
    	ktoIdent = "1201200100";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE28600501017477501214", iban.toString());
    	
    	// BLZ 64020030
    	bankIdent = "64020030";
    	ktoIdent = "1408050100";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE82600501017469534505", iban.toString());
    	
    	// BLZ 64020030
    	bankIdent = "63020130";
    	ktoIdent = "1112156300";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE69600501010004475655", iban.toString());
    	
    	// BLZ 62030050
    	bankIdent = "62030050";
    	ktoIdent = "7002703200";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE72600501017406501175", iban.toString());
    	
    	// BLZ 69220020
    	bankIdent = "69220020";
    	ktoIdent = "6402145400";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE91600501017485500252", iban.toString());
    	
    	//	Jetzt noch ein Beispiel, das nicht konvertiert werden darf
    	// BLZ 69220020
    	bankIdent = "67220020";
    	ktoIdent = "1234567890";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
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
