package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Activity_ListHart_listview extends AppCompatActivity {

    View back_btn_hart_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hart_listview);
        //뒤로가기 버튼
        back_btn_hart_list = (View)this.findViewById(R.id.back_btn_hart_listview);

        /**  어댑터 연결  **/
        ListViewAdapter adapter = new ListViewAdapter();

        ListView listView = findViewById(R.id.att_listview);
        Uri uri_data = Uri.parse("android.resource://com.example.firstproject/" + R.drawable.dabang);

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new item(uri_data, "부산의 중심지 롯데캐슬", "반여1동","센텀 롯데 캐슬","300/10"));
        adapter.addItem(new item(uri_data, "부산의 중심지 롯데캐슬", "반여1동","센텀 롯데 캐슬","300/10"));
        adapter.addItem(new item(uri_data, "부산의 중심지 롯데캐슬", "반여1동","센텀 롯데 캐슬","300/10"));
        adapter.addItem(new item(uri_data, "부산의 중심지 롯데캐슬", "반여1동","센텀 롯데 캐슬","300/10"));
        adapter.addItem(new item(uri_data, "부산의 중심지 롯데캐슬", "반여1동","센텀 롯데 캐슬","300/10"));

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

//        //listview onclick
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String data = (String) adapterView.getItemAtPosition(position);
//            }
//        });
//
        //뒤로 가기 버튼 [왼쪽 상단]
        back_btn_hart_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public class ListViewAdapter extends BaseAdapter {

        ArrayList<Uri> 이미지_arr = data.이미지_arr;
        ArrayList<String> 제목_arr = data.제목_arr;
        ArrayList<String> 위치_arr = data.위치_arr;
        ArrayList<String> 건물_arr = data.건물_arr;
        ArrayList<String> 가격_arr = data.가격_arr;
        ArrayList<Boolean> 관심여부_arr = data.관심여부_arr;
        ArrayList<Boolean> 관심여부복사본_arr = (ArrayList<Boolean>) 관심여부_arr.clone();

        TextView 제목;
        TextView 지역;
        TextView 아파트;
        TextView 가격;
        ImageView 이미지;
        ImageView 하트;
        ImageView 메뉴;


        ArrayList<item> items = new ArrayList<item>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(item item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final item item = items.get(position);
            /** 초기화 **/
            //위치 값 초기화 (관심여부복사본_arr)
//            int true_위치 = 관심여부복사본_arr.indexOf(true);
//            관심여부복사본_arr.set(true_위치, false);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.cell, viewGroup, false);
            } else {
                View view = new View(context);
                view = (View) convertView;
            }


            제목 = (TextView) convertView.findViewById(R.id.Title_btn);
            지역 = (TextView) convertView.findViewById(R.id.Location_btn);
            아파트 = (TextView) convertView.findViewById(R.id.Apart_btn);
            가격 = (TextView) convertView.findViewById(R.id.PriceInMonth_btn);
            이미지 = (ImageView) convertView.findViewById(R.id.cell_imageview);
            하트 = (ImageView) convertView.findViewById(R.id.favorite_empty);
            메뉴 = (ImageView) convertView.findViewById(R.id.sub_menu);


            //위치 값 초기화 (관심여부복사본_arr)
            int true_위치 = 관심여부복사본_arr.indexOf(true);
            if (true_위치 != -1) {
                관심여부복사본_arr.set(true_위치, false);

                //값 초기화
                Glide.with(context).load(이미지_arr.get(position)).into(이미지);
                제목.setText(제목_arr.get(position));
                지역.setText(위치_arr.get(position));
                아파트.setText(건물_arr.get(position));
                가격.setText(가격_arr.get(position));
                boolean 관심_초기화 = 관심여부_arr.get(true_위치);
                if (관심_초기화) 하트.setImageResource(R.drawable.favorite);
                else 하트.setImageResource(R.drawable.favorite_empty);
                /** 버튼 **/
                //하트 눌릴 때
                하트.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean 관심 = 관심여부_arr.get(true_위치);
                        if (!관심) {                                            // false
                            하트.setImageResource(R.drawable.favorite);
                            관심여부_arr.set(true_위치, true);
                        } else {                                               //true
                            하트.setImageResource(R.drawable.favorite_empty);
                            관심여부_arr.set(true_위치, false);
                        }
                    }
                });
            }else ;



            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;  //뷰 객체 반환
        }

    }
}