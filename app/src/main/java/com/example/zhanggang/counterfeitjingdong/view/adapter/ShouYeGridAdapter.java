package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;

import java.util.List;

/**
 * 类作用：
 * 时  间：2017/9/12 - 13:42.
 * 创建人：张刚
 */

public class ShouYeGridAdapter extends BaseAdapter {

    Context context;
    List<String> list;

    public ShouYeGridAdapter(Context context, List<String> list) {
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
        ViewHolder holder=null;
        if (view==null){
            view=View.inflate(context, R.layout.shouye_grid_item,null);
            holder=new ViewHolder();
            holder.textView=view.findViewById(R.id.shouye_item_name);
            holder.textView2=view.findViewById(R.id.shouye_item_jiesao);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.textView.setText(list.get(i));
        return view;
    }
    class ViewHolder{
        TextView textView,textView2;
        ImageView imageView;
    }
}
