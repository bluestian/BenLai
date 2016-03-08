package kf.qf.com.benlai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import kf.qf.com.benlai.R;

/**
 * Created by yzy on 2016/3/8/0008.
 */
public class AllCityAdapter extends BaseAdapter{
    private List<String> list=new ArrayList<>();
    private Context context;

    public AllCityAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> list){
        this.list=list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.citytv_item, null);
            TextView tv = (TextView) convertView.findViewById(R.id.tv_city);
            viewHolder = new ViewHolder(tv);
            convertView.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.tv.setText(list.get(position));


        return convertView;
    }

    @Override
    public boolean isEnabled(int position) {

        if(list.get(position).length()==1){

            return false;
        }

        return true;
    }


    class ViewHolder{
        TextView tv;
        public ViewHolder(View view){
            tv= (TextView) view;
        }
    }
}
