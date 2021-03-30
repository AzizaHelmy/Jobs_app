package com.example.jobsapp.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jobsapp.data.RetrofitFactory;
import com.example.jobsapp.data.WebServices;

public class JobsViewModel extends ViewModel {

    MutableLiveData<String> jobsMutableLiveData = new MutableLiveData<>();
    WebServices webServices;

    public void getALLJobs() {
        webServices = RetrofitFactory.getRetrofit().create(WebServices.class);
        webServices.getAllJobs();

    }
}
