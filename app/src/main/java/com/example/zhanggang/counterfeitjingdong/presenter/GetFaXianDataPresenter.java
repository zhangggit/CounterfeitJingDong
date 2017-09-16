package com.example.zhanggang.counterfeitjingdong.presenter;

import com.example.zhanggang.counterfeitjingdong.model.GetFaXianDataModel;
import com.example.zhanggang.counterfeitjingdong.model.bean.FaXianBean;
import com.example.zhanggang.counterfeitjingdong.view.IView.GetFaXianView;

/**
 * 类作用：
 * 时  间：2017/9/15 - 19:49.
 * 创建人：张刚
 */

//继承基类Presenter
public class GetFaXianDataPresenter extends BasePresenter<GetFaXianView> {

    private GetFaXianDataModel getFaXianDataModel;

    public GetFaXianDataPresenter(GetFaXianView iView) {
        super(iView);
    }

    @Override
    protected void initModel() {
        //创建要调用的model
        getFaXianDataModel = new GetFaXianDataModel();
    }

    public void getFaXianData(){
        //调用model层的方法
        getFaXianDataModel.getFaXianData(new GetFaXianDataModel.FaXianDataCallBack<FaXianBean>() {
            @Override
            public void onGetDataSucced(FaXianBean faXianBean) {
                iView.onGetDataSucced(faXianBean);
            }

            @Override
            public void onGetDataFailed(String ex) {
                iView.onGetDataFailed(ex);
            }
        });
    }

}
