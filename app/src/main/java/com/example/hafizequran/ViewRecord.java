package com.example.hafizequran;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewRecord extends AppCompatActivity {

    List<StudentRecord> friendsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        String rollNo = getIntent().getStringExtra("rollNo");

        dbHelper = new DatabaseHelper(this);

        friendsList = dbHelper.searchStudent(rollNo);

        recyclerView = findViewById(R.id.recyclerViewStudent);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(ViewRecord.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(friendsList);
        recyclerView.setAdapter(adapter);
    }
}
