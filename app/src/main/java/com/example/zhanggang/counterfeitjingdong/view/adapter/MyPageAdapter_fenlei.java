package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.zhanggang.counterfeitjingdong.model.bean.FenLeiBean;
import com.example.zhanggang.counterfeitjingdong.view.fragment.MyFragment_fenlei;

import java.util.ArrayList;
import java.util.List;

/**
 * 类作用：分类页面 viewpager适配器
 * 时  间：2017/9/12 - 22:42.
 * 创建人：张刚
 */

public class MyPageAdapter_fenlei extends FragmentPagerAdapter {
    List<FenLeiBean.DatasBean.ClassListBean> list = new ArrayList<>();

    public MyPageAdapter_fenlei(FragmentManager fm, List<FenLeiBean.DatasBean.ClassListBean> list) {
        super(fm);
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        //创建fragment
        MyFragment_fenlei myFragment = new MyFragment_fenlei();
        Bundle bundle = new Bundle();
        bundle.putString("id",list.get(position).getGc_id());//获取id传给fragment
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
    //设置tablayout的每个tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getGc_name();
    }

}
