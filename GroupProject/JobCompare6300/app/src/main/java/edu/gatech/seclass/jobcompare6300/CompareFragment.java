package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CompareFragment extends Fragment {

    public CompareFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compare, container, false);
        view.findViewById(R.id.btn_compare_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigation.findNavController(view).navigate(R.id.action_compare_to_title);
                Navigation.findNavController(view).popBackStack();
            }
        });
        view.findViewById(R.id.btn_compare_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_compare_to_title);
            }
        });
        return view;
    }
}