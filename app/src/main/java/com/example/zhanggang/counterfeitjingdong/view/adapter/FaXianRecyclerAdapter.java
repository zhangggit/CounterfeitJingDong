package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.bean.FaXianBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：发现页面  每个item的适配器
 * 时  间：2017/9/7 - 17:06.
 * 创建人：张刚
 */

public class FaXianRecyclerAdapter extends XRecyclerView.Adapter<FaXianRecyclerAdapter.ViewHolder> {

    Context context;
    List<FaXianBean.DataBean.ProductsBean> list;

    public FaXianRecyclerAdapter(Context context,List<FaXianBean.DataBean.ProductsBean> list) {
        this.context=context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.faxian_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //赋值
        holder.name.setText(list.get(position).name);
        holder.jiesao.setText(list.get(position).short_description);
        Glide.with(context).load(list.get(position).image_small).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder {
        @BindView(R.id.faxian_item_textview_name)
        TextView name;
        @BindView(R.id.faxian_item_textview2)
        TextView jiesao;
        @BindView(R.id.faxian_item_image)
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
