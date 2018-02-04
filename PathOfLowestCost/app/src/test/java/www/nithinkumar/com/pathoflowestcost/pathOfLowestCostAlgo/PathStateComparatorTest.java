package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PathStateComparatorTest {
    private PathStateComparator pathStateComparator;

    private PathState lowerCostPath;
    private PathState higherCostPath;

    private PathState shorterPath;
    private PathState longerPath;

    @Before
    public void setUp() {
        pathStateComparator = new PathStateComparator();

        lowerCostPath = new PathState(1);
        lowerCostPath.addRowWithCost(1, 1);

        higherCostPath = new PathState(1);
        higherCostPath.addRowWithCost(1, 10);

        shorterPath = new PathState(3);
        shorterPath.addRowWithCost(1, 9);

        longerPath = new PathState(3);
        longerPath.addRowWithCost(1, 5);
        longerPath.addRowWithCost(1, 5);
    }

    @Test
    public void returnsNegativeOneIfFirstPathIsLongerThanSecond() {
        assertThat(pathStateComparator.compare(longerPath, shorterPath), equalTo(-1));
    }

    @Test
    public void returnsPositiveOneIfFirstPathIsShorterThanSecond() {
        assertThat(pathStateComparator.compare(shorterPath, longerPath), equalTo(1));
    }

    @Test
    public void returnsZeroIfPathsHaveSameLengthAndCost() {
        assertThat(pathStateComparator.compare(shorterPath, shorterPath), equalTo(0));
    }

    @Test
    public void returnsNegativeOneIfFirstPathHasLowerCostThanSecondWithTheSameLength() {
        assertThat(pathStateComparator.compare(lowerCostPath, higherCostPath), equalTo(-1));
    }

    @Test
    public void returnsPositiveOneIfFirstPathHasLowerCostThanSecondWithTheSameLength() {
        assertThat(pathStateComparator.compare(higherCostPath, lowerCostPath), equalTo(1));
    }

    @Test
    public void returnsPositiveOneIfFirstPathIsNull() {
        assertThat(pathStateComparator.compare(null, lowerCostPath), equalTo(1));
    }

    @Test
    public void returnsNegativeOneIfLastPathIsNull() {
        assertThat(pathStateComparator.compare(lowerCostPath, null), equalTo(-1));
    }

    @Test
    public void returnsZeroIfBothPathsAreNull() {
        assertThat(pathStateComparator.compare(null, null), equalTo(0));
    }
}
