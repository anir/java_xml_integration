package com.jdom.read;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.example.model.Customer;

public class JDOMReader {
	private static final String XMLDATEFORMAT="yyyy-MM-dd'T'HH:mm:ss";
	
	public List<Customer> getDataFromXML(String filename) throws JDOMException, IOException, ParseException{
		List<Customer> data = new ArrayList<>();
		File file = new File(filename);
		SAXBuilder sax = new SAXBuilder();
		
		Document doc = null;
		doc = sax.build(file);
		
		Element root = doc.getRootElement();
		List<Element> custElement = root.getChildren("customer");
		
		for (Element element : custElement) {
			Customer customer = new Customer();
			data.add(customer);
			Attribute attr= element.getAttribute(Customer.ID);
			customer.setId(attr.getIntValue());
			customer.setName(element.getChildText(Customer.NAME));
			customer.setAbout(element.getChildText(Customer.ABOUT));
			customer.setPhone(element.getChildText(Customer.PHONE));
			customer.setAge(Integer.parseInt(element.getChildText(Customer.AGE)));
			customer.setActive(Boolean.parseBoolean(element.getChildText(Customer.ACTIVE)));
			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			customer.setJoined(df.parse(element.getChildText(customer.JOINED)));
			customer.setBalance(new BigDecimal(element.getChildText(Customer.BALANCE)));
		}
		
//		XMLOutputter output = new XMLOutputter(Format.getPrettyFormat());
//		String xmlstring = output.outputString(doc);
//		System.out.println(xmlstring);
		
		return data;
		
	}

}