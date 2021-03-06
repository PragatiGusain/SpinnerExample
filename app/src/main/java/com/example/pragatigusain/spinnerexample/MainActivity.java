package com.example.pragatigusain.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

class Student
{
    String name,college,address;
    long phone;
    Student(String name,String address,long phone,String college)
    {
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.college=college;
    }
}

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    EditText enter_name,enter_address,enter_phone;
    Button add, display;
    TextView displayStudentsResult;
    String collegeName = "";
    ArrayList<Student> studentArrayList = new ArrayList<>();
    Spinner spinnerCollegeNames;
    String collegeNames[] = {"Select college name","DIT", "Graphic Era", "HNB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter_name = findViewById(R.id.et1);
        enter_phone = findViewById(R.id.et2);
        enter_address = findViewById(R.id.et3);
        add = findViewById(R.id.b1);
        display = findViewById(R.id.b2);
        displayStudentsResult = findViewById(R.id.tv1);
        spinnerCollegeNames = findViewById(R.id.s1);
        spinnerCollegeNames.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, collegeNames);
        spinnerCollegeNames.setAdapter(arrayAdapter);
        spinnerCollegeNames.setPrompt(collegeNames[0]);
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    String name = enter_name.getText().toString();
                    long phone = Long.parseLong(enter_phone.getText().toString());
                    String address = enter_address.getText().toString();
                    studentArrayList.add(new Student(name, collegeName, phone, address));
                    Toast.makeText(getApplicationContext(),"Your Details Have Been Submitted",Toast.LENGTH_SHORT).show();
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Valid Details",Toast.LENGTH_SHORT).show();
                }
            }
        });
            display.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View v)
            {
                for (int i=0; i<studentArrayList.size(); i++)
                {

                    displayStudentsResult.setText(displayStudentsResult.getText() +
                            "Student Name is: " + studentArrayList.get(i).name + "\n");
                    displayStudentsResult.setText(displayStudentsResult.getText() +
                            "Student College is: " + studentArrayList.get(i).college + "\n");
                    displayStudentsResult.setText(displayStudentsResult.getText() +
                            "Student Phone Number is: " + studentArrayList.get(i).phone + "\n");
                    displayStudentsResult.setText(displayStudentsResult.getText() +
                            "Student Address is: " + studentArrayList.get(i).address + "\n");
                    displayStudentsResult.setText(displayStudentsResult.getText() + "****************\n\n");
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        collegeName = collegeNames[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}