package kf.qf.com.benlai.util;

import android.os.Handler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yzy on 2016/3/7/0007.
 */
public class OkHttpUtil {

    private static OkHttpClient okHttpClient;
    private static Handler handler = new Handler();

    public static void initOkHttp(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }



    /**
     * 下载json
     * @param urlString
     */
    public static void downJSON(final String urlString, final OnDownDataListener onDownDataListener){
        Request request = new Request.Builder()
                .url(urlString)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(onDownDataListener != null){
                    onDownDataListener.onFailure(urlString, e.getMessage());
                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(onDownDataListener != null){
                            try {
                                onDownDataListener.onResponse(urlString, string);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }





    public interface OnDownDataListener{
        void onResponse(String url, String json);
        void onFailure(String url, String error);
    }

}
