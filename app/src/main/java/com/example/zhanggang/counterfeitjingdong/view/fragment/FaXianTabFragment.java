package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.content.Context;
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
import com.example.zhanggang.counterfeitjingdong.presenter.GetFaXianDataPresenter;
import com.example.zhanggang.counterfeitjingdong.view.IView.GetFaXianView;
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

public class FaXianTabFragment extends Fragment implements XRecyclerView.LoadingListener,GetFaXianView{

    @BindView(R.id.recyclerview_faxian)
    XRecyclerView xRecyclerView;
    private FaXianRecyclerAdapter adapter;

    private List<FaXianBean.DataBean.ProductsBean> products;
    private GetFaXianDataPresenter getFaXianDataPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faxiantab_fragment, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecyclerView.setLayoutManager(linearLayoutManager);

        xRecyclerView.setLoadingListener(this);
        //创建presenter
        getFaXianDataPresenter = new GetFaXianDataPresenter(this);
        getFaXianDataPresenter.getFaXianData();  //请求 执行

        return view;
    }
    //下拉刷新
    @Override
    public void onRefresh() {
        products.clear();
        getFaXianDataPresenter.getFaXianData();
        adapter.notifyDataSetChanged();
        xRecyclerView.refreshComplete();
    }
    //加载数据
    @Override
    public void onLoadMore() {
        getFaXianDataPresenter.getFaXianData();
        adapter.notifyDataSetChanged();
        xRecyclerView.loadMoreComplete();
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onGetDataSucced(final FaXianBean faXianBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                products = faXianBean.data.products;  //获得对象中的集合  需要的集合
                //设置适配器
                adapter = new FaXianRecyclerAdapter(getActivity(), products);
                xRecyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onGetDataFailed(String ex) {

    }
}
