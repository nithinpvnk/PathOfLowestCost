package www.nithinkumar.com.pathoflowestcost;

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

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithoutMatrixArgument() {
        new MatrixVisitedPath(null);
    }

    /*
     * This checks if the initial value of the Total cost variable which stores the cost is equivalent to zero or not
     */
    @Test
    public void initialTotalCostZero() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(0));
    }

    /*
     * This checks the value of the Total cost variable which stores the cost after one move in the matrix
     */
    @Test
    public void totalCostAfterOneMove() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(1));
    }

    /*
     * This checks the value of the Total cost variable which stores the cost after multiple move in the matrix
     */
    @Test
    public void totalCostAfterTwoMoves() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(3));
    }

    /*
     * This checks the value of the Total cost variable which stores the cost after moving across a row in the matrix
     */
    @Test
    public void totalCostAfterMovingThroughEntireRow() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        for (int i = 0; i < matrixTwoD.getColumnCount(); i++) {
            matrixVisitedPath.pathVisited();
        }
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(15));
    }

    @Test
    public void isAnotherVisitPossible() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.visitPossible(), is(true));

        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.visitPossible(), is(false));
    }

    @Test
    public void isVisitPossibleAfterTotalCostReachesFiftyOrMore() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{MatrixVisitedPath.MAXIMUM_COST - 4, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.visitPossible(), is(true));
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.visitPossible(), is(false));
    }

    @Test
    public void notPossibleToTraverseWhenFirstValueExceedsLimit() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{MatrixVisitedPath.MAXIMUM_COST + 1, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        assertThat(matrixVisitedPath.visitPossible(), is(false));
    }

    @Test
    public void totalCostDoesNotAccumulatedIfFirstValueExceedsLimit() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{MatrixVisitedPath.MAXIMUM_COST + 1, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(0));

    }

    @Test
    public void totalCostDoesNotIncreaseAfterReachingFifty() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{MatrixVisitedPath.MAXIMUM_COST - 2, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(50));

        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(50));
    }

    @Test
    public void incrementOfColumnValueNotPossible() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{MatrixVisitedPath.MAXIMUM_COST, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.getCurrentColumn(), equalTo(1));
    }

    @Test
    public void initialColumnAtZero() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        assertThat(matrixVisitedPath.getCurrentColumn(), equalTo(0));
    }

    @Test
    public void incrementOfColumnValueAfterVisit() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.getCurrentColumn(), equalTo(1));
    }

    @Test
    public void initialPathIsEmpty() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        assertThat(matrixVisitedPath.getPathVisited().size(), equalTo(0));
    }

    @Test
    public void rowsAdditionToPathAfterVisit() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{8, 2, 3, 4, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        List<Integer> expectedPath = new ArrayList<>();
        matrixVisitedPath.pathVisited();
        expectedPath.add(1);
        assertThat(matrixVisitedPath.getPathVisited(), equalTo(expectedPath));

        matrixVisitedPath.pathVisited();
        expectedPath.add(1);
        assertThat(matrixVisitedPath.getPathVisited(), equalTo(expectedPath));
    }

    @Test
    public void initialPathTraverseSuccess() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{2, 2, 2, 2, 2}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        assertThat(matrixVisitedPath.isSuccessful(), is(false));
    }

    @Test
    public void pathTraverseSuccess() {

        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{2, 2, 2, 2, 2}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.isSuccessful(), is(true));
    }

    @Test
    public void pathTraversePartially() {
        MatrixTwoD matrixTwoD1 = new MatrixTwoD(new int[][]{{2, 2, 2, 2, 2}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD1);
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.isSuccessful(), is(false));

    }

    @Test
    public void pathTraverseFailureDueTOTotalCost() {
        MatrixTwoD matrixTwoD2 = new MatrixTwoD(new int[][]{{2, 2, 2, 2, 45}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD2);
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        matrixVisitedPath.pathVisited();
        assertThat(matrixVisitedPath.isSuccessful(), is(false));

    }

}
