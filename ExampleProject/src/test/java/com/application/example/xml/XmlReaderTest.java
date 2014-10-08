/**
 * 
 */
package com.application.example.xml;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
public class XmlReaderTest {
	
	static Logger logger = LoggerFactory.getLogger(XmlReaderTest.class);

	@Autowired
	private XmlReader xmlReader;

	@Test(expected=IllegalArgumentException.class)
	public void loadXmlResourceWithNullArgument() throws DocumentException {	
		xmlReader.loadXmlResource(null);
	}
	
	@Test
	public void loadXmlResourceWithInternalXmlFile() throws DocumentException, URISyntaxException {	
		URL urlToXmlToLoad = XmlReaderTest.class.getResource("/xml/staff.xml");
		File xmlToLoad = new File(urlToXmlToLoad.toURI());
		Document result = xmlReader.loadXmlResource(xmlToLoad);
		Assert.assertNotNull(result);
	}
}
