package www.nithinkumar.com.pathoflowestcost;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.MatrixTwoD;
import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.MatrixVisitedPath;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This is a test suite used to check the score
 */

public class MatrixVisitedPathTest {

    private MatrixVisitedPath matrixVisitedPath;

    @Before
    public void initialSetUp() {
        matrixVisitedPath = new MatrixVisitedPath();
    }

    /*
     * This checks if the initial value of the Total cost variable which stores the cost is equivalent to zero or not
     */
    @Test
    public void initialTotalCostZero() {
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(0));
    }

    /*
     * This checks the value of the Total cost variable which stores the cost after one move in the matrix
     */
    @Test
    public void totalCostAfterOneMove() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(1));
    }

    /*
     * This checks the value of the Total cost variable which stores the cost after multiple move in the matrix
     */
    @Test
    public void totalCostAfterTwoMoves() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(3));
    }

    /*
     * This checks the value of the Total cost variable which stores the cost after moving across a row in the matrix
     */
    @Test
    public void totalCostAfterMovingThroughEntireRow() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        for (int i = 0; i < matrixTwoD.getColumnCount(); i++) {
            matrixVisitedPath.pathVisited(matrixTwoD);
        }
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(15));
    }

    @Test
    public void isAnotherVisitPossible() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.visitPossible(matrixTwoD), is(true));

        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.visitPossible(matrixTwoD), is(false));
    }

    @Test
    public void isVisitPossibleAfterTotalCostReachesFiftyOrMore() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.visitPossible(matrixTwoD), is(true));
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.visitPossible(matrixTwoD), is(false));
    }

    @Test
    public void notPossibleToTraverseWhenFirstValueExceedsLimit()
    {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{51, 2, 3, 4, 5}});
        assertThat(matrixVisitedPath.visitPossible(matrixTwoD), is(false));
    }

    @Test
    public void totalCostDoesNotAccumulatedIfFirstValueExceedsLimit()
    {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{51, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(0));

    }

    @Test
    public void totalCostDoesNotIncreaseAfterReachingFifty() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(50));

        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(50));
    }

    @Test
    public void incrementOfColumnValueNotPossible()
    {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getCurrentColumn(), equalTo(1));
    }

    @Test
    public void initialColumnAtZero() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        assertThat(matrixVisitedPath.getCurrentColumn(), equalTo(0));
    }

    @Test
    public void incrementOfColumnValueAfterVisit() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getCurrentColumn(), equalTo(1));
    }

    @Test
    public void initialPathIsEmpty() {
        assertThat(matrixVisitedPath.getPathVisited().size(), equalTo(0));
    }

    @Test
    public void rowsAdditionToPathAfterVisit() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{8, 2, 3, 4, 5}});
        List<Integer> expectedPath = new ArrayList<>();
        matrixVisitedPath.pathVisited(matrixTwoD);
        expectedPath.add(1);
        assertThat(matrixVisitedPath.getPathVisited(), equalTo(expectedPath));

        matrixVisitedPath.pathVisited(matrixTwoD);
        expectedPath.add(1);
        assertThat(matrixVisitedPath.getPathVisited(), equalTo(expectedPath));
    }

    @Test
    public void initialPathTraverseSuccess() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{2, 2, 2, 2, 2}});
        assertThat(matrixVisitedPath.isSuccessful(matrixTwoD), is(false));
    }

    @Test
    public void pathTraverseSuccess() {

        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{2, 2, 2, 2, 2}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.isSuccessful(matrixTwoD), is(true));
    }

    @Test
    public void pathTraversePartially() {
        MatrixTwoD matrixTwoD1 = new MatrixTwoD(new int[][]{{2, 2, 2, 2, 2}});
        matrixVisitedPath.pathVisited(matrixTwoD1);
        matrixVisitedPath.pathVisited(matrixTwoD1);
        matrixVisitedPath.pathVisited(matrixTwoD1);
        matrixVisitedPath.pathVisited(matrixTwoD1);
        assertThat(matrixVisitedPath.isSuccessful(matrixTwoD1), is(false));

    }

    @Test
    public void pathTraverseFailureDueTOTotalCost() {
        MatrixTwoD matrixTwoD2 = new MatrixTwoD(new int[][]{{2, 2, 2, 2, 45}});
        matrixVisitedPath.pathVisited(matrixTwoD2);
        matrixVisitedPath.pathVisited(matrixTwoD2);
        matrixVisitedPath.pathVisited(matrixTwoD2);
        matrixVisitedPath.pathVisited(matrixTwoD2);
        matrixVisitedPath.pathVisited(matrixTwoD2);
        assertThat(matrixVisitedPath.isSuccessful(matrixTwoD2), is(false));

    }

}
