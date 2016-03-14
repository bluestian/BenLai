package kf.qf.com.benlai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import kf.qf.com.benlai.R;
import kf.qf.com.benlai.entity.HotCityEntity;

/**
 * Created by yzy on 2016/3/8/0008.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder> {
    private Context context;
    private List<HotCityEntity> list=new ArrayList<>();

    public CityAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<HotCityEntity> list){
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hotcitytv_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getCityName());
        holder.tv.setTag(list.get(position).getCityNo());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_hotcity);


        }
    }
}
