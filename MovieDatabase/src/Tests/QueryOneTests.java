package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Model.*;
import java.util.*;
import org.junit.jupiter.api.Test;

// author - clayton mclamb
// purpose - testing query one
class QueryOneTests<T> extends QueryTest{
	    
	    private String getString(int year, long total) {
	    	// getting string rep. 
	    	return "The total box office in " + year + " was $" + total + ".\n";
	    }
	    
	    private ArrayList<String> getAnswers(){
	    	ArrayList<String> answers = new ArrayList<String>();
	    	answers.add(getString(2000, 1898045446));
	    	answers.add(getString(1963, 0));
	    	answers.add(getString(1975, 260000000));
	    	answers.add(getString(1980, 290158751));
	    	answers.add(getString(1990, 866007665));
	    	answers.add(getString(1995, 547898657));
	    	answers.add(getString(2005, 2905172250L));
	    	return answers;
	    }
	    
	    @Test
		void TestQueryOne() {
	    	// testing query
	    	HashMap<String, DataFrame> dataFrames = loadData();
	    	Query query = new QueryOne(dataFrames);
	    	ArrayList<String> correctAnswers = getAnswers();
	    	ArrayList<String> answers = new ArrayList<String>();
	    	int[] years = {2000, 1963, 1975, 1980, 1990, 1995, 2005};
	    	for(int year : years) {
	    		System.out.println(year);
	    		HashMap<String, T> parameters = new HashMap<String, T>();
	    		parameters.put("year", (T)(Object)year);
	    		String answer = query.getAnswer(parameters);
	    		answers.add(answer);
	    	}
	    	assertEquals(correctAnswers, answers, "the correct answers were + \n " + correctAnswers + "\n the answers the query returned were \n" + answers);
	    }

	
}
