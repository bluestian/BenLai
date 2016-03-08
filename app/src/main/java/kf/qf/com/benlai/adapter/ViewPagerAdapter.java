package kf.qf.com.benlai.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import kf.qf.com.benlai.R;


/**
 *
 *导航页的viewpager的适配器；
    }
 */
public  class ViewPagerAdapter extends PagerAdapter {
    private  static  final  int [] pics={R.mipmap.welcome_one,R.mipmap.welcome_two
           };
     private  ArrayList<View> views;
     private  Context context;
      public ViewPagerAdapter(Context context, ArrayList<View> views){
              this.context=context;
              this.views = views;
          LinearLayout.LayoutParams  lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                  LinearLayout.LayoutParams.MATCH_PARENT);

          for (int i = 0;i<pics.length;i++){
              ImageView imageview = new ImageView(context);
              imageview.setScaleType(ImageView.ScaleType.FIT_XY);
              imageview.setLayoutParams(lparams);
              imageview.setImageResource(pics[i]);

              views.add(imageview);

          }
      }



    @Override
    public int getCount() {
        if (views!=null){
              return  views.size();
        }
        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
           container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));
    }
}
