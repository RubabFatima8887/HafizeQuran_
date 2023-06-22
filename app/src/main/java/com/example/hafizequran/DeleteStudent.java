package com.example.hafizequran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        EditText ed = findViewById(R.id.editTextRollNo);
        Button bt  = findViewById(R.id.buttondel);
        //String s = ed.getText().toString();

        DatabaseHelper db = new DatabaseHelper(DeleteStudent.this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.deleteStudentRecord(ed.getText().toString(),DeleteStudent.this);

            }
        });

    }
}