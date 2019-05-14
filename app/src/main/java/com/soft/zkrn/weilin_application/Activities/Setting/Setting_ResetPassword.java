package com.soft.zkrn.weilin_application.Activities.Setting;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.soft.zkrn.weilin_application.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Setting_ResetPassword extends AppCompatActivity {
    private Button save;
    private EditText ed1;
    private TextView ed2;
    //   int max=240; //最大的字符数
    private int hasnum;//现在拥有的字符数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_reset_password);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar8);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ed1=(EditText)findViewById(R.id.editable1);
        ed2=(TextView) findViewById(R.id.editable2);

        //设置监听，统计字数个数
//        ed1.addTextChangedListener(new TextWatcher() {
//            private CharSequence temp;
//            private int selectionStart;
//            private int selectionEnd;
//            private int max=240;
        //在文字改变前
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
        //文字改变过程中,s为实时监控文字长度
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//               temp=s;//实时统计字符的长度

//            }
        //文字改变后
//            @Override
//            public void afterTextChanged(Editable s) {
//                int number =s.length() ;
//                ed2.setText(number+ "/" + max + "字");
//                selectionStart = ed1.getSelectionStart();
//                selectionEnd = ed1.getSelectionEnd();
        //如果超出范围
//                if (temp.length() > max) {
        //删去首和尾
//                    s.delete(selectionStart - 1, selectionEnd);
//                    int tempSelection = selectionEnd;
//                    ed1.setText(s);
//                    ed1.setSelection(tempSelection);//设置光标在最后面
//                }
//            }
//        });
        //绑定按钮
        save=(Button)findViewById(R.id.save);
        //点击事件，点击按钮弹出框
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Setting_ResetPassword.this,"保存新密码",Toast.LENGTH_SHORT).show();
                dialogshow();
            }
        });
        //绑定
    }


    private void dialogshow(){
        TextView text01;
        Button Iknow;
        AlertDialog.Builder builder=new AlertDialog.Builder(Setting_ResetPassword.this);
        //Context
        LayoutInflater inflater=LayoutInflater.from(Setting_ResetPassword.this);
        //绑定
        View v=inflater.inflate(R.layout.dialog1,null);
        //开始绑定
        text01=v.findViewById(R.id.text01);
        Iknow=v.findViewById(R.id.Iknow);
        //创建
        final Dialog dialog=builder.create();
        dialog.show();
        //此行代码要放在show的后面不然会有遮盖
        dialog.getWindow().setContentView(v);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        //设置背景为透明才使得背景不可见，否则有白边
        dialog.setCanceledOnTouchOutside(false);//触摸外部消失
        dialog.getWindow().setGravity(Gravity.CENTER);
        //自定义布局应该在这里添加，要在dialog.show()的后面
        //dialog.getWindow().setGravity(Gravity.CENTER);//可以设置显示的位置
        //点击事件
        Iknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这一段一定要有不然会反复弹出
                dialog.dismiss();
                Toast.makeText(Setting_ResetPassword.this,"您已经确定",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Setting_ResetPassword.this,Setting_Safety.class);
                startActivity(intent);
                finish();
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
