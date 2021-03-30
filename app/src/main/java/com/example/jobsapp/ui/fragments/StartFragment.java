package com.example.jobsapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.jobsapp.R;
import com.example.jobsapp.databinding.FragmentStartBinding;


public class StartFragment extends Fragment {
    FragmentStartBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.startButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.homeFragment);
//                Intent i = new Intent(MainActivity.this, HomeFragment.class);
//                startActivity(i);
            }
        });
    }
}