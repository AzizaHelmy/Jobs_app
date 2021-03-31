package com.example.jobsapp.network;

import com.example.jobsapp.model.JobsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static Retrofit retrofit;//obj from retrofit class
    private static final String BASE_URL = "https://jobs.github.com/";
    WebServices webServices;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }

        return retrofit;
    }
//=======================================================//
    public Call<List<JobsModel>> getJobs(){
        return webServices.getAllJobs();
    }
}
