package com.vind.android.ar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.vind.android.ar.R;

public class GiftActivity extends BaseActivity implements View.OnClickListener{

    ImageView lv_gift_menu;
    LinearLayout gift_layout_menu;
    View gift_layout_menu_out;

    //메뉴 버튼
    ImageView lv_gift_menu_workout, lv_gift_menu_people, lv_gift_menu_rank, lv_gift_menu_program, lv_gift_menu_gift, lv_gift_menu_more;

    private String menu_OnOff = "Off";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift);



        //메뉴 on off
        this.lv_gift_menu = (ImageView) findViewById(R.id.lv_gift_menu);
        this.lv_gift_menu.setOnClickListener(this);

        this.gift_layout_menu_out = (View) findViewById(R.id.gift_layout_menu_out);
        this.gift_layout_menu_out.setOnClickListener(this);



        this.gift_layout_menu = (LinearLayout)findViewById(R.id.gift_layout_menu);


        this.lv_gift_menu_workout = (ImageView) findViewById(R.id.lv_gift_menu_workout);
        this.lv_gift_menu_people = (ImageView) findViewById(R.id.lv_gift_menu_people);
        this.lv_gift_menu_rank = (ImageView) findViewById(R.id.lv_gift_menu_rank);
        this.lv_gift_menu_program = (ImageView) findViewById(R.id.lv_gift_menu_program);
        this.lv_gift_menu_gift = (ImageView) findViewById(R.id.lv_gift_menu_gift);
        this.lv_gift_menu_more = (ImageView) findViewById(R.id.lv_gift_menu_more);

        this.lv_gift_menu_workout.setOnClickListener(this);
        this.lv_gift_menu_people.setOnClickListener(this);
        this.lv_gift_menu_rank.setOnClickListener(this);
        this.lv_gift_menu_program.setOnClickListener(this);
        this.lv_gift_menu_gift.setOnClickListener(this);
        this.lv_gift_menu_more.setOnClickListener(this);


    }


    public void OnMenu(){
        switch (this.menu_OnOff) {
            case "Off":
                this.gift_layout_menu.setVisibility(View.VISIBLE);
                this.menu_OnOff = "On";
                break;
            case "On":
                this.gift_layout_menu.setVisibility(View.INVISIBLE);
                this.menu_OnOff = "Off";
                break;
        }
    }


    @Override
    public void onClick(View view) {
        Intent outIntent = null;
        switch (view.getId()) {
            case R.id.lv_gift_menu:
                OnMenu();
                break;
            case R.id.gift_layout_menu_out:
                OnMenu();
                break;
            case R.id.lv_gift_menu_workout:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","workout");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case R.id.lv_gift_menu_people:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","people");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case R.id.lv_gift_menu_rank:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","rank");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case R.id.lv_gift_menu_program:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","program");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
            case R.id.lv_gift_menu_gift:
                Toast.makeText(view.getContext(),"here",Toast.LENGTH_SHORT).show();
                break;
            case R.id.lv_gift_menu_more:
                outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("menuVal","more");
                setResult(RESULT_OK, outIntent);
                finish();
                break;
        }
    }
}
