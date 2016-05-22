package bishe.xcl.com.xcl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class TimeChangeReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.HOUR_OF_DAY);
        calendar.get(Calendar.MINUTE);
    }
}
