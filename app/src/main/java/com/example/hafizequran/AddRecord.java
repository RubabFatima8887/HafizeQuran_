package com.example.hafizequran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddRecord extends AppCompatActivity {

    private EditText etStudentId, etStartingAyat, etEndingAyat, etSabqi, etMazil, etDate;
    private Button AddRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        etStudentId = findViewById(R.id.editText1);
        etStartingAyat = findViewById(R.id.editText2);
        etEndingAyat = findViewById(R.id.editText3);
        etSabqi = findViewById(R.id.editText4);
        etMazil = findViewById(R.id.editText5);
        etDate = findViewById(R.id.editText6);
        AddRecord = findViewById(R.id.button7);

        AddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentId = etStudentId.getText().toString().trim();
                String startingAyat = etStartingAyat.getText().toString().trim();
                String endingAyat = etEndingAyat.getText().toString().trim();
                String sabqi = etSabqi.getText().toString().trim();
                String mazil = etMazil.getText().toString().trim();
                String date = etDate.getText().toString().trim();

                StudentRecord studentRecord = new StudentRecord("John Doe", studentId, Integer.parseInt(startingAyat),
                        Integer.parseInt(endingAyat), Integer.parseInt(sabqi), Integer.parseInt(mazil), date);

                DatabaseHelper dbHelper = new DatabaseHelper(AddRecord.this);

                dbHelper.insertStudent(studentRecord,AddRecord.this);
                Toast.makeText(AddRecord.this, "Record added successfully", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}