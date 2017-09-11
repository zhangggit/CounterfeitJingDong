package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;

import java.util.List;

import static android.support.constraint.R.id.parent;

/**
 * 类作用：//分类页面 左边listview的适配器
 * 时  间：2017/9/11 - 15:27.
 * 创建人：张刚
 */

public class FenLeiLeftAdapter extends BaseAdapter{
    private int mCurrentItem=0;
    private boolean isClick=false;
    Context context;
    List<String> list;

    public FenLeiLeftAdapter(Context context, List<String> list) {
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
        if (view==null){
            view=View.inflate(context,R.layout.fenlei_left_item,null);
            holder=new ViewHolder();
            holder.textView=view.findViewById(R.id.fenlei_item_zuo_textview);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.textView.setText(list.get(i));

        if (mCurrentItem==i&&isClick){  //选中
            view.setBackgroundColor(Color.parseColor("#3F51B5"));
            holder.textView.setTextColor(Color.parseColor("#ff6600"));
        }else{    //未选中
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }
        return view;
    }
    //背景色
    public void setCurrentItem(int currentItem){
        this.mCurrentItem=currentItem;
    }
    //字体颜色
    public void setClick(boolean click){
        this.isClick=click;
    }
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
