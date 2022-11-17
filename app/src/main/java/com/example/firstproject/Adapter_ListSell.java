package com.example.firstproject;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;


public class Adapter_ListSell extends RecyclerView.Adapter<Adapter_ListSell.CustomViewHolder> {

    ArrayList<String> 제목_arr = data.제목_arr;
    ArrayList<String> 위치_arr = data.위치_arr;
    ArrayList<String> 건물_arr = data.건물_arr;
    ArrayList<String> 가격_arr = data.가격_arr;
    ArrayList<String> 내용_arr = data.내용_arr;
    ArrayList<Boolean> 관심여부_arr = data.관심여부_arr;
    ArrayList<Boolean> 작성여부_arr = data.작성여부_arr;
    ArrayList<Boolean> 작성여부복사본_arr = (ArrayList<Boolean>) 작성여부_arr.clone();

    //  --------------------------onclick --------------
    private OnItemClickListener mListener = null ;

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View 뷰 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent,false);
        return new CustomViewHolder(뷰);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        int posi = position;
        //작성여부의 복사본을 만들어 data class 에 있는
        //true 값이 있는 위치 값
        int true_위치 = 작성여부복사본_arr.indexOf(true);
        작성여부복사본_arr.set(true_위치,false);

        //값 초기화
        holder.제목.setText(제목_arr.get(true_위치));
        holder.지역.setText(위치_arr.get(true_위치));
        holder.아파트.setText(건물_arr.get(true_위치));
        holder.가격.setText(가격_arr.get(true_위치));
        //sub menu 보이게
        holder.메뉴.setVisibility(View.VISIBLE);
        //하트 초기화
        boolean 관심_초기화 = 관심여부_arr.get(true_위치);
        if (관심_초기화) holder.하트.setImageResource(R.drawable.favorite);
        else holder.하트.setImageResource(R.drawable.favorite_empty);
        //하트 눌릴 떄
        holder.하트.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean 관심 = 관심여부_arr.get(true_위치);
                if(!관심){                                            // false
                    holder.하트.setImageResource(R.drawable.favorite);
                    관심여부_arr.set(true_위치,true);
                }else{                                               //true
                    holder.하트.setImageResource(R.drawable.favorite_empty);
                    관심여부_arr.set(true_위치,false);
                }
            }
        });
        //sub menu 눌릴 때
        holder.메뉴.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
                popupMenu.getMenuInflater().inflate(R.menu.sub_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        //수정
                        if (menuItem.getItemId() == R.id.update){
                            //Post activity로 이동
                            Intent PostIntent = new Intent(view.getContext(), Activity_Post.class);
                            PostIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            PostIntent.putExtra("position",posi);
                            view.getContext().startActivity(PostIntent);
                        }
                        //삭제
                        else if (menuItem.getItemId() == R.id.delete) {
                            //데이터 삭제
                            제목_arr.remove(posi);
                            건물_arr.remove(posi);
                            위치_arr.remove(posi);
                            가격_arr.remove(posi);
                            내용_arr.remove(posi);
                            관심여부_arr.remove(posi);
                            작성여부_arr.remove(posi);
                            //새로고침
                            Intent 새로고침 = ((Activity)view.getContext()).getIntent();
                            ((Activity)view.getContext()).finish(); //현재 액티비티 종료 실시
                            ((Activity)view.getContext()).overridePendingTransition(0, 0); //효과 없애기
                            ((Activity)view.getContext()).startActivity(새로고침); //현재 액티비티 재실행 실시
                            ((Activity)view.getContext()).overridePendingTransition(0, 0); //효과 없애기

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }
    // 작성여부의 true 갯수 만큼 view 만듦
    @Override
    public int getItemCount() {
        return Collections.frequency(작성여부_arr,true);
    }

    //    ----------------뷰홀더-------------------
    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView 제목;
        TextView 지역;
        TextView 아파트;
        TextView 가격;
        ImageView 이미지;
        ImageView 하트;
        ImageView 메뉴;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            제목 =(TextView)itemView.findViewById(R.id.Title_btn);
            지역 =(TextView)itemView.findViewById(R.id.Location_btn);
            아파트 =(TextView)itemView.findViewById(R.id.Apart_btn);
            가격 =(TextView)itemView.findViewById(R.id.PriceInMonth_btn);
            이미지 =(ImageView) itemView.findViewById(R.id.cell_imageview);
            하트 =(ImageView) itemView.findViewById(R.id.favorite_empty);
            메뉴 =(ImageView) itemView.findViewById(R.id.sub_menu);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION)
                    {
                        if (mListener != null) {
                            mListener.onItemClick(v, pos) ;
                        }
                    }
                }
            });
        }
    }

}
