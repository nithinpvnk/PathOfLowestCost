package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This is a test suite used to check the score
 */

public class MatrixVisitedPathTest {

    @Test(expected = IllegalArgumentException.class)
    public void cannotBeConstructedWithoutAGrid() {
        new MatrixVisitedPath(null);
    }

    @Test
    public void getBestPathForAllRowsReturnsLongerPathsAheadOfShorterPathsWithLowerCost() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{
                {2, 1, PathState.MAXIMUM_COST, PathState.MAXIMUM_COST, 1},
                {1, 10, 10, PathState.MAXIMUM_COST, 5}});
        MatrixVisitedPath matrixVisitedPath = new MatrixVisitedPath(matrixTwoD);
        List<Integer> expectedPath = new ArrayList<>(
                Arrays.asList(new Integer[]{2, 1, 2})
        );

        PathState result = matrixVisitedPath.getBestPathForGrid();

        assertThat(result.getTotalCost(), equalTo(12));
        assertThat(result.getRowsTraversed(), equalTo(expectedPath));
    }

    @Test
    public void findsPathThroughExampleOne() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        });
        MatrixVisitedPath visitor = new MatrixVisitedPath(matrixTwoD);
        List<Integer> expectedPath = new ArrayList<>(
                Arrays.asList(new Integer[]{1, 2, 3, 4, 4, 5})
        );

        PathState solution = visitor.getBestPathForGrid();
        assertThat(solution.isSuccessful(), is(true));
        assertThat(solution.getTotalCost(), equalTo(16));
        assertThat(solution.getRowsTraversed(), equalTo(expectedPath));
    }

    @Test
    public void findsPathThroughExampleTwo() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 1, 2, 3}
        });
        MatrixVisitedPath visitor = new MatrixVisitedPath(matrixTwoD);
        List<Integer> expectedPath = new ArrayList<>(
                Arrays.asList(new Integer[]{1, 2, 1, 5, 4, 5})
        );

        PathState solution = visitor.getBestPathForGrid();
        assertThat(solution.isSuccessful(), is(true));
        assertThat(solution.getTotalCost(), equalTo(11));
        assertThat(solution.getRowsTraversed(), equalTo(expectedPath));
    }

    @Test
    public void findsIncompletePathThroughExampleThree() {
        MatrixTwoD matrixTwoD = new MatrixTwoD(new int[][]{
                {19, 10, 19, 10, 19},
                {21, 23, 20, 19, 12},
                {20, 12, 20, 11, 10}
        });
        MatrixVisitedPath visitor = new MatrixVisitedPath(matrixTwoD);
        List<Integer> expectedPath = new ArrayList<>(
                Arrays.asList(new Integer[]{1, 1, 1})
        );

        PathState solution = visitor.getBestPathForGrid();
        assertThat(solution.isSuccessful(), is(false));
        assertThat(solution.getTotalCost(), equalTo(48));
        assertThat(solution.getRowsTraversed(), equalTo(expectedPath));
    }

    @Test
    public void findsPathThroughMaximumGrid() {
        int[][] gridArray = new int[10][100];
        for (int row = 0; row < gridArray.length; row++) {
            for (int column = 0; column < gridArray[0].length; column++) {
                if (row == 5 && column % 2 == 0) {
                    gridArray[row][column] = 1;
                } else if (row == 5) {
                    gridArray[row][column] = 0;
                } else {
                    gridArray[row][column] = 25;
                }
            }
        }
        Integer[] expectedPathArray = new Integer[100];
        for (int row = 0; row < expectedPathArray.length; row++) {
            expectedPathArray[row] = 6;
        }

        MatrixTwoD matrixTwoD = new MatrixTwoD(gridArray);
        MatrixVisitedPath visitor = new MatrixVisitedPath(matrixTwoD);
        List<Integer> expectedPath = new ArrayList<>(Arrays.asList(expectedPathArray));

        PathState solution = visitor.getBestPathForGrid();
        assertThat(solution.isSuccessful(), is(true));
        assertThat(solution.getTotalCost(), equalTo(50));
        assertThat(solution.getRowsTraversed(), equalTo(expectedPath));
    }

    @Test
    public void findsPathThroughGridGeneratingManyPaths() throws Exception {
        int[][] gridArray = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        MatrixTwoD matrixTwoD = new MatrixTwoD(gridArray);
        MatrixVisitedPath visitor = new MatrixVisitedPath(matrixTwoD);

        PathState solution = visitor.getBestPathForGrid();
        assertThat(solution.isSuccessful(), is(true));
        assertThat(solution.getTotalCost(), equalTo(1));
    }
}


