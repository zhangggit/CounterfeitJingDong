package com.example.zhanggang.counterfeitjingdong.view.IView;


import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe2;

/**
 * 类作用：
 * 时  间：2017/9/16 - 9:22.
 * 创建人：张刚
 */

public interface Regidter2View extends IView{
    void onDateSucced(ZhuCe2 zhuCe2);
    void onDateFailed(String ex);
}
