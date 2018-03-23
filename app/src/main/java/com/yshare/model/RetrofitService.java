package com.yshare.model;





import com.yshare.mvp.test.bean.TestBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/3/14.
 */

public interface RetrofitService {
    String BaseURL="https://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<TestBean> test();
}
