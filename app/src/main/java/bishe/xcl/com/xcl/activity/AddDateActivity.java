package bishe.xcl.com.xcl.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.data.bean.Plan;

public class AddDateActivity extends AppCompatActivity implements View.OnClickListener, CalendarDatePickerDialogFragment.OnDateSetListener, RadialTimePickerDialogFragment.OnTimeSetListener {

    private Button btnCancle, btnSure;
    private LinearLayout layoutBegin, layoutEnd, layoutTime;
    private TextView tvBegin, tvEnd, tvTime;
    private EditText etContent;

    private SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date);

        initView();
    }

    private void initView() {
        layoutBegin = (LinearLayout) findViewById(R.id.layout_date_add_begin);
        layoutEnd = (LinearLayout) findViewById(R.id.layout_date_add_end);
        layoutTime = (LinearLayout) findViewById(R.id.layout_date_add_time);
        btnCancle = (Button) findViewById(R.id.btn_date_add_cancle);
        btnSure = (Button) findViewById(R.id.btn_date_add_sure);
        etContent = (EditText) findViewById(R.id.et_date_add);
        tvBegin = (TextView) findViewById(R.id.tv_date_add_begin);
        tvEnd = (TextView) findViewById(R.id.tv_date_add_end);
        tvTime = (TextView) findViewById(R.id.tv_date_add_time);

        layoutBegin.setOnClickListener(this);
        layoutEnd.setOnClickListener(this);
        btnCancle.setOnClickListener(this);
        btnSure.setOnClickListener(this);
        layoutTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == layoutBegin){
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                    .setOnDateSetListener(this)
                    .setFirstDayOfWeek(Calendar.SUNDAY)
                    .setPreselectedDate(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
                    .setDateRange(null, null)
                    .setDoneText("选择")
                    .setCancelText("取消");
            cdp.show(getSupportFragmentManager(), "begin_date");
        } else if (v == btnCancle){
            finish();
        } else if (v == layoutEnd){
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                    .setOnDateSetListener(this)
                    .setFirstDayOfWeek(Calendar.SUNDAY)
                    .setPreselectedDate(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
                    .setDateRange(null, null)
                    .setDoneText("选择")
                    .setCancelText("取消");
            cdp.show(getSupportFragmentManager(), null);
        } else if (v == btnSure){
            savePlan();
        } else if (v == layoutTime){
            RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                    .setOnTimeSetListener(this)
                    .setStartTime(5, 0)
                    .setDoneText("选择")
                    .setCancelText("取消");
            rtpd.show(getSupportFragmentManager(), null);
        }
    }

    private void savePlan() {
        Plan plan = new Plan(tvBegin.getText().toString(), tvEnd.getText().toString(),etContent.getText().toString(),  tvTime.getText().toString());
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        if ("begin_date".equals(dialog.getTag())) tvBegin.setText(ft.format(calendar.getTime()));
        else tvEnd.setText(ft.format(calendar.getTime()));
    }

    @Override
    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
        String time = "" + hourOfDay + " : " + minute;
        tvTime.setText(time);
    }
}