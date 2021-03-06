package com.soft.zkrn.weilin_application.Activities.Setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.soft.zkrn.weilin_application.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Setting_Safety extends AppCompatActivity {
    private LinearLayout code;
    private LinearLayout phone;
    //手机号
    private TextView number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_safety);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.phone);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_Safety.this,"绑定",Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(Setting_Safety.this,bangding.class);
//                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        code=(LinearLayout)findViewById(R.id.code);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_Safety.this,"修改密码",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Setting_Safety.this, Setting_ResetPassword.class);
                startActivity(intent);
            }
        });
        number=(TextView)findViewById(R.id.number);
        phone=(LinearLayout)findViewById(R.id.phone);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_Safety.this,"绑定",Toast.LENGTH_SHORT).show();
                String num=number.getText().toString();
                Intent intent=new Intent(Setting_Safety.this,Setting_bingding.class);
                //传键值
                intent.putExtra("电话号码",num);
                startActivity(intent);
            }
        });
        Intent intent1=getIntent();
        String str=intent1.getStringExtra("号码0");
//        number.setText(str);
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
