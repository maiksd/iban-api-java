package org.as.iban.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class IbanRuleGerman {

    final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    final String SCHEMA_LANG = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private String rule_id;
    
    private boolean noCalculation = false;
    private boolean mappingKto = false;
    private boolean mappingBlz = false;
    private boolean modificationKto = false;
    
    private ArrayList<Element> listNoCalculation = new ArrayList<Element>();
    private ArrayList<MappingKto> listMappingKto = new ArrayList<MappingKto>();
    private ArrayList<Element> listMappingBlz = new ArrayList<Element>();
    private ArrayList<Element> listModificationKto = new ArrayList<Element>();
    
    public IbanRuleGerman (String rule_id) {
	this.rule_id = rule_id;
	readRule();
    }
    
    private void readRule() {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder;
	Document document = null;
	
	Element element = null;
	
	try {
	    factory.setNamespaceAware(true);
	    factory.setValidating(true);
	    factory.setAttribute(SCHEMA_LANG,XML_SCHEMA);
	    factory.setAttribute(SCHEMA_SOURCE, this.getClass().getResourceAsStream("/iban_rules_german.xsd"));
	    
	    builder = factory.newDocumentBuilder();
	    document = builder.parse(this.getClass().getResourceAsStream("/iban_rules_german.xml"));

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

	NodeList nodes = document.getElementById(rule_id).getChildNodes();
	for (int i = 0; i < nodes.getLength(); i++) {
	    if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
		NodeList nodeRule = nodes.item(i).getChildNodes();
		
		for (int j = 0; j < nodeRule.getLength(); j++) {
		    if (nodeRule.item(j).getNodeType() == Node.ELEMENT_NODE) { 
			element = (Element) nodeRule.item(j);
		    
			switch (nodes.item(i).getNodeName()) {
			case "no_calculation":
			    listNoCalculation.add(element);
			    break;
			    
			case "mappings_kto":
			    MappingKto mapKto = new MappingKto(((Element)element.getParentNode()).getAttribute("blz"));
			    mapKto.setFrom(element.getAttribute("from"));
			    mapKto.setTo(element.getTextContent());
			    listMappingKto.add(mapKto);
			    break;
			    
			case "mappings_blz":
			    listMappingBlz.add(element);
			    break;
			    
			case "modification_kto":
			    listModificationKto.add(element);
			    break;
			}
		    }
		}
	    }
	}
    }
    
    public boolean isNoCalculation (String blz) {
	Iterator<Element> iter = listNoCalculation.iterator();
	
	while (iter.hasNext()) {
	    if (iter.next().getAttribute("blz").equals(blz))
		this.noCalculation = true;
	}
	return noCalculation;
    }
    

    public LinkedList<String> getRegexpNoCalculation (String blz) {
	LinkedList<String> tempList = new LinkedList<String>();
	Iterator<Element> iter = listNoCalculation.iterator();
	
	while (iter.hasNext()) {
	    Element tempElement = iter.next();
	    if (tempElement.getAttribute("blz").equals(blz))
		tempList.add(tempElement.getTextContent());
	}
	
	return tempList;
    }
    
    
    public boolean isMappingKto (String blz) {
	Iterator<MappingKto> iter = listMappingKto.iterator();
	
	while (iter.hasNext()) {
	    if ((iter.next()).getBlz().equals(blz))
		this.mappingKto = true;
	}
	return mappingKto;
    }
    

    public String getMappedKto (String blz, String kto) {
	Iterator<MappingKto> iter = listMappingKto.iterator();
	
	while (iter.hasNext()) {
	    MappingKto tempMapping = iter.next();
	    if (tempMapping.getBlz().equals(blz) && tempMapping.getFrom().equals(kto))
		return tempMapping.getTo();
	}
	return null;
    }
    
  
    public boolean isMappingBlz (String blz) {
	Iterator<Element> iter = listMappingBlz.iterator();
	
	while (iter.hasNext()) {
	    if (iter.next().getAttribute("from").equals(blz))
		this.mappingBlz = true;
	}
	return mappingBlz;
    }
    
 
    public String getMappedBlz(String blz) {
	Iterator<Element> iter = listMappingBlz.iterator();
	
	while (iter.hasNext()) {
	    Element tempElement = iter.next();
	    if (tempElement.getAttribute("from").equals(blz))
		return tempElement.getTextContent();
	}
	return null;
    }
    
    public boolean isModification (String blz) {
	Iterator<Element> iter = listModificationKto.iterator();
	
	while (iter.hasNext()) {
	    if (iter.next().getAttribute("blz").equals(blz))
		this.modificationKto = true;
	}
	return modificationKto;
    }
    

    public LinkedList<String> getRegexpModification (String blz) {
	LinkedList<String> tempList = new LinkedList<String>();
	Iterator<Element> iter = listModificationKto.iterator();
	
	while (iter.hasNext()) {
	    Element tempElement = iter.next();
	    if (tempElement.getAttribute("blz").equals(blz))
		tempList.add(tempElement.getTextContent());
	}
	
	return tempList;
    }
    

    class MappingKto {
	
	private String blz;
	private String from;
	private String to;
	
	MappingKto (String blz){
	    this.blz = blz;
	}
	
	private void setFrom (String from) {
	    this.from = from;
	}
	
	private void setTo (String to) {
	    this.to = to;
	}
	
	private String getFrom() {
	    return this.from;
	}
	
	private String getTo() {
	    return this.to;
	}
	
	private String getBlz() {
	    return this.blz;
	}
    }
}
