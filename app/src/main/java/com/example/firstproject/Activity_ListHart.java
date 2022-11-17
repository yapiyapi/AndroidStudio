package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_ListHart extends AppCompatActivity {

    View back_btn_att_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hart);
        //뒤로가기 버튼
        back_btn_att_list = (View)this.findViewById(R.id.back_btn_att_list);
        //어댑터 연결
        RecyclerView 리싸이클러뷰;
        Adapter_ListHart 어댑터;
        LinearLayoutManager 레이아웃매니저;

        리싸이클러뷰 = (RecyclerView) this.findViewById(R.id.recy_att);
        레이아웃매니저 = new LinearLayoutManager(this);
        어댑터 = new Adapter_ListHart();
        리싸이클러뷰.setLayoutManager(레이아웃매니저);
        리싸이클러뷰.setAdapter(어댑터);


        //리사이클러뷰 화면전환
        어댑터.setOnItemClickListener(new Adapter_ListHart.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent( Activity_ListHart.this , Activity_CallInquiry.class);
                startActivity(intent);
            }
        }) ;

        //뒤로 가기 버튼 [왼쪽 상단]
        back_btn_att_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}