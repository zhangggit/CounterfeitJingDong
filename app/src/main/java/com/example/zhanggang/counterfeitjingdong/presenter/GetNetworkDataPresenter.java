package com.example.zhanggang.counterfeitjingdong.presenter;

import com.example.zhanggang.counterfeitjingdong.model.GetNetWorkDataModel;
import com.example.zhanggang.counterfeitjingdong.model.bean.ShouYeGridData;
import com.example.zhanggang.counterfeitjingdong.view.IView.IGetNetworkData;

/**
 * 类作用：首页的Presenter
 * 时  间：2017/9/15 - 19:02.
 * 创建人：张刚
 */

public class GetNetworkDataPresenter extends BasePresenter<IGetNetworkData>{

    private GetNetWorkDataModel getNetWorkDataModel;

    public GetNetworkDataPresenter(IGetNetworkData iView) {
        super(iView);
    }

    @Override
    protected void initModel() {
        //创建要调用的model
        getNetWorkDataModel = new GetNetWorkDataModel();
    }
    public void getNetWorkData(){
        //调用model的方法
        getNetWorkDataModel.getNetWorkData(new GetNetWorkDataModel.DataCallBack<ShouYeGridData>() {
            @Override
            public void onGetDataSucced(ShouYeGridData shouYeGridData) {
                iView.OnGetNetworkDataSucced(shouYeGridData);
            }

            @Override
            public void onGetDataFaild(String ex) {
                iView.OnGetNetworkDataFailed(ex);
            }
        });
    }
}
