package bishe.xcl.com.xcl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.activity.FirstFirstActivity;
import bishe.xcl.com.xcl.activity.FirstSecondActivity;
import bishe.xcl.com.xcl.activity.FirstThirdActivity;

/**
 * Project : XCL
 * Package : bishe.xcl.com.xcl.fragment
 * Todo
 * Created by Zhang Mingzhe on 2016/5/19.
 * Mail : zhangmingzhe@navinfo.com.
 * Update by on .
 * Mail : .
 */
public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        view.findViewById(R.id.main_first_first_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstFragment.this.getContext(), FirstFirstActivity.class));
            }
        });

        view.findViewById(R.id.main_first_second_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstFragment.this.getContext(), FirstSecondActivity.class));
            }
        });

        view.findViewById(R.id.main_first_third_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstFragment.this.getContext(), FirstThirdActivity.class));
            }
        });
    }
}
