package com.yshare.mvp.test.contact;

import com.yshare.baselib.mvpbase.BasePresenter;
import com.yshare.baselib.mvpbase.BaseView;
import com.yshare.mvp.test.bean.StoriesBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/20.
 */

public interface TestContact {

    interface view extends BaseView{

        /**
         *设置数据
         *
         * @param dataList
         */
        void setData(List<StoriesBean> dataList);
    }

    interface presenter extends BasePresenter{
        /**
         * 获取数据
         */
        void getData();
    }
}
