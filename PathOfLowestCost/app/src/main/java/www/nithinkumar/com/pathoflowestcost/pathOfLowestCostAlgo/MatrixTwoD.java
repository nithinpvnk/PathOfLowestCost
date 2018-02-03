package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;


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
    public int getValueAtCell(int row, int column)
    {
        return values[row - 1][column - 1];
    }

    public int getRowCount() {
        return values.length;
    }

    public int getColumnCount() {
       return values[0].length;
    }
}
