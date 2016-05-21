package bishe.xcl.com.xcl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.activity.SecondFirstActivity;
import bishe.xcl.com.xcl.activity.SecondSecondActivity;
import bishe.xcl.com.xcl.activity.SecondThirdActivity;

/**
 * Project : XCL
 * Package : bishe.xcl.com.xcl.fragment
 * Todo
 * Created by Zhang Mingzhe on 2016/5/19.
 * Mail : zhangmingzhe@navinfo.com.
 * Update by on .
 * Mail : .
 */
public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        view.findViewById(R.id.main_second_first_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondFragment.this.getContext(), SecondFirstActivity.class));
            }
        });

        view.findViewById(R.id.main_second_second_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondFragment.this.getContext(), SecondSecondActivity.class));
            }
        });

        view.findViewById(R.id.main_second_third_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondFragment.this.getContext(), SecondThirdActivity.class));
            }
        });
    }
}
