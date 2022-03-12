package edu.gatech.seclass.jobcompare6300;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private Job mCurrentJob;
    private List<Job> mJobOffers;
    private Weight mWeight;
    private Job mCompareJob1;
    private Job mCompareJob2;

    public UserViewModel(Application application) {
        super(application);
        mCurrentJob = new Job();
        mJobOffers = new ArrayList<Job>();
        mWeight = new Weight();
        mCompareJob1 = new Job();
        mCompareJob2 = new Job();
    }

    public Job getCurrentJob() { return mCurrentJob; }
    public Weight getWeight() { return mWeight; }
    public Job getCompareJob1() { return mCompareJob1; }
    public Job getCompareJob2() { return mCompareJob2; }

    public void setCurrentJob(Job job) { mCurrentJob = job; }
    public void setWeight(Weight weight) { mWeight = weight; }
    public void setCompareJob1(Job job) { mCompareJob1 = job; }
    public void setCompareJob2(Job job) { mCompareJob2 = job; }
    public void setJobOffers(List<Job> jobOffers) { mJobOffers = jobOffers; }
    public void addJobOffer(Job job) { mJobOffers.add(job); }

    public List<Job> getJobs() {
        List<Job> jobs = new ArrayList<Job>(mJobOffers);
        if (mCurrentJob.isCurrentJob()) {
            jobs.add(mCurrentJob); // avoid adding redundant
        }
        jobs.sort(new ScoreComparator().reversed());

        return jobs;
    }

    private class ScoreComparator implements Comparator<Job> {
        private float score(Job job) {
            float score = job.getAdjustedSalary() * mWeight.getAYS()
                    + job.getAdjustedBonus() * mWeight.getAYB()
                    + job.getRelocation() * mWeight.getRS()
                    + (job.getRetirementBenefits() * (float)job.getSalary() / 100) * mWeight.getRPB()
                    + ((float)job.getStock() / 4) * mWeight.getRSUA();
            return (mWeight.getSum() == 0) ? score : score / mWeight.getSum();
        }

        // Function to compare
        public int compare(Job job1, Job job2) {
            return Float.compare(score(job1), score(job2));
        }
    }
}
