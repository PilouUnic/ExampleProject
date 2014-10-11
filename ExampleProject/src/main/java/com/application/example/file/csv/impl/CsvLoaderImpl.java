/**
 * 
 */
package com.application.example.file.csv.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;

import com.application.example.file.csv.ICsvLoader;
import com.application.example.file.exception.LoaderException;
import com.application.example.file.xls.entitie.RowElement;

/**
 * @author AURELIEN
 *
 */
@Service
public class CsvLoaderImpl implements ICsvLoader {	
	
	static Logger logger = LoggerFactory.getLogger(CsvLoaderImpl.class);

	/**
	 * Default constructor.
	 */
	public CsvLoaderImpl() {
	}

	/**
	 * Loading a CSV file which contain a first row as header.
	 * 
	 * @throws LoaderException
	 */
	@Override
	public List<RowElement> loadFileWithHeader(final File fileToLoad) throws LoaderException {
		logger.trace("launching 'loadFileWithHeader' method in 'CsvLoaderImpl.java'");
		if(fileToLoad == null) {
			throw new IllegalArgumentException("The parameter is null.");
		}
		List<RowElement> elementList = new ArrayList<RowElement>();
		try {
			logger.debug("loading file: " + fileToLoad.getPath());
			CSVReader reader = new CSVReader(new FileReader(fileToLoad));

			try {
				List<String[]> myEntries = reader.readAll();
				int i = 0;
				for(String[] entry : myEntries) {
					if(entry != null) {
						RowElement rowElement = new RowElement();
						if(i == 0) {
							rowElement.setRowType(RowElement.RowType.HEAEDER);
						} else {
							rowElement.setRowType(RowElement.RowType.CONTENT);
						}
						rowElement.setContentElements(Arrays.asList(entry));
						logger.debug("memorizing row: " + Arrays.asList(entry).toString());
						elementList.add(rowElement);
						i++;
					}
				}
			} finally {
				if(reader != null) {
					reader.close();
				}
			}
		} catch(IOException ex) {
			throw new LoaderException("Error during loading CSV file", ex);
		} finally {
			logger.trace("end of 'loadFileWithHeader' method in 'CsvLoaderImpl.java'");
		}
		return elementList;
	}

	/**
	 * Loading a CSV file which not contain a first row as header.
	 * 
	 * @throws LoaderException
	 */
	@Override
	public List<RowElement> loadFileWithoutHeader(final File fileToLoad) throws LoaderException {
		logger.trace("launching 'loadFileWithoutHeader' method in 'CsvLoaderImpl.java'");
		if(fileToLoad == null) {
			throw new IllegalArgumentException("The parameter is null.");
		}
		List<RowElement> elementList = new ArrayList<RowElement>();
		try {
			logger.debug("loading file: " + fileToLoad.getPath());
			CSVReader reader = new CSVReader(new FileReader(fileToLoad));
			try {
				List<String[]> myEntries = reader.readAll();
				boolean firstRow = true;
				for(String[] entry : myEntries) {
					if(entry != null) {
						if(!firstRow) {
							RowElement rowElement = new RowElement(RowElement.RowType.CONTENT, Arrays.asList(entry));
							logger.debug("memorizing row: " + Arrays.asList(entry).toString());
							elementList.add(rowElement);
						}
						firstRow = false;
					}
				}
			} finally {
				if(reader != null) {
					reader.close();
				}
			}
		} catch(IOException ex) {
			throw new LoaderException("Error during loading CSV file", ex);
		} finally {
			logger.trace("end of 'loadFileWithoutHeader' method in 'CsvLoaderImpl.java'");
		}
		return elementList;
	}

}
