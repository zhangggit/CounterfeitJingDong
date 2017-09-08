package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 类作用：首页 第一个页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class ShouYeFragment extends Fragment {

    List<String> images = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shou_ye_fragment, container, false);

        setImages();
        setBanner(view);


        return view;
    }
    //设置Banner轮播
    private void setBanner(View view) {
        Banner banner = view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);

        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
    //设置图片集合
    private void setImages() {
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311979&di=b34a790a363061b61ebbdc4cdcb05526&imgtype=0&src=http%3A%2F%2Fpicyun.90sheji.com%2Fdesign%2F00%2F03%2F49%2F64%2Fs_1024_54ed221172712.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311979&di=881b57bc4fe86eed1b6bbbef701d6e9d&imgtype=0&src=http%3A%2F%2Fp7.zbjimg.com%2Fservice%2F2016-05%2F07%2Fservice%2F572d53d6aa29c.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780733943&di=8cf4d7d72b85740d6570029a1f2639ac&imgtype=0&src=http%3A%2F%2Fimg11.360buyimg.com%2Fcms%2Fjfs%2Ft244%2F181%2F918959068%2F708384%2F3aa97b0f%2F53f3fc52Nb3ea7aa9.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311979&di=17ba9a0b5d37ca11ba92a7086be4bec7&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F12%2F82%2F64%2F21b1OOOPICa6.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780402170&di=a68c315bcd6e1f1f53bc4199150c4955&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D647556253%2C2324393888%26fm%3D214%26gp%3D0.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311979&di=ed2f0a45d3007f733a1bfdc460976b2b&imgtype=0&src=http%3A%2F%2Fimages2015.cnblogs.com%2Fblog%2F1046195%2F201610%2F1046195-20161028141024062-613721819.png");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311978&di=89faa4b9459c01c05aa377d0d531352a&imgtype=0&src=http%3A%2F%2Fpic118.nipic.com%2Ffile%2F20161215%2F20494655_204817750001_2.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311977&di=d3579c25eb74b8b60b17c2eea10251ce&imgtype=0&src=http%3A%2F%2Fimg.aiimg.com%2Fuploads%2Fallimg%2F150711%2F1-150G1121R8.jpg");
    }
}
