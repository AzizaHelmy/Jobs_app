package com.example.jobsapp.ui.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jobsapp.model.JobsModel;
import com.example.jobsapp.network.RetrofitFactory;
import com.example.jobsapp.network.WebServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobsViewModel extends ViewModel {

    public MutableLiveData<List<JobsModel>> jobsMutableLiveData = new MutableLiveData<>();

    WebServices webServices;
    ProgressDialog dialog;
    Context context;

    public void getAllJobs() {
        showLoadingDialog();
        webServices = RetrofitFactory.getRetrofit().create(WebServices.class);
        Call<List<JobsModel>> listCall = webServices.getAllJobs();
        listCall.enqueue(new Callback<List<JobsModel>>() {
            @Override
            public void onResponse(Call<List<JobsModel>> call, Response<List<JobsModel>> response) {
                hideLoading();
                jobsMutableLiveData.setValue(response.body());
                Toast.makeText(context, "sucsess", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<JobsModel>> call, Throwable t) {
                Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
            }
        });
    }

    //=============================================
    private void hideLoading() {
        dialog.dismiss();
    }

    //=========================================
    private void showLoadingDialog() {
        dialog = ProgressDialog.show(context, "",
                "Loading. Please wait...", true);
        dialog.show();
    }

    //==============================================
}
// ...