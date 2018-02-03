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
    public void initialZeroScore() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        assertThat(matrixVisitedPath.getScore(), equalTo(0));
    }

    @Test
    public void scoreAfterOneMove() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getScore(), equalTo(1));
    }

    @Test
    public void scoreAfterTwoMoves() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        matrixVisitedPath.pathVisited(matrixTwoD);
        matrixVisitedPath.pathVisited(matrixTwoD);
        assertThat(matrixVisitedPath.getScore(), equalTo(3));

    }

    @Test
    public void scoreAfterMovingThroughEntireRow() {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{{1, 2, 3, 4, 5}});
        for (int i = 0; i < matrixTwoD.getColumnCount(); i++) {
            matrixVisitedPath.pathVisited(matrixTwoD);
        }
        assertThat(matrixVisitedPath.getScore(), equalTo(15));
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


}
