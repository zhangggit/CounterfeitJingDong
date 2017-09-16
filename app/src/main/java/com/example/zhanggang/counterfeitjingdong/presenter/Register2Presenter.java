package com.example.zhanggang.counterfeitjingdong.presenter;

import com.example.zhanggang.counterfeitjingdong.model.Register2Model;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe2;
import com.example.zhanggang.counterfeitjingdong.view.IView.Regidter2View;

/**
 * 类作用：注册密码的presenter
 * 时  间：2017/9/16 - 9:28.
 * 创建人：张刚
 */

public class Register2Presenter extends BasePresenter<Regidter2View> {

    private final Register2Model register2Model;
    String shoujihao;
    String pwd;

    public Register2Presenter(Regidter2View iView, String shoujihao, String pwd) {
        super(iView);
        this.shoujihao = shoujihao;
        this.pwd = pwd;
        register2Model = new Register2Model(shoujihao, pwd);
    }

    @Override
    protected void initModel() {

    }

    public void getRegister2Data() {
        register2Model.getData(new Register2Model.Register2DataCallBack<ZhuCe2>() {
            @Override
            public void onGetRegister2Succed(ZhuCe2 zhuCe2) {
                iView.onDateSucced(zhuCe2);
            }

            @Override
            public void onGetRegister2Failed(String ex) {
                iView.onDateFailed(ex);
            }
        });
    }
}
