package com.example.jobsapp.ui.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jobsapp.R;
import com.example.jobsapp.data.RetrofitFactory;
import com.example.jobsapp.data.WebServices;
import com.example.jobsapp.databinding.FragmentHomeBinding;
import com.example.jobsapp.model.JobsModel;
import com.example.jobsapp.ui.JobsViewModel;
import com.example.jobsapp.ui.adapter.JobsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    //RecyclerView RvJobs;
    JobsAdapter adapter;
    List<JobsModel> jobsModelList = new ArrayList<>();
    JobsViewModel viewModel;
    WebServices webServices;
    ProgressDialog dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        //viewModel = ViewModelProviders.of(this).get(JobsViewModel.class);
        //viewModel.
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
        getAllJobs();
    }

    //===================================================
    private void getAllJobs() {
        showLoadingDialog();
        webServices = RetrofitFactory.getRetrofit().create(WebServices.class);
        Call<List<JobsModel>> listCall = webServices.getAllJobs();
        listCall.enqueue(new Callback<List<JobsModel>>() {
            @Override
            public void onResponse(Call<List<JobsModel>> call, Response<List<JobsModel>> response) {
                hideLoading();
                jobsModelList.clear();
                jobsModelList.addAll(response.body());
                Toast.makeText(getContext(), "sucsess", Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<JobsModel>> call, Throwable t) {
                Toast.makeText(getContext(), "error", Toast.LENGTH_LONG).show();
            }
        });
    }

    //=============================================
    private void hideLoading() {
        dialog.dismiss();
    }

    //=========================================
    private void showLoadingDialog() {
        dialog = ProgressDialog.show(getContext(), "",
                "Loading. Please wait...", true);
        dialog.show();
    }

    //==============================================
    private void setUpRecyclerView() {
        binding.jobsRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.jobsRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));


        adapter = new JobsAdapter(getContext(), jobsModelList, new JobsAdapter.OnItemClick() {
            @Override
            public void onViewClick(View v, int position) {

                JobsModel clickedJob = jobsModelList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("azza", clickedJob);
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_detailsFragment, bundle);
            }
        });
        binding.jobsRv.setAdapter(adapter);
    }

}