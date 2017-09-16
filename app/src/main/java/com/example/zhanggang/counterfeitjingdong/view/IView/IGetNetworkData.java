package com.example.zhanggang.counterfeitjingdong.view.IView;

import com.example.zhanggang.counterfeitjingdong.model.bean.ShouYeGridData;

/**
 * 类作用：
 * 时  间：2017/9/15 - 18:50.
 * 创建人：张刚
 */

public interface IGetNetworkData extends IView{
    void OnGetNetworkDataSucced(ShouYeGridData shouYeGridData);

    void OnGetNetworkDataFailed(String ex);
}
