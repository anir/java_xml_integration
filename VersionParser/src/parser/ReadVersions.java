package parser;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.example.dataprovider.DataProvider;


public class ReadVersions {
	public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException{
		String filename = DataProvider.DATADIR + "versions.xml";
		SAXVersionHandler handle = new SAXVersionHandler();
		List<Partners> list = handle.readDataFromXML(filename);
		System.out.println("Number of partners: " + list.size());
		
		for (Partners partners : list) {
			String partner_id= partners.getPartner_id();
			System.out.println(partner_id);
			System.out.println("");
		}
		
	}
}
