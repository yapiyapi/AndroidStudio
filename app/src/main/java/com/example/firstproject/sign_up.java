package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("xorm","hi");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView 이름 = (TextView) this.findViewById(R.id.edit_name);
        TextView 이메일 = (TextView) this.findViewById(R.id.edit_email);
        TextView 아이디 = (TextView) this.findViewById(R.id.edit_id);
        TextView 비밀번호 = (TextView) this.findViewById(R.id.edit_password);


        Button 회원가입버튼 = (Button) this.findViewById(R.id.btn_signup);
        회원가입버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_up.this, MainActivity.class);
                intent.putExtra("이름",이름.getText().toString());
                intent.putExtra("이메일",이메일.getText().toString());
                intent.putExtra("아이디",아이디.getText().toString());
                intent.putExtra("비밀번호",비밀번호.getText().toString());
                startActivity(intent);
            }
        });
    }
}