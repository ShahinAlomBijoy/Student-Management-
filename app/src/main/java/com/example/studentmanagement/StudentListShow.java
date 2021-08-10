package com.example.studentmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.xml.transform.Source;

public class StudentListShow extends AppCompatActivity {
    ListView listView;
    ArrayList<StudentModel> arrayList;
    StudentDatabaseSource source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_student_list_show);
        listView =findViewById (R.id.list_itemId);
        source = new StudentDatabaseSource (this);
        arrayList= source.getAllStudent ();

        StudentAdapter studentAdapter =new StudentAdapter (this,arrayList);
        listView.setAdapter (studentAdapter);
        registerForContextMenu (listView );

        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              StudentModel studentModel =arrayList.get (position);
                Intent intent =new Intent (StudentListShow.this,MainActivity.class);
                intent.putExtra ("STUDENT", studentModel);
                startActivity (intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu (menu, v, menuInfo);

MenuInflater menuInflater = getMenuInflater ();
menuInflater.inflate (R.menu.menu,menu);
menu.setHeaderTitle (" Delete Student");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo ();
        if (item.getItemId ()==R.id.delete){
           Boolean status= source.DeleteStudent (arrayList.get (adapterContextMenuInfo.position));
           if (status){
               Toast.makeText (this,"Successfully Deleted",Toast.LENGTH_LONG).show ();
           }
           else  Toast.makeText (this,"Fail to delete",Toast.LENGTH_LONG).show ();
        }
        return super.onContextItemSelected (item);
    }
}