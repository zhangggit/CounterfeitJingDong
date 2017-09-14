package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.GouWuData;
import com.example.zhanggang.counterfeitjingdong.view.adapter.MyJiShuAdapter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GouWuCheJiShuActivity extends AppCompatActivity{

    @BindView(R.id.quanxuan) TextView quanxuan;
    @BindView(R.id.fanxuan) TextView fanxuan;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    HashMap<Integer, Boolean> hashMap = new HashMap<>();
    private MyJiShuAdapter adapter;
    @BindView(R.id.showTv)
    TextView showTv;
    @BindView(R.id.showjiage)
    TextView showjiage;
    String urlPath="http://apiv3.yangkeduo.com/v5/newlist?page=1&%20size=1";
    private List<GouWuData.GoodsListBean> list1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_che_ji_shu);
        ButterKnife.bind(this);

        init();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyJiShuAdapter(list1,hashMap,this);
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
                showjiage.setText("价格："+count*10+"");
            }
        });
        //反选
        fanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<Map.Entry<Integer, Boolean>> entries = adapter.selectFan();
                int count=0;
                for (Map.Entry<Integer, Boolean> bean:entries) {
                    if (bean.getValue()==true){
                        count++;
                    }
                }
                showTv.setText("个数："+count+"");//赋值
                showjiage.setText("价格："+count*10+"");
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
                showTv.setText("个数："+i);//赋值
                showjiage.setText("价格："+i*10+"");
            }
        });
    }

    private void init() {
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                GouWuData gouWuData = new Gson().fromJson(response.body().string(), GouWuData.class);
                list1.addAll(gouWuData.goods_list);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <list1.size(); i++) {
                            hashMap.put(i, false); //默认全不选中
                        }
                    }
                });
            }
        });
    }

}
