package com.example.sax.read;

import java.util.List;

import com.example.dataprovider.DataProvider;

public class ReadXMLWithSAX {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		String filename = DataProvider.DATADIR + "customers.xml";
		SAXCustomerHandler saxHandler = new SAXCustomerHandler();
		List<Customer> list = saxHandler.readDataFromXML(filename);
		System.out.println("Number of customers: " + list.size());
		
		for (Customer customer : list) {
			System.out.println("Customer : " + customer.toString());
		}
		
	}

}
