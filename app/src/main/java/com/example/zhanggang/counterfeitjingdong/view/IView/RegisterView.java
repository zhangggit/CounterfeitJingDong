package com.example.zhanggang.counterfeitjingdong.view.IView;

import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe1;

/**
 * 类作用：注册手机号的view
 * 时  间：2017/9/16 - 9:02.
 * 创建人：张刚
 */

public interface RegisterView extends IView {
     void onDateSucced(ZhuCe1 zhuCe1);
     void onDateFailed(String ex);
}
