/**
 * 
 */
package com.application.example.xml;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Service;

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

	
	public Element loadXmlResource(final File xmlFileToLoad) throws JDOMException, IOException {
		if(xmlFileToLoad == null) {
			throw new IllegalArgumentException("The paramter cannot be null.");
		}
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(xmlFileToLoad);
		Element root = document.getRootElement();
		return root;
	}

}
