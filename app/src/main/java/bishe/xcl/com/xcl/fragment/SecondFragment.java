package bishe.xcl.com.xcl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.activity.AddDateActivity;
import bishe.xcl.com.xcl.activity.DateInfoActivity;

/**
 * Project : XCL
 * Package : bishe.xcl.com.xcl.fragment
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
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView calendar = (CalendarPickerView) view.findViewById(R.id.cpv_second);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .withSelectedDate(today);

        calendar.setDateSelectableFilter(new CalendarPickerView.DateSelectableFilter() {
            @Override
            public boolean isDateSelectable(Date date) {
                Intent intent = new Intent(getContext(), DateInfoActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
                return true;
            }
        });

        view.findViewById(R.id.tv_add_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddDateActivity.class));
            }
        });
    }
}
