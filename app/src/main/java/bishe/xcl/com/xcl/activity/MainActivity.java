package bishe.xcl.com.xcl.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {

    private View firstView, secondView;

    private ViewPager mainVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        firstView = findViewById(R.id.main_first_btn);
        secondView = findViewById(R.id.main_second_btn);
        mainVp = (ViewPager) findViewById(R.id.main_vp);

        mainVp.setAdapter(new MainAdapter(getSupportFragmentManager()));

        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    changeUI(true);
                } else {
                    changeUI(false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        firstView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainVp.setCurrentItem(0);
            }
        });
        secondView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainVp.setCurrentItem(1);
            }
        });
    }

    private void changeUI(boolean isFirst) {
        if (isFirst){
            firstView.setBackgroundResource(R.drawable.ic_accessibility_light_blue_900_18dp);
            secondView.setBackgroundResource(R.drawable.ic_account_box_light_blue_500_18dp);
        } else {
            firstView.setBackgroundResource(R.drawable.ic_accessibility_light_blue_500_18dp);
            secondView.setBackgroundResource(R.drawable.ic_account_box_light_blue_900_18dp);
        }
    }
}
