/**
 * 
 */
package com.application.example.file.csv;

import java.io.File;
import java.util.List;

import com.application.example.file.exception.LoaderException;
import com.application.example.file.xls.entitie.RowElement;


/**
 * @author AURELIEN
 *
 */
public interface ICsvLoader {
	
	List<RowElement> loadFileWithHeader(final File fileToLoad) throws LoaderException;	
	List<RowElement>  loadFileWithoutHeader(final File fileToLoad) throws LoaderException;
	List<RowElement>  loadFile(final File fileToLoad) throws LoaderException;
}
