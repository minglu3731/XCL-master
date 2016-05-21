package bishe.xcl.com.xcl.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.adapter.InfomationAdapter;
import bishe.xcl.com.xcl.data.bean.Infomation;
import bishe.xcl.com.xcl.weight.MyImageView;

public class InfomationActivity extends AppCompatActivity {

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation);

        Infomation infomation = (Infomation) getIntent().getSerializableExtra("info");
        text = infomation.getContent();
        ViewPager viewPaper = (ViewPager) findViewById(R.id.infomation_vp);

        InfomationAdapter adapter = new InfomationAdapter(getSupportFragmentManager());
        adapter.setList(infomation.getImgBigId());
        viewPaper.setAdapter(adapter);
    }

    public String getText(){
        return text;
    }
}
