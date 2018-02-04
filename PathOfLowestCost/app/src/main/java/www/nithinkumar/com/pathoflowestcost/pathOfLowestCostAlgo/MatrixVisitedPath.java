package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;


import java.util.ArrayList;
import java.util.List;

public class MatrixVisitedPath {

    public static int MAXIMUM_COST = 50;

    //Variable to hold the cost of the path
    private int totalCost;
    private int currentColumn;
    private List<Integer> pathVisited;
    private MatrixTwoD matrixTwoD;
    private PathState pathState;

    public MatrixVisitedPath(MatrixTwoD matrixTwoD) {
        if (matrixTwoD == null) {
            throw new IllegalArgumentException("A matrix is required to find the visited path");
        }

        this.matrixTwoD = matrixTwoD;
        this.pathVisited = new ArrayList<>();
        this.pathState = new PathState(2);
    }


    //Getter method to retrieve that score
    public int getTotalCost() {
        return totalCost;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public List<Integer> getPathVisited() {
        return pathVisited;
    }

    public PathState getPathState() {
        return pathState;
    }

    public void pathVisited() {
        int currentRow = 1;
        if (visitPossible()) {
            currentColumn++;
            totalCost += matrixTwoD.getValueAtCell(currentRow, currentColumn);
            pathVisited.add(1);
            pathState.addRowWithCost(1, matrixTwoD.getValueAtCell(currentRow, currentColumn));
         //   pathState.isSuccessful() = isSuccessful();
        }
    }

    public boolean visitPossible() {
        return ((currentColumn < matrixTwoD.getColumnCount()) && (!nextVisitPossible()));
    }


    public boolean isSuccessful() {
        return (pathVisited.size() == matrixTwoD.getColumnCount()) && (totalCost < MAXIMUM_COST);
    }

    private boolean nextVisitPossible() {
        return (totalCost + matrixTwoD.getValueAtCell(1, currentColumn + 1)) > MAXIMUM_COST;
    }
}
