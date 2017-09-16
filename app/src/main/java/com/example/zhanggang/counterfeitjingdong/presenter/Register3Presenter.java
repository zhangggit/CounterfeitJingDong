package com.example.zhanggang.counterfeitjingdong.presenter;

import com.example.zhanggang.counterfeitjingdong.model.Register3Model;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe3;
import com.example.zhanggang.counterfeitjingdong.view.IView.Register3View;

/**
 * 类作用：注册验证码的presenter
 * 时  间：2017/9/16 - 9:46.
 * 创建人：张刚
 */

public class Register3Presenter extends BasePresenter<Register3View> {

    private final Register3Model register3Model;
    String shoujihao;
    String mima;
    String yanzhengma;

    public Register3Presenter(Register3View iView, String shoujihao, String mima, String yanzhengma) {
        super(iView);
        this.shoujihao = shoujihao;
        this.mima = mima;
        this.yanzhengma = yanzhengma;
        register3Model = new Register3Model(shoujihao, mima, yanzhengma);
    }

    @Override
    protected void initModel() {

    }

    public void getRegister3Data() {
        register3Model.getData(new Register3Model.onGetDataCallBack<ZhuCe3>() {
            @Override
            public void GetSucced(ZhuCe3 zhuCe3) {
                iView.onDataSucced(zhuCe3);
            }

            @Override
            public void GetFailed(String ex) {
                iView.onDataFailed(ex);
            }
        });
    }

}
