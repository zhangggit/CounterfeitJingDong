package com.example.zhanggang.counterfeitjingdong.model;

import android.support.annotation.NonNull;

import com.example.zhanggang.counterfeitjingdong.model.bean.FaXianBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：发现的model层
 * 时  间：2017/9/15 - 19:33.
 * 创建人：张刚
 */

public class GetFaXianDataModel {

    public GetFaXianDataModel(){

    }

    public void getFaXianData(@NonNull final FaXianDataCallBack<FaXianBean> faXianDataCallBack){
        //网络请求
        String urlPath="http://api.eleteam.com/v1/product/list-featured-topic";
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    FaXianBean faXianBean = new Gson().fromJson(response.body().string(), FaXianBean.class);
                    faXianDataCallBack.onGetDataSucced(faXianBean);
                }else {
                    String message = response.message();
                    faXianDataCallBack.onGetDataFailed(message);
                }
            }
        });
    }
    //定义接口
    public interface FaXianDataCallBack<T>{
        void onGetDataSucced(T t);
        void onGetDataFailed(String ex);
    }

}
