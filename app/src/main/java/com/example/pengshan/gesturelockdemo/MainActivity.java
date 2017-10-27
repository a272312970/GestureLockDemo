package com.example.pengshan.gesturelockdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.gestureLockView)
    GestureLockView mGestureLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mGestureLockView.setLimitNum(6);
        mGestureLockView.setOnGestureFinishListener(new GestureLockView.OnGestureFinishListener() {
            @Override
            public void OnGestureFinish(boolean success, String key) {
                if(success){
                    mGestureLockView.setKey(key);
                }else{
                    if(key.length() >= 6){
                        Toast.makeText(MainActivity.this,"两次输入不一致",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"密码长度过短",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
