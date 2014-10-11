/**
 * 
 */
package com.application.example.xls.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

import com.application.example.xls.AbstractLoader;
import com.application.example.xls.ICSVLoader;
import com.application.example.xls.entitie.RowElement;
import com.application.example.xls.exception.CSVLoaderException;
import com.application.example.xls.exception.LoaderException;

/**
 * @author AURELIEN
 *
 */
public class CSVLoaderImpl extends AbstractLoader implements ICSVLoader {	

	/**
	 * Default constructor.
	 */
	public CSVLoaderImpl() {
	}

	/**
	 * Loading a CSV file which contain a first row as header.
	 * 
	 * @throws LoaderException
	 */
	@Override
	public void loadFileWithHeader() throws CSVLoaderException {
		try {
			CSVReader reader = new CSVReader(new FileReader(getSourceFile()));

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
						getElements().add(rowElement);
						i++;
					}
				}
			} finally {
				if(reader != null) {
					reader.close();
				}
			}
		} catch(IOException ex) {
			throw new CSVLoaderException("Error during loading CSV file", ex);
		}
	}

	/**
	 * Loading a CSV file which not contain a first row as header.
	 * 
	 * @throws LoaderException
	 */
	@Override
	public void loadFileWithoutHeader() throws LoaderException {
		try {
			CSVReader reader = new CSVReader(new FileReader(getSourceFile()));
			try {
				List<String[]> myEntries = reader.readAll();
				for(String[] entry : myEntries) {
					if(entry != null) {
						RowElement rowElement = new RowElement(RowElement.RowType.CONTENT, Arrays.asList(entry));
						getElements().add(rowElement);
					}
				}
			} finally {
				if(reader != null) {
					reader.close();
				}
			}
		} catch(IOException ex) {
			throw new CSVLoaderException("Error during loading CSV file", ex);
		}
	}

}
