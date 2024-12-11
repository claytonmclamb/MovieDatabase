package Model;

import java.util.HashMap;

// author - clayton mclamb
// purpose - performs the query one functionality
public class QueryOne<T extends Comparable<T>> extends Query<T>{
	//fields
	private static final String DATA_OF_INTEREST = "gross";
	private static final String COL_OF_INTEREST = "USA Box Office";

	
	public QueryOne(HashMap<String, DataFrame> dataFrames) {
		/*
		 * Purpose: Constructor
		 * Parameters:
		 * 	dataFrames: hashmap of data
		 */
		super(dataFrames);
	}
	
	@Override
	public String getAnswer(HashMap<String, T> parameters) {
		/*
		 * getting the answer for this query
		 * parameters - hashmap of input values
		 */
		int year = (int) parameters.get("year");
		DataFrame dataOfInterest = (DataFrame) dataFrames.get(DATA_OF_INTEREST);
		String answer = findTotalBoxOffice(dataOfInterest, year);
		return answer;
	}
	
	public HashMap<String, T> getInput() {
		/*
		 * Taking in input
		 */
		HashMap<String, T> parameters = new HashMap<String, T>();
		System.out.print("What year are you interested in? ");
		T year = (T)(Object) scnr.nextInt();
		parameters.put("year",  year);
		return parameters;
	}
	
	private String findTotalBoxOffice(DataFrame data, int year) {
		/*
		 * sums up box office
		 */
		DataFrame<T> filteredData = data.filter("Year", year, "=");
		long total = 0;
		for(int i = 0; i < filteredData.size(); i++){
			Row row = filteredData.get(i);
			int boxOffice = (int) row.get(COL_OF_INTEREST);
			total += boxOffice;
		}
		return "The total box office in " + year + " was $" + total + ".\n";
	}
}
