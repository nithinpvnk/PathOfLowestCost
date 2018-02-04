package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;

import java.util.ArrayList;
import java.util.List;

public class PathState {

    public static int MAXIMUM_COST = 50;
    public boolean successful = false;
    private List<Integer> rowsTraversed = new ArrayList<Integer>();
    private int totalCost = 0;

    public PathState(PathState pathState) {
    }

    public PathState(int expectedLength) {
    }

    public List<Integer> getRowsTraversed() {
        return rowsTraversed;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void addRow(int row, int cost) {
        rowsTraversed.add(row);
        totalCost += cost;
    }

    public int getPathLength() {
    }

    public boolean isComplete() {
    }

    public boolean isSuccessful() {
    }

    public void addRowWithCost(int row, int cost) {
    }

    public boolean isOverCost() {
    }
}
