package com.application.example.file.xls;

import java.io.IOException;
import java.util.List;

import com.application.example.file.exception.LoaderException;


/**
 * The Interface IXlsGenerator.
 */
public interface XslGenerator {

	/**
	 * Méthode qui ajoute une liste d'objet à un tableau excel.
	 * 
	 * @param aList
	 *            the a list
	 * @return the integer
	 */
	public Integer add(List<Object> aList);

	/**
	 * Write.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void write() throws LoaderException;

	/**
	 * Méthode qui permet la taille totale du fichier passé en parametre
	 * 
	 * @return
	 */
	public Integer getMaxRowBeforeAdd();

}
