package com.example.firstproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Adapter_Home extends RecyclerView.Adapter<Adapter_Home.CustomViewHolder> {

    ArrayList<Uri> 이미지_arr = data.이미지_arr;
    ArrayList<String> 제목_arr = data.제목_arr;
    ArrayList<String> 위치_arr = data.위치_arr;
    ArrayList<String> 건물_arr = data.건물_arr;
    ArrayList<String> 가격_arr = data.가격_arr;
    ArrayList<String> 내용_arr = data.내용_arr;
    ArrayList<Boolean> 관심여부_arr = data.관심여부_arr;
    ArrayList<String> 판매상태_arr = data.판매상태_arr;
    ArrayList<String> 판매상태복사본_arr = (ArrayList<String>) 판매상태_arr.clone();

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

        int pos=0;
        // 둘 다 있을 때
        if (판매상태복사본_arr.indexOf("판매중")!=-1 && 판매상태복사본_arr.indexOf("")!=-1) {
            if (판매상태복사본_arr.indexOf("판매중") < 판매상태복사본_arr.indexOf("")) {
                pos = 판매상태복사본_arr.indexOf("판매중");
            } else {
                pos = 판매상태복사본_arr.indexOf("");
            }
        } else if (판매상태복사본_arr.indexOf("판매중")==-1 && 판매상태복사본_arr.indexOf("")!=-1){
            pos = 판매상태복사본_arr.indexOf("");
        }else if (판매상태복사본_arr.indexOf("판매중")!=-1 && 판매상태복사본_arr.indexOf("")==-1){
            pos = 판매상태복사본_arr.indexOf("판매중");
        }else return;
        판매상태복사본_arr.set(pos, "reset");
        int 최종위치 = pos;

        //true 최종값
        /** 초기화 **/
        //값 초기화
        Glide.with(holder.itemView).load(이미지_arr.get(최종위치)).into(holder.이미지);
        holder.제목.setText(제목_arr.get(최종위치));
        holder.지역.setText(위치_arr.get(최종위치));
        holder.아파트.setText(건물_arr.get(최종위치));
        holder.가격.setText(가격_arr.get(최종위치));
        //하트 초기화
        boolean 관심_초기화 = 관심여부_arr.get(최종위치);
        if (관심_초기화) holder.하트.setImageResource(R.drawable.favorite);
        else holder.하트.setImageResource(R.drawable.favorite_empty);
        //하트 눌릴 때
        holder.하트.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean 관심 = 관심여부_arr.get(최종위치);
                if(!관심){                                            // false
                    holder.하트.setImageResource(R.drawable.favorite);
                    관심여부_arr.set(최종위치,true);
                }else{                                               //true
                    holder.하트.setImageResource(R.drawable.favorite_empty);
                    관심여부_arr.set(최종위치,false);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 판매상태_arr.size()- Collections.frequency(판매상태_arr,"숨김") - Collections.frequency(판매상태_arr,"판매완료");
    }

//    ----------------뷰홀더-------------------
    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView 제목;
        TextView 지역;
        TextView 아파트;
        TextView 가격;
        ImageView 이미지;
        ImageView 하트;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            제목 =(TextView)itemView.findViewById(R.id.Title_btn);
            지역 =(TextView)itemView.findViewById(R.id.Location_btn);
            아파트 =(TextView)itemView.findViewById(R.id.Apart_btn);
            가격 =(TextView)itemView.findViewById(R.id.PriceInMonth_btn);
            이미지 =(ImageView) itemView.findViewById(R.id.cell_imageview);
            하트 =(ImageView) itemView.findViewById(R.id.favorite_empty);

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
