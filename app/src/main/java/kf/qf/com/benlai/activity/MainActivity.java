package kf.qf.com.benlai.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import kf.qf.com.benlai.R;
import kf.qf.com.benlai.fragment.FragmentHome;
import kf.qf.com.benlai.fragment.NewProductFragment;
import kf.qf.com.benlai.res.URLS;
import kf.qf.com.benlai.util.OkHttpUtil;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    private TextView tv_selectCity;
    private FragmentHome fragmentHome;
    private NewProductFragment fragmentNewPro=null;
    private String cityNo="";
    private String cityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int startTimes = getSharedPreferences("benlai", MODE_PRIVATE).getInt("startTimes", 0);
        if (startTimes == 0) {
            SharedPreferences.Editor editor = getSharedPreferences("benlai", MODE_PRIVATE).edit();
            editor.putInt("startTimes", 1);
            editor.commit();
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        tv_selectCity = (TextView) findViewById(R.id.tv_selectCity);

        initFragment();
        initMain();
        //初始化radiobutton
        initRb();


    }

    private void initMain() {
        cityName = getSharedPreferences("benlai", MODE_PRIVATE).getString("cityName", "");
        cityNo = getSharedPreferences("benlai", MODE_PRIVATE).getString("cityNo", "");
        tv_selectCity.setText(cityName);
        //要向网络请求数据，数据请求完成后setdata给各个需要展示数据的控件
        String vp_url = String.format(URLS.VIEWPAGER, URLS.deviceId, cityNo);
        String ll_url = String.format(URLS.SHOUYE, URLS.deviceId, cityNo);
        OkHttpUtil.downJSON(vp_url, new OkHttpUtil.OnDownDataListener() {
            @Override
            public void onResponse(String url, String json) {
                fragmentHome.setVPJson(json);
            }

            @Override
            public void onFailure(String url, String error) {

            }
        });
        OkHttpUtil.downJSON(ll_url, new OkHttpUtil.OnDownDataListener() {
            @Override
            public void onResponse(String url, String json) {
                fragmentHome.setLvjson(json);
            }

            @Override
            public void onFailure(String url, String error) {

            }
        });
    }


    //初始化fragment
    private void initFragment() {
        fragmentHome = new FragmentHome();
        fragmentNewPro = new NewProductFragment();
        transaction.add(R.id.fl_fragment, fragmentHome);
        transaction.commit();

    }


    private void initRb() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_home) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_fragment, fragmentHome).commit();
                } else if (checkedId == R.id.rb_fenlei) {
                } else if (checkedId == R.id.rb_xinpin) {
                    fragmentNewPro.loadData(cityNo);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_fragment, fragmentNewPro).commit();
                } else if (checkedId == R.id.rb_wode) {
                }
            }
        });

    }

    //给toolbar上面的单个控件设置点击事件
    public void click(View view) {
        if (view.getId() == R.id.tv_selectCity) {
            startActivityForResult(new Intent(this, CityActivity.class), 1);

        } else if (view.getId() == R.id.tv_checkGoods) {

        } else if (view.getId() == R.id.iv_QRcode) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        initMain();
    }
}
