package com.vind.android.ar.fragment;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.vind.android.ar.R;
import com.vind.android.ar.activity.WorkoutActivity;
import com.vind.android.ar.eventlistener.ViewOnClickListener;

public class WorkoutDayViewFragment extends Fragment{

    public WorkoutActivity workoutActivity;
    public ImageView lv_workout_day_select;
    public ImageView lv_program_plus;
    public LinearLayout ll_program_container;
    public LinearLayout ll_program_butterfly;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_workout_day_view, container, false );


        ViewOnClickListener viewOnClickListener = new ViewOnClickListener();

        this.lv_workout_day_select = (ImageView) view.findViewById(R.id.lv_workout_day_select);
        this.lv_workout_day_select.setOnClickListener(viewOnClickListener);
        this.lv_program_plus = (ImageView) view.findViewById(R.id.lv_program_plus);
        this.lv_program_plus.setOnClickListener(viewOnClickListener);

        this.ll_program_container = (LinearLayout) view.findViewById(R.id.ll_program_container);
        this.ll_program_butterfly = (LinearLayout) view.findViewById(R.id.ll_program_butterfly);
        //this.ll_program_butterfly.getLayoutParams().height = (int) getResources().getDimension(R.dimen.workout_program_butterfly);

        switch (workoutActivity.tv_selected_day.getText().toString()){
            case "17":
                this.ll_program_container.setVisibility(View.INVISIBLE);
                this.lv_workout_day_select.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.workout_17_jan));
                break;
            case "21":
                this.ll_program_container.setVisibility(View.VISIBLE);
                this.lv_workout_day_select.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.workout_21_jan));
                break;
        }

        onButterfly();


        return view;
    }

    public void onButterfly(){

        if (workoutActivity.selected_plus.equals("plus")) {
            this.ll_program_butterfly.setVisibility(View.VISIBLE);
        }
    }


}
