package com.example.dom.read;

import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;
import com.example.utilities.Stopwatch;

public class ReadXMLWithDOM {

	public static void main(String[] args) throws XPathExpressionException {

		DOMReader reader = new DOMReader();
		//Stopwatch watch = new Stopwatch().start("Parsing XML");
		List<Customer> data = reader.getDataFromXML(
				DataProvider.DATADIR + "customers.xml",
				"//customer[age >= 65]");
		//watch.stop();
		System.out.println("There are " + data.size() + " records");
		
		for (Customer customer : data) {
			System.out.println(customer.toString());
		}
	}

}