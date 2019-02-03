package com.aaqanddev.aaqsbakingapp.util;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroService {
    private static final String mBASE_URL = "https://d17h27t6h515a5.cloudfront.net/";
    private static Retrofit sRetro = null;


    public static Retrofit getRetroInstance(Gson gson, OkHttpClient client){
        if (null == sRetro){
            sRetro = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .baseUrl(mBASE_URL)
                    .build();
        }
        return sRetro;
    }
}