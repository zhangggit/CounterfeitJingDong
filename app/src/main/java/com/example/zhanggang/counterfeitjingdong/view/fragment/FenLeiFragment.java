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
import com.example.zhanggang.counterfeitjingdong.view.adapter.FenLeiLeftAdapter;
import com.example.zhanggang.counterfeitjingdong.view.adapter.FenLeiRightAdapter;
import com.library.zxing.activity.QRCodeScanFragment;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    List<String> list = new ArrayList<>();
    @BindView(R.id.main_right_rv)
    RecyclerView recyclerView;
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    private FenLeiRightAdapter rightAdapter;
    private FenLeiLeftAdapter leftAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fen_lei_fragment, container, false);
        ButterKnife.bind(this,view);

        init();
        //左边listview
        leftAdapter = new FenLeiLeftAdapter(getActivity(), list);
        listView.setAdapter(leftAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i%2==0){
                   rightAdapter = new FenLeiRightAdapter(getActivity(),list1);
                    recyclerView.setAdapter(rightAdapter);
                }else{
                    rightAdapter= new FenLeiRightAdapter(getActivity(),list2);
                    recyclerView.setAdapter(rightAdapter);
                }
                rightAdapter.notifyDataSetChanged();
                leftAdapter.setCurrentItem(i);
                leftAdapter.setClick(true);
                leftAdapter.notifyDataSetChanged();
            }
        });
        init1();
        init2();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        rightAdapter = new FenLeiRightAdapter(getActivity(),list1);
        recyclerView.setAdapter(rightAdapter);

        return view;
    }

    private void init1() {
        for (int i = 0; i < 10; i++) {
            list1.add("数据"+i);
        }
    }
    private void init2() {
        for (int i = 0; i < 10; i++) {
            list2.add("不一样的数据"+i);
        }
    }

    //添加左边listview的数据
    private void init() {
        list.add("推荐分类");list.add("京东超市");list.add("国际名牌");list.add("奢侈品");list.add("全球购");list.add("男装");
        list.add("女装");list.add("男鞋");list.add("女鞋");list.add("内衣配饰");list.add("箱包手货");list.add("美妆个护");
        list.add("钟表珠宝");list.add("手机数码");list.add("电脑办公");list.add("家用电器");list.add("食品生鲜");list.add("酒水饮料");
        list.add("母婴童装");list.add("玩具乐器");list.add("医药保健");list.add("计生情趣");list.add("运动户外");list.add("汽车用品");
        list.add("家居厨具");list.add("家具家装");list.add("礼品鲜花");list.add("宠物生活");list.add("生活旅行");list.add("图书音响");
        list.add("邮币");list.add("农资绿植");list.add("特产馆");list.add("京东金融");list.add("拍卖");list.add("二手商品");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
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
