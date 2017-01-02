package com.vind.android.ar.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vind.android.ar.R;
import com.vind.android.ar.eventlistener.ViewOnClickListener;
import com.vind.android.ar.fragment.PeopleFriendsFragment;
import com.vind.android.ar.fragment.PeopleGroupFragment;

public class PeopleActivity extends BaseActivity implements View.OnClickListener{

    ImageView lv_people_menu;
    LinearLayout people_layout_menu;
    View people_layout_menu_out;
    ImageView lv_people_friends, lv_people_group;
    TextView tv_curr_frag;
    Fragment current_frag;

    //메뉴 버튼
    ImageView lv_people_menu_workout, lv_people_menu_people, lv_people_menu_rank, lv_people_menu_program, lv_people_menu_gift, lv_people_menu_more;

    private String menu_OnOff = "Off";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);


        ViewOnClickListener viewOnClickListener = new ViewOnClickListener();

        //메뉴 on off
        this.lv_people_menu = (ImageView) findViewById(R.id.lv_people_menu);
        this.lv_people_menu.setOnClickListener(this);

        this.people_layout_menu_out = (View) findViewById(R.id.people_layout_menu_out);
        this.people_layout_menu_out.setOnClickListener(this);



        this.people_layout_menu = (LinearLayout)findViewById(R.id.people_layout_menu);


        this.lv_people_menu_workout = (ImageView) findViewById(R.id.lv_people_menu_workout);
        this.lv_people_menu_people = (ImageView) findViewById(R.id.lv_people_menu_people);
        this.lv_people_menu_rank = (ImageView) findViewById(R.id.lv_people_menu_rank);
        this.lv_people_menu_program = (ImageView) findViewById(R.id.lv_people_menu_program);
        this.lv_people_menu_gift = (ImageView) findViewById(R.id.lv_people_menu_gift);
        this.lv_people_menu_more = (ImageView) findViewById(R.id.lv_people_menu_more);

        this.lv_people_menu_workout.setOnClickListener(this);
        this.lv_people_menu_people.setOnClickListener(this);
        this.lv_people_menu_rank.setOnClickListener(this);
        this.lv_people_menu_program.setOnClickListener(this);
        this.lv_people_menu_gift.setOnClickListener(this);
        this.lv_people_menu_more.setOnClickListener(this);


        this.lv_people_friends = (ImageView) findViewById(R.id.lv_people_friends);
        this.lv_people_group = (ImageView) findViewById(R.id.lv_people_group);

        this.lv_people_friends.setOnClickListener(viewOnClickListener);
        this.lv_people_group.setOnClickListener(viewOnClickListener);

        this.tv_curr_frag = (TextView) findViewById(R.id.tv_curr_frag);

        ChangeFragment(new PeopleFriendsFragment());


    }

    public void ChangeFragment(Fragment fragment){
        this.current_frag = fragment;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, this.current_frag);
        fragmentTransaction.commit();

    }

    public void ChangeTabState( String val ) {
        switch (val.toString()){
            case "friends_on":
                this.lv_people_friends.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.people_friends_on));
                this.lv_people_group.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.people_group_off));
                this.tv_curr_frag.setText("FRIENDS");
                break;
            case "group_on":
                this.lv_people_group.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.people_group_on));
                this.lv_people_friends.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.people_friends_off));
                this.tv_curr_frag.setText("GROUP");
                break;
        }

    }

    public void GroupPollUpDown(){
        ((PeopleGroupFragment) this.current_frag).ChangePollUpDown();
    }

    public void GroupCoinOnOff(){
        ((PeopleGroupFragment) this.current_frag).ChangeCoinOnOff();
    }


    public void OnMenu(){
        switch (this.menu_OnOff) {
            case "Off":
                this.people_layout_menu.setVisibility(View.VISIBLE);
                this.menu_OnOff = "On";
                break;
            case "On":
                this.people_layout_menu.setVisibility(View.INVISIBLE);
                this.menu_OnOff = "Off";
                break;
        }
    }




    @Override
    public void onClick(View view) {
        Intent outIntent = null;
        switch (view.getId()) {
            case R.id.lv_people_menu:
                OnMenu();
                break;
            case R.id.people_layout_menu_out:
                OnMenu();
                break;
            case R.id.lv_people_menu_workout:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","workout");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case R.id.lv_people_menu_people:
                Toast.makeText(view.getContext(),"here",Toast.LENGTH_SHORT).show();
                break;
            case R.id.lv_people_menu_rank:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","rank");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case R.id.lv_people_menu_program:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","program");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case R.id.lv_people_menu_gift:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","gift");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case R.id.lv_people_menu_more:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","more");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
        }
    }
}
