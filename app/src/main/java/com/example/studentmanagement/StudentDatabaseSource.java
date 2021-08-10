package com.example.studentmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class StudentDatabaseSource {
    StudentDatabaseHelper studentDatabaseHelper;
    StudentModel studentModel;
    SQLiteDatabase sqLiteDatabase;

    public StudentDatabaseSource(Context context) {
        studentDatabaseHelper =new StudentDatabaseHelper (context);
    }

    public void Open(){

        sqLiteDatabase = studentDatabaseHelper.getWritableDatabase ();
    }
    public void Close(){
       studentDatabaseHelper.close ();
    }
    public boolean addStudent(StudentModel studentModel){

        this.Open ();
        ContentValues contentValues =new ContentValues ();
        contentValues.put (studentDatabaseHelper.COL_NAME,studentModel.getName ());
        contentValues.put (studentDatabaseHelper.COL_AGE,studentModel.getAge ());
        contentValues.put (studentDatabaseHelper.COL_ADDRESS,studentModel.getAddress ());
       Long insertedRow= sqLiteDatabase.insert (studentDatabaseHelper.STUDENT_TABLE,null,contentValues);
       this.Close ();
       if (insertedRow>0){
           return true;
       }
       else return false;
    }

    public boolean UpdateStudent(StudentModel studentModel){
        this.Open ();
        ContentValues contentValues =new ContentValues ();
        contentValues.put (studentDatabaseHelper.COL_NAME,studentModel.getName ());
        contentValues.put (studentDatabaseHelper.COL_AGE,studentModel.getAge ());
        contentValues.put (studentDatabaseHelper.COL_ADDRESS,studentModel.getAddress ());
 int UpdatedRow=       sqLiteDatabase.update (StudentDatabaseHelper.STUDENT_TABLE,contentValues,studentDatabaseHelper.COL_ID+"=?",new String[]{String.valueOf (studentModel.getID ())});
 if (UpdatedRow>0){
     return true;
 }else return false;



    }


    public boolean DeleteStudent(StudentModel Model){
this.Open ();
   int DeleteRow=sqLiteDatabase.delete (StudentDatabaseHelper.STUDENT_TABLE,studentDatabaseHelper.COL_ID+"=?", new String[]{String.valueOf (Model.getID ())});
this.Close ();
if (DeleteRow>0){
    return true;
}
else return false;
    }


    public ArrayList<StudentModel> getAllStudent(){
        this.Open ();
        ArrayList<StudentModel> arrayList= new ArrayList<> ();
        Cursor cursor=sqLiteDatabase.query (StudentDatabaseHelper.STUDENT_TABLE,null,null,null,null,null,null);
        if (cursor.moveToFirst ()){
            do {

               String name= cursor.getString (cursor.getColumnIndex (studentDatabaseHelper.COL_NAME));
                int age=cursor.getInt (cursor.getColumnIndex (studentDatabaseHelper.COL_AGE));
                String address=cursor.getString (cursor.getColumnIndex (studentDatabaseHelper.COL_ADDRESS));
                int id = cursor.getInt (cursor.getColumnIndex (studentDatabaseHelper.COL_ID));

                StudentModel studentModel =new StudentModel (id,name,age,address);
                arrayList.add (studentModel);



            }while (cursor.moveToNext ());
            this.Close ();




        }
return  arrayList;

    }

}
