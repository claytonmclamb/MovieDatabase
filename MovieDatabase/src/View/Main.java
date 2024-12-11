package View;
// author - Clayton McLamb
// THIS IS WHERE YOU RUN THE PROGRAM. 

public class Main {
	
	public static void main(String[] args) {
		// this is where you specify the location of the data
		final String FOLDER_NAME = "src//Data//";
		View view = new MovieView(FOLDER_NAME);
		view.main();
	}

}
