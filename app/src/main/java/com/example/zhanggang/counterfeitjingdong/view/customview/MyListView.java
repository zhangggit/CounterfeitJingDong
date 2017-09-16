package com.example.zhanggang.counterfeitjingdong.view.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 类作用：自定义Lidtview解决和scrollview
 * 时  间：2017/9/13 - 16:20.
 * 创建人：张刚
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,//右移运算符，相当于除于4
                MeasureSpec.AT_MOST);//测量模式取最大值
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);//重新测量高度
    }
}
