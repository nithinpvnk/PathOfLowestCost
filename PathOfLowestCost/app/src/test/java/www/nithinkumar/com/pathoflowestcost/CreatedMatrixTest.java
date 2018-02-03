package www.nithinkumar.com.pathoflowestcost;

import org.junit.Test;

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
        MatrixTwoD matrixTwoD = new MatrixTwoD(values);
    }

    /*
     * This is a test case used to check the condition of minimum five column to be present in the given matrix
     */
    @Test(expected = IllegalArgumentException.class)
    public void minimumFiveColumnsRequiredInMatrix() {
        int[][] values = new int[1][4];
        MatrixTwoD matrixTwoD = new MatrixTwoD(values);
    }

    /*
     * This is a test case used to check the condition of maximum ten rows to be present in the given matrix
     */
    @Test(expected = IllegalArgumentException.class)
    public void maximumTenRowsAvailableInMatrix() {

        int[][] values = new int[12][10];
        MatrixTwoD matrixTwoD = new MatrixTwoD(values);
    }

    /*
     * This is a test case used to check the condition of maximum one hundred columns to be present in the given matrix
     */
    @Test(expected = IllegalArgumentException.class)
    public void maximumHundredColumsAvailableInMatrix() {
        int[][] values = new int[1][101];
        MatrixTwoD matrixTwoD = new MatrixTwoD(values);
    }

    /*
     * This is a test case used to check the condition of the rows and columns to be in the given limit in the given matrix
     */
    @Test
    public void ProperMatrix() {
        int[][] values = new int[7][77];
        MatrixTwoD matrixTwoD = new MatrixTwoD(values);
    }

    @Test
    public void getValueFromParticularCellInMatrix()
    {
        int values[][] = new int[][]{ { 1, 3, 5, 7, 9 },{ 2, 4, 6, 8, 10} };
        MatrixTwoD matrixTwoD = new MatrixTwoD(values);

        assertThat(matrixTwoD.getValueAtCell(1,1), equalTo(1));
        assertThat(matrixTwoD.getValueAtCell(2,5), equalTo(10));
    }

    @Test
    public void getRowCount()
    {
        MatrixTwoD threeRowGrid = new MatrixTwoD(new int[][]{ { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 } });
        MatrixTwoD fiveRowGrid = new MatrixTwoD(new int[][]{ { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 } });

        assertThat(threeRowGrid.getRowCount(), equalTo(3));
        assertThat(fiveRowGrid.getRowCount(), equalTo(5));
    }

    @Test
    public void getColumnCount()
    {
        MatrixTwoD fiveColumnGrid = new MatrixTwoD(new int[][]{ { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 } });
        MatrixTwoD tenColumnGrid = new MatrixTwoD(new int[][]{ { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } });

        assertThat(fiveColumnGrid.getColumnCount(), equalTo(5));
        assertThat(tenColumnGrid.getColumnCount(), equalTo(10));

    }
}
