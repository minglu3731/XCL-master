package bishe.xcl.com.xcl.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bishe.xcl.com.xcl.fragment.FirstFragment;
import bishe.xcl.com.xcl.fragment.SecondFragment;

/**
 * Project : XCL
 * Package : bishe.xcl.com.xcl.adapter
 * Update by on .
 * Mail : .
 */
public class MainAdapter extends FragmentPagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new FirstFragment();
        }
        return new SecondFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
