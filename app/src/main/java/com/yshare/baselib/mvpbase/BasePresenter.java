package com.yshare.baselib.mvpbase;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/3/15.
 */

public interface BasePresenter {

    //默认初始化
    void start();

    //Activity关闭把view对象置空
    void detach();

    //将网络请求的每一个disposable添加进入CompositeDisposable,再退出时一并注销
    void addDisposable(Disposable subscription);

    //注销所有请求
    void unDisposable();
}
