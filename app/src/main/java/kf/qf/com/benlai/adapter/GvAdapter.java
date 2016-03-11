package kf.qf.com.benlai.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import kf.qf.com.benlai.R;
import kf.qf.com.benlai.entity.NewProduectEntity;

/**
 * Created by 84903 on 2016/3/10.
 */
public class GvAdapter extends RecyclerView.Adapter<GvAdapter.MyViewHolder>{
      private Context context;
     private  List<NewProduectEntity.DataEntity.ItemListEntity> list;
    public GvAdapter(Context context, List<NewProduectEntity.DataEntity.ItemListEntity> list) {
           this.context=context;
           this.list = list;
    }

    @Override
    public GvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.item_newproduct,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GvAdapter.MyViewHolder holder, int position) {
               if (holder instanceof MyViewHolder){
                       MyViewHolder myViewHolder = holder;
                      myViewHolder.sdv.setImageURI(Uri.parse(list.get(position).getImageUrl()));
                      myViewHolder.tv.setText(list.get(position).getBriefName());
                     myViewHolder.tvpr.setText(list.get(position).getPrice());

               }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdv;
        TextView tv;
        TextView tvpr;
        public MyViewHolder(View itemView) {
            super(itemView);
              sdv = (SimpleDraweeView) itemView.findViewById(R.id.fdv_fragment_head);
              tv = (TextView) itemView.findViewById(R.id.tv_title);
              tvpr = (TextView) itemView.findViewById(R.id.tv_price);
        }


    }
}
