package com.example.activityresultsapidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.activityresultsapidemo.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding mBinding;
    //可自定义resultCode，不要0就行。因为0是RESULT_CANCELED。
    //建议直接使用系统自带的Activity.RESULT_OK
    public static final int RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        mBinding.setData(this);
        String receive = getIntent().getStringExtra("input") == null ? "" : getIntent().getStringExtra("input");
        mBinding.tvReceive.setText(receive);
    }

    //数据回绑，按钮点击
    public void send() {
        Intent intent = new Intent();
        intent.putExtra("result", "SecondActivity回传的数据");
//        setResult(RESULT_CODE, intent);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}