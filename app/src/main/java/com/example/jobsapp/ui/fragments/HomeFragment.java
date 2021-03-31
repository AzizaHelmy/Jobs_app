package com.example.jobsapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jobsapp.R;
import com.example.jobsapp.databinding.FragmentHomeBinding;
import com.example.jobsapp.model.JobsModel;
import com.example.jobsapp.ui.adapter.JobsAdapter;
import com.example.jobsapp.ui.main.JobsViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;


    JobsAdapter adapter;
    List<JobsModel> jobsModelList = new ArrayList<>();

    JobsViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
        getAllJobs();
    }

    //===============================================
    private void getAllJobs() {
        viewModel = ViewModelProviders.of(this).get(JobsViewModel.class);
        viewModel.getAllJobs();
        viewModel.jobsMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<JobsModel>>() {
            @Override
            public void onChanged(List<JobsModel> jobsModels) {
                jobsModelList.clear();
                jobsModelList.addAll(jobsModels);
                adapter.notifyDataSetChanged();
            }
        });
    }
    //===================================================
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