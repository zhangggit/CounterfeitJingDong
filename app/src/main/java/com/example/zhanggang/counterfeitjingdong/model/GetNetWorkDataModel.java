package com.example.zhanggang.counterfeitjingdong.model;

import android.support.annotation.NonNull;

import com.example.zhanggang.counterfeitjingdong.model.bean.ShouYeGridData;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：首页的model
 * 时  间：2017/9/15 - 18:53.
 * 创建人：张刚
 */

public class GetNetWorkDataModel {

    public GetNetWorkDataModel(){

    }

    public void getNetWorkData(@NonNull final DataCallBack<ShouYeGridData> dataDataCallBack){
        //网络请求
        String path="http://api.eleteam.com/v1/product/list-featured-topic";
        UrlUtile.sendOkHttpRequest(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    ShouYeGridData shouYeGridData = new Gson().fromJson(response.body().string(), ShouYeGridData.class);
                    dataDataCallBack.onGetDataSucced(shouYeGridData);
                }else{
                    String message = response.message();
                    dataDataCallBack.onGetDataFaild(message);
                }

            }
        });

    }
    //定义接口
    public interface DataCallBack<T>{
        void onGetDataSucced(T t);
        void onGetDataFaild(String ex);
    }
}
