/**
 * 
 */
package com.application.example.xls.exception;

/**
 * @author aurelien.cortial
 * 
 */
public class XLSGeneratorException extends LoaderException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public XLSGeneratorException() {
	}

	/**
	 * @param arg0
	 */
	public XLSGeneratorException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public XLSGeneratorException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public XLSGeneratorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public XLSGeneratorException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
