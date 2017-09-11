package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：
 * 时  间：2017/9/11 - 15:59.
 * 创建人：张刚
 */

public class FenLeiRightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<String> list;
    GridView gridview;

    public FenLeiRightAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        switch (viewType){
            case 0:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fenlei_right_item, parent, false);
                holder=new ViewHolder(view);
               break;
            case 1:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fenlei_right_item2, parent, false);
                holder= new ViewHolder2(view);
                gridview=view.findViewById(R.id.fenlei_right_gridview);
                FenLeiGridViewAdapter gridViewAdapter = new FenLeiGridViewAdapter(context,list);
                gridview.setAdapter(gridViewAdapter);
                break;
        }
        return  holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ViewHolder mholder= (ViewHolder) holder;
        }else if (holder instanceof ViewHolder2){
            ViewHolder2 mholder= (ViewHolder2) holder;
            mholder.textView.setText(list.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fenlei_right_image1)
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        @BindView(R.id.fenlei_right_text)
        TextView textView;
        @BindView(R.id.fenlei_right_gridview)
        GridView gridView;
        public ViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
