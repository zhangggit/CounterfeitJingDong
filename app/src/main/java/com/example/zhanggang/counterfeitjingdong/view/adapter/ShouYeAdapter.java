package com.example.zhanggang.counterfeitjingdong.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类作用：
 * 时  间：2017/9/6 - 14:54.
 * 创建人：张刚
 */

public class ShouYeAdapter extends FragmentPagerAdapter {

    List<Fragment> list;

    public ShouYeAdapter(FragmentManager fm, List<Fragment> list) {
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
