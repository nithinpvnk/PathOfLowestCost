package www.nithinkumar.com.pathoflowestcost;

import org.junit.Test;

import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.MatrixTwoD;
import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.MatrixVisitedPath;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This is a test suite used to check the score
 */

public class MatrixVisitedPathTest {

    /*
     * This checks if the initial value of the score variable which stores the cost is equivalent to zero or not
     */
    @Test
    public void initialTotalCostZero() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(0));
    }

    @Test
    public void totalCostAfterOneMove() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(1));
    }

    @Test
    public void totalCostAfterTwoMoves() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(3));

    }

    @Test
    public void totalCostAfterMovingThroughEntireRow() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        for (int i = 0; i < matrixTwoD.getColumnCount(); i++) {
            matrixVisitedPath.pathVisited(matrixTwoD);
        }
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(15));
    }

    @Test
    public void isAnotherVisitPossible() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
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
    public void isVisitPossibleAfterTotalCostReachesFiftyOrMore()
    {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{ 48, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.visitPossible(matrixTwoD), is(false));

    }

    @Test
    public void totalCostDoesNotIncreaseAfterReachingFifty()
    {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{48, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(50));

        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getTotalCost(), equalTo(50));
    }


}
