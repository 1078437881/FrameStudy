package com.yshare.model;

import com.yshare.baselib.retroft.BaseApiImpl;

/**
 * Created by Administrator on 2018/4/11.
 */

public class Api extends BaseApiImpl{

    private static Api api = new Api(RetrofitService.BaseURL);
    public Api(String baseUrl) {
        super(baseUrl);
    }

    public static RetrofitService getInstance(){
        return api.getRetrofit().create(RetrofitService.class);
    }

}
