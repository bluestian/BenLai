package kf.qf.com.benlai.fragment;

import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import kf.qf.com.benlai.R;
import kf.qf.com.benlai.adapter.GvAdapter;
import kf.qf.com.benlai.base.BaseFragment;
import kf.qf.com.benlai.entity.NewProduectEntity;
import kf.qf.com.benlai.res.URLS;
import kf.qf.com.benlai.util.OkHttpUtil;

import static kf.qf.com.benlai.entity.NewProduectEntity.DataEntity;

/**
 * Created by 84903 on 2016/3/9.
 */
public class NewProductFragment extends BaseFragment implements OkHttpUtil.OnDownDataListener {

    private static final String TAG = "print";
    private List<DataEntity.ItemListEntity> mlist;//新品页的数据；
    private SimpleDraweeView simpleDraweeView;
    private RecyclerView mrecyclerView;
    private GvAdapter gvAdapter;
    protected int contentViewGetid() {
        return R.layout.fragment_newproduct;
    }

    @Override
    protected void init(View view) {
        mlist = new ArrayList<>();
       mrecyclerView = (RecyclerView) view.findViewById(R.id.gd_fragment);
       gvAdapter = new GvAdapter(getActivity(), mlist);
       //广告头的数据；
         simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.fd);




    }


    public void loadData(String cityNo) {
        //下载数据;
        String xinpin = String.format(URLS.XINPIN, URLS.deviceId, cityNo);

        OkHttpUtil.downJSON(xinpin, this);


    }

    //数据下载的回调方法；
    @Override
    public void onResponse(String url, String json) {
         //新品页数据的适配；
        NewProduectEntity mnewProduect = new Gson().fromJson(json, NewProduectEntity.class);
        int size = mnewProduect.getData().size();
        DataEntity dataEntity = null;
        for (int i = 0; i < size; i++) {
            dataEntity = mnewProduect.getData().get(i);
        }
        mlist.addAll(dataEntity.getItemList());



         mrecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mrecyclerView.setAdapter(gvAdapter);
        simpleDraweeView.setImageURI(Uri.parse(dataEntity.getHeaderImg()));
        //头数据；



    }

    @Override
    public void onFailure(String url, String error) {

    }

}
