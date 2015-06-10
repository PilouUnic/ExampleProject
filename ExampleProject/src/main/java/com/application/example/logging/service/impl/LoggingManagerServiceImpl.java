package com.application.example.logging.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.application.example.logging.entity.LogRowElement;
import com.application.example.logging.entity.LoggingException;
import com.application.example.logging.service.LoggingManagerService;

@Service
public class LoggingManagerServiceImpl implements LoggingManagerService {

	static Logger logger = LoggerFactory.getLogger(LoggingManagerServiceImpl.class);
	private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-15");
	private static final String regexForInfoLevel = "<[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}>\\s\\|\\s(I|E|W)\\s\\|";

	/**
	 * 
	 * @param deployedApplicationName
	 * @return
	 */
	private List<LogRowElement> loadLogFile(final String deployedApplicationName) {

		StringBuilder sbLogFilePath = new StringBuilder();
		sbLogFilePath.append("G:\\ACO\\TEST_LOG.log");

		final File logFile = new File(sbLogFilePath.toString());
		if(logFile == null || !logFile.exists()) {
			// TODO Exception
		}

		try {
			Scanner sc = new Scanner(logFile); 
			String currentLine = null;

			try {

				while (sc.hasNextLine()) { 
					currentLine = sc.nextLine(); 
					System.out.println(currentLine);
				}
			} finally {
				if(sc != null) {
					sc.close();
				}
			}
		} catch(IOException ex){

		}

		return null;
	}

	/**
	 * Initilise le style de l'en-tete.
	 * @param workbook Objet Workbook representant le fichier Excel.
	 * @Return Un objet de type CellStyle.
	 */
	private CellStyle headerCellStyleInitialisation(final Workbook workbook) {

		// Creation d'un nouveau style de cellule
		logger.trace("Creation of cellstyle for header line...");
		final CellStyle headerCellStyle = workbook.createCellStyle();
		// Valorisation de la bordure haute
		logger.trace("Initialisation of top border line...");
		headerCellStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		// Valorisation de la bordure basse
		logger.trace("Initialisation of bottom border line...");
		headerCellStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		// Valorisation de la bordure de droite
		logger.trace("Initialisation of left border line...");
		headerCellStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
		// Valorisation de la bordure de gauche
		logger.trace("Initialisation of right border line...");
		headerCellStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
		// Valorisation de l'alignement du contenu
		logger.trace("Initialisation cell content alignement...");
		headerCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		// Valorisation de la couleur de fond
		logger.trace("Initialisation cell background color...");
		headerCellStyle.setFillForegroundColor(HSSFColor.LIME.index);
		headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		return headerCellStyle;
	}

	/**
	 * Initilise le style de l'en-tete.
	 * @param workbook Objet Workbook representant le fichier Excel.
	 * @Return Un objet de type CellStyle.
	 */
	private CellStyle contentCellStyleInitialisationForWarn(final Workbook workbook) {

		// Creation d'un nouveau style de cellule
		logger.trace("Creation of cellstyle for header line...");
		final CellStyle contentCellStyle = workbook.createCellStyle();
		final Font font = workbook.createFont();
		// Valorisation de l'alignement du contenu
		logger.trace("Initialisation cell content alignement...");
		contentCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		font.setColor(HSSFColor.ORANGE.index);
		contentCellStyle.setFont(font);

		return contentCellStyle;
	}
	
	/**
	 * Initilise le style de l'en-tete.
	 * @param workbook Objet Workbook representant le fichier Excel.
	 * @Return Un objet de type CellStyle.
	 */
	private CellStyle contentCellStyleInitialisationForError(final Workbook workbook) {

		// Creation d'un nouveau style de cellule
		logger.trace("Creation of cellstyle for header line...");
		final CellStyle contentCellStyle = workbook.createCellStyle();
		final Font font = workbook.createFont();
		// Valorisation de l'alignement du contenu
		logger.trace("Initialisation cell content alignement...");
		contentCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		font.setColor(HSSFColor.RED.index);
		contentCellStyle.setFont(font);

		return contentCellStyle;
	}
	
	/**
	 * Initilise le style de l'en-tete.
	 * @param workbook Objet Workbook representant le fichier Excel.
	 * @Return Un objet de type CellStyle.
	 */
	private CellStyle contentCellStyleInitialisationForInfo(final Workbook workbook) {

		// Creation d'un nouveau style de cellule
		logger.trace("Creation of cellstyle for header line...");
		final CellStyle contentCellStyle = workbook.createCellStyle();
		final Font font = workbook.createFont();
		// Valorisation de l'alignement du contenu
		logger.trace("Initialisation cell content alignement...");
		contentCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		font.setColor(HSSFColor.BLACK.index);
		contentCellStyle.setFont(font);

		return contentCellStyle;
	}

	/**
	 * Permet d'ecrire le contenu d'un objet workbook dans un fichier Excel passe en parametre.
	 * @param xlsResultFile Fichier de resultat de l'extraction.
	 * @param workbook Objet Workbook de POI.
	 * @throws ExtractionException
	 */
	private void writtingExcelFileContent(final File xlsResultFile, final Workbook workbook) throws LoggingException {

		OutputStream xlsOutput = null;
		try {
			try {
				xlsOutput = new FileOutputStream(xlsResultFile);
				if (xlsOutput != null) {
					workbook.write(xlsOutput);
				}
			} finally {
				if (xlsOutput != null) {
					xlsOutput.close();
				}
			}

		} catch (final IOException ex) {
			throw new LoggingException();
		}
	}

	/**
	 * Methode de construction de la ligne d'en-tete a partir des objets resultant du parsing CSV.
	 * @param csvElement List d'objet RowElement representant le contenu des divers CSV parcourus.
	 * @param workbook Objet Workbook.
	 * @throws ExtractionException
	 */
	private void buildHeaderRow(final Workbook workbook, final Sheet sheet) throws LoggingException {

		// Creation d'une premiere ligne d'en-tete
		logger.debug("Creation first row header");
		final Row headerRow = sheet.createRow(0);

		// Mise en forme des bordures de l'en-tete
		logger.debug("Initialisation of header style");
		logger.trace("Calling 'headerCellStyleInitialisation' method");
		final CellStyle headerCellStyle = headerCellStyleInitialisation(workbook);

		Cell cell = null;

		final String dateLabel = "DATE";
		final String critivityLabel = "CRITICITY";
		final String messageLabel = "MESSAGE";

		logger.debug("Creating cell in header with value: {} ", dateLabel);
		cell = headerRow.createCell(0);
		cell.setCellValue(new String(dateLabel.getBytes(DEFAULT_ENCODING), DEFAULT_ENCODING));
		logger.trace("Creating cell style for cell with value: {} ", dateLabel);
		cell.setCellStyle(headerCellStyle);

		logger.debug("Creating cell in header with value: {} ", critivityLabel);
		cell = headerRow.createCell(1);
		cell.setCellValue(new String(critivityLabel.getBytes(DEFAULT_ENCODING), DEFAULT_ENCODING));
		logger.trace("Creating cell style for cell with value: {} ", critivityLabel);
		cell.setCellStyle(headerCellStyle);

		logger.debug("Creating cell in header with value: {} ", messageLabel);
		cell = headerRow.createCell(2);
		cell.setCellValue(new String(messageLabel.getBytes(DEFAULT_ENCODING), DEFAULT_ENCODING));
		logger.trace("Creating cell style for cell with value: {} ", messageLabel);
		cell.setCellStyle(headerCellStyle);

	}

	/**
	 * Methode de construction du contenu du fichier XLS.
	 * @param csvElement List d'objet RowElement representant le contenu des divers CSV parcourus.
	 * @param workbook Objet Workbook.
	 * @throws ExtractionException
	 */
	private void buildContentRow(final List<LogRowElement> logRowElement, final Workbook workbook, final Sheet sheet) throws LoggingException {

		logger.debug("Building content os XLS file");
		// Recuperation des elements non HEADER
		logger.debug("Recovering all content lines");
		int rowIndex = 1;

		final CellStyle contentCellStyleforInfo = contentCellStyleInitialisationForInfo(workbook);
		final CellStyle contentCellStyleforWarn = contentCellStyleInitialisationForWarn(workbook);
		final CellStyle contentCellStyleforError = contentCellStyleInitialisationForError(workbook);
		Cell cell = null;

		for (final LogRowElement element : logRowElement) {

			// Creation d'une premiere ligne d'en-tete
			logger.debug("Creation first row header");
			final Row contentRow = sheet.createRow(rowIndex);
			
			if("E".equals(element.getCriticity())) {
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getDate());
				cell = contentRow.createCell(0);
				cell.setCellValue(element.getDate());
				cell.setCellStyle(contentCellStyleforError);
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getCriticity());
				cell = contentRow.createCell(1);
				cell.setCellValue("ERROR");
				cell.setCellStyle(contentCellStyleforError);
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getMessage());
				cell = contentRow.createCell(2);
				cell.setCellValue(element.getMessage());
				cell.setCellStyle(contentCellStyleforError);
				
			} else if("I".equals(element.getCriticity())) {
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getDate());
				cell = contentRow.createCell(0);
				cell.setCellValue(element.getDate());
				cell.setCellStyle(contentCellStyleforInfo);
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getCriticity());
				cell = contentRow.createCell(1);
				cell.setCellValue("INFORMATION");
				cell.setCellStyle(contentCellStyleforInfo);
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getMessage());
				cell = contentRow.createCell(2);
				cell.setCellValue(element.getMessage());
				cell.setCellStyle(contentCellStyleforInfo);
				
			} else if("W".equals(element.getCriticity())) {
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getDate());
				cell = contentRow.createCell(0);
				cell.setCellValue(element.getDate());
				cell.setCellStyle(contentCellStyleforWarn);
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getCriticity());
				cell = contentRow.createCell(1);
				cell.setCellValue("WARNING");
				cell.setCellStyle(contentCellStyleforWarn);
				
				// Valorisation de la cellule
				logger.debug("Populating cell with value: {}", element.getMessage());
				cell = contentRow.createCell(2);
				cell.setCellValue(element.getMessage());
				cell.setCellStyle(contentCellStyleforWarn);
			}

			rowIndex++;
		}

		// Ajustement de la largeur des colonnes.
		logger.trace("Ajusting columns width...");
		final Row row = sheet.getRow(0);
		for (int colNum = 0; colNum < row.getLastCellNum(); colNum++) {
			workbook.getSheetAt(0).autoSizeColumn(colNum);
		}

	}


	private void generateXlsResultFile(final File resultFile, final List<LogRowElement> logRowElement) throws LoggingException {

		Workbook workbook = null;
		try {
			// Suppression du fichier si il existe deja
			if (resultFile.exists()) {
				resultFile.delete();
			}
			resultFile.createNewFile();
			// Creation du Workbook necessaire pour la generation du fichier
			// de resultat Excel.
			logger.debug("Creation of Workbook object");
			workbook = new HSSFWorkbook();

		} catch (final IOException ex) {
			throw new LoggingException();
		}

		// Creation d'une feuille de calcul
		logger.debug("Creation sheet object from workbook");
		final Sheet sheet = workbook.createSheet();

		// Construction de la ligne d'en-tete
		logger.trace("Calling 'buildHeaderRow' method");
		buildHeaderRow(workbook, sheet);

		// Construction du contenu
		logger.trace("Calling 'buildContentRow' method");
		buildContentRow(logRowElement, workbook, sheet);

		// Ecriture du fichier
		logger.trace("Calling 'write' method");
		writtingExcelFileContent(resultFile, workbook);
	}
	
	@Override
	public File generateExcelLogFile(final File initialLogFile) throws LoggingException {
		
		File excelLogFile = new File("C:\\DEV\\DATA\\LOG\\TEST_LOG.xls");
		
		StringBuilder sbLogFilePath = new StringBuilder();
		sbLogFilePath.append("C:\\DEV\\DATA\\LOG\\TEST_LOG.log");
		
		Pattern pattern = Pattern.compile(regexForInfoLevel);
		Matcher matcher = null;

		final File logFile = new File(sbLogFilePath.toString());
		if(logFile == null || !logFile.exists()) {
			// TODO Exception
		}

		String currentDate;
		String currentCriticity;
		String currentMessage;
		String[] splittedCurrentLine;
		LogRowElement logRowElement = null;
		List<LogRowElement> result = new ArrayList<LogRowElement>();
		try {

			String currentLine = null;
			InputStream ips = new FileInputStream(logFile); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);

			try {
				while ((currentLine = br.readLine()) != null){
					matcher = pattern.matcher(currentLine);
					if(matcher.find()) {
						splittedCurrentLine = currentLine.split("\\|");

						currentDate = splittedCurrentLine[0].trim();
						currentCriticity = splittedCurrentLine[1].trim();
						currentMessage = splittedCurrentLine[2].trim();

						System.out.println(currentLine);
						System.out.println("  - " + currentDate);
						System.out.println("  - " + currentCriticity);
						System.out.println("  - " + currentMessage);

						logRowElement = new LogRowElement(currentDate, currentCriticity, currentMessage);
						result.add(logRowElement);
					}				
				}

			} finally {
				if(br != null) {
					br.close();
				}
				if(ipsr != null) {
					ipsr.close();
				}
				if(ips != null) {
					ips.close();
				}
			}
		} catch(IOException ex){

		}

		generateXlsResultFile(excelLogFile, result);
		logger.info("End of convertion");
		
		return excelLogFile;
	}

}
