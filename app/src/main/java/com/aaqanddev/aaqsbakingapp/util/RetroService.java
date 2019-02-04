package com.aaqanddev.aaqsbakingapp.util;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroService {
    private static final String mBASE_URL = "https://d17h27t6h515a5.cloudfront.net/";
    private static Retrofit sRetro = null;
    private static HttpLoggingInterceptor sInterceptor = new HttpLoggingInterceptor();
    private static OkHttpClient sClient = new OkHttpClient();

    public static Retrofit getRetroInstance(Gson gson){
        if (null == sRetro){
            sInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            sClient.newBuilder()
                    .addInterceptor(sInterceptor).build();

            sRetro = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(sClient)
                    .baseUrl(mBASE_URL)
                    .build();
        }
        return sRetro;
    }
}