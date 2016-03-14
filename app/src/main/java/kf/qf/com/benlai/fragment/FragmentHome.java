package kf.qf.com.benlai.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kf.qf.com.benlai.R;
import kf.qf.com.benlai.adapter.LvAdapter;
import kf.qf.com.benlai.entity.HomeDataEntity;
import kf.qf.com.benlai.entity.VpHomeEntity;
import kf.qf.com.benlai.widget.MyListView;

/**
 * Created by yzy on 2016/3/9/0009.
 */
public class FragmentHome extends Fragment {
    private List<SimpleDraweeView> list = new ArrayList<>();
    private LvAdapter lvAdapter;
    private MyPagerAdapter myPagerAdapter;
    private ViewPager vp_home;
    private MyListView lv_fmhome;

    //给lv设置json数据
    public void setLvjson(String json){
        try {

            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            TypeToken<List<HomeDataEntity>> tt=new TypeToken<List<HomeDataEntity>>(){};
            List<HomeDataEntity> list_HomeDataEntity = new Gson().fromJson(data.toString(),tt.getType());
            lvAdapter.setData(list_HomeDataEntity);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void setVPJson(String json) {
        List<SimpleDraweeView> list2 = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray jsonArray = object.getJSONArray("data").getJSONObject(0).getJSONArray("list");
            TypeToken<List<VpHomeEntity>> tt = new TypeToken<List<VpHomeEntity>>() {
            };
            List<VpHomeEntity> list_vp = new Gson().fromJson(jsonArray.toString(), tt.getType());

            for (VpHomeEntity vp :list_vp) {
                String img = vp.getImg();
                SimpleDraweeView draweeView = new SimpleDraweeView(getActivity());
                draweeView.setImageURI(Uri.parse(img));
                list2.add(draweeView);
            }
            myPagerAdapter.setData(list2);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lvAdapter = new LvAdapter(getActivity());
        myPagerAdapter = new MyPagerAdapter();
        return inflater.inflate(R.layout.fragment_home, null, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        vp_home = (ViewPager) view.findViewById(R.id.vp_home);
        lv_fmhome = (MyListView) view.findViewById(R.id.lv_fmhome);
        vp_home.setAdapter(myPagerAdapter);
        lv_fmhome.setAdapter(lvAdapter);
    }


    class MyPagerAdapter extends PagerAdapter {
        public void setData(List<SimpleDraweeView> dataList) {
            list = dataList;
            this.notifyDataSetChanged();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }




}
