package org.as.iban.model;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.as.iban.exception.IbanException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Represents a iban format of a specified country.
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
public class IbanFormat {
    //	local variables
    final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    final String SCHEMA_LANG = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
    
    private String countryCode;
    private String regexp;
    private int bankIdentLength;
    private int ktoIdentLength;
    
    /**
     * Constructor for the IbanFormat for a specific country
     * @param countryCode	The country code for which the IBAN format definition is loaded
     * @throws IbanException 
     */
    public IbanFormat(String countryCode) throws IbanException {
		this.countryCode = countryCode;
		readFormatConfig();
    }

    /**
     * Reads the iban format information from the config file
     * @throws IbanException 
     */
    private void readFormatConfig() throws IbanException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document = null;
		
		try {
		    factory.setNamespaceAware(true);
		    factory.setValidating(true);
		    factory.setAttribute(SCHEMA_LANG,XML_SCHEMA);
		    factory.setAttribute(SCHEMA_SOURCE, this.getClass().getResourceAsStream("/iban_format.xsd"));
		    
		    builder = factory.newDocumentBuilder();
		    document = builder.parse(this.getClass().getResourceAsStream("/iban_format.xml"));
	
		} catch (ParserConfigurationException e) {
		    e.printStackTrace();
		    System.exit(-1);
		} catch (SAXException e) {
		    e.printStackTrace();
		    System.exit(-1);
		} catch (IOException e) {
		    e.printStackTrace();
		    System.exit(-1);
		}
		
		NodeList nodeFormat = null;
		try {
		    nodeFormat = document.getElementById(countryCode).getChildNodes();
		} catch (Exception e) {
		    throw new IbanException(IbanException.IBAN_EXCEPTION_UNSUPPORTED_COUNTRY);
		}

		if (nodeFormat.getLength() == 0)
		    throw new IbanException(IbanException.IBAN_EXCEPTION_UNSUPPORTED_COUNTRY);

		for (int i = 0; i < nodeFormat.getLength(); i++){
		    switch (nodeFormat.item(i).getNodeName()){
		    	case "regexp":
		    		this.regexp = nodeFormat.item(i).getTextContent();
		    		break;
		    	case "bankIdentLength":
		    		this.bankIdentLength = Integer.valueOf(nodeFormat.item(i).getTextContent());
		    		break;
		    	case "ktoIdentLength":
		    		this.ktoIdentLength = Integer.valueOf(nodeFormat.item(i).getTextContent());
		    }
		}
    }

    /**
     * Gets the regular expression of the IBAN current format
     * @return	The regular expression that represents the current format as defined in iban_format.xml
     */
    public String getRegexp() {
        return regexp;
    }

    /**
     * Gets the defined length for a bank identifier number
     * @return	The max length for a bank identifier number as defined in iban_format.xml
     */
    public int getBankIdentLength() {
        return bankIdentLength;
    }

    /**
     * Gets the defined length for a account identifier number
     * @return	The max length for a account identifier number as defined in iban_format.xml
     */
    public int getKtoIdentLength() {
        return ktoIdentLength;
    }

}
