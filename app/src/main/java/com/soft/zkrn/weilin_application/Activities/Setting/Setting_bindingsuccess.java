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

public class Setting_bindingsuccess extends AppCompatActivity {
    private Button back;
    private TextView num5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_bindingsuccess);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar7);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        num5=(TextView)findViewById(R.id.num5);
        //接受键值对
        Intent intent=getIntent();
        String info2=intent.getStringExtra("电话号码");
        num5.setText(info2);
        num5=(TextView)findViewById(R.id.num5);

        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num0 = num5.getText().toString();
                Toast.makeText(Setting_bindingsuccess.this,"返回",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Setting_bindingsuccess.this,Setting_Safety.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                intent.putExtra("号码0",num0);
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

