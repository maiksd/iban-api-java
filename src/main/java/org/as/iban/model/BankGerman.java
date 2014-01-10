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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Represents a german bank
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
public class BankGerman {

    private static final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    private static final String SCHEMA_LANG = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private String blz;
    private String bic;
    private String ruleId;
    private String name;
    private IbanRuleGerman rule;

    private static ThreadLocal<Document> documentBank = new ThreadLocal();

	

    /**
     * Constructor. Reads the informations for a specific bank from banks_german.xml
     * @param blz	The BLZ for a german bank (bank identifier)
     * @throws IbanException
     */
	public BankGerman( String blz ) throws IbanException {
		this.blz = blz;

		readBankConfig();
		if( ruleId.equals( "000000" ) || ruleId.equals( "000100" ) )
			this.rule = null;
		else
			this.rule = new IbanRuleGerman( "_" + ruleId );
	}
    
    private static synchronized Document getDocumentBank() {
    	if( documentBank.get() == null ) {
    	    DocumentBuilderFactory factoryBank = DocumentBuilderFactory.newInstance();
    		try {
    		    factoryBank.setNamespaceAware(true);
    		    factoryBank.setValidating(true);
    		    factoryBank.setAttribute(SCHEMA_LANG,XML_SCHEMA);
    		    factoryBank.setAttribute(SCHEMA_SOURCE, BankGerman.class.getResourceAsStream("/banks_german.xsd"));
    		
    		    DocumentBuilder builderBank = factoryBank.newDocumentBuilder();
    		    documentBank.set( builderBank.parse(BankGerman.class.getResourceAsStream("/banks_german.xml")) );
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
    	return documentBank.get();
    }
    
    /**
     * Reads the configuration of the bank from config file
     * @throws IbanException
     */
	private void readBankConfig() throws IbanException {

		Document doc = getDocumentBank();

		NodeList nodeBank = null;
		try {
			nodeBank = doc.getElementById( "_" + this.blz ).getChildNodes();
		} catch( Exception e ) {
			throw new IbanException( IbanException.IBAN_EXCEPTION_INVALID_BANKIDENT );
		}

		if( nodeBank.getLength() == 0 ) throw new IbanException( IbanException.IBAN_EXCEPTION_INVALID_BANKIDENT );

		for( int i = 0; i < nodeBank.getLength(); i++ ) {
			Node node = nodeBank.item( i );
			String nodeName = node.getNodeName();
			if( nodeName.equals( "bic" ) ) {
				if( !node.getTextContent().isEmpty() ) this.bic = node.getTextContent();
			} else if( nodeName.equals( "rule" ) )
				this.ruleId = node.getTextContent();
			else if( nodeName.equals( "name" ) ) this.name = node.getTextContent();
		}
	}
    
    /**
     * Get the current bank identifier of the bank
     * @return	The current bank identifier
     */
    public String getBlz() {
    	return blz;
    }
    
    /**
     * Set the bank identifier for this bank (i.e. in case of mapping)
     * @param blz The new bank identifier
     * @throws IbanException
     */
    public void setBlz (String blz) throws IbanException {
	this.blz = blz;
	readBankConfig();
	if (ruleId.equals("000000") || ruleId.equals("000100"))
	    this.rule = null;
	else
	    this.rule = new IbanRuleGerman("_" + ruleId);
    }
    
    /**
     * Get the BIC of the current bank identifier number
     * @return	BIC associated with the bank
     */
    public String getBic() {
	if (this.rule != null) {
	    if (rule.isMappingBic(blz))
		this.bic = rule.getMappedBic(blz);
	}
        return bic;
    }

    /**
     * Get the IBAN ruleID associated to the current bank identifier number
     * @return	The IBAN ruleID associated to the current bank identifier number
     */
    public String getRuleId() {
        return ruleId;
    }
    
    /**
     * Get the IBAN rule associated to the current bank identifier number
     * @return	The IBAN rule associated to the current bank identifier number
     */
    public IbanRuleGerman getIbanRule(){
	return rule;
    }
    
    /**
     * Get the name of the current bank
     * @return	The name of the current bank
     */
    private String getName() {
	return name;
    }
    
}
