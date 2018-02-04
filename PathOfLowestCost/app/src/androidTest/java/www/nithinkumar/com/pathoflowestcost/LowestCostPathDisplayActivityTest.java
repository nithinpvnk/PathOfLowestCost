package www.nithinkumar.com.pathoflowestcost;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class LowestCostPathDisplayActivityTest {

    @Rule
    public ActivityTestRule<LowestCostPathDisplayActivity> mActivityTestRule = new ActivityTestRule<>(LowestCostPathDisplayActivity.class);

    @Test
    public void viewPagerIsConfiguredWithAPathOptionsPagerAdapter() {
        PagerAdapter pagerAdapter = ((ViewPager) mActivityTestRule.getActivity().findViewById(R.id.container)).getAdapter();
        assertThat(pagerAdapter, instanceOf(PathOptionsPagerAdapter.class));
    }

    @Test
    public void tabLayoutIsConfiguredAndStartsAtTheZerothTab() {
        TabLayout tabLayout = (mActivityTestRule.getActivity().findViewById(R.id.tabs));
        assertThat(tabLayout.getSelectedTabPosition(), equalTo(0));
    }

}
