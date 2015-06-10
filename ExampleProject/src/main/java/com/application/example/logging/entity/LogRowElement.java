/**
 * 
 */
package com.application.example.logging.entity;

import java.io.Serializable;

/**
 * @author AURELIEN
 *
 */
public class LogRowElement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String date;
	private String criticity;
	private String message;
	
	public LogRowElement(String date, String criticity, String message) {
		super();
		this.date = date;
		this.criticity = criticity;
		this.message = message;
	}

	public String getDate() {
		return date.substring(1, date.length()-1);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCriticity() {
		return criticity;
	}

	public void setCriticity(String criticity) {
		this.criticity = criticity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
