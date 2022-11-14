package com.example.firstproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Adapter_home extends RecyclerView.Adapter<Adapter_home.CustomViewHolder> {

    ArrayList<String> 월세_arr = new ArrayList<>(Arrays.asList(
            "300/10","300/20","300/25","300/30","300/40"));
    ArrayList<String> 지역_arr = new ArrayList<>(Arrays.asList(
            "반여1동","반여2동","반여3동","반여4동","반여5동"));
    ArrayList<String> 아파트_arr = new ArrayList<>(Arrays.asList(
            "센텀 롯데 캐슬","아시아 선수촌","제니스","아이파크","더 샵"));

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
        View 뷰 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_home, parent,false);
        return new CustomViewHolder(뷰);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.월세.setText(월세_arr.get(position));
        holder.지역.setText(지역_arr.get(position));
        holder.아파트.setText(아파트_arr.get(position));

    }

    @Override
    public int getItemCount() {
        return 월세_arr.size();
    }

//    ----------------뷰홀더-------------------
    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView 월세;
        TextView 지역;
        TextView 아파트;
        ImageView 이미지;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            월세 =(TextView)itemView.findViewById(R.id.PriceInMonth_btn);
            지역 =(TextView)itemView.findViewById(R.id.Location_btn);
            아파트 =(TextView)itemView.findViewById(R.id.Apart_btn);
            이미지 =(ImageView) itemView.findViewById(R.id.cell_imageview);

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
