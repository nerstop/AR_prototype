package com.vind.android.ar.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vind.android.ar.R;
import com.vind.android.ar.activity.WorkoutActivity;
import com.vind.android.ar.eventlistener.ViewOnClickListener;

public class WorkoutMonthViewFragment extends Fragment{

    View bt_day_17, bt_day_21;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_workout_month_view, container, false );

        ViewOnClickListener viewOnClickListener = new ViewOnClickListener();

        this.bt_day_17 = (View) view.findViewById(R.id.bt_day_17);
        this.bt_day_21 = (View) view.findViewById(R.id.bt_day_21);

        this.bt_day_17.setOnClickListener(viewOnClickListener);
        this.bt_day_21.setOnClickListener(viewOnClickListener);

        return view;
    }
}
