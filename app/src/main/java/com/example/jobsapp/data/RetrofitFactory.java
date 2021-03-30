package com.example.jobsapp.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static Retrofit retrofit;//obj from retrofit class
    private static final String BASE_URL = "https://jobs.github.com/";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }

        return retrofit;
    }
}
