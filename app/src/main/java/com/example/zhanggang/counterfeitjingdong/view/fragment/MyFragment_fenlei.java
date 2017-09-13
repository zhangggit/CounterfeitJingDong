package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean2;
import com.example.zhanggang.counterfeitjingdong.view.adapter.FenLeiViewPagerAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：分类页面 每个fragment
 * 时  间：2017/9/12 - 22:45.
 * 创建人：张刚
 */

public class MyFragment_fenlei extends Fragment {

    @BindView(R.id.recyclerview_fenlei)
    RecyclerView recyclerView;
    private int id;
    String urlPath="http://169.254.142.217/mobile/index.php?act=goods_class&gc_id=";
    private FenLeiViewPagerAdapter myAdapter;
    private String str;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        //得到传过来的id
        str = arguments.getString("id");
//        id = Integer.valueOf(str).intValue();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fenlei_item, container, false);
        ButterKnife.bind(this,inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        initData();
    }

    private void initData() {
        UrlUtile.sendOkHttpRequest(urlPath+str, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json = response.body().string();
                Gson gson = new Gson();
                FenLeiBean2 fenleiInfo2 = gson.fromJson(json, FenLeiBean2.class);
                final List<FenLeiBean2.DatasBean.ClassListBean> list = fenleiInfo2.getDatas().getClass_list();//获取集合
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //分类页面viewpager的fragment里recyclerview的适配器
                        myAdapter = new FenLeiViewPagerAdapter(getActivity(),list);
                        recyclerView.setAdapter(myAdapter);
                        myAdapter.notifyDataSetChanged();
                    }
                });

            }
        });
    }
}
