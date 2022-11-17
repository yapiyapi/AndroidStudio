package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

//    private Dialog dialog;

    ImageButton home_btn, lct_btn, inf_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_btn= (ImageButton) findViewById(R.id.home_btn);
        lct_btn= (ImageButton) findViewById(R.id.location_btn);
        inf_btn= (ImageButton) findViewById(R.id.information_btn);

        //회원가입할 때 받은 데이터 ( home <-> more_view )
        Intent 회원가입데이터 = getIntent();
        String 이름 = 회원가입데이터.getStringExtra("이름");
        String 이메일 = 회원가입데이터.getStringExtra("이메일");
        String 아이디 = 회원가입데이터.getStringExtra("아이디");
        String 비밀번호 = 회원가입데이터.getStringExtra("비밀번호");
        boolean 로그인여부 = 회원가입데이터.getBooleanExtra("로그인여부", false);

        Bundle 번들 = new Bundle();
        Fragment_Home home = new Fragment_Home();
        번들.putString("아이디", 아이디);
        번들.putString("비밀번호", 비밀번호);
        번들.putString("이름", 이름);
        번들.putString("이메일", 이메일);
        번들.putBoolean("로그인여부", 로그인여부);
        home.setArguments(번들);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,home);
        transaction.addToBackStack(null);
        transaction.commit();

        //하단 navigation bar 버튼 [home]
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle 번들 = new Bundle();
                Fragment_Home home = new Fragment_Home();
                번들.putString("아이디", 아이디);
                번들.putString("비밀번호", 비밀번호);
                번들.putString("이름", 이름);
                번들.putString("이메일", 이메일);
                번들.putBoolean("로그인여부", 로그인여부);
                home.setArguments(번들);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,home);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        //하단 navigation bar 버튼 [location 지도]
        lct_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(Uri.parse("geo:47.6,-122.3"));
            }
        });
        //하단 navigation bar 버튼 [더보기]
        inf_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle 번들 = new Bundle();
                Fragment_ViewMore 더보기 = new Fragment_ViewMore();
                번들.putString("아이디", 아이디);
                번들.putString("비밀번호", 비밀번호);
                번들.putString("이름", 이름);
                번들.putString("이메일", 이메일);
                번들.putBoolean("로그인여부", 로그인여부);
                더보기.setArguments(번들);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, 더보기);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }



    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        startActivity(intent);
    }

//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//
//        dialog = new Dialog(MainActivity.this);
//
//        //인플레이션
//        dialog.setContentView(R.layout.activity_dialog);
//
//        Button button2 = (Button)dialog.findViewById(R.id.button2);
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
//    }
}