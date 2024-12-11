package Controller;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import Model.*;
import View.ViewSettings;

// author Clayton Mclamb
// purpose - controller part of MVC. Decides what to do with user input and communicates with the model.
public class MovieController<T extends Comparable<T>> extends Controller{
	
    public MovieController(String folderName) {
    	/*
    	 * Purpose: Constructor
    	 * Parameters:
    	 * 		- folderName: 
    	 */
    	super(folderName);
    }
    
    protected void makeDataFrames(String folderName) {
    	/*
    	 * Purpose: this function loads the various dataframes into the dataFrames field
    	 * Parameters:
    	 * 	folderName - where the data is located
    	 */
    	loadCastData(folderName);
    	loadGrossData(folderName);
    	loadRatingsData(folderName);
    }
    
    private void loadCastData(String folderName) {
    	/*
    	 * Purpose: loads the cast data into dataFrames field
    	 * Parameters:
    	 * 	folderName - where the data is located
    	 */
    	final String FILE = "cast.txt";
    	Preprocessing castProcessor = new CastProcessor(folderName + FILE);
    	dataFrames.put("cast", castProcessor.loadData());
    }
    
    private void loadGrossData(String folderName) {
    	/*
    	 * Purpose: loads the gross data into dataFrames field
    	 * Parameters:
    	 * 	folderName - where the data is located
    	 */
    	final String FILE = "gross.txt";
    	Preprocessing grossProcessor = new GrossProcessor(folderName + FILE);
    	dataFrames.put("gross", grossProcessor.loadData());
    }
    
    private void loadRatingsData(String folderName) {
    	/*
    	 * Purpose: loads the ratings data into dataFrames field
    	 * Parameters:
    	 * 	folderName - where the data is located
    	 */
    	final String FILE = "ratings.txt";
    	Preprocessing ratingsProcessor = new RatingsProcessor(folderName + FILE);
    	dataFrames.put("ratings", ratingsProcessor.loadData());
    }

	protected void makeFactory() {
        /*
         * Purpose: Populate the factory with mappings of query identifiers to their corresponding Query class constructors.
         */
        try {
            factory.put(ViewSettings.queryOne, (Constructor<? extends Query<T>>) QueryOne.class.getConstructor(HashMap.class));
            factory.put(ViewSettings.queryTwo, (Constructor<? extends Query<T>>) QueryTwo.class.getConstructor(HashMap.class)); 
            factory.put(ViewSettings.queryThree, (Constructor<? extends Query<T>>) QueryThree.class.getConstructor(HashMap.class)); 
            factory.put(ViewSettings.queryFour, (Constructor<? extends Query<T>>) QueryFour.class.getConstructor(HashMap.class)); 
            factory.put(ViewSettings.queryFive, (Constructor<? extends Query<T>>) QueryFive.class.getConstructor(HashMap.class)); 
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
