package Model;

import java.util.HashMap;

// author - clayton mclamb
// purpose - performs query four
public class QueryFour<T extends Comparable<T>> extends Query<T>{
	
	public QueryFour(HashMap<String, DataFrame> dataFrames) {
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
		String data = (String) parameters.get("data");
		String type = (String) parameters.get("type");
		int rank = (int) parameters.get("rank");
		DataFrame dataFrame = dataFrames.get(data);
		return "The " + type + " of the #" + rank + " ranked " + data + " movie was " + performQuery(dataFrame, type, rank) + "\n";
	}
	
	public HashMap<String, T> getInput(){
		/*
		 * taking in input
		 */
		HashMap<String, T> parameters = new HashMap<String, T>();
		System.out.print("What data are you interested in (ratings or gross)? ");
		T data = (T) scnr.next();
		parameters.put("data", data);
		System.out.print("What type are you interested in (cast or director)? ");
		T type = (T) scnr.next();
		parameters.put("type", type);
		System.out.print("What rank are you interested in? ");
		T rank = (T)(Object) scnr.nextInt();
		parameters.put("rank",  rank);
		return parameters;
	}
	
	private String performQuery(DataFrame data, String type, int rank) {
		/*
		 * performs the filtering and functionalyt of query
		 */
		DataFrame filteredData = data.filter("Rank", rank, "=");
		String title = (String) filteredData.get(0).get("Title");
		DataFrame castData = dataFrames.get("cast");
		Row row = castData.filter("Title", title, "=").get(0);
		if (type.equals("cast")) {
			return getCast(row);
		}
		else {
			return getDirector(row);
		}
	}
	
	private String getDirector(Row data) {
		/*
		 * Purpose: Gets the director from the row
		 * Parameters:
		 * 		data - row that you want to extract the director from
		 */
		return (String) data.get("Director");
	}
	
	private String getCast(Row data) {
		/*
		 * gets the cast from a row
		 */
		String answer = "";
		for (int i = 1; i <= 4; i++) {
			String name = "Cast " + i;
			answer += (String) data.get(name) + ", ";
		}
		answer += data.get("Cast 5") + ".";
		return answer;
	}
	
	
}
