package com.timen.ronny.newtextview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 自定义控件之扩展
 * Created by Ronny on 2016/6/1.
 */
public class NewTextView extends TextView {
    Paint mPaint1;
    Paint mPaint2;

    public NewTextView(Context context) {
        super(context);
        initPaint();
    }

    public NewTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public NewTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }
    //1、继承TextView并重写ondraw（）方法
    @Override
    protected void onDraw(Canvas canvas) {
        //绘制内层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        //绘制外层矩形
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        //保存
        canvas.save();
        //绘制文字前先平移10像素
        canvas.translate(10,0);

        super.onDraw(canvas);

        canvas.restore();


    }
    //2、初始化画笔
    private void initPaint() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.GRAY);
        mPaint2.setStyle(Paint.Style.FILL);

    }
}
