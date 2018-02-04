package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixTwoD {

    private int[][] values;

    public MatrixTwoD(int[][] values) {

        if (values.length < 1 || values.length > 10) {
            // This checks and throws the IllegalArgumentException if the value of rows is not in the range of 1 to 10 both inclusive
            throw new IllegalArgumentException("Between one and ten rows of values are expected");
        } else if (values[0].length < 5 || values[0].length > 100) {
            // This checks and throws the IllegalArgumentException if the value of columns is not in the range of 5 to 100 both inclusive
            throw new IllegalArgumentException("Between five and one hundred columns of values are expected");
        }

        this.values = values;
    }

    /*
     * Method to retrive the value at a particular cell in the Matrix
     */
    public int getValueAtCell(int row, int column) {
        return values[row - 1][column - 1];
    }

    public int getRowCount() {
        return values.length;
    }

    public int getColumnCount() {
        return values[0].length;
    }

    public List<Integer> getRowsAdjacentTo(int rowNumber) {
        Set<Integer> adjacentRows = new HashSet<>();

        if (isValidRowNumber(rowNumber)) {
            adjacentRows.add(rowNumber);
            adjacentRows.add(getRowAbove(rowNumber));
            adjacentRows.add(getRowBelow(rowNumber));
        }

        return new ArrayList<>(adjacentRows);
    }

    public String asDelimitedString(String delimiter) {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                builder.append(values[row][column]);
                if (column < values[row].length - 1) {
                    builder.append(delimiter);
                }
            }
            if (row < values.length - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    private boolean isValidRowNumber(int rowNumber) {
        return (rowNumber > 0) && (rowNumber <= values.length);
    }

    private int getRowAbove(int rowNumber) {
        int potentialRowNumber = rowNumber - 1;
        return (potentialRowNumber < 1) ? values.length : potentialRowNumber;
    }

    private int getRowBelow(int rowNumber) {
        int potentialRowNumber = rowNumber + 1;
        return (potentialRowNumber > values.length) ? 1 : potentialRowNumber;
    }

}
