package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean2;

import java.util.List;

/**
 * 类作用：
 * 时  间：2017/9/11 - 17:00.
 * 创建人：张刚
 */

public class FenLeiGridViewAdapter extends BaseAdapter {

    Context context;
    List<FenLeiBean.DatasBean.ClassListBean> fenleiList;
    public FenLeiGridViewAdapter(Context context,List<FenLeiBean.DatasBean.ClassListBean> fenleiList) {
        this.context = context;
        this.fenleiList=fenleiList;
    }

    @Override
    public int getCount() {
        return fenleiList.size();
    }

    @Override
    public Object getItem(int i) {
        return fenleiList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view==null){
            view=View.inflate(context, R.layout.fenlei_right_grid_item,null);
            holder=new ViewHolder();
            holder.textView=view.findViewById(R.id.gridview_text);
            holder.imageView=view.findViewById(R.id.gridview_image);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.textView.setText(fenleiList.get(i).gc_name);
        String imagestring = fenleiList.get(i).image;
        String replaceAll = imagestring.replaceAll("127.0.0.1", "169.254.60.203");
        Log.e("TAG", "getView: "+replaceAll);
//        Glide.with(context).load(replaceAll).into(holder.imageView);
        return view;
    }
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

}
