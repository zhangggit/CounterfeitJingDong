package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.view.activity.GouWuCheJiShuActivity;
import com.example.zhanggang.counterfeitjingdong.view.adapter.GouWuCheRecyclerAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：购物车页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */

public class GouWuCheFragment extends Fragment implements XRecyclerView.LoadingListener {

    @BindView(R.id.recyclerview_gouwuche)
    XRecyclerView recyclerView;
    List<String> list = new ArrayList<>();
    private GouWuCheRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_gou_wu_che_fragment, container, false);
        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new GouWuCheRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLoadingListener(this);
        //点击跳转购物车计数页
        adapter.setOnClickItemLener(new GouWuCheRecyclerAdapter.onClickItemLener() {
            @Override
            public void setOnClickItemLener(View view, int position) {
                Intent intent = new Intent(getActivity(), GouWuCheJiShuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        for (int i = 0; i < 100; i++) {
            list.add("名字" + i);
        }
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        list.clear();
        init();
        adapter.notifyDataSetChanged();
        recyclerView.refreshComplete();
    }

    //加载更多
    @Override
    public void onLoadMore() {
        init();
        adapter.notifyDataSetChanged();
        recyclerView.loadMoreComplete();
    }
}
