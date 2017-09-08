package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类作用：首页viewpager适配器
 * 时  间：2017/9/8 - 16:06.
 * 创建人：张刚
 */

public class ShouYeViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> list;
    public ShouYeViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
