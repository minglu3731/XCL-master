package bishe.xcl.com.xcl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bishe.xcl.com.xcl.activity.AddDateActivity;
import bishe.xcl.com.xcl.activity.DateInfoActivity;
import bishe.xcl.com.xcl.data.bean.Plan;
import bishe.xcl.com.xcl.data.dao.PlanDao;

public class TimeChangeReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = Calendar.getInstance();

        if (calendar.get(Calendar.HOUR_OF_DAY) == 19 && calendar.get(Calendar.MINUTE) == 0){
            Intent intent1 = new Intent(context, DateInfoActivity.class);
            intent1.putExtra("date", new Date());
            context.startActivity(intent1);
        }
    }
}
