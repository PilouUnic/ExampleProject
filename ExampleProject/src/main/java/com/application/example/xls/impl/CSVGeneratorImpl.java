/**
 * 
 */
package com.application.example.xls.impl;

import java.io.File;
import java.util.List;

import com.application.example.xls.ICSVGenerator;
import com.application.example.xls.entitie.RowElement;
import com.application.example.xls.exception.XLSLoaderExeption;

/**
 * @author AURELIEN
 *
 */
public abstract class CSVGeneratorImpl implements ICSVGenerator {
	
	/** The xls file. */
	private transient File csvFile = null;

	/** The row length. */
	protected Integer rowLength = 0;

	/**
	 * 
	 */
	public CSVGeneratorImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.reactis.handler.csv.CSVGenerator#add(java.util.List)
	 */
	@Override
	public Integer add(List<RowElement> aList) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.reactis.handler.csv.CSVGenerator#write()
	 */
	@Override
	public void write() throws XLSLoaderExeption {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.reactis.handler.csv.CSVGenerator#getMaxRowBeforeAdd()
	 */
	@Override
	public Integer getMaxRowBeforeAdd() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the csvFile
	 */
	public File getCsvFile() {
		return csvFile;
	}

	/**
	 * @param csvFile the csvFile to set
	 */
	public void setCsvFile(File csvFile) {
		this.csvFile = csvFile;
	}

	/**
	 * @return the rowLength
	 */
	public Integer getRowLength() {
		return rowLength;
	}

	/**
	 * @param rowLength the rowLength to set
	 */
	public void setRowLength(Integer rowLength) {
		this.rowLength = rowLength;
	}

}
