package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Row<T>{
    // Class designed for each row in a DataFrame object.
    private ArrayList<String> columns;
    private HashMap<String, T> row;

    public Row() {
        // Default constructor - makes empty row
        columns = new ArrayList<>();
        row = new HashMap<>();
    }

    public Row(ArrayList<T> items, ArrayList<String> columns) {
        /*
         * Purpose: Custom Constructor for values given in ArrayList.
         * Parameters:
         *  - items: ArrayList of associated values
         *  - columns: ArrayList of column names 
         */
        row = new HashMap<>();
        this.columns = columns;
        for (int i = 0; i < columns.size(); i++) {
            row.put(columns.get(i), items.get(i));
        }
    }

    public ArrayList<String> getCols() {
        /*
         * Purpose: Returns the columns of the row. 
         */
        return columns;
    }

    public T get(String key) {
        /*
         * Purpose: Returns the value of associated column. 
         */
        return row.get(key);
    }

    public boolean equals(Row<T> other) {
        /*
         * Purpose: Returns if two rows have the same values or not. True if they have the same overlapping values. 
         * Parameters: 
         *  - other: Row to be compared
         */
        for (String col : other.getCols()) {
            if (!this.row.get(col).equals(other.get(col))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        /*
         * Purpose: Returns the Row as a String representation. 
         */
        StringBuilder answer = new StringBuilder();
        for (String column : columns) {
            answer.append(row.get(column)).append(" | ");
        }
        answer.append("\n");
        return answer.toString();
    }

    public boolean match(String column, T value) {
        /*
         * Purpose: Returns true if a value matches a given value in a column of a row. 
         * Parameters: 
         *  - column: specific column to retrieve value from
         *  - value: Value to be compared
         */
        return row.get(column).equals(value);
    }

	public boolean lessThan(String column, T value) {
        /*
         * Purpose: Returns true if a value is less than a given value in a column of a row. 
         * Parameters: 
         *  - column: specific column to retrieve value from
         *  - value: Value to be compared
         */
        T columnValue = row.get(column);
        if (columnValue instanceof Comparable) {
            return ((Comparable<T>) columnValue).compareTo(value) < 0;
        }
        throw new IllegalArgumentException("Values are not comparable");
    }

	public boolean greaterThan(String column, T value) {
        /*
         * Purpose: Returns true if a value is greater than a given value in a column of a row. 
         * Parameters: 
         *  - column: specific column to retrieve value from
         *  - value: Value to be compared
         */
        T columnValue = row.get(column);
        if (columnValue instanceof Comparable) {
            return ((Comparable<T>) columnValue).compareTo(value) > 0;
        }
        throw new IllegalArgumentException("Values are not comparable");
    }

    public int compareRow(Row<T> b, String col) {
        /*
         * Purpose: Compares two rows to one another - designed for sorting DataFrames. 
         * Parameters: 
         *  - b: Other row to be compared
         *  - col: Column for comparison
         */
        T thisValue = this.get(col);
        T otherValue = b.get(col);
        if (thisValue instanceof Comparable && otherValue instanceof Comparable) {
            return ((Comparable<T>) thisValue).compareTo(otherValue);
        }
        throw new IllegalArgumentException("Values are not comparable");
    }
}
