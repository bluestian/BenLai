package kf.qf.com.benlai.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**acitivity的基类
 * Created by 84903 on 2016/3/7.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(contentViewGetid());
        init();//初始化的工作；
        loadData();//下载数据的方法；



    }

    protected void init() {

    }

    protected void loadData() {

    }

    protected abstract int contentViewGetid();

    //activity的过场动画的方法；
    public   void startActivity(Intent intent,int animIn ,int animOut ){
            super.startActivity(intent);
          overridePendingTransition(animIn,animOut);
    }
}
