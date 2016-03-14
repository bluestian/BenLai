package kf.qf.com.benlai.quote;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import kf.qf.com.benlai.R;

/**
 *
 */
public class MyBehavior extends CoordinatorLayout.Behavior{

    public MyBehavior(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    /**
     * 确定依赖关系
     * @param parent
     * @param child 表示从属对象，也就是指定了app:layout_behavior这个属性的对象
     * @param dependency 表示你希望的依赖对象
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == R.id.fd;
    }

    /**
     * 依赖对象发生一系列改变的时候，会回调该方法
     * @param parent
     * @param view2
     * @param view1
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View view2, View view1) {
        view2.setY(view1.getY() + view1.getHeight());
        return true;
    }
}
