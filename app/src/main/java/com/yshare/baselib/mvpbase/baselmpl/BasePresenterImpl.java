package com.yshare.baselib.mvpbase.baselmpl;

import com.yshare.baselib.mvpbase.BasePresenter;
import com.yshare.baselib.mvpbase.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/3/16.
 */

public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter {

    protected V view;

    public BasePresenterImpl(V view) {
        this.view = view;
        start();
    }

    @Override
    public void detach() {
        this.view = null;
        unDisposable();
    }

    @Override
    public void start() {

    }

    //将所有正在处理的Subscription都添加到CompositeSubscription中,统一退出的时候注销观察
    private CompositeDisposable mCompositeDisposable;

    /**
     * 将Disposable添加
     *
     * @param subscription
     */
    @Override
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb需要新的实例否则绑定时无效
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    /**
     * 在界面退出等需要解绑观察着的情况下调用此方法统一解绑,防止Rx造成的内存泄漏
     */
    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }

    }
}
