package com.example.android.navigationpatternlistdetail;

import android.app.Application;
import android.content.Context;

/**
 * Created by Tanaskovic on 4/1/2018.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}