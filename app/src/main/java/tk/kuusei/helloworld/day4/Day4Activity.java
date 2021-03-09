package tk.kuusei.helloworld.day4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import tk.kuusei.helloworld.R;

public class Day4Activity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tablayout;

    private Day4ViewPagerAdapter viewPagerAdapter;
    private BottomNavigationView bottomNavigation;
    private Menu menu;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day4);

        viewpager = findViewById(R.id.day4_viewpager);
        tablayout = findViewById(R.id.day4_tablayout);

        viewPagerAdapter = new Day4ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(viewPagerAdapter);
        tablayout.setupWithViewPager(viewpager);

        bottomNavigation = findViewById(R.id.day4_bottomnavigation);
        menu = bottomNavigation.getMenu();


        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                menu.getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.day4Fragment1:
                    viewpager.setCurrentItem(0);
                    break;
                case R.id.day4Fragment2:
                    viewpager.setCurrentItem(1);
                    break;
                case R.id.day4Fragment3:
                    viewpager.setCurrentItem(2);
                    break;
            }
            return false;
        });
    }
}