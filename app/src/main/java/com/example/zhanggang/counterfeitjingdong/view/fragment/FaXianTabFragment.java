package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.FaXianBean;
import com.example.zhanggang.counterfeitjingdong.view.adapter.FaXianRecyclerAdapter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：发现页面  每个fragment 公用的
 * 时  间：2017/9/6 - 15:35.
 * 创建人：张刚
 */

public class FaXianTabFragment extends Fragment implements XRecyclerView.LoadingListener {

    @BindView(R.id.recyclerview_faxian)
    XRecyclerView xRecyclerView;
    private FaXianRecyclerAdapter adapter;

    String urlPath="http://api.eleteam.com/v1/product/list-featured-topic";
    List<FaXianBean.DataBean.ProductsBean> list1 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faxiantab_fragment, container, false);
        ButterKnife.bind(this, view);

        init1();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new FaXianRecyclerAdapter(getActivity(),list1);
        xRecyclerView.setAdapter(adapter);

        xRecyclerView.setLoadingListener(this);

        return view;
    }

    private void init1() {
        //网络请求数据
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {FaXianBean faXianBean = new Gson().fromJson(response.body().string(), FaXianBean.class);
                list1.addAll(faXianBean.data.products);
            }
        });
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        list1.clear();
        init1();
        adapter.notifyDataSetChanged();
        xRecyclerView.refreshComplete();
    }
    //加载数据
    @Override
    public void onLoadMore() {
        init1();
        adapter.notifyDataSetChanged();
        xRecyclerView.loadMoreComplete();
    }
}
