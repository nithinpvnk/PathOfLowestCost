package www.nithinkumar.com.pathoflowestcost;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import www.nithinkumar.com.pathoflowestcost.util.Examples;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class PathOfLowestCostExamplesFragmentTest {

    private PathOfLowestCostExamplesFragment fragment;

    @Rule
    public ActivityTestRule<LowestCostPathDisplayActivity> mActivityTestRule = new ActivityTestRule<>(LowestCostPathDisplayActivity.class);

    @Before
    public void setUp() {
        fragment = new PathOfLowestCostExamplesFragment();
        assertNotNull(fragment);
    }

    @Test
    public void clickingExampleOneButtonLoadsExampleGridOne() {
        String expectedContents = Examples.EXAMPLE_GRID_1.asDelimitedString("\t");
        onView(withId(R.id.grid_1_button)).perform(click());

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void clickingExampleOneButtonLoadsExampleGridTwo() {
        String expectedContents = Examples.EXAMPLE_GRID_1.asDelimitedString("\t");
        onView(withId(R.id.grid_1_button)).perform(click());

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void clickingExampleOneButtonLoadsExampleGridThree() {
        String expectedContents = Examples.EXAMPLE_GRID_1.asDelimitedString("\t");
        onView(withId(R.id.grid_1_button)).perform(click());

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void clickingExampleOneButtonLoadsExampleGridFour() {
        String expectedContents = Examples.EXAMPLE_GRID_1.asDelimitedString("\t");
        onView(withId(R.id.grid_1_button)).perform(click());

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void clickingExampleOneButtonLoadsExampleGridFive() {
        String expectedContents = Examples.EXAMPLE_GRID_1.asDelimitedString("\t");
        onView(withId(R.id.grid_1_button)).perform(click());

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void clickingExampleOneButtonLoadsExampleGridSix() {
        String expectedContents = Examples.EXAMPLE_GRID_1.asDelimitedString("\t");
        onView(withId(R.id.grid_1_button)).perform(click());

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void clickingExampleOneButtonLoadsExampleGridSeven() {
        String expectedContents = Examples.EXAMPLE_GRID_1.asDelimitedString("\t");
        onView(withId(R.id.grid_1_button)).perform(click());

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void clickingExampleOneButtonLoadsExampleGridEight() {
        String expectedContents = Examples.EXAMPLE_GRID_1.asDelimitedString("\t");
        onView(withId(R.id.grid_1_button)).perform(click());

        onView(withId(R.id.grid_contents)).check(matches(withText(expectedContents)));
    }

    @Test
    public void goButtonIsDisabledByDefault() {
        Button goButton = fragment.getView().findViewById(R.id.go_button);
        assertThat(goButton.isEnabled(), is(false));
    }

    @Test
    public void clickingAnyExampleGridButtonEnablesGoButton() {

        onView(withId(R.id.grid_3_button)).perform(click());
        onView(withId(R.id.go_button)).perform(click());

        onView(withId(R.id.results_success)).check(matches(withText("No")));
        Button goButton = fragment.getView().findViewById(R.id.go_button);

        fragment.getView().findViewById(R.id.grid_1_button).performClick();
        assertThat(goButton.isEnabled(), is(true));
        goButton.setEnabled(false);

        fragment.getView().findViewById(R.id.grid_2_button).performClick();
        assertThat(goButton.isEnabled(), is(true));
        goButton.setEnabled(false);

        fragment.getView().findViewById(R.id.grid_3_button).performClick();
        assertThat(goButton.isEnabled(), is(true));
    }

    @Test
    public void clickingGoAfterClickingAGridButtonDisplaysYesIfPathSuccessful() {
        onView(withId(R.id.grid_1_button)).perform(click());
        onView(withId(R.id.go_button)).perform(click());

        onView(withId(R.id.results_success)).check(matches(withText("Yes")));
    }

    @Test
    public void clickingGoAfterClickingAGridButtonDisplaysNoIfPathNotSuccessful() {
        onView(withId(R.id.grid_3_button)).perform(click());
        onView(withId(R.id.go_button)).perform(click());

        onView(withId(R.id.results_success)).check(matches(withText("No")));
    }

    @Test
    public void clickingGoAfterClickingAGridButtonDisplaysTotalCostOfPathOnSecondLineOfResults() {
        onView(withId(R.id.grid_2_button)).perform(click());
        onView(withId(R.id.go_button)).perform(click());

        onView(withId(R.id.results_total_cost)).check(matches(withText("11")));
    }

    @Test
    public void clickingGoAfterClickingAGridButtonDisplaysPathTakenOnThirdLineOfResults() {
        onView(withId(R.id.grid_1_button)).perform(click());
        onView(withId(R.id.go_button)).perform(click());

        onView(withId(R.id.results_path_taken)).check(matches(withText("1\t2\t3\t4\t4\t5")));
    }

    @Test
    public void selectingADifferentGridClearsResults() {

        onView(withId(R.id.grid_1_button)).perform(click());
        onView(withId(R.id.go_button)).perform(click());
        onView(withId(R.id.grid_2_button)).perform(click());
        onView(withId(R.id.results_success)).check(matches(withText("")));
        onView(withId(R.id.results_total_cost)).check(matches(withText("No Results")));
        onView(withId(R.id.results_path_taken)).check(matches(withText("")));

    }

//    @Test
//    public void selectingTheSameGridDoesNotClearResults() {
//        onView(withId(R.id.grid_1_button)).perform(click());
//        onView(withId(R.id.go_button)).perform(click());
//        onView(withId(R.id.grid_1_button)).perform(click());
//        assertThat(onView(withId(R.id.results_success)).check(matches(withText("")));
//        onView(withId(R.id.results_total_cost)).check(matches(withText("No Results")));
//        onView(withId(R.id.results_path_taken)).check(matches(withText("")));
//    }

}

