package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import Model.*;


// author - clayton mclamb
// purpose - testing query two
public class QueryTwoTests<T> extends QueryTest{
	private String getString(int nDirectors) {
		String answer = "Below is a list of all directors. \n";
    	int count = 0;
    	int i = 0;
    	while(count < nDirectors && i < QUERY_CONSTANTS.directors.length) {
    		String value = QUERY_CONSTANTS.directors[i];
    		answer += value + "\n";
    		count++;
    		i++;
    	}
    	return answer;
    }
    
    private ArrayList<String> getAnswers(){
    	// getting the answers
    	ArrayList<String> answers = new ArrayList<String>();
    	answers.add(getString(5));
    	answers.add(getString(10));
    	answers.add(getString(15));
    	answers.add(getString(20));
    	answers.add(getString(25));
    	answers.add(getString(30));
    	answers.add(getString(35));
    	answers.add(getString(40));
    	return answers;
    }
    
    @Test
	void TestQueryTwo() {
    	//testing the query
    	HashMap<String, DataFrame> dataFrames =loadData();
    	Query query = new QueryTwo(dataFrames);
    	ArrayList<String> correctAnswers = getAnswers();
    	ArrayList<String> answers = new ArrayList<String>();
    	int[] nValues = {5, 10, 15, 20, 25, 30, 35, 40};
    	for(int n : nValues) {
    		HashMap<String, T> parameters = new HashMap<String, T>();
    		parameters.put("nDirectors", (T)(Object)n);
    		String answer = query.getAnswer(parameters);
    		answers.add(answer);
    	}
    	// do the answers match up?
    	assertEquals(correctAnswers, answers, "the answers did not match.");
    }

}
