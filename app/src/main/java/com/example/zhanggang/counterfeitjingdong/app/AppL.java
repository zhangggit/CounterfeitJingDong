package com.example.zhanggang.counterfeitjingdong.app;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * 类作用：
 * 时  间：2017/9/7 - 19:38.
 * 创建人：张刚
 */

public class AppL extends Application {
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    protected static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(configuration);
        appContext=this;
    }
    public static Context appContext(){
        return appContext;
    }

}
