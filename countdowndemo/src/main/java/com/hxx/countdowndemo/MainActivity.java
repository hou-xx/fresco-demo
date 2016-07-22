package com.hxx.countdowndemo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 测试 CountDownTimer类
 */
public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.txt_main);
        mTextView.setText("获取验证码");
        countDownTimer = new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long l) {
                mTextView.setText("(" + l / 1000 + "）秒后重新获取");
                mTextView.setEnabled(false);
            }

            @Override
            public void onFinish() {
                mTextView.setText("获取验证码");
                mTextView.setEnabled(true);
            }
        };
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.start();
            }
        });
    }
}
