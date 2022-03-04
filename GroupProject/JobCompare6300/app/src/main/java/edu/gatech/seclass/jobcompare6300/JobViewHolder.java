package edu.gatech.seclass.jobcompare6300;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class JobViewHolder  extends RecyclerView.ViewHolder {
    public View mView;
    public LinearLayout mLinearLayout;
    public TextView mRank;
    public TextView mTitle;
    public TextView mCompany;

    public JobViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
        mLinearLayout = itemView.findViewById(R.id.item_linearLayout);
        mRank = itemView.findViewById(R.id.item_rank);
        mTitle = itemView.findViewById(R.id.item_title);
        mCompany = itemView.findViewById(R.id.item_company);
    }
}
