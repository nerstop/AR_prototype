package com.vind.android.ar.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vind.android.ar.R;
import com.vind.android.ar.eventlistener.ViewOnClickListener;
import com.vind.android.ar.fragment.JoinGeneralFragment;
import com.vind.android.ar.fragment.JoinStudentFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    ImageView lv_weight;
    ImageView lv_main_menu;
    LinearLayout main_layout_menu;
    View main_layout_menu_out;




    //메뉴 버튼
    ImageView lv_main_menu_workout, lv_main_menu_people, lv_main_menu_rank, lv_main_menu_program, lv_main_menu_gift, lv_main_menu_more;

    private String weight_OnOff = "Off";
    private String menu_OnOff = "Off";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewOnClickListener viewOnClickListener = new ViewOnClickListener();

        // weight 위젯 on off
        this.lv_weight = (ImageView) findViewById(R.id.lv_weight);
        this.lv_weight.setOnClickListener(viewOnClickListener);

        //메뉴 on off
        this.lv_main_menu = (ImageView) findViewById(R.id.lv_main_menu);
        this.lv_main_menu.setOnClickListener(this);

        this.main_layout_menu_out = (View) findViewById(R.id.main_layout_menu_out);
        this.main_layout_menu_out.setOnClickListener(this);



        this.main_layout_menu = (LinearLayout)findViewById(R.id.main_layout_menu);
        //this.main_layout_menu.setOnClickListener(viewOnClickListener);

//        Paint paint = new Paint();
//        paint.setColor(Color.BLACK);
//        paint.setAlpha(65);
//        this.main_layout_menu.setBackgroundColor(paint.getColor());


        this.lv_main_menu_workout = (ImageView) findViewById(R.id.lv_main_menu_workout);
        this.lv_main_menu_people = (ImageView) findViewById(R.id.lv_main_menu_people);
        this.lv_main_menu_rank = (ImageView) findViewById(R.id.lv_main_menu_rank);
        this.lv_main_menu_program = (ImageView) findViewById(R.id.lv_main_menu_program);
        this.lv_main_menu_gift = (ImageView) findViewById(R.id.lv_main_menu_gift);
        this.lv_main_menu_more = (ImageView) findViewById(R.id.lv_main_menu_more);

        this.lv_main_menu_workout.setOnClickListener(this);
        this.lv_main_menu_people.setOnClickListener(this);
        this.lv_main_menu_rank.setOnClickListener(this);
        this.lv_main_menu_program.setOnClickListener(this);
        this.lv_main_menu_gift.setOnClickListener(this);
        this.lv_main_menu_more.setOnClickListener(this);


    }

    public void ChangeWeightWiget(){
        switch (this.weight_OnOff){
            case "Off":
                this.lv_weight.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.main_wiget_weight_plus));
                this.lv_weight.getLayoutParams().height = (int) getResources().getDimension(R.dimen.wiget_weiget_on_height);
                this.weight_OnOff = "On";
                break;
            case "On":
                this.lv_weight.setImageDrawable((Drawable)getResources().getDrawable(R.drawable.main_wiget_weight));
                this.lv_weight.getLayoutParams().height = (int) getResources().getDimension(R.dimen.wiget_weight_height);
                this.weight_OnOff = "Off";
                break;
        }
    }

    public void OnMenu(){
        switch (this.menu_OnOff) {
            case "Off":
                this.main_layout_menu.setVisibility(View.VISIBLE);
                this.menu_OnOff = "On";
                break;
            case "On":
                this.main_layout_menu.setVisibility(View.INVISIBLE);
                this.menu_OnOff = "Off";
                break;
        }
    }


    @Override
    public void onClick(View view) {
        Intent inIntent = null;
        switch (view.getId()) {
            case R.id.lv_main_menu:
                OnMenu();
                break;
            case R.id.main_layout_menu_out:
                OnMenu();
                break;
            case R.id.lv_main_menu_workout:
                this.menu_OnOff = "On";
                OnMenu();

                inIntent = new Intent(getApplicationContext(),WorkoutActivity.class);
                startActivityForResult(inIntent, 0);
                break;
            case R.id.lv_main_menu_people:
                this.menu_OnOff = "On";
                OnMenu();
                inIntent = new Intent(getApplicationContext(),PeopleActivity.class);
                startActivityForResult(inIntent, 0);
                break;
            case R.id.lv_main_menu_rank:
                this.menu_OnOff = "On";
                OnMenu();

                inIntent = new Intent(getApplicationContext(),RankActivity.class);
                startActivityForResult(inIntent, 0);
                break;
            case R.id.lv_main_menu_program:
                this.menu_OnOff = "On";
                OnMenu();

                inIntent = new Intent(getApplicationContext(),ProgramActivity.class);
                startActivityForResult(inIntent, 0);
                break;
            case R.id.lv_main_menu_gift:
                this.menu_OnOff = "On";
                OnMenu();

                inIntent = new Intent(getApplicationContext(),GiftActivity.class);
                startActivityForResult(inIntent, 0);
                break;
            case R.id.lv_main_menu_more:
                this.menu_OnOff = "On";
                OnMenu();

                inIntent = new Intent(getApplicationContext(),MoreActivity.class);
                startActivityForResult(inIntent, 0);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK) {
            String menuVal = data.getStringExtra("menuVal");
            //Toast.makeText(getApplicationContext(),menuVal.toString(), Toast.LENGTH_SHORT).show();
            switch (menuVal.toString()){
                case "workout":
                    this.lv_main_menu_workout.callOnClick();
                    break;
                case "people":
                    this.lv_main_menu_people.callOnClick();
                    break;
                case "rank":
                    this.lv_main_menu_rank.callOnClick();
                    break;
                case "program":
                    this.lv_main_menu_program.callOnClick();
                    break;
                case "gift":
                    this.lv_main_menu_gift.callOnClick();
                    break;
                case "more":
                    this.lv_main_menu_more.callOnClick();
                    break;
            }
        }
    }

}
