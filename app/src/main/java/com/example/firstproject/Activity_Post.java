package com.example.firstproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Activity_Post extends AppCompatActivity {

    ImageView back_btn_reg;
    TextView 완료;
    ImageView 이미지;
    TextView 제목;
    TextView 위치;
    TextView 건물명;
    TextView 가격;
    TextView 내용;

//    SharedPreferences 셰어드순서 = getSharedPreferences("셰어드순서", MODE_PRIVATE);
//    SharedPreferences.Editor 셰어드순서_editor = 셰어드순서.edit();

    Uri uri = null;
    Uri uri_data = Uri.parse("android.resource://com.example.firstproject/" + R.drawable.dabang);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        /**   초기화   **/
//        셰어드순서_editor.putInt("셰어드순서",0);
//        int 최종위치_1 = 셰어드순서.getInt("셰어드순서",0);

        back_btn_reg = (ImageView)this.findViewById(R.id.back_btn_reg);
        완료 = (TextView)this.findViewById(R.id.post_reg);
        이미지 = (ImageView)this.findViewById(R.id.imageplus_reg);
        제목 = (TextView)this.findViewById(R.id.title_reg);
        위치 = (TextView)this.findViewById(R.id.location_reg);
        건물명 = (TextView)this.findViewById(R.id.building_reg);
        가격 = (TextView)this.findViewById(R.id.price_reg);
        내용 = (TextView)this.findViewById(R.id.contents_reg);


        /** 판매중 데이터 중 몇번째 데이터인지 확인 ( fr. Adapter_ListSell )**/
        //수정시 받을 위치 데이터 ( fr. Adapter_ListSell )
        Intent 수정인텐트 = getIntent();
        String 식별부호 = 수정인텐트.getStringExtra("식별부호");
        //내가 작성한 매물 중에서 해당 위치 데이터 초기화
        int 최종위치 = data.식별부호_arr.indexOf(식별부호);

        if(최종위치 ==-1);
        //수정 시 내용 초기화
        else{
            Glide.with(Activity_Post.this).load(data.이미지_arr.get(최종위치)).into(이미지);
            제목.setText(data.제목_arr.get(최종위치));
            위치.setText(data.위치_arr.get(최종위치));
            건물명.setText(data.건물_arr.get(최종위치));
            가격.setText(data.가격_arr.get(최종위치));
            내용.setText(data.내용_arr.get(최종위치));
            완료.setText("수정");
        }
        /**   버튼    **/
        //뒤로 가기 버튼 [왼쪽 상단]
        back_btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //완료 (게시하기) -> 홈으로 내용 전달
        //수정 (수정하기) -> 해당 위치의 데이터 값 변경 (replace)
        완료.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //완료 (게시하기)
                if(완료.getText()!="수정"){
//                    if ( uri == null ) Toast.makeText(Activity_Post.this, "이미지를 추가 해주세요.", Toast.LENGTH_SHORT).show();
//                    else {
                        data.이미지_arr.add(0,uri);
                        data.제목_arr.add(0,제목.getText().toString());
                        data.위치_arr.add(0,위치.getText().toString());
                        data.건물_arr.add(0,건물명.getText().toString());
                        data.가격_arr.add(0,가격.getText().toString());
                        data.내용_arr.add(0,내용.getText().toString());
                        data.관심여부_arr.add(0,false);
                        data.판매상태_arr.add(0,"판매중");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            data.식별부호_arr.add(0, CurrentTime());
                        }
//                        //완료할 때마다 셰어드순서에 1 추가
//                        셰어드순서_editor.putInt("셰어드순서",셰어드순서.getInt("셰어드순서",0)+1);
//                        //셰어드 이름 = 자기 순서 값 ( 고유번호 )
//                        SharedPreferences sf = getSharedPreferences(""+셰어드순서.getInt("셰어드순서",0), MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sf.edit();
//                        //데이터
//                        editor.putString("이미지", uri.toString());
//                        editor.putString("제목", 제목.getText().toString());
//                        editor.putString("위치", 위치.getText().toString());
//                        editor.putString("건물명",건물명.getText().toString());
//                        editor.putString("가격", 가격.getText().toString());
//                        editor.putString("내용", 내용.getText().toString());
//                        editor.putBoolean("관심여부", false);
//                        editor.putString("판매상태", "판매중");
                        //activity 종료
                        finish();
                    }
//                }
                //수정 (수정하기)
                else{
                    data.이미지_arr.set(최종위치,uri);
                    data.제목_arr.set(최종위치,제목.getText().toString());
                    data.건물_arr.set(최종위치,건물명.getText().toString());
                    data.위치_arr.set(최종위치,위치.getText().toString());
                    data.가격_arr.set(최종위치,가격.getText().toString());
                    data.내용_arr.set(최종위치,내용.getText().toString());
                    finish();
                }

            }
        });

        //이미지 받아오기
        이미지.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                launcher.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>()
            {
                @Override
                public void onActivityResult(ActivityResult result)
                {
                    if (result.getResultCode() == RESULT_OK)
                    {
                        Intent intent = result.getData();
                        uri = intent.getData();
                        Glide.with(Activity_Post.this)
                                .load(uri)
                                .into(이미지);

                    }
                }
            });

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String CurrentTime (){
        // 현재 시간
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String formatedNow = now.format(formatter);
        return formatedNow;
    }

}