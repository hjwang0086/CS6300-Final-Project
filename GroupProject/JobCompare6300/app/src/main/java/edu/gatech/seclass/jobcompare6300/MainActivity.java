package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserViewModel mModel;
    private JobDao jobDao;
    private WeightDao weightDao;

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

        weightDao = new WeightDao(this);
        weightDao.open();
        Weight weight = weightDao.getWeight();
        if (weight != null) {
            mModel.setWeight(weight);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (Job job : mModel.getJobs()) {
            if (!job.isSaved()) {
                jobDao.addJobs(job);
            } else if (job.isCurrentJob()) {
                jobDao.updateJob(job);
            }
        }
        jobDao.close();

        if (weightDao.getWeight() == null) {
            weightDao.addWeight(mModel.getWeight());
        } else {
            weightDao.updateWeight(mModel.getWeight());
        }
        weightDao.close();
    }
}