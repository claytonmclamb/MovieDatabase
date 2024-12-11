package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Model.Row;
import java.util.*;

import org.junit.jupiter.api.Test;

class RowTests<T>{

	@Test
	void TestEquivalsTrue() {
		// this tests if the equals method works
		// making columns
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("name");
		columns.add("age");
		//making rows
		ArrayList<Comparable> aVals = new ArrayList<Comparable>();
		aVals.add("Clayton");
		aVals.add(21);
		Row a = new Row(aVals, columns);
		Row b = new Row(aVals, columns);
		assertEquals(true, a.equals(b), "Two of the same row did not return true.");
	}
	
	@Test
	void TestEquivalsFalse() {
		// this tests if the equals method works
		// making columns
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("name");
		columns.add("age");
		//making first row
		ArrayList<Comparable> aVals = new ArrayList<Comparable>();
		aVals.add("Clayton");
		aVals.add(21);
		Row a = new Row(aVals, columns);
		//making second row
		ArrayList<Comparable> bVals = new ArrayList<Comparable>();
		bVals.add("Clayton");
		bVals.add(24);
		Row b = new Row(bVals, columns);
		assertEquals(false, a.equals(b), "Two different rows did not return false.");
	}
	
	@Test
	void TestColumns() {
		// this tests if the correct columns are returned
		// making columns
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("name");
		columns.add("age");
		//making row
		ArrayList<Comparable> aVals = new ArrayList<Comparable>();
		aVals.add("Clayton");
		aVals.add(21);
		Row a = new Row(aVals, columns);
		assertEquals(columns, a.getCols(), "Returned the wrong columns.");
	}
	
	@Test
	void TestGet() {
		// this tests if the correct columns are returned
		// making columns
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("name");
		columns.add("age");
		//making row
		ArrayList<Comparable> aVals = new ArrayList<Comparable>();
		aVals.add("Clayton");
		aVals.add(21);
		Row a = new Row(aVals, columns);
		assertEquals(21, a.get("age"), "Returns the correct value of the key.");
	}
	@Test
	void TestMatchTrueInetegers() {
		// this tests if the equals method works
		// making columns
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("name");
		columns.add("age");
		//making rows
		ArrayList<Comparable> aVals = new ArrayList<Comparable>();
		aVals.add("Clayton");
		aVals.add(21);
		Row a = new Row(aVals, columns);
		assertEquals(true, a.match("age", 21), "The row matches.");
	}
	

	@Test
	void TestMatchTrueStrings() {
		// this tests if the equals method works
		// making columns
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("name");
		columns.add("age");
		//making rows
		ArrayList<Comparable> aVals = new ArrayList<Comparable>();
		aVals.add("Clayton");
		aVals.add(21);
		Row a = new Row(aVals, columns);
		assertEquals(true, a.match("name", "Clayton"), "The row matches.");
	}
	

	
	



}
