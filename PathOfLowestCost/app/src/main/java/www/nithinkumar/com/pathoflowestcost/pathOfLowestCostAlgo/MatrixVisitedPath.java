package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MatrixVisitedPath {

    //Variable to hold the cost of the path
    private MatrixTwoD matrixTwoD;
    private PathStateComparator pathComparator;

    MatrixVisitedPath(MatrixTwoD matrixTwoD) {
        if (matrixTwoD == null) {
            throw new IllegalArgumentException("A matrix is required to find the visited path");
        }

        this.matrixTwoD = matrixTwoD;
        this.pathComparator = new PathStateComparator();
    }


    PathState getBestPathForGrid() {
        List<PathState> allPaths = new ArrayList<>();
        for (int row = 1; row <= matrixTwoD.getRowCount(); row++) {
            RowVisitor visitor = new RowVisitor(row, matrixTwoD, new PathStateCollector());
            allPaths.add(visitor.getBestPathForRow());
        }

        Collections.sort(allPaths, pathComparator);

        return allPaths.get(0);
    }
}
