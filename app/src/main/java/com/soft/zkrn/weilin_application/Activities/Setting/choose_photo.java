package com.soft.zkrn.weilin_application.Activities.Setting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.soft.zkrn.weilin_application.R;

public class choose_photo extends AppCompatActivity {
    private NoScrollGridView noScrollGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_photo);
        noScrollGridView=(NoScrollGridView)findViewById(R.id.NoScrollGridView);
    }
}

