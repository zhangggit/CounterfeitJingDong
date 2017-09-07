package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanggang.counterfeitjingdong.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FaXianFtagment extends Fragment {

    @BindView(R.id.tablayout_faxian) TabLayout tabLayout;
    @BindView(R.id.viewpager_faxian) ViewPager viewPager;
    String [] title ={"精选","直播","订阅","视频购","问答","清单","社区","生活","数码","亲子","风尚","美食"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fa_xian_ftagment,container,false);
        ButterKnife.bind(this,view);

        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new FaXianTabFragment();
            }

            @Override
            public int getCount() {
                return title.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);


        return view;
    }
}
