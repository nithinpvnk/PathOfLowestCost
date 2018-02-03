package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;


public class MatrixVisitedPath {

    //Variable to hold the cost of the path
    private int score;
    int currentRow = 1;
    int currentColumn = 1;

    //Getter method to retrieve that score
    public int getScore() {
        return score;
    }

    public void pathVisited(MatrixTwoD matrixTwoD)
    {
        score += matrixTwoD.getValueAtCell(currentRow, currentColumn);
        currentColumn++;
    }
}
