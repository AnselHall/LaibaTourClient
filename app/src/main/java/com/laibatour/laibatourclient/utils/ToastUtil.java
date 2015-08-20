package com.laibatour.laibatourclient.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    /**
     * 可以连续弹吐司，不用等上个吐司消失，直接显示
     *
     * @param text
     */
    public static void showToast(Context context,String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
}
