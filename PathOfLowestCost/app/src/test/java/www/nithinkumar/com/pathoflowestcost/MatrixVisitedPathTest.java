package www.nithinkumar.com.pathoflowestcost;

import org.junit.Test;

import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.MatrixVisitedPath;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * This is a test suite used to check the score
 */

public class MatrixVisitedPathTest {

    /*
     * This checks if the initial value of the score variable which stores the cost is equivalent to zero or not
     */
    @Test
    public void initialZeroScore()
    {
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath();
        assertThat(matrixVisitedPath.score, equalTo(0));
    }
}
