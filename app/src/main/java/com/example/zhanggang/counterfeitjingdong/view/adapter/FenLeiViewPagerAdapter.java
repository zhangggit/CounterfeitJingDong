package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean2;
import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean3;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：分类页面 recyclerview的适配器
 * 时  间：2017/9/12 - 22:59.
 * 创建人：张刚
 */

public class FenLeiViewPagerAdapter extends RecyclerView.Adapter<FenLeiViewPagerAdapter.ViewHolder> {

    Activity context;
    List<FenLeiBean2.DatasBean.ClassListBean> list;
    String urlParh="http://169.254.142.217/mobile/index.php?act=goods_class&gc_id=";

    public FenLeiViewPagerAdapter(Activity context, List<FenLeiBean2.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fenlei_viewpager_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getGc_name());
        String gc_id = list.get(position).getGc_id();  //得到集合里的id
        UrlUtile.sendOkHttpRequest(urlParh + gc_id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FenLeiBean3 fenLeiBean3 = new Gson().fromJson(response.body().string(), FenLeiBean3.class);
                List<FenLeiBean3.DatasBean.ClassListBean> class_list = fenLeiBean3.getDatas().getClass_list();
                final FenLeiGridAdapter adapter = new FenLeiGridAdapter(context,class_list);  //recyclerview里的gridview
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        holder.gridView.setAdapter(adapter);
                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_title_fenlei)
        TextView textView;
        @BindView(R.id.gridview_fenlei)
        GridView gridView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
