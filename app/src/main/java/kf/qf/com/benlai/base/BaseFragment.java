package kf.qf.com.benlai.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**fragment的基类
 * Created by 84903 on 2016/3/7.
 */
public abstract class  BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(contentViewGetid(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData(getArguments());
    }
    //fragment中获取数据的封装方法；
    protected void getData(Bundle arguments) {

    }

    protected void loadData() {

    }

    protected void init(View view) {

    }

    protected abstract int contentViewGetid();
}
