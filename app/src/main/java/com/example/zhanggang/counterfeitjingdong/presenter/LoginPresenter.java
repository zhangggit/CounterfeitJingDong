package com.example.zhanggang.counterfeitjingdong.presenter;

import com.example.zhanggang.counterfeitjingdong.model.LoginModel;
import com.example.zhanggang.counterfeitjingdong.model.bean.DengLu;
import com.example.zhanggang.counterfeitjingdong.view.IView.LoginView;

/**
 * 类作用：登陆的Presenter
 * 时  间：2017/9/16 - 8:08.
 * 创建人：张刚
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    String phone;
    String pwd;
    private LoginModel loginModel;

    public LoginPresenter(LoginView iView,String phone,String pwd) {
        super(iView);
        this.phone=phone;
        this.pwd=pwd;
        loginModel = new LoginModel(phone,pwd);
    }

    @Override
    protected void initModel() {

    }

    public void getData(){
        loginModel.getLoginData(new LoginModel.DengLuDataCallBack<DengLu>() {
            @Override
            public void onGetDataSucced(DengLu dengLu) {
                iView.onSucced(dengLu);
            }

            @Override
            public void onGetDataFailed(String ex) {
                iView.onFailed(ex);
            }
        });
    }

}
