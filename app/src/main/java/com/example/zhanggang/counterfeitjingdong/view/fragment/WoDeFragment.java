package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.view.activity.DengLuActivity;

/**
 * 类作用：我的页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class WoDeFragment extends Fragment {

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_wo_de_fragment, container, false);
        imageView = view.findViewById(R.id.touxiang);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DengLuActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
