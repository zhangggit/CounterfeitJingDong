package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean3;

import java.util.List;

/**
 * 类作用：分类页面recyclerview里gridview适配器
 * 时  间：2017/9/12 - 23:16.
 * 创建人：张刚
 */

public class FenLeiGridAdapter extends BaseAdapter {
    Context context;
    List<FenLeiBean3.DatasBean.ClassListBean> list;
    public FenLeiGridAdapter(Context context, List<FenLeiBean3.DatasBean.ClassListBean> list) {
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
        if(view==null){
            view = View.inflate(context, R.layout.fenlei_grid_item,null);
            //获取id赋值
            TextView tv = view.findViewById(R.id.tv);
            ImageView iv = view.findViewById(R.id.iv);
            tv.setText(list.get(i).getGc_name());
            iv.setImageResource(R.mipmap.ic_launcher);
        }
        return view;
    }
}
