package com.example.finalproject.Queue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class QueueAdapter extends RecyclerView.Adapter<QueueAdapter.QueuesHolder> {

    private Fragment fragment;
    private ArrayList<Queue> queues;

    public QueueAdapter(Fragment fragment , ArrayList<Queue> queues){
        this.queues=queues;
        this.fragment = fragment;
    }

    @Override
    public int getItemCount() {
        return queues == null ? 0 : queues.size();
    }

    @Override
    public QueuesHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_queue, parent, false);
        QueuesHolder queuesHolder = new QueuesHolder(view);
        return queuesHolder;
    }

    @Override
    public void onBindViewHolder(final  QueuesHolder holder, final int position) {

        Queue queue = queues.get(position);

        holder.list_record_LBL_status.setText(queue.getStatus());
        holder. list_record_LBL_time.setText(queue.getTime());
   //     holder.list_record_LBL_customer_name.setText("  name: " + queue.getCustomerName());
    }


    class QueuesHolder extends RecyclerView.ViewHolder{
        private MaterialTextView list_record_LBL_status;
        private MaterialTextView  list_record_LBL_time;
      //  private MaterialTextView list_record_LBL_customer_name;

        public QueuesHolder(View itemView) {
            super(itemView);
            list_record_LBL_status = itemView.findViewById(R.id.list_record_LBL_status);
            list_record_LBL_time = itemView.findViewById(R.id.list_record_LBL_time);
        //    list_record_LBL_customer_name = itemView.findViewById(R.id.list_record_LBL_customer_name);
        }
    }
}
