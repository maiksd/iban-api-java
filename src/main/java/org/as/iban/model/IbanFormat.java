/**
 * 2013-10-xx	RG: new
 */

package org.as.iban.model;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
     * Constructor.
     * @param countryCode	The country code of the country for which the iban format should be loaded.
     */
    public IbanFormat(String countryCode) {
		this.countryCode = countryCode;
		readFormatConfig();
    }

    /**
     * Reads the iban format information from the config file. 
     */
    private void readFormatConfig() {
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
		
		NodeList nodeFormat = document.getElementById(countryCode).getChildNodes();
		
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
     * Gets the regular expression of the current format.
     * @return	The regular expression that represents the current format.
     */
    public String getRegexp() {
        return regexp;
    }

    /**
     * Gets the defined length for a bank ident number.
     * @return	The defined length for a bank ident number.
     */
    public int getBankIdentLength() {
        return bankIdentLength;
    }

    /**
     * Gets the defined length for a account ident number.
     * @return	The defined length for a account ident number.
     */
    public int getKtoIdentLength() {
        return ktoIdentLength;
    }

}
