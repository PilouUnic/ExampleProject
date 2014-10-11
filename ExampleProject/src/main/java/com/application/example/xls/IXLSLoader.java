/**
 * 
 */
package com.application.example.xls;

import com.application.example.xls.exception.LoaderException;


/**
 * @author AURELIEN
 *
 */
public interface IXLSLoader {
	
	void loadFileWithHeader() throws LoaderException;

	void loadFileWithoutHeader() throws LoaderException;
}
