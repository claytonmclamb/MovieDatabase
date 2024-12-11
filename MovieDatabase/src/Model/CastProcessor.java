package Model;

import java.util.ArrayList;
import java.util.List;

//author - Clayton McLamb
//purpose - this class processes the cast data
public class CastProcessor<T> extends Preprocessing {
	
	public CastProcessor(String fileName) {
		/*
		 * Purpose: this is the constructor
		 * Parameters:
		 * 	fileName: where the cast data is
		 */
		super(fileName);
	}
	
	public DataFrame loadData() {
		/*
		 * Purpose: loads the data
		 */
		final ArrayList<String> COLUMNS = new ArrayList<String>(List.of("Rank", "Title", "Year", "Director", "Cast 1", "Cast 2", "Cast 3", "Cast 4", "Cast 5"));
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
				values[3], values[4], values[5], values[6], values[7], values[8]));
		return row;
	}

}
