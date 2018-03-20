package com.yshare.baselib.retroft;

import android.util.Log;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * Created by Administrator on 2018/3/19.
 */

public class ExceptionHelper {

    private static String TAG = "ExceptionHelper";

    public static String handleExcepiton(Throwable e) {
        e.printStackTrace();
        String error = null;
        //A instanceof B:判断A是否是B的类型
        if (e instanceof SocketTimeoutException) {
            //网络超时
            Log.e(TAG, "网络连接超时:" + e.getMessage());
            error = "网络连接超时";
        } else if (e instanceof ConnectException) {
            //网络连接异常
            Log.e(TAG, "网络连接异常" + e.getMessage());
            error = "网络连接异常";
        } else if (e instanceof JSONException
                || e instanceof JsonParseException
                || e instanceof ParseException) {
            //数据解析异常
            Log.e(TAG,"数据解析异常:"+e.getMessage());
            error = "数据解析异常";

        }else if(e instanceof ApiException){
            //服务器返回的错误信息
            error = e.getCause().getMessage();
        }else if(e instanceof UnknownHostException){
            Log.e(TAG,"网络连接异常:"+e.getMessage());
            error = "网络连接异常";
        }else if(e instanceof IllegalArgumentException){
            Log.e(TAG,"非法参数异常:"+e.getMessage());
            error = "非法参数异常";
        }else{
            Log.d(TAG,"其他错误:"+e.getMessage());
            error = "未知错误";
        }
        return error;
    }
}
