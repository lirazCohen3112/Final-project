package com.example.finalproject.care;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.client.QueueReservationClient;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class CareAdapter extends RecyclerView.Adapter<CareAdapter.CaresHolder> {

    private Fragment fragment;
    private ArrayList<Care> cares;

    public CareAdapter(Fragment fragment , ArrayList<Care> cares){
        this.cares=cares;
        this.fragment = fragment;
    }

    @Override
    public int getItemCount() {
        return cares == null ? 0 : cares.size();
    }

    @Override
    public CareAdapter.CaresHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_care, parent, false);
        CareAdapter.CaresHolder caresHolder = new CareAdapter.CaresHolder(view);
        return caresHolder;
    }

    @Override
    public void onBindViewHolder(final CareAdapter.CaresHolder holder, final int position) {

        Care care = cares.get(position);

        holder.list_LBL_care_name.setText("  name: " + care.getName());
        holder.list_LBL_care_explanation.setText("  explanation: " + care.getExplanation());
        holder.list_LBL_care_cost.setText("  cost: " + care.getCost());
        holder. list_LBL_care_time.setText("  time: " + care.getTime());

    }

    class CaresHolder extends RecyclerView.ViewHolder{
        private MaterialTextView list_LBL_care_name;
        private MaterialTextView  list_LBL_care_explanation;
        private MaterialTextView list_LBL_care_cost;
        private MaterialTextView list_LBL_care_time;
        private MaterialButton care_LBL_add_new_queue;

        public CaresHolder(View itemView) {
            super(itemView);
            list_LBL_care_name = itemView.findViewById(R.id.list_LBL_care_name);
            list_LBL_care_explanation = itemView.findViewById(R.id.list_LBL_care_explanation);
            list_LBL_care_cost = itemView.findViewById(R.id.list_LBL_care_cost);
            list_LBL_care_time = itemView.findViewById(R.id.list_LBL_care_time);
            //care_LBL_add_new_queue = itemView.findViewById(R.id.care_LBL_add_new_queue);

        }
    }
}