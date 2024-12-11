package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Controller.*;

// author - Clayton McLamb
// this class provides the movie View in MVC. It interacts with the user and takes their input. 
public class MovieView extends View{
	//fields
	final static String INTRO = ViewSettings.introduction;
	final static String CONC = ViewSettings.conclusion;
	
	public MovieView(String folderName) {
		/*
		 * This is the constructor
		 * Parameters:
		 * 	- folderName - the location of the data
		 */
		super(folderName, INTRO, CONC);
		controller = new MovieController(folderName);
	}
	
	protected void makeMap() {
		/*
		 * Purpose: makes the HashMaps with the query
		 */
		queryMap = new HashMap<Integer, String>();
		for(int i = 0; i < ViewSettings.queries.length; i++) {
			queryMap.put(i+1, ViewSettings.queries[i]);
		}
	}
}
