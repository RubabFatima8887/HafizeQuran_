package com.example.hafizequran;



import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "studentbase.db";
    private static final String TABLE_NAME = "studentsRecord";

    private static final String TABLE_NAME2 = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ROLLNO = "roll_no";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_MANZIL = "manzil";
    private static final String COLUMN_SABQI = "sabqi";
    private static final String COLUMN_SABQ_ENDING_AYAT = "ending_ayat";
    private static final String COLUMN_SABQ_STARTING_AYAT = "starting_ayat";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ROLLNO + " TEXT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_MANZIL + " INTEGER,"
                + COLUMN_SABQI + " INTEGER,"
                + COLUMN_SABQ_ENDING_AYAT + " INTEGER,"
                + COLUMN_SABQ_STARTING_AYAT + " INTEGER"
                + ")";
        db.execSQL(sql);

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ROLLNO + " TEXT"
                + ")";
        db.execSQL(sql2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        String sql2 = "DROP TABLE IF EXISTS " + TABLE_NAME2;
        db.execSQL(sql2);
        onCreate(db);

    }
    private boolean isStudentExists(String rollNo, Context context) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_ROLLNO + " = ?";
        String[] selectionArgs = {rollNo};

        Cursor cursor = db.query(TABLE_NAME2, null, selection, selectionArgs, null, null, null);
        boolean flag = (cursor.getCount() > 0);

        cursor.close();
        // if (exists == true) {
        //   Toast.makeText(context, "exist", Toast.LENGTH_SHORT).show();
        //} else
        //{
        //  Toast.makeText(context, "no exist", Toast.LENGTH_SHORT).show();
        //}

        return flag;
    }

    public void insertStudent(Student student, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        if (isStudentExists(student.getId(), context)) {

            Toast.makeText(context, "Already Exist", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, student.getName());
            values.put(COLUMN_ROLLNO, student.getId());

            long newRowId = db.insert(TABLE_NAME2, null, values);


            if (newRowId != -1) {
                Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Failed to insert data", Toast.LENGTH_SHORT).show();
            }

        }

        db.close();
    }
}