package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe2;
import com.example.zhanggang.counterfeitjingdong.presenter.Register2Presenter;
import com.example.zhanggang.counterfeitjingdong.view.IView.Regidter2View;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//注册密码页面
public class Register2Activity extends AppCompatActivity implements Regidter2View {

    EditText editText;
    private String shoujihao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        editText = (EditText) findViewById(R.id.edtext_mima);

        //获取传过来的手机号
        Intent intent = getIntent();
        shoujihao = intent.getStringExtra("shoujihao");

    }

    //点击下一步
    public void on_xiayibu_zhuce2(View view) {
        String pwd = editText.getText().toString();
        Register2Presenter register2Presenter = new Register2Presenter(this, shoujihao, pwd);
        register2Presenter.getRegister2Data();
    }

    //退出 取消
    public void on_zhuce_tuichu(View view) {
        finish();
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onDateSucced(ZhuCe2 zhuCe2) {
        int code = zhuCe2.code;
        if (code == 1) {
            Intent intent = new Intent(Register2Activity.this, Regiter3Activity.class);
            //将手机号和密码存入intent
            intent.putExtra("shoujihao1", shoujihao);
            intent.putExtra("mima", editText.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public void onDateFailed(String ex) {

    }
}
