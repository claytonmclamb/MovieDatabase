package Model;
import java.util.ArrayList;
import java.util.Comparator;

public class DataFrame<T extends Comparable<T>> {
    // This class is a custom implementation of a DataFrame. Functionality similar to Pandas in Python.
    private ArrayList<String> columns;
    private ArrayList<Row<T>> dataFrame;

    public DataFrame(ArrayList<String> columns) {
        /*
         * Purpose: Constructor for DataFrame class.
         * Parameters:
         *      - columns: list of columns to have in the DataFrame
         */
        this.columns = columns;
        this.dataFrame = new ArrayList<>();
    }

    public void append(ArrayList<T> values) {
        /*
         * Purpose: Given a list of values, add to the DataFrame by converting it to a Row.
         * Parameters:
         *      - values: a list of values seen within the row
         */
        Row<T> row = new Row<>(values, this.columns);
        dataFrame.add(row);
    }

    public void appendRow(Row<T> row) {
        /*
         * Purpose: When data is already converted into the Row format, add it to the dataFrame.
         * Parameters:
         *      - row: The data in Row format
         */
        dataFrame.add(row);
    }

    public String toString() {
        /*
         * Purpose: String representation of DataFrame, displaying column names and first ten rows of data
         */
        StringBuilder answer = new StringBuilder();
        for (String column : columns) {
            answer.append(column).append(" | ");
        }
        answer.append("\n");
        for (int i = 0; i < Math.min(10, dataFrame.size()); i++) {
            answer.append(dataFrame.get(i).toString());
        }
        return answer.toString();
    }

    public void sort(String column) {
        /*
         * Purpose: Sort a specified column in descending order
         * Parameters:
         *      - column: name of column you want to sort by
         */
        class Compare implements Comparator<Row<T>> {
            @Override
            public int compare(Row<T> a, Row<T> b) {
                return a.compareRow(b, column);
            }
        }
        Comparator<Row<T>> c = new Compare();
        dataFrame.sort(c);
    }

    public DataFrame<T> filter(String column, T value, String operator) {
        /*
         * Purpose: Make a new DataFrame, filtering out values not wanted
         * Parameters:
         *      - column: Specified column you want to filter based on
         *      - value: Specified value of the column you want
         */
        DataFrame<T> filteredData = new DataFrame<>(this.columns);
        for (Row<T> row : dataFrame) {
            if (operator.equals("=") && row.match(column, value)) {
                filteredData.appendRow(row);
            } else if (operator.equals("<") && row.lessThan(column, value)) {
                filteredData.appendRow(row);
            } else if (operator.equals(">") && row.greaterThan(column, value)) {
                filteredData.appendRow(row);
            }
        }
        return filteredData;
    }

    public boolean checkValues(Row<T> row, Row<T> values) {
        /*
         * Purpose: Checks if the values match from two Rows
         * Parameters:
         *      - row: Row from a given DataFrame
         *      - values: Row of values wanted
         */
        return row.equals(values);
    }

    public int getIndex(Row<T> values) {
        /*
         * Purpose: Returns the index of the first row matching a given series of values
         * Parameters:
         *      - values: Row of values wanted
         */
        for (int i = 0; i < dataFrame.size(); i++) {
            if (checkValues(dataFrame.get(i), values)) {
                return i;
            }
        }
        return -1;
    }

    public Row<T> get(int i) {
        /*
         * Purpose: Returns the row at a given index (similar to get in ArrayLists)
         * Parameters:
         *      - i: Index of desired row
         */
        return dataFrame.get(i);
    }

    public int size() {
        /*
         * Purpose: Returns the number of rows (similar to size in ArrayLists)
         */
        return dataFrame.size();
    }

    public Row<T> findRow(String column, T value) {
        /*
         * Purpose: Returns the first row with a matching value
         * Parameters:
         *      - column: Column to examine
         *      - value: Value to compare
         */
        final String EQUALS_SIGN = "=";
        return this.filter(column, value, EQUALS_SIGN).get(0);
    }
    
    public ArrayList<T> getColumn(String column){
    	/*
    	 * Purpose: given a column, return all values
    	 * Parameters:
    	 * 	column: specified column
    	 */
    	ArrayList<T> columnValues = new ArrayList<T>();
    	for(Row row : dataFrame) {
    		T value = (T) row.get(column);
    		columnValues.add(value);
    	}
    	return columnValues;
    }
}
