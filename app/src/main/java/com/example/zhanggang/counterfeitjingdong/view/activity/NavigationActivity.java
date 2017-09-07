package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zhanggang.counterfeitjingdong.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：导航页 刚进入应用时
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class NavigationActivity extends AppCompatActivity {

    @BindView(R.id.daojishi)
    TextView textView;
    int i = 3;
    private Timer timer1;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        i--;
                        textView.setText("跳过（" + i + "）");
                    }
                });
                if (i == 0) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, 1000, 1000);

        timer1 = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(NavigationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        timer1.schedule(task1, 3000);
    }

    //点击跳过导航页
    public void on_daohang_tiaoguo(View view) {
        Intent intent = new Intent(NavigationActivity.this, MainActivity.class);
        startActivity(intent);
        timer.cancel();
        timer1.cancel();
        finish();
    }
}
