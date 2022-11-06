package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button 로그인버튼 = (Button) this.findViewById(R.id.btn_login);
        TextView 회원가입 = (TextView) this.findViewById(R.id.textview_signup);

        TextView id = (TextView) this.findViewById(R.id.text_login_id);
        TextView pw = (TextView) this.findViewById(R.id.text_login_password);

        로그인버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.getText().toString().equals("kyh") && pw.getText().toString().equals("qwer")) {
                    Intent 로그인 = new Intent(login.this, MainActivity.class);
                    로그인.putExtra("로그인여부",true);
                    startActivity(로그인);

                    Toast.makeText(login.this, "로그인", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(login.this,"아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });


        회원가입.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, sign_up.class);
                startActivity(intent);
            }
        });

    }
}