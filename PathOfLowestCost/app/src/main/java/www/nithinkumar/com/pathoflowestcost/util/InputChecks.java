package www.nithinkumar.com.pathoflowestcost.util;


public class InputChecks {

    /*
     * This is function used to convert the given input in the form of a string into a proper 2D Matrix
    */
    public static int[][] stringToMatrix(String input) {

        if (input != null) {
            String[] rows = input.split("\n");  // Split the input with respect to the new Line to separate rows

            String[] firstColumn = rows[0].split("\\s+");   //Split the values in the first row with respect to space

            int[][] outputMatrix = new int[rows.length][firstColumn.length];    //The matrix that needs to be produced from the given values

            try {
                for (int row = 0; row < rows.length; row++) {
                    String[] columns = rows[row].split("\\s+");
                    for (int column = 0; column < columns.length; column++) {
                        if (column < outputMatrix[0].length) {
                            outputMatrix[row][column] = Integer.valueOf(columns[column]);
                        }
                    }
                }

                return outputMatrix;
            } catch (NumberFormatException nfe) {
                return new int[0][0];
            }
        } else {
            return new int[0][0];
        }
    }
}
