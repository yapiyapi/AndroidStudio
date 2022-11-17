package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment_Account extends Fragment {


    private String 이름 = null;
    private String 이메일 = null;
    private String 아이디 = null;
    private String 비밀번호 = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);


        if (getArguments()!=null) {
            //main으로 부터 데이터 수신
            이름 = getArguments().getString("이름");
            이메일 = getArguments().getString("이메일");
            아이디 = getArguments().getString("아이디");
        }

        Button 아이디수정 = (Button) view.findViewById(R.id.아이디수정);
        Button 닉네임수정 = (Button) view.findViewById(R.id.닉네임수정);
        Button 이메일수정 = (Button) view.findViewById(R.id.이메일수정);
        TextView 아이디텍스트 = (TextView) view.findViewById(R.id.textview_id);
        TextView 닉네임텍스트 = (TextView) view.findViewById(R.id.textview_name);
        TextView 이메일텍스트 = (TextView) view.findViewById(R.id.textview_email);
        EditText 아이디에딧텍스트 = (EditText) view.findViewById(R.id.edittext_id);
        EditText 닉네임에딧텍스트 = (EditText) view.findViewById(R.id.edittext_name);
        EditText 이메일에딧텍스트 = (EditText) view.findViewById(R.id.edittext_email);

        TextView 로그아웃 = (TextView) view.findViewById(R.id.textview_logout);

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


        로그아웃.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("로그인여부",false);
                startActivity(intent);
            }
        });

        return view;
    }
}