package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
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

        // more_view 로 부터 받은 데이터
        Intent 더보기데이터 = getIntent();
        String 이름 = 더보기데이터.getStringExtra("이름");
        String 이메일 = 더보기데이터.getStringExtra("이메일");
        String 아이디 = 더보기데이터.getStringExtra("아이디");
        String 비밀번호 = 더보기데이터.getStringExtra("비밀번호");


        //로그인 버튼
        로그인버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (id.getText().toString().equals(아이디) && pw.getText().toString().equals(비밀번호)) {
//                    Bundle 번들 = new Bundle();
//                    home 홈화면 = new home();
//                    번들.putString("이름", 이름);
//                    번들.putString("이메일", 이메일);
//                    번들.putString("아이디", 아이디);
//                    번들.putString("비밀번호", 비밀번호);
//                    번들.putBoolean("로그인여부", true);
//                    홈화면.setArguments(번들);
//
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left,R.anim.exit_to_right);
//                    transaction.replace(R.id.frameLayout, 홈화면);
//                    transaction.addToBackStack(null);
//                    transaction.commit();
                    Intent intent = new Intent( view.getContext() , MainActivity.class);
                    intent.putExtra("이름", 이름);
                    intent.putExtra("이메일", 이메일);
                    intent.putExtra("아이디", 아이디);
                    intent.putExtra("비밀번호", 비밀번호);
                    intent.putExtra("로그인여부", true);
                    startActivity(intent);


                    Toast.makeText(getApplicationContext(), "로그인", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //회원가입 textview
        회원가입.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( view.getContext() , sign_up.class);
                startActivity(intent);
            }
        });
    }
}