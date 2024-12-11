package Model;

import java.util.HashMap;
import java.util.Scanner;


// author - clayton mclamb
// purpose - abstract class for performing queries
public abstract class Query<T extends Comparable<T>> {
	//fields
    protected HashMap<String, DataFrame> dataFrames;
	Scanner scnr;
	
	public Query(HashMap<String, DataFrame> dataFrames) {
		/*
		 * Purpose: constructor for Query object
		 * parameters:
		 * 	dataFrame - hashmap with dataframes located within
		 */
		this.dataFrames = dataFrames;
		scnr = new Scanner(System.in);
	}
	
	// abstract methods to call to get answers
	public abstract String getAnswer(HashMap<String, T> parameters);
	public abstract HashMap<String, T> getInput();
}
