package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import Model.*;

public class QueryFourTests<T> extends QueryTest{
	
	
	private String getString(String type, int rank, String data, String answer) {
		return "The " + type + " of the #" + rank + " ranked " + data + " movie was " + answer + "\n";
    }
    
    private ArrayList<String> getAnswers(){
    	ArrayList<String> answers = new ArrayList<String>();
    	answers.add(getString("cast", 5, "gross", "Liam Neeson, Ewan McGregor, Natalie Portman, Jake Lloyd, Ian McDiarmid."));
    	answers.add(getString("director", 5, "gross", "George Lucas"));
    	answers.add(getString("cast", 5, "ratings", "Eli Wallach, Clint Eastwood, Lee Van Cleef, Aldo Giuffrè, Luigi Pistilli."));
    	answers.add(getString("director", 5, "ratings", "Sergio Leone"));
    	return answers;
    }
    
    @Test
	void TestQuerFour() {
    	HashMap<String, DataFrame> dataFrames = loadData();
    	Query query = new QueryFour(dataFrames);
    	ArrayList<String> correctAnswers = getAnswers();
    	ArrayList<String> answers = new ArrayList<String>();
    	
    	String[] types = {"cast", "director", "cast", "director"};
    	final int rank = 5;
    	String[] data = {"gross", "gross", "ratings", "ratings"};
    	
    	for (int i = 0; i < types.length; i++){
    		HashMap<String, T> parameters = new HashMap<String, T>();
    		parameters.put("rank", (T)(Object) rank);
    		parameters.put("type", (T) types[i]);
    		parameters.put("data", (T) data[i]);
    		answers.add(query.getAnswer(parameters));
    	}
    	assertEquals(correctAnswers, answers, "the answers did not match.");
    }

}
