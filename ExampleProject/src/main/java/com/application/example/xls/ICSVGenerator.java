/**
 * 
 */
package com.application.example.xls;

import java.io.IOException;
import java.util.List;

import com.application.example.xls.entitie.RowElement;
import com.application.example.xls.exception.XLSLoaderExeption;

/**
 * @author AURELIEN
 *
 */
public interface ICSVGenerator {

	/**
	 * Méthode qui ajoute une liste d'objet à un tableau excel.
	 * 
	 * @param aList
	 *            the a list
	 * @return the integer
	 */
	public Integer add(List<RowElement> aList);

	/**
	 * Write.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void write() throws XLSLoaderExeption;

	/**
	 * Méthode qui permet la taille totale du fichier passé en parametre
	 * 
	 * @return
	 */
	public Integer getMaxRowBeforeAdd();
}
