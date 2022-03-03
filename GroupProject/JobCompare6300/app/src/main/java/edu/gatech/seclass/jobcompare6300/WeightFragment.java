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

public class WeightFragment extends Fragment {
    private UserViewModel mModel;

    public WeightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight, container, false);
        mModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        view.findViewById(R.id.btn_weight_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveWeight();
                Navigation.findNavController(view).navigate(R.id.action_weight_to_title);
            }
        });
        view.findViewById(R.id.btn_weight_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_weight_to_title);
            }
        });
        return view;
    }

    private void saveWeight() {
        Weight newWeight = new Weight();

        EditText editAYS = getView().findViewById(R.id.text_weight_salary);
        if (!TextUtils.isEmpty(editAYS.getText())) {
            newWeight.setAYS(Integer.parseInt(editAYS.getText().toString()));
        }
        EditText editAYB = getView().findViewById(R.id.text_weight_bonus);
        if (!TextUtils.isEmpty(editAYB.getText())) {
            newWeight.setAYB(Integer.parseInt(editAYB.getText().toString()));
        }
        EditText editRS = getView().findViewById(R.id.text_weight_stipend);
        if (!TextUtils.isEmpty(editRS.getText())) {
            newWeight.setRS(Integer.parseInt(editRS.getText().toString()));
        }
        EditText editRPB = getView().findViewById(R.id.text_weight_benefit);
        if (!TextUtils.isEmpty(editRPB.getText())) {
            newWeight.setRPB(Integer.parseInt(editRPB.getText().toString()));
        }
        EditText editRSUA = getView().findViewById(R.id.text_weight_stock);
        if (!TextUtils.isEmpty(editRSUA.getText())) {
            newWeight.setRSUA(Integer.parseInt(editRSUA.getText().toString()));
        }

        mModel.setWeight(newWeight);
    }
}