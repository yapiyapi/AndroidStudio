package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_Home extends Fragment {

    RecyclerView 리싸이클러뷰;
    Adapter_Home 어댑터;
    LinearLayoutManager 레이아웃매니저;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView 사용자이름 = (TextView) view.findViewById(R.id.textview_user_name);
        ImageButton 플러스버튼 = (ImageButton) view.findViewById(R.id.plus_btn_home);

        리싸이클러뷰 = (RecyclerView) view.findViewById(R.id.recy);
        레이아웃매니저 = new LinearLayoutManager(getActivity());
        어댑터 = new Adapter_Home();
        리싸이클러뷰.setLayoutManager(레이아웃매니저);
        리싸이클러뷰.setAdapter(어댑터);

        //데이터 수신 ( 회원가입 정보 및 로그인 여부 )
        if (getArguments()!=null){
            //로그인 여부
            boolean 로그인_bool = getArguments().getBoolean("로그인여부",false);
            if (로그인_bool==true) {
                사용자이름.setText(getArguments().getString("이름"));
                사용자이름.setVisibility(View.VISIBLE);
            }
        }

        //리사이클러뷰 화면전환
        어댑터.setOnItemClickListener(new Adapter_Home.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), Activity_CallInquiry.class);
                startActivity(intent);
            }
        });
        //게시물 추가 [오른쪽 아래]
        플러스버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Activity_Post.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        리싸이클러뷰 = (RecyclerView) getActivity().findViewById(R.id.recy);
        레이아웃매니저 = new LinearLayoutManager(getActivity());
        어댑터 = new Adapter_Home();
        리싸이클러뷰.setLayoutManager(레이아웃매니저);
        리싸이클러뷰.setAdapter(어댑터);

        //리사이클러뷰 화면전환
        어댑터.setOnItemClickListener(new Adapter_Home.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), Activity_CallInquiry.class);
                startActivity(intent);
            }
        }) ;
    }

}