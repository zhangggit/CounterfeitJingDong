package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.view.adapter.FaXianRecyclerAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：发现页面  每个fragment 公用的
 * 时  间：2017/9/6 - 15:35.
 * 创建人：张刚
 */

public class FaXianTabFragment extends Fragment implements XRecyclerView.LoadingListener {

    @BindView(R.id.recyclerview_faxian)
    XRecyclerView xRecyclerView;
    private FaXianRecyclerAdapter adapter;
    List<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faxiantab_fragment, container, false);
        ButterKnife.bind(this, view);

        init();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new FaXianRecyclerAdapter(list);
        xRecyclerView.setAdapter(adapter);

        xRecyclerView.setLoadingListener(this);


        return view;
    }

    private void init() {
        for (int i = 0; i < 20; i++) {
            list.add("数据" + i);
        }
    }

    @Override
    public void onRefresh() {
        list.clear();
        init();
        adapter.notifyDataSetChanged();
        xRecyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        init();
        adapter.notifyDataSetChanged();
        xRecyclerView.loadMoreComplete();
    }
}
