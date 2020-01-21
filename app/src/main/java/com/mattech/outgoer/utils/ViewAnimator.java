package com.mattech.outgoer.utils;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

public class ViewAnimator {

    public static void animateViewShake(View view) {
        PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat(View.ROTATION, 2f, -2f, 2f, -2f, 0f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.95f, 1f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.95f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, rotation, scaleX, scaleY).setDuration(500).start();
    }

    public static void animateViewBounce(View view) {
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 1f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.5f, 1f);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY, alpha).setDuration(300).start();
    }
}
