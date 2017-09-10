package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：购物车适配器
 * 时  间：2017/9/7 - 16:08.
 * 创建人：张刚
 */

public class GouWuCheRecyclerAdapter extends XRecyclerView.Adapter<GouWuCheRecyclerAdapter.ViewHolder> {

    List<String> list;
    onClickItemLener onClickItemLener;

    public GouWuCheRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    public void setOnClickItemLener(GouWuCheRecyclerAdapter.onClickItemLener onClickItemLener) {
        this.onClickItemLener = onClickItemLener;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gouwuche_recycler_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText(list.get(position));
        //点击事件 跳转购物车计算页面
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickItemLener!=null){
                    onClickItemLener.setOnClickItemLener(view,position);
                }
            }
        });
    }

    public interface onClickItemLener{
        void setOnClickItemLener(View view,int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder {
        @BindView(R.id.gouwuche_image)
        ImageView imageView;
        @BindView(R.id.gouwuche_name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
