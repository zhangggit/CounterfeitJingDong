package com.example.zhanggang.counterfeitjingdong.model;

import android.support.annotation.NonNull;

import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe3;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：注册验证码Model
 * 时  间：2017/9/16 - 9:42.
 * 创建人：张刚
 */

public class Register3Model {

    String shoujihao;
    String mima;
    String yanzhengma;

    public Register3Model(String shoujihao, String mima, String yanzhengma) {
        this.shoujihao = shoujihao;
        this.mima = mima;
        this.yanzhengma = yanzhengma;
    }

    public void getData(@NonNull final onGetDataCallBack<ZhuCe3> onGetDataCallBack) {
        String urlPath = "http://api.eleteam.com/v1/user/register-step3?mobile=" + shoujihao + "&&password=" + mima + "&&code=" + yanzhengma;
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    ZhuCe3 zhuCe3 = new Gson().fromJson(response.body().string(), ZhuCe3.class);
                    onGetDataCallBack.GetSucced(zhuCe3);
                } else {
                    onGetDataCallBack.GetFailed(response.message());
                }
            }
        });
    }

    public interface onGetDataCallBack<T> {
        void GetSucced(T t);

        void GetFailed(String ex);
    }

}
