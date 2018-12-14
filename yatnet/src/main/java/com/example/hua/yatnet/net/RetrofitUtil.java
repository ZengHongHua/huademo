package com.example.hua.yatnet.net;

import com.example.hua.yatnet.util.ZLog;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by ZengHongHua on 2018/12/14.
 */
public class RetrofitUtil {

    private static OkHttpClient.Builder okHttpClientBuilder;

    private static ApiService mApiService;

    private static RetrofitUtil mInstance;

    private static final int DEFAULT_TIMEOUT = 45;//请求超时时长，单位秒

    public static RetrofitUtil getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtil();
                }
            }
        }
        return mInstance;
    }

    public RetrofitUtil() {
        okHttpClientBuilder = new OkHttpClient.Builder();
        //连接失败后是否重新连接
        //okHttpClientBuilder.retryOnConnectionFailure(true);
        //设置请求超时时长
        okHttpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //okHttpClientBuilder.addInterceptor(getHeaderInterceptor());
        //启用Log日志
        if (ZLog.isDebug) {
            okHttpClientBuilder.addInterceptor(getHttpLoggingInterceptor());
        }
        //设置缓存方式、时长、地址
//        okHttpClientBuilder.addNetworkInterceptor(getCacheInterceptor());
//        okHttpClientBuilder.addInterceptor(getCacheInterceptor());
//        okHttpClientBuilder.cache(getCache());
        //设置https访问(验证证书)
//            okHttpClientBuilder.sslSocketFactory(getSSLSocketFactory(mContext, new int[]{R.raw.tomcat}));//请把服务器给的证书文件放在R.raw文件夹下
//            okHttpClientBuilder.hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        //设置统一的header
//            okHttpClientBuilder.addInterceptor(getHeaderInterceptor());
    }

    public ApiService getApiService() {
        if (mApiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    //服务器地址
                    .baseUrl(NetUrl.baseUrl)//公共URL
                    //配置转化库，采用Gson
                    //.addConverterFactory(GsonConverterFactory.create())
                    //配置回调库，采用RxJava
                    //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //设置OKHttpClient为网络客户端
                    .client(okHttpClientBuilder.build())
                    .build();
            mApiService = retrofit.create(ApiService.class);
            return mApiService;
        } else {
            return mApiService;
        }
    }

    //提供Log日志
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    public void callAppData(Call<ResponseBody> call, final NetListener listener) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);

                        ZLog.d("请求地址callAppData:" + call.request().url().url() + ",返回数据callAppData:" + json);
                        ZLog.d(jsonObject.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
