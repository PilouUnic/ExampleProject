/**
 * 
 */
package com.application.example.xls.entitie;

import java.io.Serializable;
import java.util.List;

/**
 * @author AURELIEN
 *
 */
public class RowElement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum RowType {
		HEAEDER, CONTENT;
	};
	
	
	private RowType rowType;
	private List<String> contentElements;

	/**
	 * 
	 */
	public RowElement() {
		// TODO Auto-generated constructor stub
	}
	
	public RowElement(RowType rowType, List<String> contentElements) {
		this.rowType = rowType;
		this.contentElements = contentElements;
	}

	/**
	 * @return the contentElements
	 */
	public List<String> getContentElements() {
		return contentElements;
	}

	/**
	 * @param contentElements the contentElements to set
	 */
	public void setContentElements(List<String> contentElements) {
		this.contentElements = contentElements;
	}

	/**
	 * @return the rowType
	 */
	public RowType getRowType() {
		return rowType;
	}

	/**
	 * @param rowType the rowType to set
	 */
	public void setRowType(RowType rowType) {
		this.rowType = rowType;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(contentElements != null) {			
			for(String element : contentElements) {
				builder.append(element).append("\t\t\t\t\t\t"); 
			}			
		}
		return builder.toString();
	}
}
