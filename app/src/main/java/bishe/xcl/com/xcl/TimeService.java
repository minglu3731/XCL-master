package bishe.xcl.com.xcl;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class TimeService extends Service{


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        TimeChangeReceiver receiver=new TimeChangeReceiver();
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_TIME_TICK));
    }
}
