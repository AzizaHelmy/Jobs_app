package com.example.jobsapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobsapp.R;
import com.example.jobsapp.databinding.JobsRvItemBinding;
import com.example.jobsapp.model.JobsModel;

import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.JobsViewHolder> {
    List<JobsModel> jobsModelList;
    JobsRvItemBinding binding;
    OnItemClick itemClicked;
    Context context;

    public interface OnItemClick {
        void onViewClick(View v, int position);
    }

    public JobsAdapter( Context context,List<JobsModel> jobsModelList, OnItemClick itemClicked) {
        this.jobsModelList = jobsModelList;
        this.itemClicked = itemClicked;
        this.context = context;
    }

    @NonNull
    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.jobs_rv_item, parent, false);
        return new JobsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsViewHolder holder, int position) {
        JobsModel model = jobsModelList.get(position);
        holder.name.setText(model.getCompanyName());
        holder.title.setText(model.getTitle());
        //holder.logo.setImageResource(model.);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          itemClicked.onViewClick(v, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobsModelList.size();
    }

    //======================================================//
    class JobsViewHolder extends RecyclerView.ViewHolder{
        ImageView logo;
        TextView title;
        TextView name;
        public JobsViewHolder(@NonNull View itemView) {
            super(itemView);
//            binding = JobsRvItemBinding.bind(itemView);
            logo = itemView.findViewById(R.id.company_logo_iv);
            title = itemView.findViewById(R.id.job_title_tv);
            name = itemView.findViewById(R.id.compony_name_tv);
        }
    }
}
