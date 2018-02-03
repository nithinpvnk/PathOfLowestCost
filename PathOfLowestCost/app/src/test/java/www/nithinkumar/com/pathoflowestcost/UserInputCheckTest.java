package www.nithinkumar.com.pathoflowestcost;


import org.junit.Test;

import www.nithinkumar.com.pathoflowestcost.util.InputChecks;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/*
* This is a test case used to validate the user input.
*/
public class UserInputCheckTest {

    /*
   * This is a test case which gives in an input
   * of empty string
   */
    @Test
    public void createEmptyMatrixWithNullInput() {
        assertThat(InputChecks.stringToMatrix(null), equalTo(new int[0][0]));
    }

    /*
    * This is a test case which gives in an input
    * of at least one value as a Non-Numeric string value
    */
    @Test
    public void createEmptyMatrixWithNonNumericInput() {
        assertThat(InputChecks.stringToMatrix("1 2 3 4 a g 6"), equalTo(new int[0][0]));

    }

    /*
    * This is a test case which gives in an input
    * of values of a single row in the string format
    */
    @Test
    public void createOneRowMatrix() {
        assertThat(InputChecks.stringToMatrix("1 2 3 4 5"), equalTo(new int[][]{{1, 2, 3, 4, 5}}));
    }

    /*
    * This is a test case which gives in an input
    * of values of a single column in the string format using new line separators
    */
    @Test
    public void createOneColumnMatrix() {
        assertThat(InputChecks.stringToMatrix("1\n2\n3\n4\n5"), equalTo(new int[][]{{1}, {2}, {3}, {4}, {5}}));
    }

    /*
    * This is a test case which gives in an input
    * of values of a matrix in the string format using new line separators for different column and spaces.
    * Taking the first row as the base value any row with more values than the base row values shall not be considered
    * Ex: 5 is the length then any row with more than 5 values will not have the excess values considered
    */
    @Test
    public void createMatrixWithDifferentRowSizes() {
        assertThat(InputChecks.stringToMatrix("1 2 3\n6 7 8 9 10"),
                equalTo(new int[][]{{1, 2, 3}, {6, 7, 8}}));

        assertThat(InputChecks.stringToMatrix("1 2 3 4 5 6 7\n6 7 8 9 10"),
                equalTo(new int[][]{{1, 2, 3, 4, 5, 6, 7}, {6, 7, 8, 9, 10, 0, 0}}));

    }

    /*
    * This is a test case which gives in an input
    * of values of a valid matrix in the string format using new line separators and commas
    */
    @Test
    public void createValidMatrix() {
        assertThat(InputChecks.stringToMatrix("1  2   3  4 5\n6 7 8  9\t10"),
                equalTo(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}}));
    }

}
