package com.example.dickiez.vertilogic.Server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dickiez on 4/10/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}