/**
 * 
 */


import java.io.File;
import java.util.List;

import com.application.example.xls.AbstractLoader;
import com.application.example.xls.ICSVLoader;
import com.application.example.xls.IXLSLoader;
import com.application.example.xls.entitie.RowElement;
import com.application.example.xls.exception.LoaderException;
import com.application.example.xls.factory.LoaderFactory;
import com.application.example.xls.factory.LoaderFactory.SourceFileFormat;

/**
 * @author AURELIEN
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws LoaderException 
	 */
	public static void main(String[] args) throws LoaderException {
		System.out.println("## CHARGEMENT CSV ##");
		String path = "C:\\Users\\AURELIEN\\Documents\\test.csv";
		AbstractLoader loader = LoaderFactory.create(SourceFileFormat.CSV, new File(path));
		((ICSVLoader)loader).loadFileWithHeader();
		List<RowElement> elements = loader.getElements();
		for(RowElement element : elements) {
			System.out.println(element.toString());
		}
		
		System.out.println("\n\n\n");
		
		System.out.println("## CHARGEMENT EXCEL XLSX ##");
		path = "C:\\Users\\AURELIEN\\Documents\\Classeur1.xlsx";
		loader = LoaderFactory.create(SourceFileFormat.EXCEL, new File(path));
		((IXLSLoader)loader).loadFileWithHeader();
		elements = loader.getElements();
		for(RowElement element : elements) {
			System.out.println(element.toString());
		}
		
		System.out.println("\n\n\n");
		
		System.out.println("## CHARGEMENT EXCEL XLS ##");
		path = "C:\\Users\\AURELIEN\\Documents\\Classeur1.xls";
		loader = LoaderFactory.create(SourceFileFormat.EXCEL, new File(path));
		((IXLSLoader)loader).loadFileWithHeader();
		elements = loader.getElements();
		for(RowElement element : elements) {
			System.out.println(element.toString());
		}
	}

}
