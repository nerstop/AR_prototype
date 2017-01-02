package com.vind.android.ar.fragment;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vind.android.ar.R;
import com.vind.android.ar.eventlistener.ViewOnClickListener;

public class PeopleGroupFragment extends Fragment {

    public ImageView lv_poll_UpDown;
    public ImageView lv_coin_OnOff;

    public LinearLayout ll_group_container;

    public String poll_OnOff = "Off";
    public String coin_OnOff = "Off";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_people_group, container, false );

        ViewOnClickListener viewOnClickListener = new ViewOnClickListener();
        this.lv_poll_UpDown = (ImageView) view.findViewById(R.id.lv_poll_UpDown);

        this.lv_poll_UpDown.setOnClickListener(viewOnClickListener);

        this.lv_coin_OnOff = (ImageView) view.findViewById(R.id.lv_coin_OnOff);

        this.lv_coin_OnOff.setOnClickListener(viewOnClickListener);



        this.ll_group_container = (LinearLayout) view.findViewById(R.id.ll_group_container);

        return view;
    }

    public void ChangePollUpDown(){
        switch (this.poll_OnOff.toString()){
            case "Off":
                this.ll_group_container.setVisibility(View.VISIBLE);
                this.lv_poll_UpDown.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.people_poll_up));
                this.poll_OnOff = "On";
                break;
            case "On":
                this.ll_group_container.setVisibility(View.GONE);
                this.lv_poll_UpDown.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.people_poll_down));
                this.poll_OnOff = "Off";
                break;
        }
    }

    public void ChangeCoinOnOff(){
        switch (this.coin_OnOff.toString()){
            case "Off":
                this.lv_coin_OnOff.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.people_coin_1725));
                this.coin_OnOff = "On";
                break;
            case "On":
                this.lv_coin_OnOff.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.people_coin_7_10));
                this.coin_OnOff = "Off";
                break;
        }
    }

}
