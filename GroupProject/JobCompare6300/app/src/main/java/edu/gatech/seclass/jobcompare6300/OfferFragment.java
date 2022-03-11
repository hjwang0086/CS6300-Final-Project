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

public class OfferFragment extends Fragment {
    private UserViewModel mModel;
    private Job currentOffer;

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
                if (currentOffer == null) {
                    Toast.makeText(getContext(), "Please save offer before compare", Toast.LENGTH_LONG).show();
                } else if (mModel.getCurrentJob().isCurrentJob() == false) {
                    Toast.makeText(getContext(), "Please enter current job beforehand", Toast.LENGTH_LONG).show();
                } else {
                    mModel.setCompareJob1(mModel.getCurrentJob());
                    mModel.setCompareJob2(currentOffer);
                    Navigation.findNavController(view).navigate(R.id.action_offer_to_compare);
                }
            }
        });
        view.findViewById(R.id.btn_offer_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success = addJobOffer();
                if (success) {
                    Toast.makeText(getContext(), "Offer has been saved!", Toast.LENGTH_LONG).show();
                    clearText();
                }
            }
        });
        view.findViewById(R.id.btn_offer_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { clearText(); }
        });

        return view;
    }

    private void clearText() {
        EditText id = getView().findViewById(R.id.offer_editTitle);
        id.setText("");

        id = getView().findViewById(R.id.offer_editCompany);
        id.setText("");

        id = getView().findViewById(R.id.offer_editLocation);
        id.setText("");

        id = getView().findViewById(R.id.offer_editLivingCost);
        id.setText("");

        id = getView().findViewById(R.id.offer_editSalary);
        id.setText("");

        id = getView().findViewById(R.id.offer_editBonus);
        id.setText("");

        id = getView().findViewById(R.id.offer_editRetirementBenefits);
        id.setText("");

        id = getView().findViewById(R.id.offer_editRelocation);
        id.setText("");

        id = getView().findViewById(R.id.offer_editStock);
        id.setText("");
    }

    private boolean addJobOffer() {
        Job newJob = new Job();

        EditText editTitle = getView().findViewById(R.id.offer_editTitle);
        if (!TextUtils.isEmpty(editTitle.getText())) {
            newJob.setTitle(editTitle.getText().toString());
        } else {
            Toast.makeText(getContext(), "Title should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editCompany = getView().findViewById(R.id.offer_editCompany);
        if (!TextUtils.isEmpty(editCompany.getText())) {
            newJob.setCompany(editCompany.getText().toString());
        }  else {
            Toast.makeText(getContext(), "Company name should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editLocation = getView().findViewById(R.id.offer_editLocation);
        if (!TextUtils.isEmpty(editLocation.getText())) {
            newJob.setLocation(editLocation.getText().toString());
        }  else {
            Toast.makeText(getContext(), "Location should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editLivingCost = getView().findViewById(R.id.offer_editLivingCost);
        if (!TextUtils.isEmpty(editLivingCost.getText())) {
            newJob.setLivingCost(Integer.parseInt(editLivingCost.getText().toString()));
        }  else {
            Toast.makeText(getContext(), "Cost of living should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editSalary = getView().findViewById(R.id.offer_editSalary);
        if (!TextUtils.isEmpty(editSalary.getText())) {
            newJob.setSalary(Integer.parseInt(editSalary.getText().toString()));
        }  else {
            Toast.makeText(getContext(), "Yearly salary should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editBonus = getView().findViewById(R.id.offer_editBonus);
        if (!TextUtils.isEmpty(editBonus.getText())) {
            newJob.setBonus(Integer.parseInt(editBonus.getText().toString()));
        }  else {
            Toast.makeText(getContext(), "Yearly bonus should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editRetirementBenefits = getView().findViewById(R.id.offer_editRetirementBenefits);
        if (!TextUtils.isEmpty(editRetirementBenefits.getText())) {
            newJob.setRetirementBenefits(Integer.parseInt(editRetirementBenefits.getText().toString()));
        }  else {
            Toast.makeText(getContext(), "Retirement benefit should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editRelocation = getView().findViewById(R.id.offer_editRelocation);
        if (!TextUtils.isEmpty(editRelocation.getText())) {
            newJob.setRelocation(Integer.parseInt(editRelocation.getText().toString()));
        }  else {
            Toast.makeText(getContext(), "Relocation stipend should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        EditText editStock = getView().findViewById(R.id.offer_editStock);
        if (!TextUtils.isEmpty(editStock.getText())) {
            newJob.setStock(Integer.parseInt(editStock.getText().toString()));
        } else {
            Toast.makeText(getContext(), "Restricted stock unit award should not be empty", Toast.LENGTH_LONG).show();
            return false;
        }

        currentOffer = newJob;
        mModel.addJobOffer(newJob);
        return true;
    }
}