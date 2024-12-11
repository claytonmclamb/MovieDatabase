package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// author - clayton mclamb
// purpose - how the gross data should be loaded
public class GrossProcessor extends Preprocessing {
	
	public GrossProcessor(String fileName) {
		/*
		 * Purpose: this is the constructor
		 * Parameters:
		 * 	fileName: where the gross data is
		 */
		super(fileName);
	}
	
	public DataFrame loadData() {
		/*
		 * Purpose: loads the data
		 */
		final ArrayList<String> COLUMNS = new ArrayList<String>(List.of("Rank", "Title", "Year", "USA Box Office"));
		DataFrame data = new DataFrame(COLUMNS);
		processData(data);
		return data;
	}
	
	protected ArrayList<Comparable> makeRow(String[] values){
		/*
		 * Purpose: overriden method - how to handle data at each step
		 * Parameters:
		 * 	- values: an array of values from that line
		 */
		ArrayList<Comparable> row = new ArrayList<Comparable>(List.of(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]),
													Integer.parseInt(values[3])));
		return row;
	}


}
