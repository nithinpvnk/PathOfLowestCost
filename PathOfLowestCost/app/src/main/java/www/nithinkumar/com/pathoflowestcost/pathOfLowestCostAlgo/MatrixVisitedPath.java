package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;


import java.util.ArrayList;
import java.util.List;

public class MatrixVisitedPath {

    //Variable to hold the cost of the path
    private int totalCost;
    private int currentColumn;
    private List<Integer> pathVisited = new ArrayList<>();


    //Getter method to retrieve that score
    public int getTotalCost() {
        return totalCost;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void pathVisited(MatrixTwoD matrixTwoD) {
        int currentRow = 1;
        if (visitPossible(matrixTwoD)) {
            currentColumn++;
            totalCost += matrixTwoD.getValueAtCell(currentRow, currentColumn);
            pathVisited.add(1);
        }
    }

    public boolean visitPossible(MatrixTwoD matrixTwoD) {
        return ((currentColumn < matrixTwoD.getColumnCount()) && (totalCost < 50));
    }

    public List<Integer> getPathVisited() {
        return pathVisited;
    }

    public boolean isSuccessful(MatrixTwoD matrixTwoD) {
        return (pathVisited.size() == matrixTwoD.getColumnCount()) && (totalCost < 50);
    }
}
