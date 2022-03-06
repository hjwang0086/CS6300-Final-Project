package edu.gatech.seclass.jobcompare6300;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobViewHolder> {
    private List<Job> mJobList;

    public JobAdapter(List<Job> jobList) {
        mJobList = jobList;
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JobViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final JobViewHolder holder, int position) {
        final Job job = mJobList.get(position);
        holder.mRank.setText(Integer.toString(position + 1));
        holder.mTitle.setText(job.getTitle());
        holder.mCompany.setText(job.getCompany());

        if (job.isCurrentJob()) {
            holder.mRank.setTextColor(Color.RED);
            holder.mRank.setTypeface(null, Typeface.BOLD);
            holder.mTitle.setTextColor(Color.RED);
            holder.mTitle.setTypeface(null, Typeface.BOLD);
            holder.mCompany.setTextColor(Color.RED);
            holder.mCompany.setTypeface(null, Typeface.BOLD);
        }

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Job selectedJob = mJobList.get(holder.getAdapterPosition());
                selectedJob.setSelected(!selectedJob.isSelected());
                holder.mView.setBackgroundColor(selectedJob.isSelected() ? Color.GREEN : Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mJobList == null ? 0 : mJobList.size();
    }

}
