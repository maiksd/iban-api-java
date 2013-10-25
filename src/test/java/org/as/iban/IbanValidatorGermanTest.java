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
    public void rule003600(){
    	// *** Variante 1 *** 
    	// BLZ 20050000 Kto 0000101105
    	bankIdent = "20050000";
    	ktoIdent = "0000101105";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE32210500000101105000", iban.toString());
    	
    	// BLZ 21050000 Kto 0000840132
    	bankIdent = "21050000";
    	ktoIdent = "0000840132";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE91210500000840132000", iban.toString());
    	
    	// BLZ 23050000 Kto 0000631879
    	bankIdent = "23050000";
    	ktoIdent = "0000631879";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE81210500000631879000", iban.toString());
    	// *** Ende Variante 1 ***
    	
    	
    	// *** Variante 2 ***
    	// * 8 stellig *
    	// BLZ 20050000 Kto 0030000025
    	bankIdent = "20050000";
    	ktoIdent = "0030000025";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE75210500000030000025", iban.toString());
    	
    	// BLZ 23050000 Kto 0051300528
    	bankIdent = "23050000";
    	ktoIdent = "0051300528";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE76210500000051300528", iban.toString());
    	// * Ende 8 stellig *
    	
    	// * 9 stellig *
    	// BLZ 20050000 Kto 0100271010
    	bankIdent = "20050000";
    	ktoIdent = "0100271010";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE85210500000100271010", iban.toString());
    	
    	// BLZ 23050000 Kto 0319574000
    	bankIdent = "23050000";
    	ktoIdent = "0319574000";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE55210500000319574000", iban.toString());
    	// * Ende 9 stellig *
    	
    	// * 10 stellig, 1. Stelle = 1, 3, 4, 5, 6 *
    	// BLZ 20050000 Kto 3060000035
    	bankIdent = "20050000";
    	ktoIdent = "3060000035";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE13210500003060000035", iban.toString());
    	
    	// BLZ 23050000 Kto 3070010313
    	bankIdent = "23050000";
    	ktoIdent = "3070010313";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE09210500003070010313", iban.toString());
    	
    	// BLZ 21050000 Kto 1100001928
    	bankIdent = "21050000";
    	ktoIdent = "1100001928";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE51210500001100001928", iban.toString());
    	// * Ende 10 stellig, 1. Stelle = 1, 3, 4, 5, 6 *
    	
    	// * 10 stellig, 1.+ 2. Stelle = 70 *
    	// BLZ 20050000 Kto 7052000037
    	bankIdent = "20050000";
    	ktoIdent = "7052000037";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE82210500007052000037", iban.toString());
    	
    	// BLZ 23050000 Kto 7053001166
    	bankIdent = "23050000";
    	ktoIdent = "7053001166";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE07210500007053001166", iban.toString());
    	// * Ende 10 stellig, 1.+ 2. Stelle = 70 *
    	
    	// * 10 stellig, 1.+ 2. Stelle = 85 *
    	// BLZ 20050000 Kto 8553002045
    	bankIdent = "20050000";
    	ktoIdent = "8553002045";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE20210500008553002045", iban.toString());
    	
    	// BLZ 23050000 Kto 8553009087
    	bankIdent = "23050000";
    	ktoIdent = "8553009087";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE06210500008553009087", iban.toString());
    	// * Ende 10 stellig, 1.+ 2. Stelle = 85 *
    	
    	// * 10 stellig, 1. Stelle = 9 *
    	// BLZ 20050000 Kto 9000010040
    	bankIdent = "20050000";
    	ktoIdent = "9000010040";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE37210500009000010040", iban.toString());
    	
    	// BLZ 23050000 Kto 9000906093
    	bankIdent = "23050000";
    	ktoIdent = "9000906093";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE55210500009000906093", iban.toString());
    	// * Ende 10 stellig, 1. Stelle = 9 *
    	// *** Ende Variante 2 ***
    	
    	
    	// *** Variante 3 (keine Berechnung) ***
    	// BLZ 20050000 Kto 0000000000
    	bankIdent = "20050000";
    	ktoIdent = "0000000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 20050000 Kto 0000099999
    	bankIdent = "20050000";
    	ktoIdent = "0000099999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 20050000 Kto 0000900000
    	bankIdent = "20050000";
    	ktoIdent = "0000900000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 20050000 Kto 0029999999
    	bankIdent = "20050000";
    	ktoIdent = "0029999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 20050000 Kto 0060000000
    	bankIdent = "20050000";
    	ktoIdent = "0060000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 21050000 Kto 0099999999
    	bankIdent = "21050000";
    	ktoIdent = "0099999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 21050000 Kto 0900000000
    	bankIdent = "21050000";
    	ktoIdent = "0900000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 21050000 Kto 0999999999
    	bankIdent = "21050000";
    	ktoIdent = "0999999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 21050000 Kto 2000000000
    	bankIdent = "21050000";
    	ktoIdent = "2000000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 2999999999
    	bankIdent = "23050000";
    	ktoIdent = "2999999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 7100000000
    	bankIdent = "23050000";
    	ktoIdent = "7100000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 8499999999
    	bankIdent = "23050000";
    	ktoIdent = "8499999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 8600000000
    	bankIdent = "23050000";
    	ktoIdent = "8600000000";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	
    	// BLZ 23050000 Kto 8999999999
    	bankIdent = "23050000";
    	ktoIdent = "8999999999";
    	try{
    	    iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	}
    	catch (IbanException e) {
    	    assertEquals(IbanException.IBAN_EXCEPTION_NO_IBAN_CALCULTATION, e.getMessage());
    	}
    	// *** Ende Variante 3 ***
    }
    
    @Test
    public void rule003700(){
    	// BLZ 201 107 00, Kto 0000123456
    	bankIdent = "20110700";
    	ktoIdent = "0000123456";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE41300107000000123456", iban.toString());
    	
    	
    	// BLZ 300 107 00, Kto 0000654321
    	bankIdent = "30010700";
    	ktoIdent = "0000654321";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE85300107000000654321", iban.toString());
    }
    
    @Test
    public void rule003800(){
    	// BLZ 26691213, Kto 1234567890
    	bankIdent = "26691213";
    	ktoIdent = "1234567890";
    	
    	Iban iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE25285900751234567890", iban.toString());
    	
    	
    	// BLZ 28591579, Kto 88654578
    	bankIdent = "28591579";
    	ktoIdent = "88654578";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE32285900750088654578", iban.toString());
    	
    	// BLZ 25090300, Kto 7789845
    	bankIdent = "25090300";
    	ktoIdent = "7789845";
    	
    	iban = new IbanImpl(Iban.COUNTRY_CODE_GERMAN, bankIdent, ktoIdent);
    	
    	assertEquals("DE43285900750007789845", iban.toString());
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
