package com.vind.android.ar.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.tsengvn.typekit.TypekitContextWrapper;


public class BaseActivity extends AppCompatActivity {

    // 폰트 적용하기 위한 기본 액티비티
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

}
