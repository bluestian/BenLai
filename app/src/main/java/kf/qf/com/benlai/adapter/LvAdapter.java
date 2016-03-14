package kf.qf.com.benlai.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kf.qf.com.benlai.R;
import kf.qf.com.benlai.entity.HomeDataEntity;

/**
 * Created by yzy on 2016/3/11/0011.
 */
public class LvAdapter extends BaseAdapter {
    private Context context;
    private List<HomeDataEntity> list=new ArrayList<>();
    private final LayoutInflater myInflater;
    public LvAdapter(Context context) {
        this.context = context;
        myInflater = LayoutInflater.from(context);
    }

    public void setData(List<HomeDataEntity> list){
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
        //绑定布局
        if (convertView==null){
            viewHolder=new ViewHolder();
            if (getItemViewType(position)==0){
                convertView = myInflater.inflate(R.layout.layout_lottype2, null);
                viewHolder.sdv0 = (SimpleDraweeView) convertView.findViewById(R.id.iv1_lottype2);
                viewHolder.sdv1 = (SimpleDraweeView) convertView.findViewById(R.id.iv2_lottype2);
                viewHolder.sdv2 = (SimpleDraweeView) convertView.findViewById(R.id.iv3_lottype2);
            }else if (getItemViewType(position)==1){
                convertView = myInflater.inflate(R.layout.layout_lottype3, null);
                viewHolder.sdv0 = (SimpleDraweeView) convertView.findViewById(R.id.iv1_lottype3);
            }else if (getItemViewType(position)==2){
                convertView = myInflater.inflate(R.layout.layout_lottype4, null);
                viewHolder.sdv0 = (SimpleDraweeView) convertView.findViewById(R.id.iv1_lottype4);
                viewHolder.sdv1 = (SimpleDraweeView) convertView.findViewById(R.id.iv2_lottype4);
                viewHolder.sdv2 = (SimpleDraweeView) convertView.findViewById(R.id.iv3_lottype4);
            }
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        //绑定数据
        if (getItemViewType(position)==0){
            String imgUrl0 = list.get(position).getList().get(0).getImg();
            String imgUrl1 = list.get(position).getList().get(1).getImg();
            String imgUrl2 = list.get(position).getList().get(2).getImg();
            viewHolder.sdv0.setImageURI(Uri.parse(imgUrl0));
            viewHolder.sdv1.setImageURI(Uri.parse(imgUrl1));
            viewHolder.sdv2.setImageURI(Uri.parse(imgUrl2));
        }else if (getItemViewType(position)==1){
            String imgUrl0 = list.get(position).getList().get(0).getImg();
            viewHolder.sdv0.setImageURI(Uri.parse(imgUrl0));
        }else if (getItemViewType(position)==2){
            String imgUrl0 = list.get(position).getList().get(0).getImg();
            String imgUrl1 = list.get(position).getList().get(1).getImg();
            String imgUrl2 = list.get(position).getList().get(2).getImg();
            viewHolder.sdv0.setImageURI(Uri.parse(imgUrl0));
            viewHolder.sdv1.setImageURI(Uri.parse(imgUrl1));
            viewHolder.sdv2.setImageURI(Uri.parse(imgUrl2));
        }


        return convertView;
    }
    class ViewHolder{
        SimpleDraweeView sdv0,sdv1,sdv2;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        //因为得到的数据是2-4，把他改成0-2
       int type = list.get(position).getLotType()-2;
        return type;
    }
}
