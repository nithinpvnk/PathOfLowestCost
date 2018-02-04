package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;

import java.util.ArrayList;
import java.util.List;

public class PathState {

    public static int MAXIMUM_COST = 50;

    private List<Integer> rowsTraversed = new ArrayList<>();
    private int totalCost = 0;
    private int expectedLength = 0;

    public PathState(int expectedLength) {
        this.expectedLength = expectedLength;
    }

    public PathState(PathState anotherPathState) {
        this.totalCost = anotherPathState.totalCost;
        this.expectedLength = anotherPathState.expectedLength;
        this.rowsTraversed.addAll(anotherPathState.rowsTraversed);
    }

    public List<Integer> getRowsTraversed() {
        return rowsTraversed;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getPathLength() {
        return rowsTraversed.size();
    }

    public void addRowWithCost(int row, int cost) {
        rowsTraversed.add(row);
        totalCost += cost;
    }

    public boolean isComplete() {
        return rowsTraversed.size() == expectedLength;
    }

    public boolean isSuccessful() {
        return isComplete() && !isOverCost();
    }

    public boolean isOverCost() {
        return totalCost > MAXIMUM_COST;
    }
}
