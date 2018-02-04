package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;


import java.util.List;

class RowVisitor {

    private int row;
    private MatrixTwoD matrixTwoD;
    private PathStateCollector pathCollector;

    RowVisitor(int startRow, MatrixTwoD matrixTwoD, PathStateCollector collector) {
        if (matrixTwoD == null) {
            throw new IllegalArgumentException("A visitor requires a grid");
        } else if (collector == null) {
            throw new IllegalArgumentException("A visitor requires a collector");
        } else if (startRow <= 0 || startRow > matrixTwoD.getRowCount()) {
            throw new IllegalArgumentException("Cannot visit a row outside of grid boundaries");
        }

        this.row = startRow;
        this.matrixTwoD = matrixTwoD;
        this.pathCollector = collector;
    }

    PathState getBestPathForRow() {
        PathState initialPath = new PathState(matrixTwoD.getColumnCount());

        visitPathsForRow(row, initialPath);

        return pathCollector.getBestPath();
    }

    private void visitPathsForRow(int row, PathState path) {
        if (canVisitRowOnPath(row, path)) {
            visitRowOnPath(row, path);
        }

        List<Integer> adjacentRows = matrixTwoD.getRowsAdjacentTo(row);
        boolean currentPathAdded = false;

        for (int adjacentRow : adjacentRows) {
            if (canVisitRowOnPath(adjacentRow, path)) {
                PathState pathCopy = new PathState(path);
                visitPathsForRow(adjacentRow, pathCopy);
            } else if (!currentPathAdded) {
                pathCollector.addPath(path);
                currentPathAdded = true;
            }
        }
    }

    private boolean canVisitRowOnPath(int row, PathState path) {
        return !path.isComplete() && !nextVisitOnPathWouldExceedMaximumCost(row, path);
    }

    private void visitRowOnPath(int row, PathState path) {
        int columnToVisit = path.getPathLength() + 1;
        path.addRowWithCost(row, matrixTwoD.getValueAtCell(row, columnToVisit));
    }

    private boolean nextVisitOnPathWouldExceedMaximumCost(int row, PathState path) {
        int nextColumn = path.getPathLength() + 1;
        return (path.getTotalCost() + matrixTwoD.getValueAtCell(row, nextColumn)) > PathState.MAXIMUM_COST;
    }
}
