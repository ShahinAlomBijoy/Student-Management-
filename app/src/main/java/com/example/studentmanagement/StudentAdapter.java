package com.example.studentmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<StudentModel> {
    Context context;
    ArrayList<StudentModel> arrayList;
    public StudentAdapter(@NonNull Context context, ArrayList<StudentModel> arrayList) {
        super (context, R.layout.single_student_list, arrayList);
        this.context =context;
        this.arrayList =arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from (context);
               View v=layoutInflater.inflate (R.layout.single_student_list,parent,false);
              TextView nameTV= v.findViewById (R.id.nameId);
              TextView ageTV= v.findViewById (R.id.ageId);
          TextView addressTV= v.findViewById (R.id.addressId);
          nameTV.setText (arrayList.get (position).getName ());
        ageTV.setText (String.valueOf (arrayList.get (position).getAge ()));
        addressTV.setText (arrayList.get (position).getAddress ());


        return v;
    }
}
