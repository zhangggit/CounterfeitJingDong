package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanggang.counterfeitjingdong.R;

/**
 * 类作用：首页viewpager的fragment1
 * 时  间：2017/9/8 - 15:01.
 * 创建人：张刚
 */

public class SYViewPagerFragment1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye_viewpager_fragment1,container,false);



        return view;
    }


}
