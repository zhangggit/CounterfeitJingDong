package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.view.activity.DengLuActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：我的页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class WoDeFragment extends Fragment {

    @BindView(R.id.touxiang)
    ImageView touxiang;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_wo_de_fragment, container, false);
        ButterKnife.bind(this,view);

        //点击进入登陆页面
        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DengLuActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取存入的QQ头像
        String touxiang_huichuan = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE).getString("key", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504799012955&di=e73ef8488600c38a242ed28400585010&imgtype=0&src=http%3A%2F%2Fwww.wxdh001.com%2FPublic%2Fnews%2Fimage%2F20130614%2F20130614083354_38816.jpg");
        //imageloader 将头像做圆形
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .showImageOnFail(R.mipmap.ic_launcher_round)  // 设置图片加载或解码过程中发生错误显示的图片
                .displayer(new CircleBitmapDisplayer())
                .build();
        ImageLoader.getInstance().displayImage(touxiang_huichuan,touxiang,options);
    }

}
