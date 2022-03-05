package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RankFragment extends Fragment {
    private UserViewModel mModel;

    public RankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        mModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        JobAdapter jobAdapter = new JobAdapter(mModel.getJobs());
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(jobAdapter);

        view.findViewById(R.id.btn_rank_compare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success = setCompareJobs(); // select two job exactly
                if (success) {
                    Navigation.findNavController(view).navigate(R.id.action_rank_to_compare);
                } else {
                    // TODO: solve the problem that error message doesn't show up
                    Button btn_id = (Button) view.findViewById(R.id.btn_rank_compare);
                    btn_id.setError("Number of selected jobs should be exactly 2.");
                }
            }
        });

        view.findViewById(R.id.btn_rank_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_rank_to_title);
            }
        });
        return view;
    }

    private boolean setCompareJobs() {
        //boolean isFirstJobSelected = false;
        int numSelected = 0;
        System.out.println(mModel.getJobs().size());
        for (Job job : mModel.getJobs()) {
            if (job.isSelected()) {
                if (numSelected == 0) {
                    mModel.setCompareJob1(job);
                } else {
                    mModel.setCompareJob2(job);
                }
                numSelected ++;
            }
        }

        return numSelected == 2; // success criteria
    }
}