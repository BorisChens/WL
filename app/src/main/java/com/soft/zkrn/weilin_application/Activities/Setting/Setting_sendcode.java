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

public class Setting_sendcode extends AppCompatActivity {
    private Button next3;
    private TextView surenum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_sendcode);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar6);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        surenum=(TextView)findViewById(R.id.surenum);
        //接受数据
        Intent intent=getIntent();
        String num2=intent.getStringExtra("电话号码");
        //强制转换类型
//        int result=Integer.parseInt(num2);
        surenum.setText("验证码已经发送至"+num2);
        next3=(Button)findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_sendcode.this,"下一步",Toast.LENGTH_SHORT).show();
                String info=num2;
                Intent intent=new Intent(Setting_sendcode.this,Setting_bindingsuccess.class);
                finish();
                intent.putExtra("电话号码",info);
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

