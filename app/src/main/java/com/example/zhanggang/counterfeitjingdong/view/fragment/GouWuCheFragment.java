package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanggang.counterfeitjingdong.R;
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

        init();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new GouWuCheRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLoadingListener(this);

        return view;
    }

    private void init() {
        for (int i = 0; i < 100; i++) {
            list.add("名字" + i);
        }
    }

    @Override
    public void onRefresh() {
        list.clear();
        init();
        adapter.notifyDataSetChanged();
        recyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        init();
        adapter.notifyDataSetChanged();
        recyclerView.loadMoreComplete();
    }
}
