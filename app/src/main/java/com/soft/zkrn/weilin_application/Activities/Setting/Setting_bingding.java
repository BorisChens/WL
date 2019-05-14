package com.soft.zkrn.weilin_application.Activities.Setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.soft.zkrn.weilin_application.R;

public class Setting_bingding extends AppCompatActivity {
    private TextView number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_bingding);
        //绑定
        number2=(TextView)findViewById(R.id.number2);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar3);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //绑定
        Button button=(Button)findViewById(R.id.next);
        /*接受传的键值对

         */
        Intent intent=getIntent();
        String tex=intent.getStringExtra("number");
        //传值将电话号码传入
        //    number2.setText(String.valueOf(tex));
        //按钮点击事件
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_bingding.this,"更换手机号",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Setting_bingding.this,Setting_changenumber.class);
                finish();
                startActivity(intent);
            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

