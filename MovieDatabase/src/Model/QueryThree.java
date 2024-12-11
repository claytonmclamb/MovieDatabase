package Model;

import java.util.*;

// author - clayton mclamb
// purpose - performs query three functionality
public class QueryThree<T extends Comparable<T>> extends QueryTwo<T>{
	
	public QueryThree(HashMap<String, DataFrame> dataFrames) {
		/*
		 * Purpose: Constructor
		 * Parameters:
		 * 	dataFrames: hashmap of data
		 */
		super(dataFrames);
	}

	public String getAnswer(HashMap<String, T> parameters) {
		/*
		 * getting the answer for this query
		 * parameters - hashmap of input values
		 */
		int number = (int) parameters.get("nDirectors");
		ArrayList<T> directors = getAllDirectors();
		HashMap<String, Integer> directorCounts = countingDirectors(directors);
		DataFrame directorsFrequencies = getData(directorCounts);
		return answer(directorsFrequencies, number);
	}
	
	private HashMap<String, Integer> countingDirectors(ArrayList<T> directors){
		/*
		 * counts directors
		 */
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		for(T value : directors) {
			String name = (String) value;
			if(counts.containsKey(name)) {
				counts.put(name, counts.get(name) + 1);
			}
			else {
				counts.put(name, 1);
			}
		}
		return counts;
	}
	
	private DataFrame getData(HashMap<String, Integer> frequencies) {
		/*
		 * places frequencies into dataframe
		 */
		ArrayList<String> columns = new ArrayList<>(List.of("Name", "Frequency"));
		DataFrame data = new DataFrame(columns);
		for (String key : frequencies.keySet()) {
			int value = frequencies.get(key);
			ArrayList<T> values = new ArrayList<T>();
			values.add((T)key);
			values.add((T) (Object) value);
			data.append(values);
		}
		data.sort("Frequency");
		return data;
	}
	
	
	private String answer(DataFrame counts, int nDirectors) {
		/*
		 * gets the answer
		 */
		String answer = "Below are a list of the directors that have appeared the most, in addition to their frequency.\n";
		for(int i = counts.size() - 1; i > 0 && i > counts.size() - nDirectors - 1; i--) {
			Row row = counts.get(i);
			answer += row.get("Name") + " | " + row.get("Frequency") + "\n";
		}
		return answer;
	}
}
