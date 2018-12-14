package com.example.hua.yatnet.net;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ZengHongHua on 2018/12/14.
 */
public interface ApiService {

    //发现模块数据
    @GET("V7/music_modules")
    Call<ResponseBody> getFindData(
            @Query("sskey") String sskey,
            @Query("type") int type,        //android固定传1
            @Query("page") int page,        //起始传1
            @Query("facility_id") String facility_id
    );

    //@Headers("Content-Type: application/json")
    @POST("mock/11/upgrade/")
    Call<ResponseBody> upgrade(
            @HeaderMap Map<String, String> map,
            @Body RequestBody requestBody
    );
}
