package com.example.hua.normalusedemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.hua.normalusedemo.R;
import com.example.hua.normalusedemo.base.BaseActivity;
import com.example.hua.yatnet.net.NetListener;
import com.example.hua.yatnet.net.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ZengHongHua on 2018/12/14.
 */
public class NetUseActivity extends BaseActivity {

    private Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_use);
        mBtn = findViewById(R.id.use_btn);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private void getData() {
        Call<ResponseBody> call = RetrofitUtil.getInstance().getApiService().getFindData("8280247A7480181C7ED33155F72C013Eprggwdc.=QDNwYTL", 1, 1, "mk07");
        RetrofitUtil.getInstance().callAppData(call, new NetListener() {
            @Override
            public void onSuccess(String message) {

            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    private void getData2() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("token", "value");
        map.put("key", "value");

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("old_version", "2222");
            jsonObject.put("upgrade_version", "22223");
            jsonObject.put("client_secret", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<ResponseBody> upgrade = RetrofitUtil.getInstance().getApiService().upgrade(map, requestBody);
        upgrade.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
