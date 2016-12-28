package com.vind.android.ar.fragment;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.vind.android.ar.R;
import com.vind.android.ar.eventlistener.ViewOnClickListener;

public class JoinStudentFragment extends Fragment{

    ImageView lv_student_gender_m;
    ImageView lv_student_gender_f;
    ImageView lv_join_student_confirm;

    public EditText et_join_student_id;
    public EditText et_join_student_pw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_join_student, container, false );

        ViewOnClickListener viewOnClickListener = new ViewOnClickListener();

        this.lv_student_gender_m = (ImageView) view.findViewById(R.id.lv_student_gender_m);
        this.lv_student_gender_f = (ImageView) view.findViewById(R.id.lv_student_gender_f);

        this.lv_student_gender_m.setOnClickListener(viewOnClickListener);
        this.lv_student_gender_f.setOnClickListener(viewOnClickListener);

        this.lv_join_student_confirm = (ImageView) view.findViewById(R.id.lv_join_student_confirm);
        this.lv_join_student_confirm.setOnClickListener(viewOnClickListener);

        this.et_join_student_id = (EditText) view.findViewById(R.id.et_join_student_id);
        this.et_join_student_pw = (EditText) view.findViewById(R.id.et_join_student_pw);


        return view;
    }

    public void ChangeGenderState( String val ) {
        switch (val.toString()){
            case "student_gender_m_on":
                this.lv_student_gender_m.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.join_gender_m_on));
                this.lv_student_gender_f.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.join_gender_f_off));
                break;
            case "student_gender_f_on":
                this.lv_student_gender_m.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.join_gender_m_off));
                this.lv_student_gender_f.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.join_gender_f_on));
                break;
        }

    }
}
