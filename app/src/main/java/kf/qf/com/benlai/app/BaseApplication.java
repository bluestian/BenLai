package kf.qf.com.benlai.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import kf.qf.com.benlai.util.OkHttpUtil;

/**
 * Created by yzy on 2016/3/7/0007.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpUtil.initOkHttp();
        Fresco.initialize(this);
    }
}
