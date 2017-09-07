package com.example.zhanggang.counterfeitjingdong.model;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 类作用：网络请求工具类
 * 时  间：2017/9/6 - 13:45.
 * 创建人：张刚
 */

public class UrlUtile {

    public static void sendOkHttpRequest(String address, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

}
