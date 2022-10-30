package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class frame_layout extends AppCompatActivity implements Button.OnClickListener{


    private View layout_red;
    private View layout_blue;
    private View layout_green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        this.InitializeView();
    }

    public void InitializeView()
    {
        layout_red = (LinearLayout)findViewById(R.id.red);
        layout_blue = (LinearLayout)findViewById(R.id.blue);
        layout_green = (LinearLayout)findViewById(R.id.green);
    }

    @Override
    public void onClick(View view) {
        layout_red.setVisibility(View.INVISIBLE);
        layout_blue.setVisibility(View.INVISIBLE);
        layout_green.setVisibility(View.INVISIBLE);

        switch (view.getId())
        {
            case R.id.btn_red:
                layout_red.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_blue:
                layout_blue.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_green:
                layout_green.setVisibility(View.VISIBLE);
                break;
        }
    }
}