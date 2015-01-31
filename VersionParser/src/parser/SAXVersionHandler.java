package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SAXVersionHandler extends DefaultHandler {

	private List<Partners> data;
	private Partners partner;
	private String currentElement;
	

	public List<Partners> readDataFromXML(String filename) throws SAXException,
			IOException, ParserConfigurationException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(filename), this);
		return data;
	}
	
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document parsing started...");
		data = new ArrayList<Partners>();
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Document parsing is complete...");
	}
	
	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentElement = qName;
		switch (currentElement) {
		
		case "partner":
			partner = new Partners();
			String idAsaString = attributes.getValue("id");
			partner.setPartner_id(idAsaString);
			data.add(partner);
			break;

		default:
			break;
		}
		
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("end element : " + qName);
		currentElement = "";
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
	}
}
