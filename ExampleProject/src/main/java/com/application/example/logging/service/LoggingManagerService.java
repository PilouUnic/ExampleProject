package com.application.example.logging.service;

import java.io.File;

import com.application.example.logging.entity.LoggingException;

public interface LoggingManagerService {
	
	
	/**
	 * Converti le contenu du fichier de log passe en parametre en un fichier
	 * Excel (.xls).
	 * Seul les lignes de criticites I, E et W seront recuperees et converties.
	 * Le fichier de resultat aura le même nom que le fichier de log inital
	 * hormis l'extension.
	 * 
	 * @param initialLogFile Fichier de log initial a convertir.
	 * @return Le fichier Excel de resultat.
	 * @throws Declanche une exception de type LoggingException en cas d'erreur
	 * de la conversion.
	 */
	File generateExcelLogFile(final File initialLogFile) throws LoggingException;
}
