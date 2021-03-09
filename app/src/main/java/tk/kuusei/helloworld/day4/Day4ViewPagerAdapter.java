package tk.kuusei.helloworld.day4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

public class Day4ViewPagerAdapter extends FragmentPagerAdapter {

    private Map<Integer, Fragment> data;

    public Day4ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        data = new HashMap<>();
        data.put(0, new Day4Fragment1());
        data.put(1, new Day4Fragment2());
        data.put(2, new Day4Fragment3());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "page" + position;
    }
}
