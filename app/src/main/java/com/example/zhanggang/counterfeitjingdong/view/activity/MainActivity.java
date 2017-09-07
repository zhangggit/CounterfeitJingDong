package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.view.adapter.ShouYeAdapter;
import com.example.zhanggang.counterfeitjingdong.view.fragment.FaXianFtagment;
import com.example.zhanggang.counterfeitjingdong.view.fragment.FenLeiFragment;
import com.example.zhanggang.counterfeitjingdong.view.fragment.GouWuCheFragment;
import com.example.zhanggang.counterfeitjingdong.view.fragment.ShouYeFragment;
import com.example.zhanggang.counterfeitjingdong.view.fragment.WoDeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 类作用：主类 fragment radiogroup联动
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.radiogroup)
    RadioGroup radioGroup;

    private ShouYeFragment shouYeFragment;
    private FenLeiFragment fenLeiFragment;
    private FaXianFtagment faXianFtagment;
    private GouWuCheFragment gouWuCheFragment;
    private WoDeFragment woDeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        shouYeFragment = new ShouYeFragment();
        fenLeiFragment = new FenLeiFragment();
        faXianFtagment = new FaXianFtagment();
        gouWuCheFragment = new GouWuCheFragment();
        woDeFragment = new WoDeFragment();
        //加载fragment
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_main, fenLeiFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_main, faXianFtagment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_main, gouWuCheFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_main, woDeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_main, shouYeFragment).commit();
        //默认显示页面
        getSupportFragmentManager().beginTransaction().show(shouYeFragment)
                .hide(fenLeiFragment).hide(faXianFtagment).hide(gouWuCheFragment).hide(woDeFragment).commit();
        //点击切换页面
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.radiobutton_shouye:
                        getSupportFragmentManager().beginTransaction().show(shouYeFragment)
                                .hide(fenLeiFragment).hide(faXianFtagment).hide(gouWuCheFragment).hide(woDeFragment).commit();
                        break;
                    case R.id.radiobutton_fenlei:
                        getSupportFragmentManager().beginTransaction().show(fenLeiFragment)
                                .hide(shouYeFragment).hide(faXianFtagment).hide(gouWuCheFragment).hide(woDeFragment).commit();
                        break;
                    case R.id.radiobutton_faxian:
                        getSupportFragmentManager().beginTransaction().show(faXianFtagment)
                                .hide(fenLeiFragment).hide(shouYeFragment).hide(gouWuCheFragment).hide(woDeFragment).commit();
                        break;
                    case R.id.radiobutton_gouwuche:
                        getSupportFragmentManager().beginTransaction().show(gouWuCheFragment)
                                .hide(fenLeiFragment).hide(faXianFtagment).hide(shouYeFragment).hide(woDeFragment).commit();
                        break;
                    case R.id.radiobutton_wode:
                        getSupportFragmentManager().beginTransaction().show(woDeFragment)
                                .hide(fenLeiFragment).hide(faXianFtagment).hide(gouWuCheFragment).hide(shouYeFragment).commit();
                        break;
                    default:
                        break;
                }
            }
        });


    }


}
