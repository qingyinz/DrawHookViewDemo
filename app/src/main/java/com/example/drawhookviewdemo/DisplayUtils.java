package com.example.drawhookviewdemo;

import android.content.Context;

public class DisplayUtils {
    public static float px2dp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density; }
    public static float dp2px(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density; }
    /**
     * 将px值转换为sp值，保证文字大小不变
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f); }
    /**
     * 将sp值转换为px值，保证文字大小不变
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f); }}