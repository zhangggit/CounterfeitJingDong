package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.bean.GouWuData;
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

    Context context;
    List<GouWuData.GoodsListBean> list;
    onClickItemLener onClickItemLener;
    onClickItemTJlener onClickItemTJlener;

    public GouWuCheRecyclerAdapter(Context context,List<GouWuData.GoodsListBean> list) {
        this.context=context;
        this.list = list;
    }
    public void setOnClickItemTJlener(GouWuCheRecyclerAdapter.onClickItemTJlener onClickItemTJlener) {
        this.onClickItemTJlener = onClickItemTJlener;
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
        final String name = list.get(position).goods_name; //获取名字
        holder.name.setText(name);
        final int price = list.get(position).normal_price; //获取价格
        holder.gouwuche_jiage.setText("￥"+price);
        final String imageUrl = list.get(position).image_url; //获取图片
        Glide.with(context).load(imageUrl).into(holder.imageView);
        //点击添加购物车
        holder.tianjia.setOnClickListener(new View.OnClickListener() {
            @Override//调用接口
            public void onClick(View view) {
                if (onClickItemTJlener!=null){
                    onClickItemTJlener.setOnClickTJLener(view,name,price,imageUrl);
                }
            }
        });
        //点击事件 跳转购物车计算页面
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override//调用接口
            public void onClick(View view) {
                if (onClickItemLener!=null){
                    onClickItemLener.setOnClickItemLener(view,position);
                }
            }
        });
    }

    //点击添加购物车
    public interface onClickItemTJlener{
        void setOnClickTJLener(View view,String name,int price,String imageUrl);
    }
    //点击图片
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
        @BindView(R.id.gouwuche_jiage)
        TextView gouwuche_jiage;
        @BindView(R.id.gwc_tianjia)
        ImageView tianjia;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
