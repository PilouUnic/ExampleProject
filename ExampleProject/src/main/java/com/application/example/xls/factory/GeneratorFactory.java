package com.application.example.xls.factory;



public class GeneratorFactory {

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

}
