package com.example.zhanggang.counterfeitjingdong.view.IView;

import com.example.zhanggang.counterfeitjingdong.model.bean.DengLu;

/**
 * 类作用：登陆的View
 * 时  间：2017/9/16 - 8:05.
 * 创建人：张刚
 */

public interface LoginView extends IView {
    void onSucced(DengLu dengLu);
    void onFailed(String ex);
}
