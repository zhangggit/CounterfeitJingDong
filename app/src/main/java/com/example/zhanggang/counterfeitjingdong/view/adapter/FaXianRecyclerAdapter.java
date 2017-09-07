package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：
 * 时  间：2017/9/7 - 17:06.
 * 创建人：张刚
 */

public class FaXianRecyclerAdapter extends XRecyclerView.Adapter<FaXianRecyclerAdapter.ViewHolder> {

    List<String> list;

    public FaXianRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.faxian_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder{
        @BindView(R.id.faxian_item_textview)
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
