package org.as.iban.impl;

import java.io.File;
import java.io.IOException;

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
    private String bic;
    private String rule;
    private String name;

    BankGermanImpl (String blz) {
	this.blz = blz;
	readBankConfig();
    }
    
    private void readBankConfig() {
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder;
	Document document = null;
	
	try {
	    factory.setNamespaceAware(true);
	    factory.setValidating(true);
	    factory.setAttribute(SCHEMA_LANG,XML_SCHEMA);
	    factory.setAttribute(SCHEMA_SOURCE, this.getClass().getResourceAsStream("/banks_german.xsd"));

	    builder = factory.newDocumentBuilder();
	    document = builder.parse(this.getClass().getResourceAsStream("/banks_german.xml"));

	} catch (ParserConfigurationException e) {
	    e.printStackTrace();
	} catch (SAXException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	NodeList nodeBank = document.getElementById("_011380").getChildNodes();
	for (int i = 0; i < nodeBank.getLength(); i++){
	    switch (nodeBank.item(i).getNodeName()){
	    case "blz":
		this.blz = nodeBank.item(i).getTextContent();
		break;
	    case "bic":
		this.bic = nodeBank.item(i).getTextContent();
		break;
	    case "rule":
		this.rule = nodeBank.item(i).getTextContent();
		break;
	    case "name":
		this.name = nodeBank.item(i).getTextContent();
	    }
	}
    }
    
    public String getBlz() {
	return blz;
    }
    
    public String getBic() {
        return bic;
    }

    public String getRule() {
        return rule;
    }
    
    private String getName() {
	return name;
    }
    
}
