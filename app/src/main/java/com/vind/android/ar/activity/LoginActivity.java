package com.vind.android.ar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vind.android.ar.R;
import com.vind.android.ar.eventlistener.ViewOnClickListener;

public class LoginActivity extends BaseActivity {

    EditText et_login_id, et_login_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ViewOnClickListener viewOnClickListener = new ViewOnClickListener();

        // 각 Button의 이벤트 리스너로 onClickListener 지정.
        ImageView lv_login = (ImageView) findViewById(R.id.lv_login);
        ImageView lv_join = (ImageView) findViewById(R.id.lv_join);

        lv_login.setOnClickListener(viewOnClickListener);
        lv_join.setOnClickListener(viewOnClickListener);

        this.et_login_id = (EditText) findViewById(R.id.et_login_id);
        this.et_login_pw = (EditText) findViewById(R.id.et_login_pw);


    }

    public void openJoinUserInfo(){
        Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
        startActivityForResult(intent,0);
    }

    public void LoginValidate(){
//        if(this.et_login_id.getText().toString().equals("")){
//            Toast.makeText(LoginActivity.this,"insert to id", Toast.LENGTH_SHORT).show();
//        } else if (this.et_login_pw.getText().toString().equals("")){
//            Toast.makeText(LoginActivity.this,"insert to password", Toast.LENGTH_SHORT).show();
//        } else {
            openLogin();
//        }
    }

    public void openLogin(){
//        if(this.et_login_id.getText().toString().equals("test") && this.et_login_pw.getText().toString().equals("1234")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
//        }else {
//            Toast.makeText(LoginActivity.this,"login failed.", Toast.LENGTH_SHORT).show();
//        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK) {
            String id_Data = data.getStringExtra("id");
            String pw_Data = data.getStringExtra("pw");

            et_login_id.setText(id_Data);
            et_login_pw.setText(pw_Data);
        }
    }
}
