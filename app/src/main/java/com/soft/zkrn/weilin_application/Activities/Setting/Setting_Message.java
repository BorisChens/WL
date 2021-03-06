package com.soft.zkrn.weilin_application.Activities.Setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.soft.zkrn.weilin_application.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Setting_Message extends AppCompatActivity {
    slideswitch slideswitch1;
    slideswitch slideswitch2;
    slideswitch slideswitch3;
    slideswitch slideswitch4;
    slideswitch slideswitch5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar11);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        slideswitch1 = (slideswitch) findViewById(R.id.sli);
        slideswitch1.setOnStateChangedListener(new slideswitch.OnStateChangedListener() {
            @Override
            public void onStateChangedListener(boolean state) {
                if (true == state) {
                    Toast.makeText(Setting_Message.this, "系统通知打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Setting_Message.this, "系统通知关闭", Toast.LENGTH_SHORT).show();
                }

            }
        });
        slideswitch2 = (slideswitch) findViewById(R.id.sli2);
        slideswitch2.setOnStateChangedListener(new slideswitch.OnStateChangedListener() {
            @Override
            public void onStateChangedListener(boolean state) {
                if (true == state) {
                    Toast.makeText(Setting_Message.this, "活动通知打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Setting_Message.this, "活动通知关闭", Toast.LENGTH_SHORT).show();
                }

            }
        });

        slideswitch3 = (slideswitch) findViewById(R.id.sli3);
        slideswitch3.setOnStateChangedListener(new slideswitch.OnStateChangedListener() {
            @Override
            public void onStateChangedListener(boolean state) {
                if (true == state) {
                    Toast.makeText(Setting_Message.this, "可接受求救信号", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Setting_Message.this, "关闭求救信号", Toast.LENGTH_SHORT).show();
                }

            }
        });

        slideswitch4 = (slideswitch) findViewById(R.id.sli4);
        slideswitch4.setOnStateChangedListener(new slideswitch.OnStateChangedListener() {
            @Override
            public void onStateChangedListener(boolean state) {
                if (true == state) {
                    Toast.makeText(Setting_Message.this, "提示音打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Setting_Message.this, "提示音关闭", Toast.LENGTH_SHORT).show();
                }

            }
        });

        slideswitch5 = (slideswitch) findViewById(R.id.sli5);
        slideswitch5.setOnStateChangedListener(new slideswitch.OnStateChangedListener() {
            @Override
            public void onStateChangedListener(boolean state) {
                if (true == state) {
                    Toast.makeText(Setting_Message.this, "振动提醒打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Setting_Message.this, "振动提醒关闭", Toast.LENGTH_SHORT).show();
                }

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
