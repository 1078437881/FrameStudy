package com.yshare.baselib.mvpbase.baselmpl;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yshare.baselib.mvpbase.BasePresenter;
import com.yshare.baselib.mvpbase.BaseView;

/**
 * Created by Administrator on 2018/3/16.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    protected P presenter;
    private boolean isViewCreate = false;//view是否创建
    private boolean isViewVisible = false;//view是否可见
    public Context context;
    private boolean isFirst=true;//是否第一次加载

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter =initPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewCreate = true;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isViewVisible = isVisibleToUser;
        if(isVisibleToUser&&isViewCreate){
            isVisibleToUser();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isViewVisible){
            visibleToUser();
        }
    }

    /**
     * 懒加载
     * 让用户可见
     * 第一次加载
     */
    protected void firstLoad(){

    }

    protected void visibleToUser(){
        if(isFirst){
            firstLoad();
            isFirst=false;
        }
    }
    protected void isVisibleToUser(){
        if(isFirst){
            isFirst = false;
        }
    }
    public abstract P initPresenter();
}
