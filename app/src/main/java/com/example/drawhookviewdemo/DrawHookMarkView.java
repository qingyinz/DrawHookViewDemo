package com.example.drawhookviewdemo;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrawHookMarkView  extends View {
    //打勾的起点
    int checkStartX;
    //线1的x轴增量
    private int line1X = 0;
    //线1的y轴增量
    private int line1Y = 0;
    //线2的x轴增量
    private int line2X = 0;
    //线2的y轴增量
    private int line2Y = 0;
    //增量值
    int step = 3;
    //线的宽度
    private int lineThick = 6;
    //获取圆心的x坐标
    int center;
    //圆弧半径
    int radius;
    Paint paint;
    //控件大小
    float totalWidth;
    boolean secLineInited = false;
    public DrawHookMarkView(Context context) {
        super(context);
        init(); }
    public DrawHookMarkView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Pattern p = Pattern.compile("\\d*");
        Matcher m = p.matcher(attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_width"));
        if (m.find()) {
            totalWidth = Float.valueOf(m.group()); }
        totalWidth = DisplayUtils.dp2px(context, (int) totalWidth);
        init(); }
    public DrawHookMarkView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(); }
    void init() {
        paint = new Paint();
        //设置画笔颜色
        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        //设置宽度
        paint.setStrokeWidth(lineThick);
        //设置空心
        paint.setStyle(Paint.Style.STROKE);
        //消除锯齿
        paint.setAntiAlias(true);
        //获取圆心的x坐标
        center = (int) (totalWidth / 2);
        //圆弧半径
        radius = (int) (totalWidth / 2) - lineThick;
        checkStartX = (int) (center - totalWidth / 5); }
    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (line1X < radius / 3) {
            line1X += step;
            line1Y += step; }
        //画第一根线
        canvas.drawLine(checkStartX, center, checkStartX + line1X, center + line1Y, paint);
        if (line1X >= radius / 3) {
            if (!secLineInited) {
                line2X = line1X;
                line2Y = line1Y;
                secLineInited = true; }
            line2X += step;
            line2Y -= step;
            //画第二根线
            canvas.drawLine(checkStartX + line1X - lineThick / 2,
                    center + line1Y, checkStartX + line2X, center + line2Y, paint); }
        //每隔6毫秒界面刷新
        if (line2X <= radius)
            postInvalidateDelayed(6); }}