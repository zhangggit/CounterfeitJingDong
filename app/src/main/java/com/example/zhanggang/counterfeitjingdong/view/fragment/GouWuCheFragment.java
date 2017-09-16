package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.GouWuData;
import com.example.zhanggang.counterfeitjingdong.model.bean.GouWuHuiDiao;
import com.example.zhanggang.counterfeitjingdong.view.activity.GouWuCheJiShuActivity;
import com.example.zhanggang.counterfeitjingdong.view.adapter.GouWuCheListViewAdapter;
import com.example.zhanggang.counterfeitjingdong.view.adapter.GouWuCheRecyclerAdapter;
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
 * 类作用：购物车页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */

public class GouWuCheFragment extends Fragment implements XRecyclerView.LoadingListener {

    @BindView(R.id.recyclerview_gouwuche)
    XRecyclerView recyclerView;

    List<GouWuData.GoodsListBean> list = new ArrayList<>();
    private GouWuCheRecyclerAdapter adapter;

    List<GouWuHuiDiao> list1 = new ArrayList<>();
    @BindView(R.id.gouwuche_listview)
    ListView listView;
    String urlPath = "http://apiv3.yangkeduo.com/v5/newlist?page=1&%20size=";
    int size = 1;

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

        adapter = new GouWuCheRecyclerAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLoadingListener(this);

        //点击添加到购物车
        adapter.setOnClickItemTJlener(new GouWuCheRecyclerAdapter.onClickItemTJlener() {
            @Override
            public void setOnClickTJLener(View view, String name, int price, String imageUrl) {
                //将回传回来的商品信息赋值给一个对下
                final GouWuHuiDiao gouWuHuiDiao = new GouWuHuiDiao(name, price, imageUrl);
                list1.add(gouWuHuiDiao);  //将对象赋值给对象  再传给listview适配器
                //上边的listview
                GouWuCheListViewAdapter listViewAdapter = new GouWuCheListViewAdapter(getActivity(), list1);
                listView.setAdapter(listViewAdapter);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getActivity(), GouWuCheJiShuActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        //点击跳转购物车计数页
        adapter.setOnClickItemLener(new GouWuCheRecyclerAdapter.onClickItemLener() {
            @Override
            public void setOnClickItemLener(View view, int position) {
                Intent intent = new Intent(getActivity(), GouWuCheJiShuActivity.class);
                startActivity(intent);
            }
        });
    }

    //网络请求
    private void init() {
        UrlUtile.sendOkHttpRequest(urlPath + size, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                GouWuData gouWuData = new Gson().fromJson(response.body().string(), GouWuData.class);
                list.addAll(gouWuData.goods_list);
            }
        });
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
        size++;
        init();
        adapter.notifyDataSetChanged();
        recyclerView.loadMoreComplete();
    }
}
