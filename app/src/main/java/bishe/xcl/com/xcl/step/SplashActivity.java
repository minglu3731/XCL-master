package bishe.xcl.com.xcl.step;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;

import bishe.xcl.com.xcl.R;


public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		
		if (StepCounterService.FLAG || StepDetector.CURRENT_SETP > 0) {// �����Ѿ�������ֱ����ת�����н���
			Intent intent = new Intent(SplashActivity.this, StepCounterActivity.class); //����һ���µ�Intent��ָ����ǰӦ�ó���������
																				//��Ҫ������StepActivity��
			startActivity(intent);												//�������intent��startActivity
			this.finish();
		} else {
			new CountDownTimer(2000L, 1000L)
			{
				public void onFinish()
				{

					//�������浭�뵭��Ч��
					Intent intent = new Intent();
					intent.setClass(SplashActivity.this, StartActivity.class);
					startActivity(intent);
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
					finish();

				}

				public void onTick(long paramLong)
				{
				}
			}
			.start();
		}
	}

}

