package com.nilecon.musicparkacademy.Service;

import android.content.Context;

import com.nilecon.musicparkacademy.BuildConfig;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by nileconthailand on 11/28/15 AD.
 */
public class RetrofitBase {

    public static Retrofit getBuilder(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(30 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Cache-Control", "max-age=0")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.END_POINT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
