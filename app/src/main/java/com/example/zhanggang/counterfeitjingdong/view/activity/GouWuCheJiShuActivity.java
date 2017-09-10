package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.view.adapter.MyJiShuAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GouWuCheJiShuActivity extends AppCompatActivity implements XRecyclerView.LoadingListener{

    @BindView(R.id.quanxuan) TextView quanxuan;
    @BindView(R.id.fanxuan) TextView fanxuan;
    @BindView(R.id.recyclerview)
    XRecyclerView recyclerView;
    List<String> list = new ArrayList<>();
    HashMap<Integer, Boolean> hashMap = new HashMap<>();
    private MyJiShuAdapter adapter;
    @BindView(R.id.showTv)
    TextView showTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_che_ji_shu);
        ButterKnife.bind(this);

        init();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyJiShuAdapter(list,hashMap,this,showTv);
        recyclerView.setAdapter(adapter);

        //全选
        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<Map.Entry<Integer, Boolean>> entries = adapter.selectAll();
                int count=0;
                for (Map.Entry<Integer, Boolean> bean:entries) {
                    if (bean.getValue()==true){
                        count++;
                    }
                }
                showTv.setText("个数："+count+"");//赋值
            }
        });
        //反选
        fanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.selectFan();
            }
        });
        //调用adapter的计数接口
        adapter.setCounter1(new MyJiShuAdapter.countener() {
            @Override
            public void setCount(HashMap<Integer, Boolean> hashMap) {
                int i = 0;
                Set<Map.Entry<Integer, Boolean>> entries = hashMap.entrySet();
                for (Map.Entry<Integer, Boolean> bean: entries) {
                    if (bean.getValue()==true){
                        i++;
                    }
                }
                showTv.setText("个数："+i+"");//赋值
            }
        });
    }

    private void init() {
        for (int i = 0; i < 50; i++) {
            list.add("商品" + i);
            hashMap.put(i, false); //默认全不选中
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
    //上啦加载
    @Override
    public void onLoadMore() {
        init();
        adapter.notifyDataSetChanged();
        recyclerView.loadMoreComplete();
    }


}
