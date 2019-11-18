package com.bw.zhaozhipeng;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Copyright (C)
 * <p>
 * FileName: MyView
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/18 9:41
 * <p>
 * Description:
 */
public class MView extends View {

    //宽
    private int width;
    //高
    private int height;
    //XY轴画笔
    private Paint linePaint;
    //线条画笔
    private Paint textPaint;
    private Context context;
    private final String string;
    private float[][] points = new float[][]{{1, 5}, {2, 16}, {3, 8}, {4, 30}, {5, 40}, {6, 22}, {7, 13}, {8, 44}, {9, 50}, {6, 1}};

    public MView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MView);
        string = typedArray.getString(R.styleable.MView_mColor);
        init();
        typedArray.recycle();
    }

    private void init() {
        //XY轴画笔
        linePaint = new Paint();
        //设置行程间距
        linePaint.setStrokeWidth((float) 2.0);
        //设置抗锯齿
        linePaint.setAntiAlias(true);
        //设置画笔样式
        linePaint.setStyle(Paint.Style.FILL);
        //设置画笔颜色
        linePaint.setColor(Color.BLUE);

        //线条画笔
        textPaint = new Paint();
        //设置画笔颜色
        textPaint.setColor(Color.parseColor(string));
        //设置画笔样式
        textPaint.setStyle(Paint.Style.FILL);
        //设置抗锯齿
        textPaint.setAntiAlias(true);

        textPaint.setTextSize(10);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //平移坐标点
        canvas.translate(50, height - 50);

        drawLineX(canvas);
        drawLineY(canvas);
        drawLine(canvas);
    }

    float postX = 0;
    float postY = 0;

    private void drawLine(Canvas canvas) {
        float startX = 0;
        float startY = 0;

        for (int i = 0; i < points.length; i++) {
            float temp = points[i][0] / points.length;

            if (temp == 0) {
                startX = 0 + (points[i][0] * (width - 100) / points.length);
            } else {
                startX = 0 + (points[i][0] % points.length) * ((width - 100) / points.length);
            }

            startY = 0 - (points[i][1] / 60) * ((height - 100));

            //画圆点
            canvas.drawCircle(startX, startY, 5, linePaint);
            //画线
            canvas.drawText(i + 1 + "", startX - 10, startY - 10, linePaint);

            if (i != 0) {
                canvas.drawLine(postX, postY, startX, startY, textPaint);
            }

            postX = startX;
            postY = startY;
        }
    }

    //画线Y轴
    private void drawLineY(Canvas canvas) {
        int startX = 0;
        int startY = 0;
        int spaceing = (height - 100) / points.length;
        for (int i = 0; (startY + spaceing * i) < height - 50; i++) {
            //画线
            canvas.drawLine(startX, startY, startX, startY - spaceing * i, linePaint);
            //画圆点
            canvas.drawCircle(startX, startY - spaceing * i, 5, linePaint);
            //绘制文本
            canvas.drawText(1000 * i + "", startX - 30, startY - spaceing * i, linePaint);
        }
    }

    //画线X轴
    private void drawLineX(Canvas canvas) {
        int startX = 0;
        int startY = 0;
        int spaceing = (width - 100) / points.length;
        for (int i = 0; (startX + spaceing * i) < width - 50; i++) {
            //画线
            canvas.drawLine(startX, startY, startX + spaceing * i, startY, linePaint);
            //画圆点
            canvas.drawCircle(startX + spaceing * i, startY, 5, linePaint);
            //绘制文本
            canvas.drawText(1 * i + "", startX + spaceing * i, startY + 30, linePaint);
        }
    }
}
