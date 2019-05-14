package com.soft.zkrn.weilin_application.Activities.Setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.zhy.base.fileprovider.FileProvider7;

import java.io.File;

public class setting_function_photo extends Setting_FeedBack {

    public static final int RC_CHOOSE_PHOTO = 2;
    //通过相册获取图片

    private void choosePhoto() {
        //Intent.ACTION_PICK为选择数据
        Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
        //"image/*"意思为路径
        intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intentToPickPic, RC_CHOOSE_PHOTO);
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


}
