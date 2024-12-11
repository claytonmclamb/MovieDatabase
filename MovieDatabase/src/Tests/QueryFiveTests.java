package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import Model.*;

// author - clayton mclamb
// purpose - testing query five
public class QueryFiveTests<T> extends QueryTest{
	
	
	private String getString(int rank, String movie) {
		return "The highest-grossing movie ranked " + rank + " was " + movie +".\n";    
	}
    
    private ArrayList<String> getAnswers(){
    	ArrayList<String> answers = new ArrayList<String>();
    	answers.add(getString(1, "Avatar"));
    	answers.add(getString(157, "Batman Forever"));
    	answers.add(getString(197, "A Beautiful Mind"));
    	answers.add(getString(203, "Wild Hogs"));
    	return answers;
    }
    
    @Test
	void TestQuerFour() {
    	HashMap<String, DataFrame> dataFrames = loadData();
    	Query query = new QueryFive(dataFrames);
    	ArrayList<String> correctAnswers = getAnswers();
    	ArrayList<String> answers = new ArrayList<String>();
    	int[] rankings = {1, 157, 197, 203};
    	
    	for (int i = 0; i < rankings.length; i++){
    		HashMap<String, T> parameters = new HashMap<String, T>();
    		parameters.put("rank", (T)(Object) rankings[i]);
    		answers.add(query.getAnswer(parameters));
    	}
    	assertEquals(correctAnswers, answers, "the answers did not match.");
    }

}
