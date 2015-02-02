package com.jdom.org;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class CreateXmlWithJdom {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customer> data = DataProvider.getData(DataProvider.MEDIUM);
		
		JdomCreator creator = new JdomCreator();
		Document doc = creator.createXmlDocument(data);
		List<Element> list = doc.getRootElement().getChildren();
		System.out.println("retrived" + list.size());
	}

}
