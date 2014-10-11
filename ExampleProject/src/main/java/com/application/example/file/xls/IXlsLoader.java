/**
 * 
 */
package com.application.example.file.xls;

import java.io.File;
import java.util.List;

import com.application.example.file.exception.LoaderException;
import com.application.example.file.xls.entitie.RowElement;


/**
 * @author AURELIEN
 *
 */
public interface IXlsLoader {
	
	List<RowElement> loadFileWithHeader(final File fileToLoad) throws LoaderException;
	List<RowElement>  loadFileWithoutHeader(final File fileToLoad) throws LoaderException;
}
