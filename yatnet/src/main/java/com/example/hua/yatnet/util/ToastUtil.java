package com.example.hua.yatnet.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hua.yatnet.R;

public class ToastUtil {
    /**
     * 显示普通Toast
     */
    public static void showNormalToast(Context context, String message) {
        try {
            if (!ZUtil.isEmpty(message) && null != context) {
                View view = LayoutInflater.from(context).inflate(R.layout.toast_view, null);
                TextView infoView = (TextView) view.findViewById(R.id.view_Toast_text);
                infoView.setText(message);

                Toast toast = new Toast(context);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示普通Toast, 可传显示时间
     */
    public static void showNormalToast(Context context, String message, int length) {
        try {
            if (!ZUtil.isEmpty(message) && null != context) {
                View view = LayoutInflater.from(context).inflate(R.layout.toast_view, null);
                TextView infoView = (TextView) view.findViewById(R.id.view_Toast_text);
                infoView.setText(message);
                Toast toast = new Toast(context);
                toast.setDuration(length);
                toast.setView(view);
                toast.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 暴力点击使用Toast
     */
    public static void showSingleToast(Context context, String text) {
        try {
            if (!ZUtil.isEmpty(text) && null != context) {
                View view = LayoutInflater.from(context).inflate(R.layout.toast_view, null);
                TextView infoView = (TextView) view.findViewById(R.id.view_Toast_text);
                infoView.setText(text);
                Toast toast = SingleToast.getInstance(context);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
