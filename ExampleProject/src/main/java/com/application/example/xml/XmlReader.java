/**
 * 
 */
package com.application.example.xml;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;

/**
 * @author admin
 *
 */
@Service
public class XmlReader {

	/**
	 * Default Constructor.
	 */
	public XmlReader() {
	}

	
	public Document loadXmlResource(final File xmlFileToLoad) throws DocumentException {
		if(xmlFileToLoad == null) {
			throw new IllegalArgumentException("The paramter cannot be null.");
		}
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(xmlFileToLoad);
		return document;
	}
	
	public NodeList getElementList(final Document documentToParse, final String xpathQuery) {
		if(documentToParse == null || xpathQuery == null) {
			throw new IllegalArgumentException("The paramter cannot be null.");
		}
		
		// On charge un document
		Document docuementToLoad = documentToParse;
		NodeList nodeLIst = (NodeList) docuementToLoad.selectNodes(xpathQuery);
		
		return nodeLIst;
	}
}
