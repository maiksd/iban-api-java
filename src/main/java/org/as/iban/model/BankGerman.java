/**
 * 2013-10-xx	RG: new
 */

package org.as.iban.model;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Represents a german bank.
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 *
 */
public class BankGerman {

	//	local variables
    final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    final String SCHEMA_LANG = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private String blz;
    private String bic;
    private String ruleId;
    private String name;
    private IbanRuleGerman rule;

    DocumentBuilderFactory factoryMapping = DocumentBuilderFactory.newInstance();
    DocumentBuilder builderMapping;
    Document documentMapping = null;
	
    DocumentBuilderFactory factoryBank = DocumentBuilderFactory.newInstance();
    DocumentBuilder builderBank;
    Document documentBank = null;
	

    /**
     * Constructor. Reads the informations for a specific bank from banks_german.xml 
     * @param blz	The BLZ for a german bank (bank identifier)
     */
    public BankGerman (String blz) {
	this.blz = blz;

	try {
	    factoryMapping.setNamespaceAware(true);
	    factoryMapping.setValidating(true);
	    factoryMapping.setAttribute(SCHEMA_LANG, XML_SCHEMA);
	    factoryMapping.setAttribute(SCHEMA_SOURCE, this.getClass().getResourceAsStream("/mapping_german.xsd"));
	    
	    builderMapping = factoryMapping.newDocumentBuilder();
	    documentMapping = builderMapping.parse(this.getClass().getResourceAsStream("/mapping_german.xml"));
	    
	    factoryBank.setNamespaceAware(true);
	    factoryBank.setValidating(true);
	    factoryBank.setAttribute(SCHEMA_LANG,XML_SCHEMA);
	    factoryBank.setAttribute(SCHEMA_SOURCE, this.getClass().getResourceAsStream("/banks_german.xsd"));
	
	    builderBank = factoryBank.newDocumentBuilder();
	    documentBank = builderBank.parse(this.getClass().getResourceAsStream("/banks_german.xml"));
	    
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
	
	readBankConfig();
	if (ruleId.equals("000000") || ruleId.equals("000100"))
	    this.rule = null;
	else
	    this.rule = new IbanRuleGerman("_" + ruleId);
    }
    
    /**
     * Reads the configuration of the bank from config file
     */
    private void readBankConfig() {
	NodeList nodeMapping = documentMapping.getElementById("_" + blz).getChildNodes();
		
	for (int j = 0; j < nodeMapping.getLength(); j++) {
	    if (nodeMapping.item(j).getNodeName() == "lfdnr") {
		NodeList nodeBank = documentBank.getElementById("_" + nodeMapping.item(j).getTextContent()).getChildNodes();
	    	    
		for (int i = 0; i < nodeBank.getLength(); i++){
		    switch (nodeBank.item(i).getNodeName()){
		    case "blz":
			this.blz = nodeBank.item(i).getTextContent();
			break;
		    case "bic":
			if (!nodeBank.item(i).getTextContent().isEmpty())
			    this.bic = nodeBank.item(i).getTextContent();
			break;
		    case "rule":
			this.ruleId = nodeBank.item(i).getTextContent();
			break;
		    case "name":
			this.name = nodeBank.item(i).getTextContent();
		    }
		}
	    }
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
     */
    public void setBlz (String blz) {
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
