package com.example.activityresultsapidemo;

import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyActivityResultContract extends ActivityResultContract<Intent, MyActivityResult> {
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, Intent input) {
        return input;
    }

    @Override
    public MyActivityResult parseResult(int resultCode, @Nullable Intent intent) {
        return new MyActivityResult(resultCode, intent);
    }
}
