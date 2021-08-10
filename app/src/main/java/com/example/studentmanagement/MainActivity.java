 package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
EditText eName,eAge,eAdress;
Button AddButton,ShowButton;
StudentDatabaseSource studentDatabaseSource ;
     StudentModel studentModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        eName=findViewById (R.id.editTextId1);
        eAge=findViewById (R.id.editTextId2);
        eAdress=findViewById (R.id.editTextId3);
        AddButton=findViewById (R.id.btn1);
        ShowButton=findViewById (R.id.btn2);

         studentModel= (StudentModel) getIntent ().getSerializableExtra ("STUDENT");



if (studentModel!=null){
    AddButton.setText ("UPDATE STUDENT");
    eName.setText (studentModel.getName ());
    eAge.setText (studentModel.getAge ()+"");
    eAdress.setText (studentModel.getAddress ());
}

       studentDatabaseSource =new StudentDatabaseSource (this);



// Data add & Update
        AddButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
            //update data
         if (studentModel!=null){
             String updateName= eName.getText ().toString ();
             int updateAge = Integer.valueOf (eAge.getText ().toString ());
             String updateAddress=eAdress.getText ().toString ();
             int updateId=studentModel.getID ();

             StudentModel UpdateStudentModel = new StudentModel (updateId,updateName,updateAge,updateAddress);
             boolean updateStatus=studentDatabaseSource.UpdateStudent (UpdateStudentModel);
             if (updateStatus){
                 Toast.makeText (MainActivity.this,"Update Successfully",Toast.LENGTH_LONG).show ();
             }
             else {
                 Toast.makeText (MainActivity.this,"Update Not Successfully",Toast.LENGTH_LONG).show ();
             }



         }



         //insert data
         else {

             StudentModel studentModel =new StudentModel (eName.getText ().toString (), Integer.valueOf (eAge.getText ().toString ()),eAdress.getText ().toString () );
             boolean status=studentDatabaseSource.addStudent (studentModel);

             if (status){
                 Toast.makeText (MainActivity.this,"Save",Toast.LENGTH_LONG).show ();
             }
             else {
                 Toast.makeText (MainActivity.this,"Not Save",Toast.LENGTH_LONG).show ();
             }

         }




            }


        });


        //Data show
ShowButton.setOnClickListener (new View.OnClickListener () {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent (MainActivity.this,StudentListShow.class);
        startActivity (intent);
    }
  });
    }


}