package kf.qf.com.benlai.quote;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 *
 */
public class ScrollBehavior extends CoordinatorLayout.Behavior{

    private static final String TAG = "print";

    public ScrollBehavior(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    /**
     * 确认是否处理滑动方法 - 返回true，才可回调后面的处理方法
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    /**
     * 进行滑动处理
     * @param coordinatorLayout
     * @param view1
     * @param recyclerview
     * @param dxConsumed 有效的X轴偏移量
     * @param dyConsumed 有效的Y轴偏移量 如果往下滑，该值为正数，到底部以后为0；如果往上滑，该值为负数，到顶部以后为0
     * @param dxUnconsumed 无效的X轴偏移量
     * @param dyUnconsumed 无效的Y轴偏移量 如果控件滑动到顶部，手指接着往下拉，该值为负数；如果滑动到底部，手指接着往上拉，该值为正数；其余情况都是0；
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view1, View recyclerview, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.d(TAG, "开始滑动了 onNestedScroll: dyConsumed:" + dyConsumed + "   dyUnconsumed:" + dyUnconsumed);
        if(dyConsumed > 0){//表示开始往上滑动了
            int y = (int) (view1.getY() - dyConsumed);
            if(Math.abs(y) > view1.getHeight()){
                y = -view1.getHeight();
            }
            view1.setY(y);
        } else if(dyUnconsumed < 0){//表示置顶了
            int y = (int) (view1.getY() - dyUnconsumed);
            if(y > 0){
                y = 0;
            }
            view1.setY(y);
        }
    }

    /**
     * 处理快速滑动的方法
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param velocityX
     * @param velocityY
     * @param consumed
     * @return
     */
@Override
public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        Log.d(TAG, "开始快速滑动 onNestedFling: velocityY:" + velocityY);
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
        }
        }
