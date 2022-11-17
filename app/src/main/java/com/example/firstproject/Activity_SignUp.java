package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_SignUp extends AppCompatActivity {

    private String 이름 = null;

    public void 이름(String name){
        this.이름 = name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView 이름_t = (TextView) this.findViewById(R.id.edit_name);
        TextView 이메일_t = (TextView) this.findViewById(R.id.edit_email);
        TextView 아이디_t = (TextView) this.findViewById(R.id.edit_id);
        TextView 비밀번호_t = (TextView) this.findViewById(R.id.edit_password);

        이름 = 이름_t.getText().toString();

        Button 회원가입버튼 = (Button) this.findViewById(R.id.btn_signup);

        회원가입버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( view.getContext() , Activity_Login.class);
                //home 으로 보낼 데이터
                intent.putExtra("이름", 이름_t.getText().toString());
                intent.putExtra("이메일", 이메일_t.getText().toString());
                intent.putExtra("아이디", 아이디_t.getText().toString());
                intent.putExtra("비밀번호", 비밀번호_t.getText().toString());

                이름(이름_t.getText().toString());
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(this, 이름 + "님 환영합니다.", Toast.LENGTH_SHORT).show();
    }
}