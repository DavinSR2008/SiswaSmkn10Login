package com.example.siswa.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String BASE_URL = "https://script.google.com/macros/s/AKfycbyV2tvY2GYz1rZpk6iZ7wt_W8Vuc1r5sJrftT9Zk2eJeDiszzRv6XtOnTeOwwf_bPnf7A/";

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();

    private static Gson gson = new GsonBuilder()
            .create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public static <S> S createService(Class<S>serviceClass){
        return retrofit.create(serviceClass);
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
