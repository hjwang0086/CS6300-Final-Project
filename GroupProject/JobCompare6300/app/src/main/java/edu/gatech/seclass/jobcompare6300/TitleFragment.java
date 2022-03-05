package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TitleFragment extends Fragment {
    private UserViewModel mModel;

    public TitleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_title, container, false);
        mModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        view.findViewById(R.id.btn_title_setJob).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_title_to_job);
            }
        });
        view.findViewById(R.id.btn_title_setOffer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_title_to_offer);
            }
        });
        view.findViewById(R.id.btn_title_setWeights).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_title_to_weight);
            }
        });
        view.findViewById(R.id.btn_title_rankJobs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(mModel.getJobs().size());
                if (mModel.getJobs().size() >= 1) {
                    Navigation.findNavController(view).navigate(R.id.action_title_to_rank);
                } else {
                    // TODO: solve the problem that error message doesn't show up
                    Button btn_id = (Button) view.findViewById(R.id.btn_title_rankJobs);
                    btn_id.setError("There is no job currently.");
                }
            }
        });
        return view;
    }
}