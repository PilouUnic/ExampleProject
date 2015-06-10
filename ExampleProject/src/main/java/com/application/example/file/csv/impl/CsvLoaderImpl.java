/**
 * 
 */
package com.application.example.file.csv.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;

import com.application.example.file.csv.ICsvLoader;
import com.application.example.file.exception.LoaderException;
import com.application.example.file.xls.entitie.RowElement;
import com.application.example.file.xls.entitie.RowElement.RowType;

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

	/**
	 * Loading a CSV file which contain a first row as header.
	 * 
	 * @throws LoaderException
	 */
	@Override
	public List<RowElement> loadFile(final File fileToLoad) throws LoaderException {
		logger.trace("launching 'loadFileWithHeader' method in 'CsvLoaderImpl.java'");
		if(fileToLoad == null) {
			throw new IllegalArgumentException("The parameter is null.");
		}

		try {

			StringTokenizer st=null;
			FileReader inputFileReader = new FileReader(fileToLoad);
			BufferedReader inputStream = new BufferedReader(inputFileReader);
			String inLine = null;

			while((inLine =  inputStream.readLine())!=null){
				st = new StringTokenizer(inLine, "$");
				System.out.println(st.nextToken());
				System.out.println(st.nextToken());
				System.out.println(st.nextToken());
			}

		}
		catch (IOException e) {  

		}

		List<RowElement> elementList = new ArrayList<RowElement>();
		//		try {
		//			logger.debug("loading file: " + fileToLoad.getPath());
		//			CSVReader reader = new CSVReader(new FileReader(fileToLoad));
		//
		//			try {
		//				List<String[]> myEntries = reader.readAll();
		//				int i = 0;
		//				for(String[] entry : myEntries) {
		//					if(entry != null) {
		//						RowElement rowElement = new RowElement();
		//						if(i == 0) {
		//							rowElement.setRowType(RowElement.RowType.HEAEDER);
		//						} else {
		//							rowElement.setRowType(RowElement.RowType.CONTENT);
		//						}
		//						rowElement.setContentElements(Arrays.asList(entry));
		//						logger.debug("memorizing row: " + Arrays.asList(entry).toString());
		//						elementList.add(rowElement);
		//						i++;
		//					}
		//				}
		//			} finally {
		//				if(reader != null) {
		//					reader.close();
		//				}
		//			}
		//		} catch(IOException ex) {
		//			throw new LoaderException("Error during loading CSV file", ex);
		//		} finally {
		//			logger.trace("end of 'loadFileWithHeader' method in 'CsvLoaderImpl.java'");
		//		}
		return elementList;
	}

	public static void main(String[] args) {

		final File csvFileTloLoad = new File("C:\\DEV\\DATA\\XML\\example.csv");
		try {

			StringTokenizer st=null;
			FileReader inputFileReader = new FileReader(csvFileTloLoad);
			BufferedReader inputStream = new BufferedReader(inputFileReader);
			String inLine = null;
			List<RowElement> elementList = new ArrayList<RowElement>();

			boolean isHeader = true;
			int columnNumber = 0;
			int currentColumn = 0;
			int currentLineNumber = 0;
			StringBuilder currentLine = new StringBuilder();
			final String endOfLineDelimiter = "</EOF>";
			
			StringBuilder sb = new StringBuilder();
			String completeLineWithoutDelimiter = "";
			
			RowElement rowElement = null;
			while((inLine =  inputStream.readLine())!=null){
				if(inLine.contains(endOfLineDelimiter)) {
					// On retire le delimiteur de fin
					if(currentLine.toString().isEmpty()) {
						completeLineWithoutDelimiter = inLine.substring(0, inLine.indexOf(endOfLineDelimiter));
					} else {
						completeLineWithoutDelimiter = currentLine.toString();
					}
					
					rowElement = new RowElement();				
					if(isHeader) {
						rowElement.setRowType(RowType.HEAEDER);
					} else {
						rowElement.setRowType(RowType.CONTENT);
					}
					String[] contentConverted = completeLineWithoutDelimiter.toString().replace("$", ";").split(";");
					rowElement.setContentElements(Arrays.asList(contentConverted));
					elementList.add(rowElement);
					
					// Reinit de la ligne courante
					currentLine = new StringBuilder();
					completeLineWithoutDelimiter = "";
					isHeader = false;
				} else {
					currentLine.append(inLine);
				}

			}
			
			for(RowElement el : elementList) {
				System.out.println(el.toString());
			}

		}
		catch (IOException e) {  

		}

	}

}
