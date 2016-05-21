package bishe.xcl.com.xcl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.adapter.FirstSecondAdapter;
import bishe.xcl.com.xcl.data.bean.Infomation;

public class FirstSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_second);
        ListView lv = (ListView) findViewById(R.id.lv_fs);
        lv.setAdapter(getInfomationAdapter());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FirstSecondActivity.this, InfomationActivity.class);
                intent.putExtra("info",(Infomation) parent.getAdapter().getItem(position));
                startActivity(intent);
            }
        });
    }

    private FirstSecondAdapter getInfomationAdapter() {
        FirstSecondAdapter adapter = new FirstSecondAdapter(this);
        adapter.setDatas(getInfomations());
        return adapter;
    }

    private List<Infomation> getInfomations() {
        List<Infomation> list = new ArrayList<>();
        list.add(new Infomation(R.drawable.tst_icon, new int[]{ R.drawable.tst_big, R.drawable.tst_big_2} , "Test1", "this is a test new demo"));
        list.add(new Infomation(R.drawable.tst_icon, new int[]{R.drawable.tst_big}, "Test2", "this is a test demo"));
        list.add(new Infomation(R.drawable.tst_icon,new int[] {R.drawable.tst_big}, "Test3", "this is a test demo"));
        list.add(new Infomation(R.drawable.tst_icon,new int[]{R.drawable.tst_big}, "Test4", "this is a test demo"));
        list.add(new Infomation(R.drawable.tst_icon, new int[]{R.drawable.tst_big}, "Test5", "this is a test demo"));
        list.add(new Infomation(R.drawable.tst_icon, new int[]{R.drawable.tst_big}, "Test6", "this is a test demo"));
        return list;
    }
}
