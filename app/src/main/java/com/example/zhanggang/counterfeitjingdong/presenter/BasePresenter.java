package com.example.zhanggang.counterfeitjingdong.presenter;

import android.content.Context;

import com.example.zhanggang.counterfeitjingdong.app.AppL;
import com.example.zhanggang.counterfeitjingdong.view.IView.IView;

/**
 * 类作用：Presenter基类
 * 时  间：2017/9/15 - 19:02.
 * 创建人：张刚
 */

public abstract class BasePresenter<T extends IView> {

    // T 通知view刷新的接口
    protected T iView;

    public BasePresenter(T iView) {
        this.iView = iView;
        initModel();
    }

    protected abstract void initModel();

    //如果接口提供的环境变量为null的话, 就返回application环境变量
    Context context() {
        if (iView != null && iView.context() != null) {
            return iView.context();
        }
        return AppL.appContext();
    }
}
