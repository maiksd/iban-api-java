package org.as.iban.impl;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class BankGermanImpl {

    final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    final String SCHEMA_LANG = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private String blz;
    private LinkedList <String> bic;
    private String rule;
    private String name;

    BankGermanImpl (String blz) {
	this.blz = blz;
	this.bic = new LinkedList();
	readBankConfig();
    }
    
    private void readBankConfig() {

	DocumentBuilderFactory factoryMapping = DocumentBuilderFactory.newInstance();
	DocumentBuilder builderMapping;
	Document documentMapping = null;


	DocumentBuilderFactory factoryBank = DocumentBuilderFactory.newInstance();
	DocumentBuilder builderBank;
	Document documentBank = null;
	
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
	} catch (SAXException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
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
    	    		if (!nodeBank.item(i).getTextContent().isEmpty() && !this.bic.contains(nodeBank.item(i).getTextContent()))
    	    		    this.bic.add(nodeBank.item(i).getTextContent());
    	    		break;
    	    	    case "rule":
    	    		this.rule = nodeBank.item(i).getTextContent();
    	    		break;
    	    	    case "name":
    	    		this.name = nodeBank.item(i).getTextContent();
    	    	    }
    	    	}
    	    }
	}
    }
    
    public String getBlz() {
	return blz;
    }
    
    public LinkedList getBic() {
        return bic;
    }

    public String getRule() {
        return rule;
    }
    
    private String getName() {
	return name;
    }
    
}
