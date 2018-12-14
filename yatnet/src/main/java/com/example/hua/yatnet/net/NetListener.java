package com.example.hua.yatnet.net;

/**
 * Created by ZengHongHua on 2018/1/5.
 */

public interface NetListener {

    void onSuccess(String message);

    void onFailed(String message);
}
