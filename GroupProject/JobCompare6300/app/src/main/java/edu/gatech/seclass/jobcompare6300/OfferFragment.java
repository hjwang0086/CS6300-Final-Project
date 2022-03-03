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

public class OfferFragment extends Fragment {
    private UserViewModel mModel;

    public OfferFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offer, container, false);
        mModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        view.findViewById(R.id.btn_offer_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_offer_to_title);
            }
        });
        view.findViewById(R.id.btn_offer_compare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_offer_to_compare);
            }
        });
        view.findViewById(R.id.btn_offer_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addJobOffer();
            }
        });
        return view;
    }

    private void addJobOffer() {
        Job newJob = new Job();

        EditText editTitle = getView().findViewById(R.id.offer_editTitle);
        if (!TextUtils.isEmpty(editTitle.getText())) {
            newJob.setTitle(editTitle.getText().toString());
        }
        EditText editCompany = getView().findViewById(R.id.offer_editCompany);
        if (!TextUtils.isEmpty(editCompany.getText())) {
            newJob.setCompany(editCompany.getText().toString());
        }
        EditText editLocation = getView().findViewById(R.id.offer_editLocation);
        if (!TextUtils.isEmpty(editLocation.getText())) {
            newJob.setLocation(editLocation.getText().toString());
        }
        EditText editLivingCost = getView().findViewById(R.id.offer_editLivingCost);
        if (!TextUtils.isEmpty(editLivingCost.getText())) {
            newJob.setLivingCost(Integer.parseInt(editLivingCost.getText().toString()));
        }
        EditText editSalary = getView().findViewById(R.id.offer_editSalary);
        if (!TextUtils.isEmpty(editSalary.getText())) {
            newJob.setSalary(Integer.parseInt(editSalary.getText().toString()));
        }
        EditText editBonus = getView().findViewById(R.id.offer_editBonus);
        if (!TextUtils.isEmpty(editBonus.getText())) {
            newJob.setBonus(Integer.parseInt(editBonus.getText().toString()));
        }
        EditText editRetirementBenefits = getView().findViewById(R.id.offer_editRetirementBenefits);
        if (!TextUtils.isEmpty(editRetirementBenefits.getText())) {
            newJob.setRetirementBenefits(Integer.parseInt(editRetirementBenefits.getText().toString()));
        }
        EditText editRelocation = getView().findViewById(R.id.offer_editRelocation);
        if (!TextUtils.isEmpty(editRelocation.getText())) {
            newJob.setRelocation(Integer.parseInt(editRelocation.getText().toString()));
        }
        EditText editStock = getView().findViewById(R.id.offer_editStock);
        if (!TextUtils.isEmpty(editStock.getText())) {
            newJob.setStock(Integer.parseInt(editStock.getText().toString()));
        }

        mModel.addJobOffer(newJob);
    }
}