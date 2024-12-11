package View;

//author - clayton mclamb
//purpose - constants within view
public class ViewSettings {
	// these are the queries
	public static final String queryOne = "Give the total US box office earnings in the database in a single year.";
	public static final String queryTwo = "Give a list of all the directors of movies in the database.";
	public static final String queryThree = "Give a list of some number of directors who appear most in the database.";
	public static final String queryFour = "Tell the director or cast members who starred in a movie, given the movie’s rating rank or money rank.";
	public static final String queryFive = "Tell the title of a highest-grossing movie that was a given rank.";
	public static final String[] queries = {queryOne, queryTwo, queryThree, queryFour, queryFive};
	// these are the statements for printing
	public static final String introduction = "Hello welcome to the Movie Database. Below are a list of queries you can select.\nAfter selecting a query, we will take in more information to answer your question.\nSelect 0 if you would not like to query the database.\n";
	public static final String selection = "Select a query to perform: ";
	public static final String conclusion = "Thank you for using the movie database!";
}
