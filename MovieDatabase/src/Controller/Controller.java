package Controller;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import Model.*;
import View.ViewSettings;

// author Clayton Mclamb
// purpose - controller part of MVC. Decides what to do with user input and communicates with the model.
public abstract class Controller<T extends Comparable<T>> {
	//fields
	//factory pattern
    protected final HashMap<String, Constructor<? extends Query<T>>> factory;
    // where data is stored
    protected HashMap<String, DataFrame> dataFrames;
    

    public Controller(String folderName) {
    	/*
    	 * Purpose: Constructor
    	 * Parameters:
    	 * 		- folderName: 
    	 */
        factory = new HashMap<>();
        dataFrames = new HashMap<String, DataFrame>();
        makeFactory();
        makeDataFrames(folderName);
    }
    
    protected abstract void makeDataFrames(String folderName);
    protected abstract void makeFactory();
    
   
    public String getAnswer(String query) {
    	/*
    	 * Purpose: This gets the query from the factory pattern and uses it to get the answer for the View
    	 */
    	Query queryDecision = null;
		try {
			//getting the query and using it
			queryDecision = factory.get(query).newInstance(dataFrames);
			return queryDecision.getAnswer(queryDecision.getInput());
		} catch (Exception e) {
			//query did not work
			return "Query not possible. Please adjust the query.\n";
		}
    }
}
