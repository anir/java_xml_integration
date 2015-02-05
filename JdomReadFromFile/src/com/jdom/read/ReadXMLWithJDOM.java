package com.jdom.read;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.jdom2.JDOMException;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class ReadXMLWithJDOM {

	public static void main(String[] args) throws JDOMException, IOException, ParseException {
				
		JDOMReader read = new JDOMReader();
		List<Customer> data = read.getDataFromXML(DataProvider.DATADIR + "customers.xml");
		System.out.println("Number of customers: " + data.size());
		for ( Customer customer : data) {
			System.out.println(customer);
		}

	}

}
