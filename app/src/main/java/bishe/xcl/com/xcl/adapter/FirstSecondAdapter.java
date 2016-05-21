package bishe.xcl.com.xcl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bishe.xcl.com.xcl.R;
import bishe.xcl.com.xcl.data.bean.Infomation;

public class FirstSecondAdapter extends BaseAdapter{

    private Context context;

    private List<Infomation> datas;

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Infomation infomation = datas.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_fs_item, parent, false);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_fs_item_content);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_fs_item_title);
            viewHolder.img = convertView.findViewById(R.id.v_fs_item_img);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvContent.setText(infomation.getContent());
        viewHolder.tvTitle.setText(infomation.getTitle());
        viewHolder.img.setBackgroundResource(infomation.getImgId());
        return convertView;
    }

    private class ViewHolder{
        TextView tvTitle, tvContent;
        View img;
    }
}
