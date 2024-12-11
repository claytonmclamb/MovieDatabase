package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Controller.*;

// author - Clayton McLamb
// this class provides the View in MVC. It interacts with the user and takes their input. 
public abstract class View {
	//fields
	Controller controller;
	HashMap<Integer, String> queryMap;
	Scanner scnr;
	String introduction;
	String conclusion;
	
	public View(String folderName, String introduction, String conclusion) {
		/*
		 * This is the constructor
		 * Parameters:
		 * 	- folderName - the location of the data
		 *  - introduction - start of program
		 *  - conclusion - end of program
		 */
		makeMap();
		scnr = new Scanner(System.in);
		this.introduction = introduction;
		this.conclusion = conclusion;
	}
	
	protected abstract void makeMap();
	
	public void main() {
		/*
		 * Purpose: Main loop of the code
		 */
		System.out.println(introduction);
		int selection = selectionProcess();
		while (selection != 0) {
			String answer = getAnswer(selection);
			System.out.println(answer);
			selection = selectionProcess();
		}
		System.out.println(conclusion);
	}
	
	private int selectionProcess() {
		/*
		 * Purpose: Process for how users select queries. 
		 */
		printQueries();
		int selection = getSelection();
		return selection;
	}
	
	private void printQueries() {
		/*
		 * Purpose: Prints the queries from the user to choose from
		 */
		for(Integer key : queryMap.keySet()) {
			System.out.println(key + ": " + queryMap.get(key));
		}
	}
	
	private int getSelection() {
		/*
		 * Purpose: gets the selection from the user
		 */
		System.out.print(ViewSettings.selection);
		int selection = scnr.nextInt();
		System.out.println();
		return selection;
	}
	
	private String getAnswer(int selection) {
		/*
		 * Purpose: Returns the query the user has selected
		 * Parameters:
		 * 	selection: what number the user has selected
		 */
		String selectedQuery = queryMap.get(selection);
		String answer = controller.getAnswer(selectedQuery);
		return answer;
	}
}
