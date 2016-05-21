package bishe.xcl.com.xcl.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.activity.InfomationActivity;
import bishe.xcl.com.xcl.data.bean.Infomation;

public class InfomationFragment extends Fragment {

    private TextView tv;
    private int id;
    private boolean ishowtv;

    public InfomationFragment(int id) {
        this.id = id;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_image_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = (TextView) view.findViewById(R.id.tv_my_image);
        View view1 = view.findViewById(R.id.v_my_image);

        tv.setText(getInfoActivity().getText());
        tv.setVisibility(View.INVISIBLE);
        ishowtv = false;
        view1.setBackgroundResource(id);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishowtv) {
                    tv.setVisibility(View.INVISIBLE);
                    ishowtv = false;
                }
                else {
                    tv.setVisibility(View.VISIBLE);
                    ishowtv = true;
                }
            }
        });
    }

    private InfomationActivity getInfoActivity(){
        return (InfomationActivity) getActivity();
    }
}
