package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean2;
import com.example.zhanggang.counterfeitjingdong.view.adapter.FenLeiLeftAdapter;
import com.example.zhanggang.counterfeitjingdong.view.adapter.FenLeiRightAdapter;
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

/**
 * 类作用：分类页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class FenLeiFragment extends QRCodeScanFragment {

    @BindView(R.id.on_erweima_fenlei)
    ImageView on_erweima_fenlei;
    @BindView(R.id.main_left_rv)
    ListView listView;
    @BindView(R.id.main_right_rv)
    RecyclerView recyclerView;
//    List<String> list1 = new ArrayList<>();
//    List<String> list2 = new ArrayList<>();
    private FenLeiRightAdapter rightAdapter;
    private FenLeiLeftAdapter leftAdapter;

    String zuoPath="http://169.254.60.203/mobile/index.php?act=goods_class";
    String zuoPath2="http://169.254.60.203/mobile/index.php?act=goods_class&gc_id=6";
    List<FenLeiBean.DatasBean.ClassListBean> fenleiList = new ArrayList<>();
    List<String> fenleiIDList = new ArrayList<>();
    List<FenLeiBean2.DatasBean.ClassListBean> fenleiList2 = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fen_lei_fragment, container, false);
        ButterKnife.bind(this, view);

        //网络请求 获取左边listview的名字
        initDataLeft();
        initDataLeft2();

        //左边listview
        leftAdapter = new FenLeiLeftAdapter(getActivity(), fenleiList);
        listView.setAdapter(leftAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if (i % 2 == 0) {
                    rightAdapter = new FenLeiRightAdapter(getActivity(), fenleiList2,fenleiList);
                    recyclerView.setAdapter(rightAdapter);
                } else {
                    rightAdapter = new FenLeiRightAdapter(getActivity(), fenleiList2,fenleiList);
                    recyclerView.setAdapter(rightAdapter);
                }
                rightAdapter.notifyDataSetChanged();
                leftAdapter.setCurrentItem(i);
                leftAdapter.setClick(true);
                leftAdapter.notifyDataSetChanged();
            }
        });
//        init1();
//        init2();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        rightAdapter = new FenLeiRightAdapter(getActivity(), fenleiList2,fenleiList);
        recyclerView.setAdapter(rightAdapter);

        return view;
    }
    private void initDataLeft2() {
        UrlUtile.sendOkHttpRequest(zuoPath2, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FenLeiBean2 fenLeiBean = new Gson().fromJson(response.body().string(), FenLeiBean2.class);
                fenleiList2.addAll(fenLeiBean.datas.class_list);
            }
        });
    }

    //网络请求 获取左边listview的名字
    private void initDataLeft() {
        UrlUtile.sendOkHttpRequest(zuoPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FenLeiBean fenLeiBean = new Gson().fromJson(response.body().string(), FenLeiBean.class);
                fenleiList.addAll(fenLeiBean.datas.class_list);
                for (FenLeiBean.DatasBean.ClassListBean bean:fenleiList) {
                    String gc_id = bean.getGc_id();
                    fenleiIDList.add(gc_id);
                }
            }
        });
    }

//    private void init1() {
//        for (int i = 0; i < 10; i++) {
//            list1.add("数据" + i);
//        }
//    }
//
//    private void init2() {
//        for (int i = 0; i < 10; i++) {
//            list2.add("不一样的数据" + i);
//        }
//    }
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
