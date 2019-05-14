package com.soft.zkrn.weilin_application.Activities.Setting;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import com.soft.zkrn.weilin_application.R;
import com.zhy.base.fileprovider.FileProvider7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;

public class Setting_FeedBack extends AppCompatActivity {
    private Button handin;
    private ImageView photo;
    private EditText editable1;
    private TextView editable2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_feedback);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar15);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        handin=(Button)findViewById(R.id.handin);
        handin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogshow();
            }
        });
        photo=(ImageView)findViewById(R.id.photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogshow2();
            }
        });
        editable1=(EditText)findViewById(R.id.editable1);
        editable2=(TextView)findViewById(R.id.editable2);
        editable1.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            //最多只允许240个字
            int max=240;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //时刻记录字数的改变
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp=s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                //转换类型
                int num=temp.toString().length();
                editable2.setText(num+"/"+max);
            }
        });
    }
    private void dialogshow(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("您已成功提交意见");
        builder.setMessage("您的每一次反馈与建议都是促进我们前进的动力");
        builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Setting_FeedBack.this,Setting_Mainpage.class);
                startActivity(intent);
                //    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
                //        finish();
            }
        }).create();
        builder.show();
        //onDestroy();
    }


    /*
    private void dialogshow(){

        Button Iknow2;
        AlertDialog.Builder builder=new AlertDialog.Builder(Setting_FeedBack.this);
        //Context
        LayoutInflater inflater=LayoutInflater.from(Setting_FeedBack.this);
        //绑定
        View v=inflater.inflate(R.layout.dialog2,null);
        //开始绑定
        Iknow2=v.findViewById(R.id.Iknow2);
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
        Iknow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这一段一定要有不然会反复弹出
                dialog.dismiss();
                Toast.makeText(Setting_FeedBack.this,"您已经确定",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Setting_FeedBack.this,Setting_Mainpage.class);
                startActivity(intent);
            }
        });

    }
    */

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void dialogshow2(){
        Button getphoto;
        Button choosephoto;
        Button cancel;
        AlertDialog.Builder builder=new AlertDialog.Builder(Setting_FeedBack.this);
        //Context
        LayoutInflater inflater=LayoutInflater.from(Setting_FeedBack.this);
        //绑定
        View v=inflater.inflate(R.layout.dialog3,null);
        //开始绑定
        cancel=v.findViewById(R.id.cancel);
        getphoto=v.findViewById(R.id.getphoto);
        choosephoto=v.findViewById(R.id.choosephoto);
        //创建
        final Dialog dialog2=builder.create();
        dialog2.show();
        //此行代码要放在show的后面不然会有遮盖
        dialog2.getWindow().setContentView(v);
        dialog2.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        //设置背景为透明才使得背景不可见，否则有白边
        dialog2.setCanceledOnTouchOutside(false);//触摸外部消失
        dialog2.getWindow().setGravity(Gravity.CENTER);
        //取消弹出框
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });
        //点击实现照相功能
        getphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
        //点击实现选择照片功能
        choosephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
            }
        });
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //未授权，申请授权(从相册选择图片需要读取存储卡的权限)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, RC_CHOOSE_PHOTO);
        } else {
            //已授权，获取照片
            choosePhoto();
        }


    }
    //权限的一个回调

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RC_TAKE_PHOTO:   //拍照权限申请返回
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    takePhoto();
                }
                break;
            //相册选择照片权限申请返回
            case RC_CHOOSE_PHOTO:
                choosePhoto();
                break;
        }
    }


    /*
        通过相册获取图片
         */
    public static final int RC_CHOOSE_PHOTO = 2;


    private void choosePhoto() {
        //Intent.ACTION_PICK为选择数据
        Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
        //"image/*"意思为路径
        intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intentToPickPic, RC_CHOOSE_PHOTO);
    }
    /*
    系统相册获取图片返回,用Glide来显示图片
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RC_CHOOSE_PHOTO:
                Uri uri = data.getData();
                //写一个工具类
                String filePath = FileUtil.getFilePathByUri(this, uri);

                if (!TextUtils.isEmpty(filePath)) {
                    RequestOptions requestOptions1 = new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
                    //将照片显示在 Image上
                    Glide.with(this).load(filePath).apply(requestOptions1).into(photo);
                }
                break;

            case RC_TAKE_PHOTO:
                RequestOptions requestOptions = new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
                //将图片显示在Image上
                Glide.with(this).load(mTempPhotoPath).apply(requestOptions).into(photo);
                break;
        }
    }

    //
    /*
    实现拍照功能
    */
    public static final int RC_TAKE_PHOTO = 1;
    private String mTempPhotoPath;
    private Uri imageUri;

    private void takePhoto() {
        //ACTION_IMAGE_CAPTURE节省很多时间，不需要单独开发相机UI，直接调用系统相机
        Intent intentToTakePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //访问SD卡下的文件夹
        File fileDir = new File(Environment.getExternalStorageDirectory() + File.separator + "photoTest" + File.separator);
        //文件不存在
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        //选择图片形式
        File photoFile = new File(fileDir, "photo.jpeg");
        //获得绝对路径
        mTempPhotoPath = photoFile.getAbsolutePath();
        //调用了一个小众库的方法
        imageUri = FileProvider7.getUriForFile(this, photoFile);
        //输入数据
        intentToTakePhoto.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intentToTakePhoto, RC_TAKE_PHOTO);
    }



    //返回事件
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
