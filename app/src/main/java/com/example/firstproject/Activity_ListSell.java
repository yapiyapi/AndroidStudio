package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_ListSell extends AppCompatActivity {

    private RecyclerView sell_recy;
    private RecyclerView sold_out_recy;
    private RecyclerView hide_recy;
    private Button sell_btn;
    private Button sold_out_btn;
    private Button hide_btn;
    private View back_btn_sell_list;
    //어댑터 변수
    Adapter_ListSell 어댑터;
    LinearLayoutManager 레이아웃매니저;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sell);
        /** --------변수 설정 ---------**/
        //각각 Recyclerview 화면
        sell_recy = (RecyclerView)this.findViewById(R.id.sell_recy);
        sold_out_recy = (RecyclerView)this.findViewById(R.id.sold_out_recy);
        hide_recy = (RecyclerView)this.findViewById(R.id.hide_recy);
        //상단 바 버튼
        sell_btn = (Button)this.findViewById(R.id.sell_btn);
        sold_out_btn = (Button)this.findViewById(R.id.sold_out_btn);
        hide_btn = (Button)this.findViewById(R.id.hide_btn);
        //뒤로가기 버튼
        back_btn_sell_list = (View)this.findViewById(R.id.back_btn_sell_list);
        /** --------어댑터 설정 ---------**/
        //어댑터 및 레이아웃매니저 생성
        레이아웃매니저 = new LinearLayoutManager(this);
        어댑터 = new Adapter_ListSell();
        sell_recy.setLayoutManager(레이아웃매니저);
        sell_recy.setAdapter(어댑터);
        /** --------버튼 설정 ---------**/
        // 리사이클러뷰 onclick시 화면전환
        어댑터.setOnItemClickListener(new Adapter_ListSell.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent( Activity_ListSell.this , Activity_CallInquiry.class);
                startActivity(intent);
            }
        }) ;

        sell_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sell_recy.setVisibility(View.VISIBLE);
                sold_out_recy.setVisibility(View.INVISIBLE);
                hide_recy.setVisibility(View.INVISIBLE);
                //
                레이아웃매니저 = new LinearLayoutManager(view.getContext());
                어댑터 = new Adapter_ListSell();
                sell_recy.setLayoutManager(레이아웃매니저);
                sell_recy.setAdapter(어댑터);
            }
        });
        sold_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sell_recy.setVisibility(View.INVISIBLE);
                sold_out_recy.setVisibility(View.VISIBLE);
                hide_recy.setVisibility(View.INVISIBLE);
            }
        });
        hide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sell_recy.setVisibility(View.INVISIBLE);
                sold_out_recy.setVisibility(View.INVISIBLE);
                hide_recy.setVisibility(View.VISIBLE);
            }
        });

        //뒤로 가기 버튼 [왼쪽 상단]
        back_btn_sell_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //새로고침
        /** --------어댑터 설정 ---------**/
        //어댑터 및 레이아웃매니저 생성
        레이아웃매니저 = new LinearLayoutManager(this);
        어댑터 = new Adapter_ListSell();
        sell_recy.setLayoutManager(레이아웃매니저);
        sell_recy.setAdapter(어댑터);
    }

}