package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class buy_list extends AppCompatActivity {

    View back_btn_att_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_list);

        back_btn_att_list = (View)this.findViewById(R.id.back_btn_sell_list);

        //뒤로 가기 버튼 [왼쪽 상단]
        back_btn_att_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}