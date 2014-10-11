/**
 * 
 */
package com.application.example.xls;

import java.io.IOException;
import java.util.List;

import com.application.example.xls.exception.XLSLoaderExeption;

/**
 * @author AURELIEN
 *
 */
public interface ExcelGenerator {

	/**
	 * Méthode qui ajoute une liste d'objet à un CSV.
	 * 
	 * @param aList
	 *            the a list
	 * @return the integer
	 */
	public abstract Integer add(List<Object> aList);

	/**
	 * Write.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public abstract void write() throws XLSLoaderExeption;

	/**
	 * Méthode qui permet la taille totale du fichier passé en parametre
	 * 
	 * @return
	 */
	public abstract Integer getMaxRowBeforeAdd();
}
