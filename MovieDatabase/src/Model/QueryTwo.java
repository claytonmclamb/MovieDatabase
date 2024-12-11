package Model;

import java.util.*;

// author - clayton mclamb
// purpose - performs query two functionality
public class QueryTwo<T extends Comparable<T>> extends Query<T> {
	//fields
	private static final String DATA_NAME = "cast";
	
	
	public QueryTwo(HashMap<String, DataFrame> dataFrames) {
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
        return concatenateDirectors(directors, number);
    }
    
    public HashMap<String, T> getInput() {
    	/*
    	 * gets input
    	 */
    	HashMap<String, T> parameters = new HashMap<String, T>();
    	System.out.print("How many director(s) would you like to list? ");
    	T nDirectors = (T)(Object)scnr.nextInt();
    	parameters.put("nDirectors", nDirectors);
    	return parameters;
    }
    
    protected ArrayList<T> getAllDirectors(){
    	/*
    	 * gets all of the directors in the dataframe
    	 */
    	DataFrame data = dataFrames.get(DATA_NAME);
    	data.sort("Director");
    	ArrayList<T> directors = data.getColumn("Director");
    	return directors;
    }
    
    private String concatenateDirectors(ArrayList<T> directors, int number) {
    	/*
    	 * places all the directors into one string
    	 */
    	String answer = "Below is a list of all directors. \n";
    	int count = 0;
    	int i = 0;
    	while(count < number && i < directors.size()) {
    		T value = directors.get(i);
    		String string = (String) value;
    		if (!answer.contains(string)) {
        		answer += string + "\n";
        		count++;
    		}
    		i++;
    	}
    	return answer;
    			
    }
}
