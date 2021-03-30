package com.example.jobsapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jobsapp.databinding.FragmentDetailsBinding;
import com.example.jobsapp.model.JobsModel;


public class DetailsFragment extends Fragment {

    JobsModel receivedJobs;
    FragmentDetailsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {

            receivedJobs = (JobsModel) args.getSerializable("azza");
            binding.nameTv.setText(receivedJobs.getCompanyName());
            binding.titleTv.setText(receivedJobs.getTitle());
            binding.typeTv.setText(receivedJobs.getType());
            binding.urlTv.setText(receivedJobs.getUrl());
            binding.compenyUrlTv.setText(receivedJobs.getCompanyUrl());
            binding.description.setText(receivedJobs.getDescription());
            //Glide.with(requireContext()).load(receivedJobs.getImage()).into(productIv);
        }
    }
}