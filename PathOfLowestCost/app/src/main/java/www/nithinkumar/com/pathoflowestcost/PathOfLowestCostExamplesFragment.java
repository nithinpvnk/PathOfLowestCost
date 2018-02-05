package www.nithinkumar.com.pathoflowestcost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.MatrixTwoD;
import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.MatrixVisitedPath;
import www.nithinkumar.com.pathoflowestcost.pathOfLowestCostAlgo.PathState;
import www.nithinkumar.com.pathoflowestcost.util.Examples;


public class PathOfLowestCostExamplesFragment extends Fragment {
    private MatrixTwoD matrixTwoD;

    public PathOfLowestCostExamplesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_path_of_lowest_cost_examples, container, false);

        Button gridOneButton =  fragmentView.findViewById(R.id.grid_1_button);
        gridOneButton.setOnClickListener(new GridOnClickListener());

        Button gridTwoButton =  fragmentView.findViewById(R.id.grid_2_button);
        gridTwoButton.setOnClickListener(new GridOnClickListener());

        Button gridThreeButton =  fragmentView.findViewById(R.id.grid_3_button);
        gridThreeButton.setOnClickListener(new GridOnClickListener());

        Button gridFourButton =  fragmentView.findViewById(R.id.grid_4_button);
        gridFourButton.setOnClickListener(new GridOnClickListener());

        Button gridFiveButton =  fragmentView.findViewById(R.id.grid_5_button);
        gridFiveButton.setOnClickListener(new GridOnClickListener());

        Button gridSixButton =  fragmentView.findViewById(R.id.grid_6_button);
        gridSixButton.setOnClickListener(new GridOnClickListener());

        Button gridSevenButton =  fragmentView.findViewById(R.id.grid_7_button);
        gridSevenButton.setOnClickListener(new GridOnClickListener());

        Button gridEightButton =  fragmentView.findViewById(R.id.grid_8_button);
        gridEightButton.setOnClickListener(new GridOnClickListener());

        Button goButton =  fragmentView.findViewById(R.id.go_button);
        goButton.setOnClickListener(new GoOnClickListener());

        return fragmentView;
    }

    private MatrixTwoD getGridForButton(View view) {
        switch (view.getId()) {
            case R.id.grid_1_button:
                return Examples.EXAMPLE_GRID_1;
            case R.id.grid_2_button:
                return Examples.EXAMPLE_GRID_2;
            case R.id.grid_3_button:
                return Examples.EXAMPLE_GRID_3;
            case R.id.grid_4_button:
                return Examples.EXAMPLE_GRID_4;
            case R.id.grid_5_button:
                return Examples.EXAMPLE_GRID_5;
            case R.id.grid_6_button:
                return Examples.EXAMPLE_GRID_6;
            case R.id.grid_7_button:
                return Examples.EXAMPLE_GRID_7;
            case R.id.grid_8_button:
                return Examples.EXAMPLE_GRID_8;
            default:
                return null;
        }
    }

    private void clearResults() {
        ((TextView) getView().findViewById(R.id.results_success)).setText("");
        ((TextView) getView().findViewById(R.id.results_total_cost)).setText(getResources().getText(R.string.no_results));
        ((TextView) getView().findViewById(R.id.results_path_taken)).setText("");
    }

    private String formatPath(PathState path) {
        StringBuilder builder = new StringBuilder();
        List<Integer> rows = path.getRowsTraversed();

        for (int i = 0; i < rows.size(); i++) {
            builder.append(rows.get(i));
            if (i < rows.size() - 1) {
                builder.append("\t");
            }
        }

        return builder.toString();
    }

    class GridOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            MatrixTwoD selectedGrid = getGridForButton(view);
            if (!selectedGrid.equals(matrixTwoD)) {
                clearResults();
            }

            matrixTwoD = selectedGrid;
            ((TextView) getView().findViewById(R.id.grid_contents)).setText(matrixTwoD.asDelimitedString("\t"));
            getView().findViewById(R.id.go_button).setEnabled(true);
        }
    }

    class GoOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            MatrixVisitedPath visitor = new MatrixVisitedPath(matrixTwoD);
            PathState bestPath = visitor.getBestPathForGrid();

            if (bestPath.isSuccessful()) {
                ((TextView) getView().findViewById(R.id.results_success)).setText("Yes");
            } else {
                ((TextView) getView().findViewById(R.id.results_success)).setText("No");
            }
            ((TextView) getView().findViewById(R.id.results_total_cost)).setText(Integer.toString(bestPath.getTotalCost()));
            ((TextView) getView().findViewById(R.id.results_path_taken)).setText(formatPath(bestPath));
        }
    }

}
