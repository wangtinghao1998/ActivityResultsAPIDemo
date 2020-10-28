package com.example.activityresultsapidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.activityresultsapidemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> mLauncher;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setData(this);

        mLauncher = registerForActivityResult(new MyActivityResultContract(), new ActivityResultCallback<MyActivityResult>() {
            @Override
            public void onActivityResult(MyActivityResult result) {
                //Activity.RESULT_OK == -1
                if (result.getResultCode() == Activity.RESULT_OK) {
                    String receive = result.getIntent().getStringExtra("result") == null ? "" : result.getIntent().getStringExtra("result");
                    mBinding.tvReceive.setText(receive);
                }
            }
        });
    }

    //数据回绑，按钮点击
    public void send() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("input", "MainActivity发送的数据");
        mLauncher.launch(intent);
    }

}