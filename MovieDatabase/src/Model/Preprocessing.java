package Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//author - clayton mclamb
//purpose - abstract class template for preprocessing each dataframe
public abstract class Preprocessing {
	//fields
	protected String fileName;
	
	public Preprocessing(String fileName) {
		/*
		 * Purpose: constructor
		 * Parameters:
		 * 	fileName - where the file is located
		 */
		this.fileName = fileName;
	}
	
	
	// abstract methods for loading data
	abstract public DataFrame loadData();
	abstract protected ArrayList<Comparable> makeRow(String[] values);
	
	public Scanner getFileScanner() {
		/*
		 * Purpose: Makes a scanner for a text file
		 */
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Scanner s = new Scanner(fs);
			return s;
		}
		catch(IOException ie) {
			System.out.println("File exception occured. " + fileName);
			return null;
		}
	}
	
	
	protected void processData(DataFrame data) {
		/*
		 * Purpose: this is how the data is processed
		 * Parameters:
		 * 	data - an empty dataframe to add to
		 */
		Scanner scnr = getFileScanner();
		scnr.nextLine();
		while (scnr.hasNextLine()){
			String line = scnr.nextLine();	
			String[] values = line.split("\t");
			ArrayList<Comparable> row = makeRow(values);
			data.append(row);
		}
	}


}
