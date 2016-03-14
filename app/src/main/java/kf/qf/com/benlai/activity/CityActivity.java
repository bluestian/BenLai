package kf.qf.com.benlai.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import kf.qf.com.benlai.R;
import kf.qf.com.benlai.adapter.AllCityAdapter;
import kf.qf.com.benlai.adapter.CityAdapter;
import kf.qf.com.benlai.entity.CityEntity;
import kf.qf.com.benlai.entity.HotCityEntity;
import kf.qf.com.benlai.res.URLS;
import kf.qf.com.benlai.util.JsonUtil;
import kf.qf.com.benlai.util.OkHttpUtil;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends AppCompatActivity {

    private static final String TAG = "print";
    private String result_sousuo;
    private CityAdapter cityAdapter;
    private List<String> allcity_list;
    private AllCityAdapter allCityAdapter;
    private View headView;
    private List<String> areaName_list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //初始化搜索框
        initSouSuo();
        //头部
        headView = View.inflate(this, R.layout.lv_header, null);
        //初始化热门城市
        initRecyclerView();
        //初始化所有城市
        initRecyclerViewAll();

    }

    //给叉设置点击事件
    public void click_close(View view){
        finish();
    }

    //给热门城市条目设置监听
    public void tv_hotcity(View view){
        Log.d(TAG, "tv_hotcity: " + view.getTag());
        Intent intent = getIntent();
        String cityNo = view.getTag().toString();
        intent.putExtra("cityNo",cityNo);
        TextView tv = (TextView)view;
        String cityName = (String) tv.getText();
        intent.putExtra("cityName", cityName);
        //往共享参数里面存
        SharedPreferences.Editor editor= getSharedPreferences("benlai",MODE_PRIVATE).edit();
        editor.putString("cityName", cityName);
        editor.putString("cityNo", cityNo);
        editor.commit();
        int startTimes=getSharedPreferences("benlai",MODE_PRIVATE).getInt("startTimes",0);
        if (startTimes==0){
            startActivity(new Intent(this,MainActivity.class));
        }else {
            //返回启动它的activity
            setResult(11);
        }

        finish();
    }

    private void initSlid() {
        LinearLayout slid = (LinearLayout) findViewById(R.id.slid);
        int size = areaName_list.size();
        for (int i = 0; i < size; i++) {
            TextView textView = new TextView(this);
            textView.setText(areaName_list.get(i));
            textView.setTextSize(10);
            textView.setPadding(0,5,5,5);
            slid.addView(textView);
        }

    }

    //初始化所有城市方法
    private void initRecyclerViewAll() {
        allcity_list = new ArrayList<>();
        allCityAdapter = new AllCityAdapter(this);
        ListView lv = (ListView) findViewById(R.id.lv_all);
        lv.setAdapter(allCityAdapter);
        lv.addHeaderView(headView);
        OkHttpUtil.downJSON(URLS.CITY_LIST, new OkHttpUtil.OnDownDataListener() {

            @Override
            public void onResponse(String url, String json) {
                List<CityEntity> list = JsonUtil.parseCity(json);

                int length = list.size();
                for (int i = 0; i < length; i++) {
                    String areaName = list.get(i).getAreaName();
                    areaName_list.add(areaName);
                    allcity_list.add(areaName);//A
                    List<CityEntity.CityEnt> cityEnt_list = list.get(i).getCity();
                    int len = cityEnt_list.size();
                    for (int j = 0; j < len; j++) {
                        allcity_list.add(cityEnt_list.get(j).getCityName());//鞍山
                    }
                }
                allCityAdapter.setData(allcity_list);
                allCityAdapter.notifyDataSetChanged();
                //初始化侧边字母条
                initSlid();

            }

            @Override
            public void onFailure(String url, String error) {

            }
        });
    }

    //初始化热门城市方法
    private void initRecyclerView() {
        cityAdapter = new CityAdapter(this);
        RecyclerView recyclerView = (RecyclerView) headView.findViewById(R.id.rv_hot);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(cityAdapter);

        OkHttpUtil.downJSON(URLS.CITY_LIST, new OkHttpUtil.OnDownDataListener() {
            List<HotCityEntity> hotCity_list;

            @Override
            public void onResponse(String url, String json) {
                hotCity_list = JsonUtil.parseHotCity(json);
                cityAdapter.setData(hotCity_list);
            }

            @Override
            public void onFailure(String url, String error) {

            }
        });


    }


    //初始化搜索框方法
    private void initSouSuo() {
        final EditText et = (EditText) findViewById(R.id.etSearch);
        final ImageView iv = (ImageView) findViewById(R.id.clear);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
            }
        });
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //当点击了确认键后执行
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    Log.d(TAG, "onKeyDown: enter............");
                    //查找与result相同的城市

                }
                return true;
            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    iv.setVisibility(View.VISIBLE);
                } else {
                    iv.setVisibility(View.GONE);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
