package com.yshare.mvp.test.activity;

import android.os.Bundle;

import com.yshare.baselib.mvpbase.baselmpl.BaseActivity;
import com.yshare.framestudy.R;
import com.yshare.mvp.test.adapter.TestAdapter;
import com.yshare.mvp.test.bean.StoriesBean;
import com.yshare.mvp.test.contact.TestContact;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity<TestContact.presenter>implements TestContact.view{


    private List<StoriesBean> list = new ArrayList<>();
    private TestAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    public void setData(List<StoriesBean> dataList) {

    }

    @Override
    public TestContact.presenter initPresenter() {
        return null;
    }

}
