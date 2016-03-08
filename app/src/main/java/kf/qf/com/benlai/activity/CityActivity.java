package kf.qf.com.benlai.activity;

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

import java.util.List;

import kf.qf.com.benlai.R;
import kf.qf.com.benlai.entity.HotCityEntity;
import kf.qf.com.benlai.res.URLS;
import kf.qf.com.benlai.util.JsonUtil;
import kf.qf.com.benlai.util.OkHttpUtil;


public class CityActivity extends AppCompatActivity {

    private static final String TAG = "print";
    private String result_sousuo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.delcha);
        //初始化搜索框
        initSouSuo();
        //初始化热门城市
        initRecyclerView();


    }

    private void initRecyclerView() {
        OkHttpUtil.downJSON(URLS.CITY_LIST, new OkHttpUtil.OnDownDataListener() {
            List<HotCityEntity> hotCityEntities;

            @Override
            public void onResponse(String url, String json) {
                hotCityEntities = JsonUtil.parseHotCity(json);
            }

            @Override
            public void onFailure(String url, String error) {

            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_hot);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
       // recyclerView.setAdapter();
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
                if (keyCode==KeyEvent.KEYCODE_ENTER){
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
                if (s.length()!=0) {
                    iv.setVisibility(View.VISIBLE);
                }else {iv.setVisibility(View.GONE);}
                result_sousuo= (String) s;

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
