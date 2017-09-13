package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean;
import com.example.zhanggang.counterfeitjingdong.view.adapter.MyPageAdapter_fenlei;
import com.google.gson.Gson;
import com.library.zxing.activity.QRCodeScanFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * 类作用：分类页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class FenLeiFragment extends QRCodeScanFragment {

    @BindView(R.id.on_erweima_fenlei)
    ImageView on_erweima_fenlei;
    @BindView(R.id.tablayout_fenlei)
    VerticalTabLayout tabLayout;
    @BindView(R.id.viewpager_fenlei)
    ViewPager  viewPager;
    private MyPageAdapter_fenlei adapter;
    String urlPath="http://169.254.142.217/mobile/index.php?act=goods_class";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fen_lei_fragment, container, false);
        ButterKnife.bind(this, view);

        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FenLeiBean fenLeiBean = new Gson().fromJson(response.body().string(), FenLeiBean.class);
                List<FenLeiBean.DatasBean.ClassListBean> class_list = fenLeiBean.getDatas().class_list;//获取左边tablayout的内容集合
                adapter = new MyPageAdapter_fenlei(getChildFragmentManager(), class_list);
                viewPager.setAdapter(adapter);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tabLayout.setupWithViewPager(viewPager);
                    }
                });

            }
        });
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
