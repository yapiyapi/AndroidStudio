package com.example.firstproject;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Home extends RecyclerView.Adapter<Adapter_Home.CustomViewHolder> {


    ArrayList<Uri> 이미지 = data.이미지_arr;
    ArrayList<String> 제목 = data.제목_arr;
    ArrayList<String> 지역 = data.위치_arr;
    ArrayList<String> 아파트 = data.건물_arr;
    ArrayList<String> 가격 = data.가격_arr;
    ArrayList<String> 내용 = data.내용_arr;
    ArrayList<Boolean> 관심여부 = data.관심여부_arr;

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
//        holder.이미지.setImageURI(이미지.get(position));
        holder.제목.setText(제목.get(position));
        holder.지역.setText(지역.get(position));
        holder.아파트.setText(아파트.get(position));
        holder.가격.setText(가격.get(position));

        boolean 관심_초기화 = 관심여부.get(holder.getAdapterPosition());
        if (관심_초기화) holder.하트.setImageResource(R.drawable.favorite);
        else holder.하트.setImageResource(R.drawable.favorite_empty);

        holder.하트.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean 관심 = 관심여부.get(holder.getAdapterPosition());
                if(!관심){                                            // false
                    holder.하트.setImageResource(R.drawable.favorite);
                    관심여부.set(holder.getAdapterPosition(),true);
                }else{                                               //true
                    holder.하트.setImageResource(R.drawable.favorite_empty);
                    관심여부.set(holder.getAdapterPosition(),false);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 제목.size();
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
