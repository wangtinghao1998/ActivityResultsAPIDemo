package com.example.activityresultsapidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class MyActivityResult implements Parcelable {
    private int mResultCode;
    private Intent mIntent;

    public MyActivityResult(int mResultCode, Intent mIntent) {
        this.mResultCode = mResultCode;
        this.mIntent = mIntent;
    }

    protected MyActivityResult(Parcel in) {
        mResultCode = in.readInt();
        mIntent = in.readParcelable(Intent.class.getClassLoader());
    }

    public int getResultCode(){
        return mResultCode;
    }

    public Intent getIntent(){
        return mIntent;
    }

    public static final Creator<MyActivityResult> CREATOR = new Creator<MyActivityResult>() {
        @Override
        public MyActivityResult createFromParcel(Parcel in) {
            return new MyActivityResult(in);
        }

        @Override
        public MyActivityResult[] newArray(int size) {
            return new MyActivityResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mResultCode);
        dest.writeParcelable(mIntent, flags);
    }

    public static String resultCodeToString(int resultCode) {
        switch (resultCode) {
            case Activity.RESULT_OK: return "RESULT_OK";
            case Activity.RESULT_CANCELED: return "RESULT_CANCELED";
            default: return String.valueOf(resultCode);
        }
    }

    @Override
    public String toString() {
        return "MyActivityResult{" +
                "mResultCode=" + resultCodeToString(mResultCode) +
                ", mIntent=" + mIntent +
                '}';
    }
}
