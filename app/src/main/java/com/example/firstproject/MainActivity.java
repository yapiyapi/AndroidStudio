package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int start;
    int end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(MainActivity.this, "온크리에이트", Toast.LENGTH_SHORT).show();
        ImageButton 계정이미지 = (ImageButton) this.findViewById(R.id.imagebtn_account);
        TextView 로그인 = (TextView) this.findViewById(R.id.textview_login);

        //회원가입시 기입한 정보들 [sign_up -> main -> account]
        //main 에서 sign_up 정보 수신
        Intent 회원가입인텐트 = getIntent();
        String 이름 = 회원가입인텐트.getStringExtra("이름");
        String 이메일 = 회원가입인텐트.getStringExtra("이메일");
        String 아이디 = 회원가입인텐트.getStringExtra("아이디");
        String 비밀번호 = 회원가입인텐트.getStringExtra("비밀번호");

        //로그인 여부 -> 로그인 textview 지우기
        Intent 로그인여부 = getIntent();
        boolean 로그인_bool = 로그인여부.getBooleanExtra("로그인여부",false);
        if (로그인_bool==true) 로그인.setVisibility(View.INVISIBLE);


        //계정이미지 버튼 [오른쪽 상단]
        계정이미지.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, account.class);
                intent.putExtra("url","www.naver.com");
                intent.putExtra("이름",이름);
                intent.putExtra("이메일",이메일);
                intent.putExtra("아이디",아이디);
                intent.putExtra("비밀번호",비밀번호);
                startActivity(intent);
            }
        });

        //로그인 text [오른쪽 상단]
        로그인.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });


    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(MainActivity.this, "온스타트", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(MainActivity.this, "온리줌", Toast.LENGTH_SHORT).show();
//        end = (int) System.currentTimeMillis();
//        if (start == 0){}
//        else Toast.makeText(MainActivity.this, ""+(end-start)+"ms", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(MainActivity.this, "온리스타트", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(MainActivity.this, "온퍼즈", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(getApplicationContext(), "온스탑", Toast.LENGTH_SHORT).show();
//        start = (int) System.currentTimeMillis(); // start = 시작시간 - 1970년
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(MainActivity.this, "온디스트로이", Toast.LENGTH_SHORT).show();
//    }
}