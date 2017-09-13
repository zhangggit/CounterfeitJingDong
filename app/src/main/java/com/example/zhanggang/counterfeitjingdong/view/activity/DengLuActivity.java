package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.DengLu;
import com.example.zhanggang.counterfeitjingdong.view.fragment.WoDeFragment;
import com.google.gson.Gson;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.io.IOException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 登陆页面
 */
public class DengLuActivity extends AppCompatActivity {
    @BindView(R.id.zhanghao)
    EditText zhanghao;
    @BindView(R.id.mima)
    EditText mima;
    @BindView(R.id.qqdenglu)
    ImageView qqdenglu;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        ButterKnife.bind(this);
        //创建一个SharedPreference于存QQ头像信息
        SharedPreferences sp = getSharedPreferences("name",MODE_PRIVATE);
        edit = sp.edit();


    }
    //点击登陆
    public void on_denglu(View view) {
        //获取输入框的手机号和密码
        String phone = zhanghao.getText().toString();
        String pwd = mima.getText().toString();
        if (phone!=null&&pwd!=null){
            String urlPath="http://api.eleteam.com/v1/user/login?mobile="+phone+"&password="+pwd;
            UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    DengLu dengLu = new Gson().fromJson(response.body().string(), DengLu.class);
                    int code = dengLu.code;
                    if (code==1){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(DengLuActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(DengLuActivity.this, "登陆失败，请先注册", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                }
            });
        }

    }
    //QQ登陆
    public void on_qqdenglu(View view) {
        UMShareAPI.get(this).getPlatformInfo(DengLuActivity.this, SHARE_MEDIA.QQ, umAuthListener);
    }
    //集成QQ
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            //获取QQ头像
            String iconurl = data.get("iconurl");
            //存入SharedPreferences
            edit.putString("key",iconurl);
            edit.commit();
            finish();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    //手机注册
    public void on_shoujizhuce(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    //点击退出页面
    public void on_denglu_tuichu(View view) {
        finish();
    }


}
