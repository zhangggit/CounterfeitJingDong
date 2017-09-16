package com.example.zhanggang.counterfeitjingdong.model;

import android.support.annotation.NonNull;

import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe2;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：注册密码的model
 * 时  间：2017/9/16 - 9:23.
 * 创建人：张刚
 */

public class Register2Model {

    String shoujihao;
    String pwd;

    public Register2Model(String shoujihao, String pwd) {
        this.shoujihao = shoujihao;
        this.pwd = pwd;
    }

    public void getData(@NonNull final Register2DataCallBack<ZhuCe2> register2DataCallBack) {
        String urlPath = "http://api.eleteam.com/v1/user/register-step1?mobile=" + shoujihao + "&password=" + pwd;
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    ZhuCe2 zhuCe2 = new Gson().fromJson(response.body().string(), ZhuCe2.class);
                    register2DataCallBack.onGetRegister2Succed(zhuCe2);
                } else {
                    register2DataCallBack.onGetRegister2Failed(response.message());
                }
            }
        });

    }

    public interface Register2DataCallBack<T> {
        void onGetRegister2Succed(T t);

        void onGetRegister2Failed(String ex);
    }

}
