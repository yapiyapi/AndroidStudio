package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        Button 아이디수정 = (Button) this.findViewById(R.id.아이디수정);
        Button 닉네임수정 = (Button) this.findViewById(R.id.닉네임수정);
        Button 이메일수정 = (Button) this.findViewById(R.id.이메일수정);
        TextView 아이디텍스트 = (TextView) this.findViewById(R.id.textview_id);
        TextView 닉네임텍스트 = (TextView) this.findViewById(R.id.textview_name);
        TextView 이메일텍스트 = (TextView) this.findViewById(R.id.textview_email);
        EditText 아이디에딧텍스트 = (EditText) this.findViewById(R.id.edittext_id);
        EditText 닉네임에딧텍스트 = (EditText) this.findViewById(R.id.edittext_name);
        EditText 이메일에딧텍스트 = (EditText) this.findViewById(R.id.edittext_email);

        //main으로 부터 데이터 수신
        Intent 계정정보 = getIntent();

        String 아이디 = 계정정보.getStringExtra("아이디");
        String 이름 = 계정정보.getStringExtra("이름");
        String 이메일 = 계정정보.getStringExtra("이메일");

        아이디텍스트.setText(아이디);
        닉네임텍스트.setText(이름);
        이메일텍스트.setText(이메일);
        아이디에딧텍스트.setText(아이디);
        닉네임에딧텍스트.setText(이름);
        이메일에딧텍스트.setText(이메일);

        //아이디 수정 버튼 로직
        아이디수정.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(아이디수정.getText().toString().equals("수정")){
                    아이디텍스트.setVisibility(View.INVISIBLE);
                    아이디에딧텍스트.setVisibility(View.VISIBLE);
                    아이디수정.setText("확인");
                }
                else{
                    아이디텍스트.setText(아이디에딧텍스트.getText().toString());
                    아이디텍스트.setVisibility(View.VISIBLE);
                    아이디에딧텍스트.setVisibility(View.INVISIBLE);
                    아이디수정.setText("수정");
                }
            }
        });
        //닉네임 수정 버튼 로직
        닉네임수정.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(닉네임수정.getText().toString().equals("수정")){
                    닉네임텍스트.setVisibility(View.INVISIBLE);
                    닉네임에딧텍스트.setVisibility(View.VISIBLE);
                    닉네임수정.setText("확인");
                }
                else{
                    닉네임텍스트.setText(닉네임에딧텍스트.getText().toString());
                    닉네임텍스트.setVisibility(View.VISIBLE);
                    닉네임에딧텍스트.setVisibility(View.INVISIBLE);
                    닉네임수정.setText("수정");
                }
            }
        });
        //이메일 수정 버튼 로직
        이메일수정.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(이메일수정.getText().toString().equals("수정")){
                    이메일텍스트.setVisibility(View.INVISIBLE);
                    이메일에딧텍스트.setVisibility(View.VISIBLE);
                    이메일수정.setText("확인");
                }
                else{
                    이메일텍스트.setText(이메일에딧텍스트.getText().toString());
                    이메일텍스트.setVisibility(View.VISIBLE);
                    이메일에딧텍스트.setVisibility(View.INVISIBLE);
                    이메일수정.setText("수정");
                }
            }
        });

        TextView 로그아웃 = (TextView) this.findViewById(R.id.textview_logout);
        로그아웃.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}