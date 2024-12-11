package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Model.*;
import java.util.*;
import org.junit.jupiter.api.Test;


public class QueryThreeTests<T> extends QueryTest{
	
	private String getString(int nDirectors) {
		// getting string representation
		String answer = "Below are a list of the directors that have appeared the most, in addition to their frequency.\n";
    	int count = 0;
    	int i = 0;
    	while(count < nDirectors && i < QUERY_CONSTANTS.directors.length) {
    		String value = QUERY_CONSTANTS.DIRECTOR_FREQ_NAME[i] + " | " + QUERY_CONSTANTS.DIRECTOR_FREQ_INT[i];
    		answer += value + "\n";
    		count++;
    		i++;
    	}
    	return answer;
    }
    
    private ArrayList<String> getAnswers(){
    	// getting correct answers
    	ArrayList<String> answers = new ArrayList<String>();
    	answers.add(getString(5));
    	answers.add(getString(10));
    	answers.add(getString(15));
    	answers.add(getString(20));
    	answers.add(getString(25));
    	answers.add(getString(30));
    	return answers;
    }
    
    private int getNumber(String line) {
    	// getting number from line
    	String[] data = line.split(" ");
    	return Integer.parseInt(data[data.length - 1]);
    }
    
    
    private ArrayList<Boolean> checkAnswerFrequency(ArrayList<String> correctAnswers, ArrayList<String> predictedAnswers) {
    	// checking if frequencies match
    	ArrayList<Boolean> verification = new ArrayList<Boolean>();
    	for (int i = 0; i < correctAnswers.size(); i++) {
    		boolean check = true;
    		String[] correct = correctAnswers.get(i).split("\n");
    		String[] prediction = predictedAnswers.get(i).split("\n");
    		for(int j = 1; j < correct.length; j++) {
    			int numA = getNumber(correct[j]);
    			int numB = getNumber(prediction[j]);
    			if(numA != numB) {
    				check = false;
    			}
    		}
    		verification.add(check);
    	}
    	return verification;
    }
    
    @Test
	void TestQueryThree() {
    	// testing query three
    	HashMap<String, DataFrame> dataFrames =loadData();
    	Query query = new QueryThree(dataFrames);
    	ArrayList<String> correctAnswers = getAnswers();
    	ArrayList<String> answers = new ArrayList<String>();

    	ArrayList<Boolean> answersBoolean = new ArrayList<Boolean>();
    	for(int i = 0; i < 6; i++) {
    		answersBoolean.add(true);
    	}
    	int[] nValues = {5, 10, 15, 20, 25, 30};
    	for(int n : nValues) {
    		HashMap<String, T> parameters = new HashMap<String, T>();
    		parameters.put("nDirectors", (T)(Object)n);
    		String answer = query.getAnswer(parameters);
    		answers.add(answer);
    	}
    	
    	assertEquals(answersBoolean, checkAnswerFrequency(correctAnswers, answers), "the answers did not match.");
    }
}
