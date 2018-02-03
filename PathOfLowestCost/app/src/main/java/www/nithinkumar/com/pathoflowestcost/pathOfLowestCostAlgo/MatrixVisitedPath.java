package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;


public class MatrixVisitedPath {

    //Variable to hold the cost of the path
    private int totalCost;
    private int currentColumn = 0;

    //Getter method to retrieve that score
    public int getTotalCost() {
        return totalCost;
    }

    public int getCurrentColumn()
    {
        return currentColumn;
    }

    public void pathVisited(MatrixTwoD matrixTwoD) {
        int currentRow = 1;
        if (visitPossible(matrixTwoD)) {
            currentColumn++;
            totalCost += matrixTwoD.getValueAtCell(currentRow, currentColumn);
        }
    }

    public boolean visitPossible(MatrixTwoD matrixTwoD) {
        return ((currentColumn < matrixTwoD.getColumnCount()) && (totalCost < 50));
    }
}
