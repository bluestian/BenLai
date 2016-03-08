package kf.qf.com.benlai.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import adapter.ViewPagerAdapter;
import base.BaseActivity;
import kf.qf.com.benlai.R;

/**
 * Created by 84903 on 2016/3/7.
 */
public class ViewPagerAnimAcitivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    //定义ViewPager适配器
    private ViewPagerAdapter vpAdapter;
    private ArrayList<View> views ;
    private ImageView[] point;
    private  int currentIndex;
    private  ImageView ivBtn;//跳转的按钮
    private  ImageView ivBtn5,ivBtn4,ivBtn3,ivBtn2,ivBtn1;
    private  static  final  int [] pics={R.mipmap.welcome_one,R.mipmap.welcome_two
    };
    @Override
    protected int contentViewGetid() {
        //进行导航页的全屏设置
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.acitivity_viewpageranim;
    }

    @Override
    protected void init() {
        viewPager = (ViewPager) findViewById(R.id.vp_anim);
        views = new ArrayList<>();
        vpAdapter = new ViewPagerAdapter(this,views);
        viewPager.setAdapter(vpAdapter);
        viewPager.addOnPageChangeListener(this);
        initpoint();

        ivBtn = (ImageView) findViewById(R.id.iv_but_view);
        ivBtn5= (ImageView) findViewById(R.id.iv_welcom5);

        ivBtn4= (ImageView) findViewById(R.id.iv_welcom4);
        ivBtn3= (ImageView) findViewById(R.id.iv_welcom3);
        ivBtn2= (ImageView) findViewById(R.id.iv_welcom2);
        ivBtn1= (ImageView) findViewById(R.id.iv_welcom1);


    }
    //初始化小点图片；
    private void initpoint() {
        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.ll_layout);
        point = new ImageView[pics.length];
        for (int i=0;i<pics.length;i++) {
            //取出布局文件中的每一个子元素；
            point[i]=  (ImageView) linearlayout.getChildAt(i);
            point[i].setEnabled(true);
            point[i].setOnClickListener(this);
            point[i].setTag(i);

        }
        //设置当面的默认位置；
        currentIndex=0;
        //设置为蓝色，即选中的状态；
        point[currentIndex].setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        int position= (int) v.getTag();
        setCurView(position);
        setCurDot(position);
    }
    /**
     * 设置当前页面的位置
     */
    private void setCurView(int position){
        if (position < 0 || position >= pics.length) {
            return;
        }
        viewPager.setCurrentItem(position);
    }

    /**
     * 设置当前的小点的位置
     */
    private void setCurDot(int positon){
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
            return;
        }
        point[positon].setEnabled(false);
        point[currentIndex].setEnabled(true);

        currentIndex = positon;
    }





    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position==pics.length-1){

            //点击按钮的进入主界面的事件；
            ivBtn.setVisibility(View.VISIBLE);
            ivBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ViewPagerAnimAcitivity.this, MainActivity.class));
                }
            });

            ivBtn5.setVisibility(View.VISIBLE);



            ObjectAnimator animator = ObjectAnimator.ofFloat(ivBtn5, "translationY",  -800f);
            ObjectAnimator animator4 = ObjectAnimator.ofFloat(ivBtn5, "alpha", 1.0f, 0.2f, 1.0F);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(animator).before(animator4);

            animatorSet.setDuration(200);
            animatorSet.start();

            ivBtn1.setVisibility(View.INVISIBLE);
            ivBtn2.setVisibility(View.INVISIBLE);
            ivBtn3.setVisibility(View.INVISIBLE);
            ivBtn4.setVisibility(View.INVISIBLE);
        }
        else{
            ivBtn1.setVisibility(View.VISIBLE);
            ivBtn2.setVisibility(View.VISIBLE);
            ivBtn3.setVisibility(View.VISIBLE);
            ivBtn4.setVisibility(View.VISIBLE);
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(ivBtn1, "translationY",  -600f);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(ivBtn2, "translationY",  -600f);
            ObjectAnimator animator3 = ObjectAnimator.ofFloat(ivBtn3, "translationY",  -600f);
            ObjectAnimator animator4 = ObjectAnimator.ofFloat(ivBtn4, "translationY",  -600f);
            AnimatorSet animatorSet = new AnimatorSet();
            //animatorSet.play(animator1).before(animator2).before(animator3).before(animator4);
            animatorSet.playSequentially(animator1,animator2,animator3,animator4);
            animatorSet.setDuration(1000).start();
            ivBtn.setVisibility(View.INVISIBLE);
            ivBtn5.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onPageSelected(int position) {
           setCurDot(position);



    }

    @Override
    public void onPageScrollStateChanged(int state) {


    }


}
