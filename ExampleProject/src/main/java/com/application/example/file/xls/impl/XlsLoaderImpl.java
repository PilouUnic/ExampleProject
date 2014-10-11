/**
 * 
 */
package com.application.example.file.xls.impl;

import org.springframework.stereotype.Service;

/**
 * @author AURELIEN
 *
 */
@Service
public class XlsLoaderImpl /*implements IXlsLoader*/  {

//	/**
//	 * Default constructor.
//	 */
//	public XlsLoaderImpl() {
//		
//	}
//
//	@Override
//	public void loadFileWithHeader() throws LoaderException {
//		
//		try {
//			InputStream stream = new FileInputStream(getSourceFile());
//			try {
//				//Get the workbook instance for XLS file 
//				Workbook workbook = WorkbookFactory.create(stream);
//
//				//Get first sheet from the workbook
//				Sheet sheet = workbook.getSheetAt(0);
//
//				//Get iterator to all the rows in current sheet
//				Iterator<Row> rowIterator = sheet.iterator();
//				
//				int i = 0;				
//				while (rowIterator.hasNext()) 
//				{
//					Row row = rowIterator.next();
//					RowElement rowElement = new RowElement();
//					if(i == 0) {
//						rowElement.setRowType(RowElement.RowType.HEAEDER);
//					} else {
//						rowElement.setRowType(RowElement.RowType.CONTENT);
//					}
//					
//					
//					//For each row, iterate through all the columns
//					Iterator<Cell> cellIterator = row.cellIterator();
//					
//					List<String> entry = new ArrayList<String>();
//					while (cellIterator.hasNext()) 
//					{
//						Cell cell = cellIterator.next();
//						entry.add(getCellValueAsString(cell));
//					}		 
//					
//					if(entry != null && !entry.isEmpty()) {
//						rowElement.setContentElements(entry);
//					}
//					getElements().add(rowElement);
//					i++;
//				}
//			} finally {
//				if(stream != null) {
//					stream.close();
//				}
//			}
//		} catch(IOException ex) {
//
//		} catch(InvalidFormatException ex) {
//
//		}
//
//	}
//
//	@Override
//	public void loadFileWithoutHeader() throws LoaderException {
//		try {
//			InputStream stream = new FileInputStream(getSourceFile());
//			try {
//				//Get the workbook instance for XLS file 
//				Workbook workbook = WorkbookFactory.create(stream);
//
//				//Get first sheet from the workbook
//				Sheet sheet = workbook.getSheetAt(0);
//
//				//Get iterator to all the rows in current sheet
//				Iterator<Row> rowIterator = sheet.iterator();
//				
//								
//				while (rowIterator.hasNext()) 
//				{
//					Row row = rowIterator.next();
//					RowElement rowElement = new RowElement();
//					rowElement.setRowType(RowElement.RowType.CONTENT);
//					
//					//For each row, iterate through all the columns
//					Iterator<Cell> cellIterator = row.cellIterator();
//					
//					List<String> entry = new ArrayList<String>();
//					while (cellIterator.hasNext()) 
//					{
//						Cell cell = cellIterator.next();
//						entry.add(getCellValueAsString(cell));
//					}	
//					
//					if(entry != null && !entry.isEmpty()) {
//						rowElement.setContentElements(entry);
//					}
//					getElements().add(rowElement);
//				}
//			} finally {
//				if(stream != null) {
//					stream.close();
//				}
//			}
//		} catch(IOException ex) {
//
//		} catch(InvalidFormatException ex) {
//
//		}
//	}
//
//	/**
//	 * Gets the cell value as string.
//	 * 
//	 * @param aCell
//	 *            the a cell
//	 * @return the cell value as string
//	 */
//	private String getCellValueAsString(final Cell aCell) {
//		String str = "";
//		switch (aCell.getCellType()) {
//		case Cell.CELL_TYPE_BLANK:
//			str = "";
//			break;
//		case Cell.CELL_TYPE_BOOLEAN:
//			str = (Boolean.valueOf(aCell.getBooleanCellValue())).toString();
//			break;
//		case Cell.CELL_TYPE_ERROR:
//			str = (Byte.valueOf(aCell.getErrorCellValue())).toString();
//			break;
//		case Cell.CELL_TYPE_FORMULA:
//			str = aCell.getCellFormula();
//			break;
//		case Cell.CELL_TYPE_NUMERIC:
//			Double dbl = aCell.getNumericCellValue();
//			DecimalFormat format = new DecimalFormat();
//			format.setDecimalSeparatorAlwaysShown(false);
//			format.setGroupingUsed(false);
//			str = format.format(dbl.doubleValue());
//			break;
//		case Cell.CELL_TYPE_STRING:
//			str = aCell.getStringCellValue();
//			if (str.isEmpty()) {
//				str = aCell.getRichStringCellValue().getString();
//			}
//			break;
//		default:
//			str = "";
//			break;
//		}
//
//		return str;
//	}

}
