package com.yshare.baselib.mvpbase.baselmpl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yshare.baselib.mvpbase.BasePresenter;
import com.yshare.baselib.mvpbase.BaseView;
import com.yshare.baselib.utils.ActivityManager;

/**
 * Created by Administrator on 2018/3/15.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    protected P presenter;
    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ActivityManager.getAppInstance().addActivity(this);//将当前Activity添加进管理栈
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getAppInstance().removeActivity(this);//将当前Activity移除管理栈
        if (presenter != null) {
            presenter.detach();//在presenter中解绑view
            presenter = null;
        }
        super.onDestroy();
    }

    /**
     * 在子类中初始化对应的presenter
     *
     * @return 相对应的presenter
     */
    public abstract P initPresenter();

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void showLadingDialog(String msg) {

    }
}
