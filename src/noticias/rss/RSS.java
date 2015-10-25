package noticias.rss;


import java.io.File;

import org.w3c.dom.*;
import javax.xml.parsers.*;

public class RSS {

	public void start() {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document dom = null;
		
		dbf = DocumentBuilderFactory.newInstance();
		
		try{
			db = dbf.newDocumentBuilder();
			dom = db.parse("/predata/unrss.rss");
		}catch(Exception s){
			System.err.println("Un error fatal");
		}
		
		Element rootElement = dom.getDocumentElement();
		
		
		
	}

}
