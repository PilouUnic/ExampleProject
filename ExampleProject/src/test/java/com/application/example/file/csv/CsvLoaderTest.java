/**
 * 
 */
package com.application.example.file.csv;

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

import com.application.example.file.exception.LoaderException;
import com.application.example.file.xls.entitie.RowElement;

/**
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
public class CsvLoaderTest {
	
	static Logger logger = LoggerFactory.getLogger(CsvLoaderTest.class);
	
	final File csvFileTloLoad = new File("F:\\resources\\csvFileExample.csv");
	final File badCsvFileTloLoad = new File("");
	
	@Autowired
	private ICsvLoader iCsvLoader; 

	

	/**
	 * Test method for {@link com.application.example.csv.impl.CsvLoaderImpl#loadFileWithHeader()}.
	 * @throws LoaderException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testLoadFileWithHeaderWithNullArgument() throws LoaderException {
		logger.trace("launching 'testLoadFileWithHeaderWithNullArgument' method in 'CsvLoaderTest.java'");
		iCsvLoader.loadFileWithHeader(null);		
		logger.trace("end of 'testLoadFileWithHeaderWithNullArgument' method in 'CsvLoaderTest.java'");
	}
	
	/**
	 * Test method for {@link com.application.example.csv.impl.CsvLoaderImpl#loadFileWithHeader()}.
	 * @throws LoaderException 
	 */
	@Test(expected=LoaderException.class)
	public void testLoadFileWithHeaderWithNotFoundFile() throws LoaderException {
		logger.trace("launching 'testLoadFileWithHeaderWithNotFoundFile' method in 'CsvLoaderTest.java'");
		iCsvLoader.loadFileWithHeader(badCsvFileTloLoad);		
		logger.trace("end of 'testLoadFileWithHeaderWithNotFoundFile' method in 'CsvLoaderTest.java'");
	}
	
	/**
	 * Test method for {@link com.application.example.csv.impl.CsvLoaderImpl#loadFileWithHeader()}.
	 * @throws LoaderException 
	 */
	@Test
	public void testLoadFileWithHeaderWithGoodFile() throws LoaderException {
		logger.trace("launching 'testLoadFileWithHeaderWithGoodFile' method in 'CsvLoaderTest.java'");
		List<RowElement> result = iCsvLoader.loadFileWithHeader(csvFileTloLoad);		
		Assert.assertTrue(result != null && !result.isEmpty());
		logger.trace("end of 'testLoadFileWithHeaderWithGoodFile' method in 'CsvLoaderTest.java'");
	}

	/**
	 * Test method for {@link com.application.example.csv.impl.CsvLoaderImpl#loadFileWithoutHeader()}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testLoadFileWithoutHeaderWithoutNullArgument() throws LoaderException {
		logger.trace("launching 'testLoadFileWithHeaderWithNullArgument' method in 'CsvLoaderTest.java'");
		iCsvLoader.loadFileWithoutHeader(null);		
		logger.trace("end of 'testLoadFileWithHeaderWithNullArgument' method in 'CsvLoaderTest.java'");
	}
	
	/**
	 * Test method for {@link com.application.example.csv.impl.CsvLoaderImpl#loadFileWithoutHeader()}.
	 */
	@Test(expected=LoaderException.class)
	public void testLoadFileWithoutHeaderWithNotFoundFile() throws LoaderException {
		logger.trace("launching 'testLoadFileWithoutHeaderWithNotFoundFile' method in 'CsvLoaderTest.java'");
		iCsvLoader.loadFileWithoutHeader(badCsvFileTloLoad);		
		logger.trace("end of 'testLoadFileWithoutHeaderWithNotFoundFile' method in 'CsvLoaderTest.java'");
	}
	
	/**
	 * Test method for {@link com.application.example.csv.impl.CsvLoaderImpl#loadFileWithHeader()}.
	 * @throws LoaderException 
	 */
	@Test
	public void testLoadFileWithoutHeaderWithGoodFile() throws LoaderException {
		logger.trace("launching 'testLoadFileWithoutHeaderWithGoodFile' method in 'CsvLoaderTest.java'");
		List<RowElement> result = iCsvLoader.loadFileWithoutHeader(csvFileTloLoad);		
		Assert.assertTrue(result != null && !result.isEmpty());
		logger.trace("end of 'testLoadFileWithoutHeaderWithGoodFile' method in 'CsvLoaderTest.java'");
	}

}
