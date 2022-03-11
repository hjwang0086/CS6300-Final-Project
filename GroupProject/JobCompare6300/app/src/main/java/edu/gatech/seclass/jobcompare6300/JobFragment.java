package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class JobFragment extends Fragment {
    private UserViewModel mModel;

    public JobFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_job, container, false);
        mModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        // Initialize text if saved previously
        if (mModel.getCurrentJob().isCurrentJob()) {
            EditText id = view.findViewById(R.id.job_editTitle);
            id.setText(mModel.getCurrentJob().getTitle());

            id = view.findViewById(R.id.job_editCompany);
            id.setText(mModel.getCurrentJob().getCompany());

            id = view.findViewById(R.id.job_editLocation);
            id.setText(mModel.getCurrentJob().getLocation());

            id = view.findViewById(R.id.job_editLivingCost);
            id.setText(Integer.toString(mModel.getCurrentJob().getLivingCost()));

            id = view.findViewById(R.id.job_editSalary);
            id.setText(Integer.toString(mModel.getCurrentJob().getSalary()));

            id = view.findViewById(R.id.job_editBonus);
            id.setText(Integer.toString(mModel.getCurrentJob().getBonus()));

            id = view.findViewById(R.id.job_editRetirementBenefits);
            id.setText(Integer.toString(mModel.getCurrentJob().getRetirementBenefits()));

            id = view.findViewById(R.id.job_editRelocation);
            id.setText(Integer.toString(mModel.getCurrentJob().getRelocation()));

            id = view.findViewById(R.id.job_editStock);
            id.setText(Integer.toString(mModel.getCurrentJob().getStock()));
        }

        view.findViewById(R.id.btn_job_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success = saveCurrentJob();
                if (success) {
                    Toast.makeText(getContext(), "Current job has been saved!", Toast.LENGTH_LONG).show();
                    Navigation.findNavController(view).navigate(R.id.action_job_to_title);
                }
            }
        });
        view.findViewById(R.id.btn_job_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_job_to_title);
            }
        });
        return view;
    }

    private boolean saveCurrentJob() {
        Job newJob = new Job();

        EditText editTitle = getView().findViewById(R.id.job_editTitle);
        if (!TextUtils.isEmpty(editTitle.getText())) {
            newJob.setTitle(editTitle.getText().toString());
        } else {
            Toast.makeText(getContext(), "Title should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editCompany = getView().findViewById(R.id.job_editCompany);
        if (!TextUtils.isEmpty(editCompany.getText())) {
            newJob.setCompany(editCompany.getText().toString());
        } else {
            Toast.makeText(getContext(), "Company name should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editLocation = getView().findViewById(R.id.job_editLocation);
        if (!TextUtils.isEmpty(editLocation.getText())) {
            newJob.setLocation(editLocation.getText().toString());
        } else {
            Toast.makeText(getContext(), "Location should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editLivingCost = getView().findViewById(R.id.job_editLivingCost);
        if (!TextUtils.isEmpty(editLivingCost.getText())) {
            newJob.setLivingCost(Integer.parseInt(editLivingCost.getText().toString()));
        } else {
            Toast.makeText(getContext(), "Cost of living should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editSalary = getView().findViewById(R.id.job_editSalary);
        if (!TextUtils.isEmpty(editSalary.getText())) {
            newJob.setSalary(Integer.parseInt(editSalary.getText().toString()));
        } else {
            Toast.makeText(getContext(), "Yearly salary should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editBonus = getView().findViewById(R.id.job_editBonus);
        if (!TextUtils.isEmpty(editBonus.getText())) {
            newJob.setBonus(Integer.parseInt(editBonus.getText().toString()));
        } else {
            Toast.makeText(getContext(), "Yearly bonus should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editRetirementBenefits = getView().findViewById(R.id.job_editRetirementBenefits);
        if (!TextUtils.isEmpty(editRetirementBenefits.getText())) {
            newJob.setRetirementBenefits(Integer.parseInt(editRetirementBenefits.getText().toString()));
        } else {
            Toast.makeText(getContext(), "Retirement benefit should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editRelocation = getView().findViewById(R.id.job_editRelocation);
        if (!TextUtils.isEmpty(editRelocation.getText())) {
            newJob.setRelocation(Integer.parseInt(editRelocation.getText().toString()));
        } else {
            Toast.makeText(getContext(), "Relocation stipend should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editStock = getView().findViewById(R.id.job_editStock);
        if (!TextUtils.isEmpty(editStock.getText())) {
            newJob.setStock(Integer.parseInt(editStock.getText().toString()));
        } else {
            Toast.makeText(getContext(), "Restricted stock unit award should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        newJob.setCurrentJob(true);
        mModel.setCurrentJob(newJob);

        return true;
    }
}