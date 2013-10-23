package org.as.iban.model;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class IbanFormat {
    
    final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    final String SCHEMA_LANG = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
    
    private String countryCode;
    private String regexp;
    private int bankIdentLength;
    private int ktoIdentLength;
    
    public IbanFormat(String countryCode) {
	this.countryCode = countryCode;
	readFormatConfig();
    }

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
	} catch (SAXException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
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

    public String getRegexp() {
        return regexp;
    }

    public int getBankIdentLength() {
        return bankIdentLength;
    }

    public int getKtoIdentLength() {
        return ktoIdentLength;
    }

}
