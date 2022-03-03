package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        TextView mTitle1 = view.findViewById(R.id.rank_title1);
        mTitle1.setText(mModel.getCurrentJob().getTitle());
        TextView mCompany1 = view.findViewById(R.id.rank_company1);
        mCompany1.setText(mModel.getCurrentJob().getCompany());

        view.findViewById(R.id.btn_rank_compare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_rank_to_compare);
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
}