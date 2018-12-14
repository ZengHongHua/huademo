package com.example.hua.normalusedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.hua.normalusedemo.base.BaseActivity;
import com.example.hua.normalusedemo.ui.NetUseActivity;
import com.example.hua.yatnet.util.ToastUtil;

/**
 * Created by ZengHongHua on 2018/12/14.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToastUtil.showNormalToast(this, "呵呵");

        findViewById(R.id.hello_world).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NetUseActivity.class));
            }
        });
    }
}
