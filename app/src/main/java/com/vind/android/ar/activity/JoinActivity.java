package com.vind.android.ar.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vind.android.ar.R;
import com.vind.android.ar.eventlistener.ViewOnClickListener;
import com.vind.android.ar.fragment.JoinGeneralFragment;
import com.vind.android.ar.fragment.JoinStudentFragment;

public class JoinActivity extends BaseActivity {

    ImageView lv_student;
    ImageView lv_general;
    TextView tv_curr_frag;
    Fragment current_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        ViewOnClickListener viewOnClickListener = new ViewOnClickListener();

        this.lv_student = (ImageView) findViewById(R.id.lv_student);
        this.lv_general = (ImageView) findViewById(R.id.lv_general);

        this.lv_student.setOnClickListener(viewOnClickListener);
        this.lv_general.setOnClickListener(viewOnClickListener);

        this.tv_curr_frag = (TextView) findViewById(R.id.tv_curr_frag);


        ChangeFragment((Fragment) new JoinStudentFragment(), this.tv_curr_frag.getText().toString());

    }

    public void ChangeFragment( Fragment fragment ,String val) {
        this.tv_curr_frag.setText(val);
        current_frag = fragment;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, current_frag);
        fragmentTransaction.commit();
    }

    public void FragmentGenderOnOff(String val ) {
        switch(this.tv_curr_frag.getText().toString()){
            case "JoinGeneralFragment":
                ((JoinGeneralFragment)current_frag).ChangeGenderState(val);
                break;
            case "JoinStudentFragment":
                ((JoinStudentFragment)current_frag).ChangeGenderState(val);
                break;
        }
    }

    public void FragmentConfirm() {
        Intent outIntent = null;
        switch(this.tv_curr_frag.getText().toString()){
            case "JoinGeneralFragment":
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("id",((JoinGeneralFragment)current_frag).et_join_general_id.getText().toString());
                outIntent.putExtra("pw",((JoinGeneralFragment)current_frag).et_join_general_pw.getText().toString());
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case "JoinStudentFragment":
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("id",((JoinStudentFragment)current_frag).et_join_student_id.getText().toString());
                outIntent.putExtra("pw",((JoinStudentFragment)current_frag).et_join_student_pw.getText().toString());
                setResult(RESULT_OK, outIntent);
                finish();
                break;
        }
    }


    public void ChangeTabState( String val ) {
        switch (val.toString()){
            case "student_on":
                this.lv_student.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.join_student_on));
                this.lv_general.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.join_general_off));
                break;
            case "general_on":
                this.lv_general.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.join_general_on));
                this.lv_student.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.join_student_off));
                break;
        }

    }

}
