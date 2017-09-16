package com.example.zhanggang.counterfeitjingdong.presenter;

import com.example.zhanggang.counterfeitjingdong.model.RegisterModel;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe1;
import com.example.zhanggang.counterfeitjingdong.view.IView.RegisterView;

/**
 * 类作用：注册1的Presenter
 * 时  间：2017/9/16 - 8:53.
 * 创建人：张刚
 */

public class RegisterPresenter extends BasePresenter<RegisterView>{

    String shoujihao;
    private RegisterModel registerModel;

    public RegisterPresenter(RegisterView iView,String shoujihao) {
        super(iView);
        this.shoujihao=shoujihao;
        registerModel = new RegisterModel(shoujihao);
    }

    @Override
    protected void initModel() {

    }
    public void getRegsiterData(){
        registerModel.getRegisterData(new RegisterModel.RegisterDataCallBack<ZhuCe1>() {
            @Override
            public void onRegisterSucced(ZhuCe1 zhuCe1) {
                iView.onDateSucced(zhuCe1);
            }

            @Override
            public void onRegisterFailed(String ex) {
                iView.onDateFailed(ex);
            }
        });
    }

}
