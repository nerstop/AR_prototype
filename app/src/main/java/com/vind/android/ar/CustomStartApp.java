package com.vind.android.ar;

import android.app.Application;

import com.tsengvn.typekit.Typekit;


public class CustomStartApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/NotoSans-Regular.ttf"))
                .addBold(Typekit.createFromAsset(this, "fonts/NotoSans-Regular.ttf"))
                .addCustom1(Typekit.createFromAsset(this, "fonts/NotoSans-Regular.ttf"));
    }
}
