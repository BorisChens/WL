package com.soft.zkrn.weilin_application.Activities.Setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.soft.zkrn.weilin_application.R;

public class Setting_changenumber extends AppCompatActivity {
    private LinearLayout country;
    private Button next2;
    private EditText ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_changenumber);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //绑定
        ed=(EditText)findViewById(R.id.ed);
        country = (LinearLayout) findViewById(R.id.country);
        country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_changenumber.this, "选择国家和地区", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Setting_changenumber.this,Setting_district.class);
                startActivity(intent);
            }
        });
        next2 = (Button) findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_changenumber.this, "下一步", Toast.LENGTH_SHORT).show();
                String num1=ed.getText().toString();
                Intent intent=new Intent(Setting_changenumber.this,Setting_sendcode.class);
                finish();
                //传入键值对
                intent.putExtra("电话号码",num1);
                startActivity(intent);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
