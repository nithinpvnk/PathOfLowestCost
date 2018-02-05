package www.nithinkumar.com.pathoflowestcost;

import android.app.AlertDialog;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import www.nithinkumar.com.pathoflowestcost.util.Examples;
import www.nithinkumar.com.pathoflowestcost.util.InputChecks;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class PathOfLowestCostCustomFragmentTest {

    private PathOfLowestCostCustomFragment fragment;

    @Rule
    public ActivityTestRule<LowestCostPathDisplayActivity> mActivityTestRule = new ActivityTestRule<>(LowestCostPathDisplayActivity.class);

    @Before
    public void setUp() {
        fragment = new PathOfLowestCostCustomFragment();
        assertNotNull(fragment);
    }

    @Test
    public void goButtonIsDisabledByDefault() {
        Button goButton = fragment.getView().findViewById(R.id.go_button);
        assertThat(goButton.isEnabled(), is(false));
    }

    @Test
    public void enteringAnyTextIntoTheCustomGridContentsEnablesTheGoButton() {
        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);
        Button goButton = fragment.getView().findViewById(R.id.go_button);

        customGridContents.setText("a");

        assertThat(goButton.isEnabled(), is(true));
    }

    @Test
    public void removingAllTextFromTheCustomGridContentsDisablesTheGoButton() {
        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);
        Button goButton = fragment.getView().findViewById(R.id.go_button);
        customGridContents.setText("a");

        customGridContents.setText("");

        assertThat(goButton.isEnabled(), is(false));
    }

//    @Test
//    public void clickingGoWithLessThanFiveColumnsOfDataDisplaysErrorMessage() {
//        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);
//
//        customGridContents.setText("1 2 3 4");
//        fragment.getView().findViewById(R.id.go_button).performClick();
//
//        AlertDialog alertDialog = mActivityTestRule.getActivity().
//        assertThat(alertDialog.getTitle().toString(), equalTo("Invalid Grid"));
//        assertThat(alertDialog.getMessage().toString(), equalTo(fragment.getResources().getString(R.string.invalid_grid_message)));
//    }
//
//    @Test
//    public void clickingGoWithMoreThanOneHundredColumnsOfDataDisplaysErrorMessage() {
//        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);
//        StringBuilder inputBuilder = new StringBuilder();
//        for (int i = 1; i <= 101; i++) {
//            inputBuilder.append(i).append(" ");
//        }
//
//        customGridContents.setText(inputBuilder.toString());
//        fragment.getView().findViewById(R.id.go_button).performClick();
//
//        ShadowAlertDialog alertDialog = Shadows.shadowOf(ShadowAlertDialog.getLatestAlertDialog());
//        assertThat(alertDialog.getTitle().toString(), equalTo("Invalid Grid"));
//        assertThat(alertDialog.getMessage().toString(), equalTo(fragment.getResources().getString(R.string.invalid_grid_message)));
//    }
//
//    @Test
//    public void clickingGoWithNonNumericDataDisplaysErrorMessage() {
//        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);
//
//        customGridContents.setText("1 2 3 4 b");
//        fragment.getView().findViewById(R.id.go_button).performClick();
//
//        ShadowAlertDialog alertDialog = Shadows.shadowOf(ShadowAlertDialog.getLatestAlertDialog());
//        assertThat(alertDialog.getTitle().toString(), equalTo("Invalid Grid"));
//        assertThat(alertDialog.getMessage().toString(), equalTo(fragment.getResources().getString(R.string.invalid_grid_message)));
//    }

    @Test
    public void clickingGoWithValidDataLoadsTheGrid() {
        String expectedContents = Examples.EXAMPLE_GRID_3.asDelimitedString("\t");
        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);

        customGridContents.setText(expectedContents);
        fragment.getView().findViewById(R.id.go_button).performClick();

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void clickingGoWithValidDataDisplaysYesIfPathSuccessful() {
        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);

        customGridContents.setText("1 2 3 4 5");
        fragment.getView().findViewById(R.id.go_button).performClick();

        TextView resultsView = fragment.getView().findViewById(R.id.results_success);
        assertThat(resultsView.getText().toString(), equalTo("Yes"));
    }

    @Test
    public void clickingGoAfterClickingAGridButtonDisplaysNoIfPathNotSuccessful() {
        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);

        customGridContents.setText("50 2 3 4 5");
        fragment.getView().findViewById(R.id.go_button).performClick();

        TextView resultsView = fragment.getView().findViewById(R.id.results_success);
        assertThat(resultsView.getText().toString(), equalTo("No"));
    }

    @Test
    public void clickingGoAfterClickingAGridButtonDisplaysTotalCostOfPathOnSecondLineOfResults() {
        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);

        customGridContents.setText("1 2 3 4 5");
        fragment.getView().findViewById(R.id.go_button).performClick();

        TextView resultsView = fragment.getView().findViewById(R.id.results_total_cost);
        assertThat(resultsView.getText().toString(), equalTo("15"));
    }

    @Test
    public void clickingGoAfterClickingAGridButtonDisplaysPathTakenOnThirdLineOfResults() {
        EditText customGridContents = fragment.getView().findViewById(R.id.custom_grid_contents);

        customGridContents.setText("1 2 3 4 5 6\n2 1 2 2 2 2\n3 3 1 3 3 3\n4 4 4 1 1 4\n5 5 5 5 5 1\n6 6 6 6 6 6");
        fragment.getView().findViewById(R.id.go_button).performClick();

        TextView resultsView = fragment.getView().findViewById(R.id.results_path_taken);
        assertThat(resultsView.getText().toString(), equalTo("1\t2\t3\t4\t4\t5"));
    }

}

