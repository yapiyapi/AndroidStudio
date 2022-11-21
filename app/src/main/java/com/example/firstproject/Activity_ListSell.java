package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
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
    Adapter_List_Sell 어댑터_판매중;
    Adapter_List_SoldOut 어댑터_판매완료;
    Adapter_List_Hide 어댑터_숨김;
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
        어댑터_판매중 = new Adapter_List_Sell();
        sell_recy.setLayoutManager(레이아웃매니저);
        sell_recy.setAdapter(어댑터_판매중);
        /** --------버튼 설정 ---------**/
        // 리사이클러뷰 onclick시 화면전환
        어댑터_판매중.setOnItemClickListener(new Adapter_List_Sell.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent( Activity_ListSell.this , Activity_CallInquiry.class);
                startActivity(intent);
            }
        }) ;
        /** -------- 프레임 설정 ---------**/
        sell_btn.setOnClickListener(new View.OnClickListener() {  //판매중
            @Override
            public void onClick(View view) {
                //상단바 글씨 크기
                sell_btn.setTextSize(16); sell_btn.setTypeface(null, Typeface.BOLD);
                sold_out_btn.setTextSize(14); sold_out_btn.setTypeface(null, Typeface.NORMAL);
                hide_btn.setTextSize(14); hide_btn.setTypeface(null, Typeface.NORMAL);
                //프레임 Visible
                sell_recy.setVisibility(View.VISIBLE);
                sold_out_recy.setVisibility(View.INVISIBLE);
                hide_recy.setVisibility(View.INVISIBLE);
                //어댑터 연결
                레이아웃매니저 = new LinearLayoutManager(view.getContext());
                어댑터_판매중 = new Adapter_List_Sell();
                sell_recy.setLayoutManager(레이아웃매니저);
                sell_recy.setAdapter(어댑터_판매중);
                /** --------버튼 설정 ---------**/
                // 리사이클러뷰 onclick시 화면전환
                어댑터_판매중.setOnItemClickListener(new Adapter_List_Sell.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Intent intent = new Intent( Activity_ListSell.this , Activity_CallInquiry.class);
                        startActivity(intent);
                    }
                }) ;
            }
        });
        sold_out_btn.setOnClickListener(new View.OnClickListener() {  //판매완료
            @Override
            public void onClick(View view) {
                //상단바 글씨 크기
                sell_btn.setTextSize(14); sell_btn.setTypeface(null, Typeface.NORMAL);
                sold_out_btn.setTextSize(16); sold_out_btn.setTypeface(null, Typeface.BOLD);
                hide_btn.setTextSize(14); hide_btn.setTypeface(null, Typeface.NORMAL);
                //프레임 Visible
                sell_recy.setVisibility(View.INVISIBLE);
                sold_out_recy.setVisibility(View.VISIBLE);
                hide_recy.setVisibility(View.INVISIBLE);
                //어댑터 연결
                레이아웃매니저 = new LinearLayoutManager(view.getContext());
                어댑터_판매완료 = new Adapter_List_SoldOut();
                sold_out_recy.setLayoutManager(레이아웃매니저);
                sold_out_recy.setAdapter(어댑터_판매완료);
                /** --------버튼 설정 ---------**/
                // 리사이클러뷰 onclick시 화면전환
                어댑터_판매완료.setOnItemClickListener(new Adapter_List_SoldOut.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Intent intent = new Intent( Activity_ListSell.this , Activity_CallInquiry.class);
                        startActivity(intent);
                    }
                }) ;
            }
        });
        hide_btn.setOnClickListener(new View.OnClickListener() {  //숨김
            @Override
            public void onClick(View view) {
                //상단바 글씨 크기
                sell_btn.setTextSize(14); sell_btn.setTypeface(null, Typeface.NORMAL);
                sold_out_btn.setTextSize(14); sold_out_btn.setTypeface(null, Typeface.NORMAL);
                hide_btn.setTextSize(16); hide_btn.setTypeface(null, Typeface.BOLD);
                //프레임 Visible
                sell_recy.setVisibility(View.INVISIBLE);
                sold_out_recy.setVisibility(View.INVISIBLE);
                hide_recy.setVisibility(View.VISIBLE);
                //어댑터 연결
                레이아웃매니저 = new LinearLayoutManager(view.getContext());
                어댑터_숨김 = new Adapter_List_Hide();
                hide_recy.setLayoutManager(레이아웃매니저);
                hide_recy.setAdapter(어댑터_숨김);
                /** --------버튼 설정 ---------**/
                // 리사이클러뷰 onclick시 화면전환
                어댑터_숨김.setOnItemClickListener(new Adapter_List_Hide.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Intent intent = new Intent( Activity_ListSell.this , Activity_CallInquiry.class);
                        startActivity(intent);
                    }
                }) ;
            }
        });
        /**----------------**/
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
        //새로고침 (수정되고 난 후 다시 activity 돌아왔을 때)
//        레이아웃매니저 = new LinearLayoutManager(this);
//        어댑터_판매중 = new Adapter_List_Sell();
//        sell_recy.setLayoutManager(레이아웃매니저);
//        sell_recy.setAdapter(어댑터_판매중);
    }

}