package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.library.zxing.activity.QRCodeScanFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：分类页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class FenLeiFragment extends QRCodeScanFragment {

    @BindView(R.id.on_erweima_fenlei)
    ImageView on_erweima_fenlei;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fen_lei_fragment, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //点击扫描二维码
        on_erweima_fenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScanQRCode();
            }
        });
    }
}
