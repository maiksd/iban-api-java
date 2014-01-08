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

	private static final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    private static final String SCHEMA_LANG = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
    
    private static ThreadLocal<Document> configDoc = new ThreadLocal();
    
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

    private static synchronized Document getConfigDoc() {
    	if( configDoc.get() == null ) {
    		try {
    			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    		    factory.setNamespaceAware(true);
    		    factory.setValidating(true);
    		    factory.setAttribute(SCHEMA_LANG,XML_SCHEMA);
    		    factory.setAttribute(SCHEMA_SOURCE, IbanFormat.class.getResourceAsStream("/src/main/resources/iban_format.xsd"));
    		    
    		    DocumentBuilder builder = factory.newDocumentBuilder();
    		    configDoc.set( builder.parse(IbanFormat.class.getResourceAsStream("/src/main/resources/iban_format.xml")) );
    		} catch (ParserConfigurationException e) {
    		    e.printStackTrace();
    		} catch (SAXException e) {
    		    e.printStackTrace();
    		} catch (IOException e) {
    		    e.printStackTrace();
    		} catch (IllegalArgumentException e ) {
    			e.printStackTrace();
    		}
    		// no System.exit, let it run into an NPE later on or whatever, but do not terminate the entire application!
    	}
    	return configDoc.get();
    }
    
    /**
     * Reads the iban format information from the config file
     * @throws IbanException
     */
    private void readFormatConfig() throws IbanException {
		
    	Document doc = getConfigDoc();
    	NodeList nodeFormat = null;
    	try {
    		nodeFormat = doc.getElementById(countryCode).getChildNodes();
    	} catch (Exception e) {
    		e.printStackTrace();	// FIXME
    		throw new IbanException(IbanException.IBAN_EXCEPTION_UNSUPPORTED_COUNTRY);
    	}

    	if (nodeFormat.getLength() == 0)
    		throw new IbanException(IbanException.IBAN_EXCEPTION_UNSUPPORTED_COUNTRY);

    	for (int i = 0; i < nodeFormat.getLength(); i++){
    		if (nodeFormat.item(i).getNodeName().equals("regexp"))
    			this.regexp = nodeFormat.item(i).getTextContent();
    		else if (nodeFormat.item(i).getNodeName().equals("bankIdentLength"))
    			this.bankIdentLength = Integer.valueOf(nodeFormat.item(i).getTextContent());
    		else if (nodeFormat.item(i).getNodeName().equals("ktoIdentLength"))
    			this.ktoIdentLength = Integer.valueOf(nodeFormat.item(i).getTextContent());
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
