package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment_ViewMore extends Fragment {

    private String 이름 = null;
    private String 이메일 = null;
    private String 아이디 = null;
    private String 비밀번호 = null;
    private boolean 로그인여부;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_more, container, false);

        ImageView 판매내역 = (ImageView) view.findViewById(R.id.sell_imgbtn);
        ImageView 구매내역 = (ImageView) view.findViewById(R.id.buy_imgbtn);
        ImageView 관심목록 = (ImageView) view.findViewById(R.id.hart_imgbtn);

        View 뷰 = (View) view.findViewById(R.id.view);
        ImageButton 계정이미지 = (ImageButton) view.findViewById(R.id.imagebtn_view_more);
        ImageButton 오른쪽방향키 = (ImageButton) view.findViewById(R.id.go_btn);

        TextView 계정이름 = (TextView) view.findViewById(R.id.제목_txtview);
        TextView 계정내용 = (TextView) view.findViewById(R.id.내용_txtview);

        //Arguments 에서 데이터 받기
        if (getArguments()!=null){
            //회원가입시 기입한 정보들 [sign_up -> main -> account]
            //home 에서 sign_up 정보 수신
            이름 = getArguments().getString("이름");
            이메일 = getArguments().getString("이메일");
            아이디 = getArguments().getString("아이디");
            비밀번호 = getArguments().getString("비밀번호");

            //로그인 여부 -> 로그인 textview 지우기
            로그인여부 = getArguments().getBoolean("로그인여부",false);
            if (로그인여부==true) {
                계정이름.setText(getArguments().getString("이름"));
                계정내용.setText(getArguments().getString("이메일"));
            }
        }

        // 더보기 화면에서 계정 view 클릭했을 때 ( 데이터 전송 )
        뷰.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로그인 했으면 account fragment로 이동
                if (로그인여부==true){
                    Bundle 번들 = new Bundle();
                    Fragment_Account 계정화면 = new Fragment_Account();
                    번들.putString("이름",이름);
                    번들.putString("이메일",이메일);
                    번들.putString("아이디",아이디);
                    번들.putString("비밀번호",비밀번호);
                    계정화면.setArguments(번들);

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left,R.anim.exit_to_right);
                    transaction.replace(R.id.frameLayout, 계정화면);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                //로그인 안했으면 login Activity로 이동
                else{
                    Intent intent = new Intent(getActivity(), Activity_Login.class);
                    intent.putExtra("이름",이름);
                    intent.putExtra("이메일",이메일);
                    intent.putExtra("아이디",아이디);
                    intent.putExtra("비밀번호",비밀번호);
                    startActivity(intent);
                }

            }
        });
        계정이미지.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로그인 했으면 account fragment로 이동
                if (로그인여부==true){
                    Bundle 번들 = new Bundle();
                    Fragment_Account 계정화면 = new Fragment_Account();
                    번들.putString("이름",이름);
                    번들.putString("이메일",이메일);
                    번들.putString("아이디",아이디);
                    번들.putString("비밀번호",비밀번호);
                    계정화면.setArguments(번들);

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left,R.anim.exit_to_right);
                    transaction.replace(R.id.frameLayout, 계정화면);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                //로그인 안했으면 login Activity로 이동
                else{
                    Intent intent = new Intent(getActivity(), Activity_Login.class);
                    intent.putExtra("이름",이름);
                    intent.putExtra("이메일",이메일);
                    intent.putExtra("아이디",아이디);
                    intent.putExtra("비밀번호",비밀번호);
                    startActivity(intent);
                }
            }
        });
        오른쪽방향키.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로그인 했으면 account fragment로 이동
                if (로그인여부==true){
                    Bundle 번들 = new Bundle();
                    Fragment_Account 계정화면 = new Fragment_Account();
                    번들.putString("이름",이름);
                    번들.putString("이메일",이메일);
                    번들.putString("아이디",아이디);
                    번들.putString("비밀번호",비밀번호);
                    계정화면.setArguments(번들);

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left,R.anim.exit_to_right);
                    transaction.replace(R.id.frameLayout, 계정화면);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                //로그인 안했으면 login Activity로 이동
                else{
                    Intent intent = new Intent(getActivity(), Activity_Login.class);
                    intent.putExtra("이름",이름);
                    intent.putExtra("이메일",이메일);
                    intent.putExtra("아이디",아이디);
                    intent.putExtra("비밀번호",비밀번호);
                    startActivity(intent);
                }
            }
        });



        //판매내역  ----------------
        판매내역.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (로그인여부==false) Toast.makeText(getActivity(), "로그인 후 사용바랍니다.", Toast.LENGTH_SHORT).show();
//                else {
                    Intent intent = new Intent(getActivity(), Activity_ListSell.class);
                    startActivity(intent);
                }
//            }
        });

        //구매내역 ----------------
        구매내역.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (로그인여부==false) Toast.makeText(getActivity(), "로그인 후 사용바랍니다.", Toast.LENGTH_SHORT).show();
//                else {
                    Intent intent = new Intent(getActivity(), Activity_ListBuy.class);
                    startActivity(intent);
                }
//            }
        });

        //관심목록 (hart) ----------------
        관심목록.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (로그인여부==false) Toast.makeText(getActivity(), "로그인 후 사용바랍니다.", Toast.LENGTH_SHORT).show();
//                else {
                    Intent intent = new Intent(getActivity(), Activity_ListHart.class);
                    startActivity(intent);
//                }
            }
        });


        return view;
    }
}