/**
 * 
 */
package com.application.example.file.xsl;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.application.example.file.csv.CsvLoaderTest;
import com.application.example.file.exception.LoaderException;
import com.application.example.file.xls.IXlsLoader;
import com.application.example.file.xls.entitie.RowElement;

/**
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
public class XlsLoaderTest {
	
static Logger logger = LoggerFactory.getLogger(CsvLoaderTest.class);
	
	final File xlsFileTloLoad = new File("F:\\resources\\xlsFileExample.xlsx");
	final File badXlsFileTloLoad = new File("");
	
	@Autowired
	private IXlsLoader iXlsLoader; 

	/**
	 * Test method for {@link com.application.example.file.xls.impl.XlsLoaderImpl#loadFileWithHeader()}.
	 * @throws LoaderException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testLoadFileWithHeaderWithNullArgument() throws LoaderException {
		logger.trace("launching 'testLoadFileWithHeaderWithNullArgument' method in 'XlsLoaderTest.java'");
		iXlsLoader.loadFileWithHeader(null);		
		logger.trace("end of 'testLoadFileWithHeaderWithNullArgument' method in 'XlsLoaderTest.java'");
	}
	
	/**
	 * Test method for {@link com.application.example.file.xls.impl.XlsLoaderImpl#loadFileWithHeader()}.
	 * @throws LoaderException 
	 */
	@Test(expected=LoaderException.class)
	public void testLoadFileWithHeaderWithNotFoundFile() throws LoaderException {
		logger.trace("launching 'testLoadFileWithHeaderWithNotFoundFile' method in 'XlsLoaderTest.java'");
		iXlsLoader.loadFileWithHeader(badXlsFileTloLoad);		
		logger.trace("end of 'testLoadFileWithHeaderWithNotFoundFile' method in 'XlsLoaderTest.java'");
	}
	
	/**
	 * Test method for {@link com.application.example.file.xls.impl.XlsLoaderImpl#loadFileWithHeader()}.
	 * @throws LoaderException 
	 */
	@Test
	public void testLoadFileWithHeaderWithGoodFile() throws LoaderException {
		logger.trace("launching 'testLoadFileWithHeaderWithGoodFile' method in 'XlsLoaderTest.java'");
		List<RowElement> result = iXlsLoader.loadFileWithHeader(xlsFileTloLoad);		
		Assert.assertTrue(result != null && !result.isEmpty());
		logger.trace("end of 'testLoadFileWithHeaderWithGoodFile' method in 'XlsLoaderTest.java'");
	}

	/**
	 * Test method for {@link com.application.example.file.xls.impl.XlsLoaderImpl#loadFileWithoutHeader()}.
	 * @throws LoaderException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testLoadFileWithoutHeaderWithNullArgument() throws LoaderException {
		logger.trace("launching 'testLoadFileWithoutHeaderWithNullArgument' method in 'XlsLoaderTest.java'");
		iXlsLoader.loadFileWithoutHeader(null);		
		logger.trace("end of 'testLoadFileWithoutHeaderWithNullArgument' method in 'XlsLoaderTest.java'");
	}
	
	/**
	 * Test method for {@link com.application.example.file.xls.impl.XlsLoaderImpl#loadFileWithoutHeader()}.
	 * @throws LoaderException 
	 */
	@Test(expected=LoaderException.class)
	public void testLoadFileWithoutHeaderWithNotFoundFile() throws LoaderException {
		logger.trace("launching 'testLoadFileWithoutHeaderWithNotFoundFile' method in 'XlsLoaderTest.java'");
		iXlsLoader.loadFileWithoutHeader(badXlsFileTloLoad);		
		logger.trace("end of 'testLoadFileWithoutHeaderWithNotFoundFile' method in 'XlsLoaderTest.java'");
	}
	
	/**
	 * Test method for {@link com.application.example.file.xls.impl.XlsLoaderImpl#loadFileWithoutHeader()}.
	 * @throws LoaderException 
	 */
	@Test
	public void testLoadFileWithoutHeaderWithGoodFile() throws LoaderException {
		logger.trace("launching 'testLoadFileWithoutHeaderWithGoodFile' method in 'XlsLoaderTest.java'");
		List<RowElement> result = iXlsLoader.loadFileWithoutHeader(xlsFileTloLoad);		
		Assert.assertTrue(result != null && !result.isEmpty());
		logger.trace("end of 'testLoadFileWithoutHeaderWithGoodFile' method in 'XlsLoaderTest.java'");
	}

}
