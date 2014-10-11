/**
 * 
 */
package com.application.example.file.xml;

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

	
	/**
	 * Chargement d'un fichier XML.
	 * 
	 * @param xmlFileToLoad Chemin complet vers un fichier XML.
	 * @return Un element de type org.jdom2.Element
	 * @throws JDOMException
	 * @throws IOException
	 */
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
