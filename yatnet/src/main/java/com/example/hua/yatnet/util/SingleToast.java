package com.example.hua.yatnet.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 单一Toast
 * Created by ZengHongHua on 2018/2/10.
 */

public class SingleToast {

    private static Toast mToast;

    public static Toast getInstance(Context context) {
        if (mToast == null) {
            synchronized (SingleToast.class) {
                if (mToast == null) {
                    mToast = new Toast(context);
                }
            }
        }
        return mToast;
    }
}
