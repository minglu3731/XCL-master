package bishe.xcl.com.xcl.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bishe.xcl.com.xcl.R;

public class MyImageView extends ViewGroup {

    private boolean isTextShow;

    private TextView tv;

    private String value;

    private int id;

    public MyImageView(Context context) {
        super(context);
        init(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_image_view, this, false);
        addView(view);
        tv = (TextView) view.findViewById(R.id.tv_my_image);
        view.findViewById(R.id.v_my_image).setBackgroundResource(id);
        tv.setText(value);
        tv.setVisibility(INVISIBLE);
        isTextShow = false;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }

    public void toggle() {
        if (isTextShow)
            tv.setVisibility(INVISIBLE);
        else
            tv.setVisibility(VISIBLE);
    }


    public void setValue(String value) {
        this.value = value;
    }

    public void setMyId(int id) {
        this.id = id;
    }
}
