package com.example.zhanggang.counterfeitjingdong.view.IView;

import com.example.zhanggang.counterfeitjingdong.model.bean.FaXianBean;

/**
 * 类作用：发现的view层
 * 时  间：2017/9/15 - 19:56.
 * 创建人：张刚
 */

public interface GetFaXianView extends IView {
    //定义成功失败两个接口
    void onGetDataSucced(FaXianBean faXianBean);
    void onGetDataFailed(String ex);
}
