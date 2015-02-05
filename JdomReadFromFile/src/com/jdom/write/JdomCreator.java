package com.jdom.write;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;

import com.example.model.Customer;

public class JdomCreator {
	private static final String XMLDATEFORMAT="yyyy-MM-dd'T'HH:mm:ss";
	public JdomCreator(){
		
		
	}
	
	public Document createXmlDocument(List<Customer> data){
		Document doc = new Document();
		Element root = new Element("customers");
		doc.addContent(root);
		
		for (Customer customer : data) {
			Element custElement = new Element("customer");
			root.addContent(custElement);
			custElement.setAttribute(Customer.ID, Integer.toString(customer.getId()));
			addChildElement(custElement, Customer.NAME, customer.getName());
			addChildElement(custElement, Customer.PHONE, customer.getPhone());
			addChildElement(custElement, Customer.AGE, Integer.toString(customer.getAge()));
			addChildElement(custElement, Customer.BALANCE, customer.getBalance().toString());
			Element about = addChildElement(custElement, Customer.ABOUT, "");
			CDATA cdata = new CDATA(customer.getAbout());
			about.addContent(cdata);
			addChildElement(custElement, Customer.ACTIVE, Boolean.toString(customer.getActive()));
			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			addChildElement(custElement, Customer.JOINED, df.format(customer.getJoined()));
		}
		
		return doc;
	}
	
	// to add child elements to an given parent element
	private Element addChildElement(Element parentElement, String elementName, String textValue){
		Element child= new Element(elementName);
		child.setText(textValue);
		parentElement.addContent(child);
		return child;
	}
}
