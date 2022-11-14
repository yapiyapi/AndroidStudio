package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class home extends Fragment {

    int start;
    int end;

    private String 이름 = null;
    private String 이메일 = null;
    private String 아이디 = null;
    private String 비밀번호 = null;


    public home() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView 리싸이클러뷰;
        Adapter_home 어댑터;
        LinearLayoutManager 레이아웃매니저;


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView 사용자이름 = (TextView) view.findViewById(R.id.textview_user_name);

        리싸이클러뷰 = (RecyclerView) view.findViewById(R.id.recy);
        레이아웃매니저 = new LinearLayoutManager(getActivity());
        어댑터 = new Adapter_home();
        리싸이클러뷰.setLayoutManager(레이아웃매니저);
        리싸이클러뷰.setAdapter(어댑터);

        //데이터 수신 ( 회원가입 정보 및 로그인 여부 )
        if (getArguments()!=null){
            //회원가입시 기입한 정보들 [sign_up -> main -> account]
            //home 에서 sign_up 정보 수신
            이름 = getArguments().getString("이름");
            이메일 = getArguments().getString("이메일");
            아이디 = getArguments().getString("아이디");
            비밀번호 = getArguments().getString("비밀번호");

            //로그인 여부
            boolean 로그인_bool = getArguments().getBoolean("로그인여부",false);
            if (로그인_bool==true) {
                사용자이름.setText(getArguments().getString("이름"));
                사용자이름.setVisibility(View.VISIBLE);
            }

        }

        //리사이클러뷰 화면전환
        어댑터.setOnItemClickListener(new Adapter_home.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), call.class);
                startActivity(intent);
            }
        }) ;

        return view;
    }
}