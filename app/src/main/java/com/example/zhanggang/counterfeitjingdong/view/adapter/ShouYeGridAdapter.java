package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.bean.ShouYeGridData;

import java.util.List;

/**
 * 类作用：首页gridview的适配器
 * 时  间：2017/9/12 - 13:42.
 * 创建人：张刚
 */

public class ShouYeGridAdapter extends BaseAdapter {

    Context context;
    List<ShouYeGridData.DataBean.ProductsBean> list;

    public ShouYeGridAdapter(Context context, List<ShouYeGridData.DataBean.ProductsBean> list) {
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
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.shouye_grid_item, null);
            holder = new ViewHolder();
            //获取控件
            holder.textView = view.findViewById(R.id.shouye_item_name);
            holder.textView2 = view.findViewById(R.id.shouye_item_jiesao);
            holder.imageView = view.findViewById(R.id.shouye_item_image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //赋值
        holder.textView.setText(list.get(i).name);
        holder.textView2.setText(list.get(i).short_description);
        Glide.with(context).load(list.get(i).image_small).into(holder.imageView);
        return view;
    }

    //内部类
    class ViewHolder {
        TextView textView, textView2;
        ImageView imageView;
    }
}
