package com.soft.zkrn.weilin_application.Activities.Setting;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

//写一个自定义的ScollGridView
public class NoScrollGridView extends GridView {
    //这个Attributeset为一个接口XML解析根据节点取出节点相对应的数据
    public NoScrollGridView(Context context, AttributeSet attr){
        super(context,attr);
    }
    public NoScrollGridView(Context context){
        super(context);
    }
    //onMeasure()方法的作用就是测量View需要多大的空间，就是宽和高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //AT_MOST为最大键值
        int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
