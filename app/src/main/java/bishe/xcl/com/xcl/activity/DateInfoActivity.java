package bishe.xcl.com.xcl.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.data.bean.DatePhoto;
import bishe.xcl.com.xcl.data.bean.Plan;
import bishe.xcl.com.xcl.data.dao.DatePhotoDao;
import bishe.xcl.com.xcl.data.dao.PlanDao;
import bishe.xcl.com.xcl.data.helper.FileHelper;

public class DateInfoActivity extends AppCompatActivity {

    private Date date;
    private TextView tvPhoto;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_info);

        tvPhoto = (TextView) findViewById(R.id.tv_date_info_photo);
        iv = (ImageView) findViewById(R.id.v_date_info);
        TextView tvTitle = (TextView) findViewById(R.id.tv_date_info_title);

        date = (Date) getIntent().getSerializableExtra("date");

        tvTitle.setText(AddDateActivity.ft.format(date));
        List<Plan> plans = new PlanDao(this).listByDate(AddDateActivity.ft.format(date));

        DatePhoto photo = new DatePhotoDao(this).photoByDate(AddDateActivity.ft.format(date));
        if (photo != null){
            tvPhoto.setVisibility(View.GONE);
            iv.setImageBitmap(FileHelper.getPhoto(AddDateActivity.ft.format(date)));
        } else {
            tvPhoto.setVisibility(View.VISIBLE);
            tvPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 1);
                }
            });

        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Plan plan : plans){
            stringBuilder.append("健身目标 ： ").append(plan.getContent()).append("  提醒时间 ： ").append("\n");
        }

        TextView tv = (TextView) findViewById(R.id.tv_date_info);
        tv.setText(stringBuilder);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            Bundle bundle = data.getExtras();
            if (bundle == null) return;
            Bitmap bitmap = (Bitmap) bundle.get("data");
            FileHelper.save(bitmap, AddDateActivity.ft.format(date));
            new DatePhotoDao(this).add(new DatePhoto(AddDateActivity.ft.format(date)));
            iv.setImageBitmap(bitmap);
            tvPhoto.setVisibility(View.GONE);
        }
    }
}
