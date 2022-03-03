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


public class JobFragment extends Fragment {
    private UserViewModel mModel;
    private EditText mEditTitle;

    public JobFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_job, container, false);
        mModel = new ViewModelProvider(this).get(UserViewModel.class);
        mEditTitle = view.findViewById(R.id.job_editTitle);

        view.findViewById(R.id.btn_job_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (!TextUtils.isEmpty(mEditTitle.getText())) {
                    //mModel.getCurrentJob().setTitle(mEditTitle.getText().toString());
                    mModel.getCurrentJob().setTitle("1");
                //}
                Navigation.findNavController(view).navigate(R.id.action_job_to_title);
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
}