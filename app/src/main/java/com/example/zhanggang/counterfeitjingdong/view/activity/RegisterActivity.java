package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.EditText;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：注册页面  注册手机号
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edtext_shoujihao)
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


    }

    //退出注册
    public void on_zhuce_tuichu(View view) {
        finish();
    }

    //下一步
    public void on_xiayibu_zhuce(View view) {
        String urlPath = "http://169.254.60.203/mobile/index.php?op=register&username=" + editText.getText().toString();

        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
            }
        });
    }


}
