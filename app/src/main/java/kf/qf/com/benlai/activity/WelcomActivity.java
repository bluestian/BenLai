package kf.qf.com.benlai.activity;

import android.content.Intent;
import android.os.Handler;

import base.BaseActivity;
import kf.qf.com.benlai.R;



/**
 * Created by 84903 on 2016/3/7.
 */
public class WelcomActivity extends BaseActivity {
    private Handler handler = new Handler();

    @Override
    protected int contentViewGetid() {
        return R.layout.activity_welcom;
    }

    @Override
    protected void init() {
          handler.postDelayed(new Runnable() {
              @Override
              public void run() {
                     startActivity(new Intent(WelcomActivity.this,ViewPagerAnimAcitivity.class)
                     ,R.anim.welcom_anim_translate,R.anim.welcom_anim_scale);
              }
          },200);
    }
}
