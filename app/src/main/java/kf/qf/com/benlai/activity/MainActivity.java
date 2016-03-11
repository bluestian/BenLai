package kf.qf.com.benlai.activity;

import android.view.View;

import kf.qf.com.benlai.R;
import kf.qf.com.benlai.base.BaseActivity;


public class MainActivity extends BaseActivity {

    private static final String TAG = "print";


    @Override
    protected int contentViewGetid() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {




        }

    public void btn(View view){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fg_newpro,new NewProductFragment()).commit();
    }
}
