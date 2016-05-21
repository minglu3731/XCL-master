package bishe.xcl.com.xcl.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bishe.xcl.com.xcl.fragment.InfomationFragment;

public class InfomationAdapter extends FragmentPagerAdapter {

    private int[] list;

    public InfomationAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.length;
    }

    public void setList(int[] list) {
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return new InfomationFragment(list[position]);
    }
}
