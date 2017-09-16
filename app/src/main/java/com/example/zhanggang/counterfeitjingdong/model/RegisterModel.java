package com.example.zhanggang.counterfeitjingdong.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe1;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：注册手机号的model
 * 时  间：2017/9/16 - 8:54.
 * 创建人：张刚
 */

public class RegisterModel {

    String shoujihao;

    public RegisterModel(String shoujihao) {
        this.shoujihao = shoujihao;
    }

    public void getRegisterData(@NonNull final RegisterDataCallBack<ZhuCe1> registerDataCallBack) {
        String urlPath = "http://api.eleteam.com/v1/user/register-step1?mobile=" + shoujihao;
        Log.e("MMMMMMMMMMM", urlPath + "........." + shoujihao);
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    ZhuCe1 zhuCe1 = new Gson().fromJson(response.body().string(), ZhuCe1.class);
                    registerDataCallBack.onRegisterSucced(zhuCe1);
                } else {
                    registerDataCallBack.onRegisterFailed(response.message());
                }
            }
        });
    }

    public interface RegisterDataCallBack<T> {
        void onRegisterSucced(T t);

        void onRegisterFailed(String ex);

    }
}
