package com.example.zhanggang.counterfeitjingdong.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.zhanggang.counterfeitjingdong.model.bean.DengLu;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.annotation.ElementType;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：登陆的model
 * 时  间：2017/9/15 - 21:07.
 * 创建人：张刚
 */

public class LoginModel {

    String phone;
    String pwd;

    public LoginModel(String phone, String pwd) {
        this.phone = phone;
        this.pwd = pwd;
    }

    public void getLoginData(@NonNull final DengLuDataCallBack<DengLu> dengLuDengLuDataCallBack) {
        Log.e("TAGGGGG", "getLoginData: "+"phone"+phone+"```````````````pwd"+pwd);
        String urlPath = "http://api.eleteam.com/v1/user/login?mobile=" + phone + "&password=" + pwd;
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    DengLu dengLu = new Gson().fromJson(response.body().string(), DengLu.class);
                    dengLuDengLuDataCallBack.onGetDataSucced(dengLu);
                } else {
                    dengLuDengLuDataCallBack.onGetDataFailed(response.message());
                }
            }
        });

    }

    public interface DengLuDataCallBack<T> {
        void onGetDataSucced(T t);

        void onGetDataFailed(String ex);
    }

}
