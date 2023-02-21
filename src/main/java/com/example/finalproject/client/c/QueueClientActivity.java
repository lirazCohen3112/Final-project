package com.example.finalproject.client.c;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;
import com.example.finalproject.client.c.FragmentsClientlistQueue;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QueueClientActivity extends AppCompatActivity {

        private MaterialTextView table_records_LBL_title;
        private FrameLayout table_records_LAY_list;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_table_queue);

            findViews();

            //View view = inflater.inflate(R.layout.QueueTrackingActivity, container, false);

            FragmentsClientlistQueue fragmentsClientlistClient = new FragmentsClientlistQueue();
            getSupportFragmentManager().beginTransaction().add(R.id.table_records_LAY_list , fragmentsClientlistClient).commit();

        }

        private void findViews() {
            table_records_LAY_list = findViewById(R.id.table_records_LAY_list);
            table_records_LBL_title = findViewById(R.id.table_records_LBL_title);
        }
}
