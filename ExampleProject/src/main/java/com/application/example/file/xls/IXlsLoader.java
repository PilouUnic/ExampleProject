/**
 * 
 */
package com.application.example.file.xls;

import com.application.example.file.exception.LoaderException;


/**
 * @author AURELIEN
 *
 */
public interface IXlsLoader {
	
	void loadFileWithHeader() throws LoaderException;

	void loadFileWithoutHeader() throws LoaderException;
}
