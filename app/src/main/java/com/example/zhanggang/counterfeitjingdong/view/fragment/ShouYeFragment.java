package com.example.zhanggang.counterfeitjingdong.view.fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.GlideImageLoader;
import com.example.zhanggang.counterfeitjingdong.model.bean.ShouYeGridData;
import com.example.zhanggang.counterfeitjingdong.presenter.GetNetworkDataPresenter;
import com.example.zhanggang.counterfeitjingdong.view.IView.IGetNetworkData;
import com.example.zhanggang.counterfeitjingdong.view.adapter.ShouYeGridAdapter;
import com.example.zhanggang.counterfeitjingdong.view.adapter.ShouYeViewPagerAdapter;
import com.youth.banner.Banner;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：首页 第一个页面
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */

//实现View层接口
public class ShouYeFragment extends Fragment implements IGetNetworkData{

    private Banner banner;
    @BindView(R.id.viewpager_shouye)
    ViewPager viewPager;
    @BindView(R.id.readiogroup_shouye)
    RadioGroup radioGroup;
    private List<String> images = new ArrayList<>();
    private List<Fragment> list = new ArrayList<>();
    @BindView(R.id.shouye_gridview)
    GridView gridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shou_ye_fragment, container, false);
        ButterKnife.bind(this,view);

        setImages();
        setBanner(view);
        setFragment();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //默认选中
        RadioButton radioButton = (RadioButton) radioGroup.getChildAt(0);
        radioButton.setChecked(true);
        //viewpager适配器
        ShouYeViewPagerAdapter viewPagerAdapter = new ShouYeViewPagerAdapter(getActivity().getSupportFragmentManager(),list);
        viewPager.setAdapter(viewPagerAdapter);
        //viewpager滑动监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RadioButton childAt_but = (RadioButton) radioGroup.getChildAt(position);
                childAt_but.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //创建Presenter
        GetNetworkDataPresenter getNetworkDataPresenter = new GetNetworkDataPresenter(this);
        getNetworkDataPresenter.getNetWorkData();

    }
    //设置两个滑动viewpager的fragment
    private void setFragment() {
        SYViewPagerFragment1 syViewPagerFragment1 = new SYViewPagerFragment1();
        SYViewPagerFragment2 syViewPagerFragment2 = new SYViewPagerFragment2();
        list.add(syViewPagerFragment1);
        list.add(syViewPagerFragment2);
    }
    //设置Banner轮播
    private void setBanner(View view) {
        banner = view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);

        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
    //设置banner轮播的图片集合
    private void setImages() {
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311979&di=b34a790a363061b61ebbdc4cdcb05526&imgtype=0&src=http%3A%2F%2Fpicyun.90sheji.com%2Fdesign%2F00%2F03%2F49%2F64%2Fs_1024_54ed221172712.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311979&di=881b57bc4fe86eed1b6bbbef701d6e9d&imgtype=0&src=http%3A%2F%2Fp7.zbjimg.com%2Fservice%2F2016-05%2F07%2Fservice%2F572d53d6aa29c.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780733943&di=8cf4d7d72b85740d6570029a1f2639ac&imgtype=0&src=http%3A%2F%2Fimg11.360buyimg.com%2Fcms%2Fjfs%2Ft244%2F181%2F918959068%2F708384%2F3aa97b0f%2F53f3fc52Nb3ea7aa9.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311979&di=17ba9a0b5d37ca11ba92a7086be4bec7&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F12%2F82%2F64%2F21b1OOOPICa6.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780402170&di=a68c315bcd6e1f1f53bc4199150c4955&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D647556253%2C2324393888%26fm%3D214%26gp%3D0.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311979&di=ed2f0a45d3007f733a1bfdc460976b2b&imgtype=0&src=http%3A%2F%2Fimages2015.cnblogs.com%2Fblog%2F1046195%2F201610%2F1046195-20161028141024062-613721819.png");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311978&di=89faa4b9459c01c05aa377d0d531352a&imgtype=0&src=http%3A%2F%2Fpic118.nipic.com%2Ffile%2F20161215%2F20494655_204817750001_2.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504780311977&di=d3579c25eb74b8b60b17c2eea10251ce&imgtype=0&src=http%3A%2F%2Fimg.aiimg.com%2Fuploads%2Fallimg%2F150711%2F1-150G1121R8.jpg");
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void OnGetNetworkDataSucced(final ShouYeGridData shouYeGridData) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //从对象中获取要用到的集合
                List<ShouYeGridData.DataBean.ProductsBean> products = shouYeGridData.getData().getProducts();
                //设置适配器
                ShouYeGridAdapter gridAdapter = new ShouYeGridAdapter(getActivity(),products);
                gridView.setAdapter(gridAdapter);
            }
        });

    }

    @Override
    public void OnGetNetworkDataFailed(String ex) {

    }
}
