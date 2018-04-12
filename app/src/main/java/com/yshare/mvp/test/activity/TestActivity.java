package com.yshare.mvp.test.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yshare.baselib.mvpbase.baselmpl.BaseActivity;
import com.yshare.framestudy.R;
import com.yshare.mvp.test.adapter.TestAdapter;
import com.yshare.mvp.test.bean.StoriesBean;
import com.yshare.mvp.test.contact.TestContact;
import com.yshare.mvp.test.presenter.TestPresenter;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity<TestContact.presenter>implements TestContact.view{


    private List<StoriesBean> list = new ArrayList<>();
    private TestAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        init();
        presenter.getData();
    }

    /**
     * 初始化界面
     */
    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        adapter = new TestAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setData(List<StoriesBean> dataList) {
        list.addAll(dataList);
        adapter.notifyDataSetChanged();
    }

    /**
     * 初始化presenter
     * @return
     */
    @Override
    public TestContact.presenter initPresenter() {
        return new TestPresenter(this);
    }

}
