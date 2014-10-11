/**
 * 
 */
package com.application.example.xls;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.application.example.xls.entitie.RowElement;

/**
 * @author AURELIEN
 *
 */
public abstract class AbstractLoader {
	
	private File sourceFile;
	private List<RowElement> elements = new ArrayList<RowElement>();

	/**
	 * Default constructor
	 */
	public AbstractLoader() {
		
	}
	
	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}
	
	/**
	 * @return the elements
	 */
	public List<RowElement> getElements() {
		return elements;
	}

	/**
	 * @param elements the elements to set
	 */
	public void setElements(List<RowElement> elements) {
		this.elements = elements;
	}

}
