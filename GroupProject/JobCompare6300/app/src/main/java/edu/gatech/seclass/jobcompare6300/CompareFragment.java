package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CompareFragment extends Fragment {
    private UserViewModel mModel;

    public CompareFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compare, container, false);
        mModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        view.findViewById(R.id.btn_compare_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetSelected();
                // Navigation.findNavController(view).navigate(R.id.action_compare_to_title);
                Navigation.findNavController(view).popBackStack();
            }
        });
        view.findViewById(R.id.btn_compare_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetSelected();
                Navigation.findNavController(view).navigate(R.id.action_compare_to_title);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setScreen();
    }

    private void setScreen() {
        TextView textTitle1 = getView().findViewById(R.id.compare_textTitle1);
        if (!mModel.getCompareJob1().getTitle().isEmpty()) {
            textTitle1.setText(mModel.getCompareJob1().getTitle());
        }
        TextView textCompany1 = getView().findViewById(R.id.compare_textCompany1);
        if (!mModel.getCompareJob1().getCompany().isEmpty()) {
            textCompany1.setText(mModel.getCompareJob1().getCompany());
        }
        TextView textLocation1 = getView().findViewById(R.id.compare_textLocation1);
        if (!mModel.getCompareJob1().getLocation().isEmpty()) {
            textLocation1.setText(mModel.getCompareJob1().getLocation());
        }
        TextView textSalary1 = getView().findViewById(R.id.compare_textSalary1);
        textSalary1.setText(Integer.toString(mModel.getCompareJob1().getAdjustedSalary()));
        TextView textBonus1 = getView().findViewById(R.id.compare_textBonus1);
        textBonus1.setText(Integer.toString(mModel.getCompareJob1().getAdjustedBonus()));
        TextView textRetirementBenefits1 = getView().findViewById(R.id.compare_textRetirementBenefits1);
        textRetirementBenefits1.setText(Integer.toString(mModel.getCompareJob1().getRetirementBenefits()));
        TextView textRelocation1 = getView().findViewById(R.id.compare_textRelocation1);
        textRelocation1.setText(Integer.toString(mModel.getCompareJob1().getRelocation()));
        TextView textStock1 = getView().findViewById(R.id.compare_textStock1);
        textStock1.setText(Integer.toString(mModel.getCompareJob1().getStock()));

        TextView textTitle2 = getView().findViewById(R.id.compare_textTitle2);
        if (!mModel.getCompareJob2().getTitle().isEmpty()) {
            textTitle2.setText(mModel.getCompareJob2().getTitle());
        }
        TextView textCompany2 = getView().findViewById(R.id.compare_textCompany2);
        if (!mModel.getCompareJob2().getCompany().isEmpty()) {
            textCompany2.setText(mModel.getCompareJob2().getCompany());
        }
        TextView textLocation2 = getView().findViewById(R.id.compare_textLocation2);
        if (!mModel.getCompareJob2().getLocation().isEmpty()) {
            textLocation2.setText(mModel.getCompareJob2().getLocation());
        }
        TextView textSalary2 = getView().findViewById(R.id.compare_textSalary2);
        textSalary2.setText(Integer.toString(mModel.getCompareJob2().getAdjustedSalary()));
        TextView textBonus2 = getView().findViewById(R.id.compare_textBonus2);
        textBonus2.setText(Integer.toString(mModel.getCompareJob2().getAdjustedBonus()));
        TextView textRetirementBenefits2 = getView().findViewById(R.id.compare_textRetirementBenefits2);
        textRetirementBenefits2.setText(Integer.toString(mModel.getCompareJob2().getRetirementBenefits()));
        TextView textRelocation2 = getView().findViewById(R.id.compare_textRelocation2);
        textRelocation2.setText(Integer.toString(mModel.getCompareJob2().getRelocation()));
        TextView textStock2 = getView().findViewById(R.id.compare_textStock2);
        textStock2.setText(Integer.toString(mModel.getCompareJob2().getStock()));
    }

    private void resetSelected() {
        for (Job job : mModel.getJobs()) {
            job.setSelected(false);
        }
    }
}