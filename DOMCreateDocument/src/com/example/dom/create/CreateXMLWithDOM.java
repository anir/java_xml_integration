package com.example.dom.create;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class CreateXMLWithDOM {

	public static void main(String[] args) throws ParserConfigurationException {
		DOMCreator creator = new DOMCreator();
		Document doc = creator.createXmlDoc();
		System.out.println(doc.toString());
		Node node = doc.getFirstChild();
		System.out.println(node.getNodeName());

	}

}
