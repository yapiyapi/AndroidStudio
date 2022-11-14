package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class sell_list extends AppCompatActivity {

    private View layout_red;
    private View layout_blue;
    private View layout_green;
    private Button btn_red;
    private Button btn_blue;
    private Button btn_green;
    private View back_btn_att_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_list);

        layout_red = (LinearLayout)this.findViewById(R.id.red_layout);
        layout_blue = (LinearLayout)this.findViewById(R.id.blue_layout);
        layout_green = (LinearLayout)this.findViewById(R.id.green_layout);

        btn_red = (Button)this.findViewById(R.id.btn_red);
        btn_blue = (Button)this.findViewById(R.id.btn_blue);
        btn_green = (Button)this.findViewById(R.id.btn_green);


        back_btn_att_list = (View)this.findViewById(R.id.back_btn_sell_list);

        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_red.setVisibility(View.VISIBLE);
                layout_blue.setVisibility(View.INVISIBLE);
                layout_green.setVisibility(View.INVISIBLE);
            }
        });
        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_red.setVisibility(View.INVISIBLE);
                layout_blue.setVisibility(View.VISIBLE);
                layout_green.setVisibility(View.INVISIBLE);
            }
        });
        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_red.setVisibility(View.INVISIBLE);
                layout_blue.setVisibility(View.INVISIBLE);
                layout_green.setVisibility(View.VISIBLE);
            }
        });
        //뒤로 가기 버튼 [왼쪽 상단]
        back_btn_att_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}