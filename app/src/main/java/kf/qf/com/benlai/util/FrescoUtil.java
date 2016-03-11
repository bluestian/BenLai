package kf.qf.com.benlai.util;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * Created by 84903 on 2016/3/9.
 */
public class FrescoUtil  {

    public static  void  initFresco(Context context){
        Fresco.initialize(context);


    }
    public static  void  initFresco(Context context,ImagePipelineConfig imagePipelineConfig){

        Fresco.initialize(context,imagePipelineConfig);


    }
    //图片的普通下载；
    public  static  void  imageViewBind(String url,SimpleDraweeView simpleDraweeView){
        Uri uri = Uri.parse(url);
        simpleDraweeView.setImageURI(uri);



    }

    //带有图片重试的下载；
    public  static  void  imageViewBindRetry(String url,SimpleDraweeView simpleDraweeView){
           Uri uri = Uri.parse(url);

        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)//开启重试
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(build);




    }

}
