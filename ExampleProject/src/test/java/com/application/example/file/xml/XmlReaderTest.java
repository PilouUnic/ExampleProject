/**
 * 
 */
package com.application.example.file.xml;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.application.example.file.xml.XmlReader;

/**
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
public class XmlReaderTest {
	
	static Logger logger = LoggerFactory.getLogger(XmlReaderTest.class);
	private final String xmlFilePath = "F:\\resources\\plantExample.xml";

	@Autowired
	private XmlReader xmlReader;

	@Test(expected=IllegalArgumentException.class)	
	public void loadXmlResourceWithNullArgument() throws JDOMException, IOException {	
		logger.trace("launching 'loadXmlResourceWithNullArgument' method in 'XmlReaderTest.java'");
		xmlReader.loadXmlResource(null);
		logger.trace("end of 'loadXmlResourceWithNullArgument' method in 'XmlReaderTest.java'");
	}
	
	@Test
	public void loadXmlResourceWithInternalXmlFile() throws URISyntaxException, JDOMException, IOException {	
		logger.trace("launching 'loadXmlResourceWithInternalXmlFile' method in 'XmlReaderTest.java'");
		File xmlToLoad = new File(xmlFilePath);
		Element result = xmlReader.loadXmlResource(xmlToLoad);
		Assert.assertNotNull(result);
		logger.trace("end of 'loadXmlResourceWithInternalXmlFile' method in 'XmlReaderTest.java'");
	}
	
	@Test
	public void loadXmlResourceAndRecoveredStaffElement() throws URISyntaxException, JDOMException, IOException {
		logger.trace("launching 'loadXmlResourceAndRecoveredStaffElement' method in 'XmlReaderTest.java'");
		File xmlToLoad = new File(xmlFilePath);
		Element root = xmlReader.loadXmlResource(xmlToLoad);
		List<Element> staffList = root.getChildren("PLANT");
		Assert.assertTrue(staffList != null && !staffList.isEmpty());
		logger.trace("end of 'loadXmlResourceAndRecoveredStaffElement' method in 'XmlReaderTest.java'");
	}
	
	@Test
	public void loadXmlResourceAndRecoveredUnfoundElement() throws URISyntaxException, JDOMException, IOException {	
		logger.trace("launching 'loadXmlResourceAndRecoveredUnfoundElement' method in 'XmlReaderTest.java'");
		File xmlToLoad = new File(xmlFilePath);
		Element root = xmlReader.loadXmlResource(xmlToLoad);
		List<Element> staffList = root.getChildren("toto");
		Assert.assertTrue(staffList.isEmpty());
		logger.trace("end of 'loadXmlResourceAndRecoveredUnfoundElement' method in 'XmlReaderTest.java'");
	}
}
