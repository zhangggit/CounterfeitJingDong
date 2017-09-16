package com.example.zhanggang.counterfeitjingdong.view.IView;

import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe3;

/**
 * 类作用：
 * 时  间：2017/9/16 - 9:46.
 * 创建人：张刚
 */

public interface Register3View extends IView {
    void onDataSucced(ZhuCe3 zhuCe3);
    void onDataFailed(String ex);
}
