package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanggang.counterfeitjingdong.R;

/**
 * 类作用：分类页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class FenLeiFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fen_lei_fragment, container, false);



        return view;
    }
}
