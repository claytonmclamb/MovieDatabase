package Tests;

import java.util.HashMap;

import Model.CastProcessor;
import Model.DataFrame;
import Model.GrossProcessor;
import Model.Preprocessing;
import Model.RatingsProcessor;


// author - clayton mclamb
// purpose - class for JUnit tests to inherit from - how ot load data
public class QueryTest {

    protected void loadCastData(String folderName, HashMap<String, DataFrame> dataFrames) {
    	final String FILE = "cast.txt";
    	Preprocessing castProcessor = new CastProcessor(folderName + FILE);
    	dataFrames.put("cast", castProcessor.loadData());
    }
    
    protected void loadGrossData(String folderName, HashMap<String, DataFrame> dataFrames) {
    	final String FILE = "gross.txt";
    	Preprocessing grossProcessor = new GrossProcessor(folderName + FILE);
    	dataFrames.put("gross", grossProcessor.loadData());
    }
    
    protected void loadRatingsData(String folderName, HashMap<String, DataFrame> dataFrames) {
    	final String FILE = "ratings.txt";
    	Preprocessing ratingsProcessor = new RatingsProcessor(folderName + FILE);
    	dataFrames.put("ratings", ratingsProcessor.loadData());
    }
    
    protected HashMap<String, DataFrame> loadData() {
    	HashMap<String, DataFrame> dataFrames = new HashMap<String, DataFrame>();
    	final String FOLDER = "src//Data//";
    	loadCastData(FOLDER, dataFrames);
    	loadGrossData(FOLDER, dataFrames);
    	loadRatingsData(FOLDER, dataFrames);
    	return dataFrames;
    }

}
