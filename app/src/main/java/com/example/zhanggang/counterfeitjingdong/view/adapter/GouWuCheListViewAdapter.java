package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.bean.GouWuHuiDiao;

import java.util.List;

/**
 * 类作用：购物车上面listview的适配器
 * 时  间：2017/9/13 - 15:37.
 * 创建人：张刚
 */

public class GouWuCheListViewAdapter extends BaseAdapter {

    Context context;
    List<GouWuHuiDiao> list;

    public GouWuCheListViewAdapter(Context context, List<GouWuHuiDiao> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=View.inflate(context, R.layout.gouwuche_list_item,null);
        //找到控件
        TextView textView = view.findViewById(R.id.gwc_item_text);
        TextView textView_price = view.findViewById(R.id.gwc_item_text2);
        ImageView image = view.findViewById(R.id.gwc_item_image);
        //赋值
        textView.setText(list.get(i).getName());
        textView_price.setText("￥"+list.get(i).getPrice());
        Glide.with(context).load(list.get(i).getImageUrl()).into(image);
        return view;
    }
}
