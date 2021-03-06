package com.soft.zkrn.weilin_application.Activities.Task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.soft.zkrn.weilin_application.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class StatisticsPublish extends AppCompatActivity {
    static Button btn_1;
    static Button btn_2;
    static Button btn_3;
    static Button btn_4;

    private Task_CenterWhole fragment_task_whole;
    private Task_CenterPublish fragment_task_publish;
    private Task_CenterComment fragment_task_comment;
    private Task_CenterComplete fragment_task_complete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_publish);
        btn_1 = findViewById(R.id.btn_task_statistics_publish_1);
        btn_2 = findViewById(R.id.btn_task_statistics_publish_2);
        btn_3 = findViewById(R.id.btn_task_statistics_publish_3);
        btn_4 = findViewById(R.id.btn_task_statistics_publish_4);

        /**
         * toolbar component
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_statistics_publish);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        /**
         * navigation finish
         */
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
