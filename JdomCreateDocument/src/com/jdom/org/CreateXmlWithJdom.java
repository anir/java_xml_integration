package com.jdom.org;

import java.io.StringWriter;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class CreateXmlWithJdom {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customer> data = DataProvider.getData(DataProvider.SMALL);
		
		JdomCreator creator = new JdomCreator();
		Document doc = creator.createXmlDocument(data);
		List<Element> list = doc.getRootElement().getChildren();
		System.out.println("retrived" + list.size());
		XMLOutputter output = new XMLOutputter(Format.getPrettyFormat());
		String xmlstring = output.outputString(doc);
		System.out.println(xmlstring);
	
	}

}
