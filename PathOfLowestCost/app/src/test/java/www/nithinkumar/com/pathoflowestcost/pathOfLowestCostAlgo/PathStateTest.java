package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.PathState;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PathStateTest {

    private PathState pathState;

    @Before
    public void setUp() {
        pathState = new PathState(2);
    }

    @Test
    public void initialZeroRowsTraverse() {
        assertThat(pathState.getRowsTraversed().size(), equalTo(0));
    }

    @Test
    public void beginsUnsuccessful() {
        assertThat(pathState.isSuccessful(), is(false));
    }

    @Test
    public void beginsWithPathLengthOfZero() {
        assertThat(pathState.getPathLength(), equalTo(0));
    }

    @Test
    public void beginsIncomplete() {
        assertThat(pathState.isComplete(), is(false));
    }

    @Test
    public void returnsRowsAdded() {
        List<Integer> expectedRows = new ArrayList<>();

        expectedRows.add(1);
        pathState.addRowWithCost(1, 0);
        assertThat(pathState.getRowsTraversed(), equalTo(expectedRows));

        expectedRows.add(10);
        pathState.addRowWithCost(10, 0);
        assertThat(pathState.getRowsTraversed(), equalTo(expectedRows));
    }

    @Test
    public void returnsCostForRowsAdded() {
        pathState.addRowWithCost(1, 2);
        assertThat(pathState.getTotalCost(), equalTo(2));

        pathState.addRowWithCost(1, 10);
        assertThat(pathState.getTotalCost(), equalTo(12));
    }

    @Test
    public void isOverCostIfCostExceedsMaximum() {
        pathState.addRowWithCost(1, PathState.MAXIMUM_COST + 1);
        assertThat(pathState.isOverCost(), is(true));
    }

    @Test
    public void isNotOverCostIfCostDoesNotExceedMaximum() {
        pathState.addRowWithCost(1, PathState.MAXIMUM_COST);
        assertThat(pathState.isOverCost(), is(false));
    }

    @Test
    public void returnsPathLengthAfterAddingRows() {
        pathState.addRowWithCost(2, 1);
        assertThat(pathState.getPathLength(), equalTo(1));

        pathState.addRowWithCost(1, 10);
        assertThat(pathState.getPathLength(), equalTo(2));
    }

    @Test
    public void isCompleteIfPathLengthMatchesGridLength() {
        pathState.addRowWithCost(2, 1);
        assertThat(pathState.isComplete(), is(false));

        pathState.addRowWithCost(1, 10);
        assertThat(pathState.isComplete(), is(true));
    }

    @Test
    public void isSuccessfulIfCompleteAndCostDoesNotExceedMaximum() {
        pathState.addRowWithCost(1, PathState.MAXIMUM_COST - 1);
        assertThat(pathState.isSuccessful(), is(false));

        pathState.addRowWithCost(2, 1);
        assertThat(pathState.isSuccessful(), is(true));
    }

    @Test
    public void isNotSuccessfulIfCompleteAndCostExceedsMaximum() {
        pathState.addRowWithCost(1, PathState.MAXIMUM_COST);
        pathState.addRowWithCost(2, 1);
        assertThat(pathState.isSuccessful(), is(false));
    }

    @Test
    public void copyConstructorMakesAnExactCopyOfPath() {
        pathState.addRowWithCost(1, 10);
        pathState.addRowWithCost(2, 10);

        List<Integer> expectedRows = new ArrayList<>();
        expectedRows.add(1);
        expectedRows.add(2);

        PathState copy = new PathState(pathState);

        assertThat(copy.getTotalCost(), equalTo(20));
        assertThat(copy.getRowsTraversed(), equalTo(expectedRows));
        assertThat(copy.isComplete(), is(true));
    }

    @Test
    public void copyConstructorMakesAnIndependentCopyOfPath() {
        pathState.addRowWithCost(1, 10);

        List<Integer> expectedRows = new ArrayList<>();
        expectedRows.add(1);

        PathState copy = new PathState(pathState);
        pathState.addRowWithCost(2, 10);

        assertThat(copy.getTotalCost(), equalTo(10));
        assertThat(copy.getRowsTraversed(), equalTo(expectedRows));
        assertThat(copy.isComplete(), is(false));
    }
}
