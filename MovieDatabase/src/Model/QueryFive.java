package Model;

import java.util.HashMap;

// author - clayton mclamb
// purpose - performs query five
public class QueryFive<T extends Comparable<T>> extends Query<T>{
	
	public QueryFive(HashMap<String, DataFrame> dataFrames) {
		/*
		 * Purpose: constructor for query four
		 */
		super(dataFrames);
	}

	public String getAnswer(HashMap<String, T> parameters) {
		/*
		 * getting the answer for this query
		 * parameters - hashmap of input values
		 */
		int rank = (int) parameters.get("rank");
		return "The highest-grossing movie ranked " + rank + " was " + getMovie(rank) +".\n";
	}
	
	public HashMap<String, T> getInput(){
		/*
		 * getting input for querys
		 */
		HashMap<String, T> parameters = new HashMap<String, T>();
		System.out.print("What rank are you interested in? ");
		T rank = (T)(Object) scnr.nextInt();
		parameters.put("rank",  rank);
		return parameters;
	}
	
	public String getMovie(int rank) {
		/*
		 * getting movie
		 */
		DataFrame data = dataFrames.get("gross");
		DataFrame filteredData = data.filter("Rank", rank, "=");
		return (String)filteredData.get(0).get("Title");
	}
	
}
