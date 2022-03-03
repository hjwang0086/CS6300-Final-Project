package edu.gatech.seclass.jobcompare6300;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private Job mCurrentJob;
    private List<Job> mJobOffers;

    public UserViewModel(Application application) {
        super(application);
        mCurrentJob = new Job();
        mJobOffers = new ArrayList<Job>();
    }

    public Job getCurrentJob() { return mCurrentJob; }
    public List<Job> getJobOffers() { return mJobOffers; }

    public void addJobOffers(Job jobOffer) { mJobOffers.add(jobOffer); }
}
