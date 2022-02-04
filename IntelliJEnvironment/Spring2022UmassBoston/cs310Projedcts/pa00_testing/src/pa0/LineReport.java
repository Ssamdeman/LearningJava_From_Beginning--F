//package com.gradescope.pa0;
package pa0;


public class LineReport {
	public static final int NLINES = 500;
	// Create an array of 500 LineUsage objects
	// since there are NLINES = 500 individual lines,
	// numbered 1 to 500, so use array size NLINES+1
	private LineUsage[] lines = new LineUsage[NLINES + 1];

	public LineReport() {
	}

	// read input data, put facts into lines array
	void loadData(String fname) {

	}

	// given loaded lines array, generate report on lines
	void generateReport() {
	
	}

	public static void main(String[] args) {
		LineReport report = new LineReport();
		report.loadData(args[0]);
		report.generateReport();
	
	}
}
