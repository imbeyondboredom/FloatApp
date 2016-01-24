package com.doesntexist.yourface.floatapp.utils;

import android.content.Context;

/**
 * Created by charlie on 1/19/16.
 */
public class DrawingUtils {

    public static float pxToDp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float dpToPx(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
