package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：
 * 时  间：2017/9/10 - 19:27.
 * 创建人：张刚
 */

public class MyJiShuAdapter extends RecyclerView.Adapter<MyJiShuAdapter.ViewHolder>  {

    List<String> list;
    HashMap<Integer, Boolean> hashMap;
    Context context;

    countener counter1;
    public void setCounter1(countener counter1) {
        this.counter1 = counter1;
    }

    public MyJiShuAdapter(List<String> list, HashMap<Integer, Boolean> hashMap, Context context) {
        this.list = list;
        this.hashMap = hashMap;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gouwu_jishu, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.shangping.setText(list.get(position));
        holder.gouwujishu_imageview.setImageResource(R.drawable.timg);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hashMap.put(position, !hashMap.get(position)); //点击一次 就把它设成自己的反值
                notifyDataSetChanged();

                if (counter1!=null){
                    counter1.setCount(hashMap); //回传hashmap集合
                }

            }
        });
        //将状态赋给checkbox
        holder.checkBox.setChecked(hashMap.get(position));
    }

    //全选方法
    public Set<Map.Entry<Integer, Boolean>> selectAll() {
        Set<Map.Entry<Integer, Boolean>> entries = hashMap.entrySet();  //得到集合
        boolean isSelected = false;   //保存当前的状态
        for (Map.Entry<Integer, Boolean> bean : entries) {
            Boolean value = bean.getValue();
            if (!value) { //只要有一个是未选中  就都设成 true
                isSelected = true;
                break;
            }
        }
        for (Map.Entry<Integer, Boolean> bean : entries) {
            bean.setValue(isSelected);
            notifyDataSetChanged();
        }
        return entries;  //返回hashset集合 用于点击全选时 计算选中多选框的数量
    }

    //反选方法
    public void selectFan() {
        Set<Map.Entry<Integer, Boolean>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Boolean> bean : entries) {
            bean.setValue(!bean.getValue());
            notifyDataSetChanged();
        }
    }
    //接口 用于点击多选框时 计算多选框选中的数量
    public interface countener{
        void setCount(HashMap<Integer, Boolean> hashMap);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gouwujishu_imageview)
        ImageView gouwujishu_imageview;
        @BindView(R.id.shangping)
        TextView shangping;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            checkBox=itemView.findViewById(R.id.check_box);
        }
    }
}
