package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserViewModel mModel;
    private JobDao jobDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mModel = new ViewModelProvider(this).get(UserViewModel.class);
        jobDao = new JobDao(this);
        jobDao.open();
        List<Job> jobs = jobDao.getData();
        List<Job> jobOffers = new ArrayList<Job>();
        for (Job job : jobs) {
            if (job.isCurrentJob()) {
                mModel.setCurrentJob(job);
            } else {
                jobOffers.add(job);
            }
        }
        mModel.setJobOffers(jobOffers);
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (Job job : mModel.getJobs()) {
            jobDao.addJobs(job);
        }
        jobDao.close();
    }
}