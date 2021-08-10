package com.example.studentmanagement;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public  class StudentDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="student.db";
    public static final int DATABASE_VERSION=1;

    public static final String STUDENT_TABLE="student_table";

    public static final String COL_ID="_id";
    public static final String COL_NAME="name";
    public static final String COL_AGE="_age";
    public static final String COL_ADDRESS="_address";

    public static final String CREATE_TABLE="Create table "+STUDENT_TABLE+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_NAME+" TEXT, "+COL_AGE+" INTEGER, "+ COL_ADDRESS+ " TEXT"+")";

    public StudentDatabaseHelper(@Nullable Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL (CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("Drop table if exists "+STUDENT_TABLE);
        this.onCreate (db);

    }
}
