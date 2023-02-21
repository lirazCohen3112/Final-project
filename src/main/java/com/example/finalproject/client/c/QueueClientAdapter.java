package com.example.finalproject.client.c;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.activities.MenuActivity;
import com.example.finalproject.client.QueueReservationClient;
import com.example.finalproject.client.datesActivityClient;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class QueueClientAdapter extends RecyclerView.Adapter<QueueClientAdapter.QueuesClientHolder> {

    private Fragment fragment;
    private ArrayList<QueueClient> queuesClient;

    public QueueClientAdapter(Fragment fragment , ArrayList<QueueClient> queuesClient){
        this.queuesClient= queuesClient;
        this.fragment = fragment;
    }

    @Override
    public int getItemCount() {
        return queuesClient == null ? 0 : queuesClient.size();
    }

    @Override
    public QueueClientAdapter.QueuesClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_list_queue, parent, false);
        QueueClientAdapter.QueuesClientHolder queuesClientHolder = new QueueClientAdapter.QueuesClientHolder(view);
        return queuesClientHolder;

    }

    @Override
    public void onBindViewHolder(final QueueClientAdapter.QueuesClientHolder holder, final int position) {

        QueueClient queueClient = queuesClient.get(position);

        holder.list_queue_LBL_Registration.setText(queueClient.getStatus());
        holder. list_queue_LBL_time.setText(queueClient.getTime());

    }

    class QueuesClientHolder extends RecyclerView.ViewHolder{
        private MaterialButton list_queue_LBL_Registration;
        private MaterialTextView list_queue_LBL_time;

        public QueuesClientHolder(View itemView) {
            super(itemView);
            list_queue_LBL_Registration = itemView.findViewById(R.id.list_queue_LBL_Registration);
            list_queue_LBL_time = itemView.findViewById(R.id.list_queue_LBL_time);

             list_queue_LBL_Registration.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        v.getContext().startActivity(new Intent(v.getContext(), QueueReservationClient.class));
                        list_queue_LBL_Registration.setVisibility(View.GONE);
                    }
             });
        }
    }
}

