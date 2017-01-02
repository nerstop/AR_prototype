package com.vind.android.ar.eventlistener;

import android.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.vind.android.ar.R;
import com.vind.android.ar.activity.JoinActivity;
import com.vind.android.ar.activity.LoginActivity;
import com.vind.android.ar.activity.MainActivity;
import com.vind.android.ar.activity.WorkoutActivity;
import com.vind.android.ar.fragment.JoinGeneralFragment;
import com.vind.android.ar.fragment.JoinStudentFragment;
import com.vind.android.ar.fragment.WorkoutDayViewFragment;
import com.vind.android.ar.fragment.WorkoutMonthViewFragment;


/**
 * auther = "__nerstop__"
 */

public class ViewOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lv_login: // View(Login) -> Button(login)
                //Toast.makeText(view.getContext(),"아직 안되",Toast.LENGTH_LONG).show();
                ((LoginActivity) view.getContext()).LoginValidate();
                break;
            case R.id.lv_join: // View(Login) -> Button(join)
                ((LoginActivity) view.getContext()).openJoinUserInfo();
                break;
            case R.id.lv_student:
                //Fragment fragment = new JoinStudentFragment();
               ((JoinActivity) view.getContext()).ChangeFragment((Fragment)new JoinStudentFragment(),"JoinStudentFragment");
                ((JoinActivity) view.getContext()).ChangeTabState("student_on");
                break;
            case R.id.lv_general:
                //Fragment fragment = new JoinGeneralFragment();
                ((JoinActivity) view.getContext()).ChangeFragment((Fragment)new JoinGeneralFragment(),"JoinGeneralFragment");
                ((JoinActivity) view.getContext()).ChangeTabState("general_on");
                break;

            case R.id.lv_general_gender_m:
                ((JoinActivity) view.getContext()).FragmentGenderOnOff("general_gender_m_on");
                break;
            case R.id.lv_general_gender_f:
                ((JoinActivity) view.getContext()).FragmentGenderOnOff("general_gender_f_on");
                break;
            case R.id.lv_student_gender_m:
                ((JoinActivity) view.getContext()).FragmentGenderOnOff("student_gender_m_on");
                break;
            case R.id.lv_student_gender_f:
                ((JoinActivity) view.getContext()).FragmentGenderOnOff("student_gender_f_on");
                break;
            case R.id.lv_join_student_confirm:
                ((JoinActivity) view.getContext()).FragmentConfirm();
                break;
            case R.id.lv_join_general_confirm:
                ((JoinActivity) view.getContext()).FragmentConfirm();
                break;
            case R.id.lv_weight:
                ((MainActivity) view.getContext()).ChangeWeightWiget();
                break;

            case R.id.lv_workout_day_select:
                ((WorkoutActivity) view.getContext()).ChangeFragmentBefore((Fragment) new WorkoutMonthViewFragment(),"");
                break;
            case R.id.bt_day_17:
                //Toast.makeText(view.getContext(), "10", Toast.LENGTH_SHORT).show();
                ((WorkoutActivity) view.getContext()).ChangeFragmentBefore((Fragment) new WorkoutDayViewFragment(),"17");
                break;
            case R.id.bt_day_21:
                //Toast.makeText(view.getContext(), "11", Toast.LENGTH_SHORT).show();
                ((WorkoutActivity) view.getContext()).ChangeFragmentBefore((Fragment) new WorkoutDayViewFragment(),"21");
                break;
            case R.id.lv_program_plus:
                ((WorkoutActivity) view.getContext()).RefreshFragment();
                break;
        }
    }
}
