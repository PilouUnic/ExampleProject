/**
 * 
 */
package com.application.example.xls.factory;

import java.io.File;

import com.application.example.xls.AbstractLoader;
import com.application.example.xls.impl.CSVLoaderImpl;
import com.application.example.xls.impl.XLSLoaderImpl;


/**
 * @author AURELIEN
 *
 */
public class LoaderFactory {
	
	private static AbstractLoader loader;

	public enum SourceFileFormat {
		CSV("csv"), EXCEL("XLS");

		private String sourceFileFormat;

		private SourceFileFormat(String s) {
			sourceFileFormat = s;
		}

		public String getSourceFileFormat() {
			return sourceFileFormat;
		}
	};   


	public static AbstractLoader create(SourceFileFormat sourceFileFormat, File sourceFile) {
		if(sourceFileFormat == SourceFileFormat.CSV) {
			loader = new CSVLoaderImpl();			
		} else if(sourceFileFormat == SourceFileFormat.EXCEL) {
			loader = new XLSLoaderImpl();		
		}
		loader.setSourceFile(sourceFile);
		return loader;
	}


}
