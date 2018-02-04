package www.nithinkumar.com.pathoflowestcost;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class PathOptionsPagerAdapterTest {

    private PathOptionsPagerAdapter pagerAdapter;


    @Rule
    public ActivityTestRule<LowestCostPathDisplayActivity> mActivityTestRule = new ActivityTestRule<>(LowestCostPathDisplayActivity.class);

    @Before
    public void setUp() {

        FragmentManager fragmentManager = mActivityTestRule.getActivity().getSupportFragmentManager();
         pagerAdapter = new PathOptionsPagerAdapter(fragmentManager);
    }

    @Test
    public void adapterHasTwoItems() {
        assertThat(pagerAdapter.getCount(), equalTo(2));
    }

    @Test
    public void firstItemOfTheAdapterIsTheExamplesFragment() {
        assertThat(pagerAdapter.getItem(0), instanceOf(PathOfLowestCostExamplesFragment.class));
    }

    @Test
    public void secondItemOfTheAdapterIsTheCustomFragment() {
        assertThat(pagerAdapter.getItem(1), instanceOf(PathOfLowestCostCustomFragment.class));
    }

    @Test
    public void otherItemsOfTheAdapterAreNull() {
        assertThat(pagerAdapter.getItem(2), nullValue());
    }

    @Test
    public void pageTitleOfTheFirstItemIsExampleGrids() {
        assertThat(pagerAdapter.getPageTitle(0).toString(), equalTo("Example Grids"));
    }

    @Test
    public void pageTitleOfTheSecondItemIsExampleGrids() {
        assertThat(pagerAdapter.getPageTitle(1).toString(), equalTo("Custom Grid"));
    }

    @Test
    public void pageTitleOfOtherItemsIsExampleGrids() {
        assertThat(pagerAdapter.getPageTitle(2), nullValue());
    }
}
