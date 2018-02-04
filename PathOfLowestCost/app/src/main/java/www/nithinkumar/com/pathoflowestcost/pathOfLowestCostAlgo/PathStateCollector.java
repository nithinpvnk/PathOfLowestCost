package www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo;

class PathStateCollector {
    private PathState bestPath;
    private PathStateComparator comparator;

    PathStateCollector() {
        comparator = new PathStateComparator();
    }

    PathState getBestPath() {
        return bestPath;
    }

    void addPath(PathState newPath) {
         if (comparator.compare(newPath, bestPath) < 0) {
            bestPath = newPath;
        }
    }
}
