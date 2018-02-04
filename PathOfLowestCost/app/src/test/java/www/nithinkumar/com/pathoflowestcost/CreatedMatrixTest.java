package www.nithinkumar.com.pathoflowestcost;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.MatrixTwoD;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/*
 * This is a test suite used to check the condition of rows and columns present in the given matrix
 */
public class CreatedMatrixTest {

    /*
     * This is a test case used to check the condition of minimum one row to be present in the given matrix
     */
    @Test(expected = IllegalArgumentException.class)
    public void minimumOneRowRequirementInMatrix() {
        int[][] values = new int[0][0];
        new MatrixTwoD(values);
    }

    /*
     * This is a test case used to check the condition of minimum five column to be present in the given matrix
     */
    @Test(expected = IllegalArgumentException.class)
    public void minimumFiveColumnsRequiredInMatrix() {
        int[][] values = new int[1][4];
        new MatrixTwoD(values);
    }

    /*
     * This is a test case used to check the condition of maximum ten rows to be present in the given matrix
     */
    @Test(expected = IllegalArgumentException.class)
    public void maximumTenRowsAvailableInMatrix() {
        int[][] values = new int[12][10];
        new MatrixTwoD(values);
    }

    /*
     * This is a test case used to check the condition of maximum one hundred columns to be present in the given matrix
     */
    @Test(expected = IllegalArgumentException.class)
    public void maximumHundredColumnsAvailableInMatrix() {
        int[][] values = new int[1][101];
        new MatrixTwoD(values);
    }

    /*
     * This is a test case used to check the condition of the rows and columns to be in the given limit in the given matrix
     */
    @Test
    public void ProperMatrix() {
        int[][] values = new int[7][77];
        new MatrixTwoD(values);
    }

    @Test
    public void getValueFromParticularCellInMatrix() {
        int values[][] = new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}};
        MatrixTwoD matrixTwoD = new MatrixTwoD(values);

        assertThat(matrixTwoD.getValueAtCell(1, 1), equalTo(1));
        assertThat(matrixTwoD.getValueAtCell(2, 5), equalTo(10));
    }

    @Test
    public void getRowCount() {
        MatrixTwoD threeRowGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}});
        MatrixTwoD fiveRowGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}});

        assertThat(threeRowGrid.getRowCount(), equalTo(3));
        assertThat(fiveRowGrid.getRowCount(), equalTo(5));
    }

    @Test
    public void getColumnCount() {
        MatrixTwoD fiveColumnGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}});
        MatrixTwoD tenColumnGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}});

        assertThat(fiveColumnGrid.getColumnCount(), equalTo(5));
        assertThat(tenColumnGrid.getColumnCount(), equalTo(10));

    }

    @Test
    public void getAdjacentRowsReturnsOneWhenOnlyOneRow() {
        MatrixTwoD oneRowGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        List<Integer> expectedRows = new ArrayList<>(
                Arrays.asList(new Integer[]{1})
        );

        assertThat(oneRowGrid.getRowsAdjacentTo(1), equalTo(expectedRows));
    }

    @Test
    public void getAdjacentRowsReturnsNothingWhenInvalidRowIsPassed() {
        MatrixTwoD oneRowGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        assertThat(oneRowGrid.getRowsAdjacentTo(0).size(), equalTo(0));
        assertThat(oneRowGrid.getRowsAdjacentTo(2).size(), equalTo(0));
    }

    @Test
    public void getAdjacentRowsReturnsBothOneAndTwoWhenTwoRows() {
        MatrixTwoD twoRowGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}});
        List<Integer> expectedRows = new ArrayList<>(
                Arrays.asList(new Integer[]{1, 2})
        );

        assertThat(twoRowGrid.getRowsAdjacentTo(1), equalTo(expectedRows));
        assertThat(twoRowGrid.getRowsAdjacentTo(2), equalTo(expectedRows));
    }

    @Test
    public void getAdjacentRowsReturnsOneThroughThreeWhenThreeRows() {
        MatrixTwoD threeRowGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}, {3, 6, 9, 12, 15}});
        List<Integer> expectedRows = new ArrayList<>(
                Arrays.asList(new Integer[]{1, 2, 3})
        );

        assertThat(threeRowGrid.getRowsAdjacentTo(1), equalTo(expectedRows));
        assertThat(threeRowGrid.getRowsAdjacentTo(2), equalTo(expectedRows));
        assertThat(threeRowGrid.getRowsAdjacentTo(3), equalTo(expectedRows));
    }

    @Test
    public void getAdjacentRowsReturnsNeighboringRowsWhenMoreThanThreeRows() {
        MatrixTwoD fourRowGrid = new MatrixTwoD(new int[][]{{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {4, 4, 4, 4, 4}});
        List<Integer> expectedRows = new ArrayList<>(
                Arrays.asList(new Integer[]{2, 3, 4})
        );

        assertThat(fourRowGrid.getRowsAdjacentTo(3), equalTo(expectedRows));
    }

    @Test
    public void getAdjacentRowsReturnsWrappedRowsWhenMoreThanThreeRows() {
        MatrixTwoD fourRowGrid = new MatrixTwoD(new int[][]{{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {4, 4, 4, 4, 4}});
        List<Integer> expectedRows = new ArrayList<>(
                Arrays.asList(new Integer[]{1, 2, 4})
        );

        assertThat(fourRowGrid.getRowsAdjacentTo(1), equalTo(expectedRows));
    }

    @Test
    public void asDelimitedStringOutputsValuesForARowSeparatedByChosenDelimiter() {
        MatrixTwoD oneRowGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});

        assertThat(oneRowGrid.asDelimitedString("|"), equalTo("1|2|3|4|5"));
    }

    @Test
    public void asDelimitedStringOutputsValuesForMultipleRowsWithTrailingLineBreaks() {
        MatrixTwoD twoRowGrid = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}});

        assertThat(twoRowGrid.asDelimitedString("\t"), equalTo("1\t2\t3\t4\t5\n2\t4\t6\t8\t10"));
    }
}
