package com.example.e_post;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Speed_post_user extends Fragment implements
        AdapterView.OnItemSelectedListener {

    String[] dist = { "Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pathanamthitta","Thiruvananthapuram","Thrissur","Wayanad"};

EditText e1,e2,e3,e4,e5;
Button btn1;
    private DatePicker datePicker;

    int year;
    int month;
    int dayOfMonth;
    DatePickerDialog datePickerDialog;

    Calendar calendar;
Spinner s1;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        final View root= inflater.inflate(R.layout.speed_post_user, container, false);
        e1=root.findViewById(R.id.date_user_speed);
        e2=root.findViewById(R.id.name_speed_user);
        e3=root.findViewById(R.id.pin_speed_user);
        e4=root.findViewById(R.id.we_speed_user);
        e5=root.findViewById(R.id.fee_speed_user);
        s1=root.findViewById(R.id.sp_dist_speed_user);
        btn1=root.findViewById(R.id.submit_speed_user);


        ArrayAdapter aa = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, dist);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s1.setAdapter(aa);



        e1.setOnClickListener(new View.OnClickListener()



        {



            @Override
            public void onClick(View v) {

                        datePickerDialog = new DatePickerDialog(getActivity(),
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                        e1.setText(day + "/" + (month + 1) + "/" + year);
                                    }
                                }, year, month, dayOfMonth);
                        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                        datePickerDialog.show();



            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
                if (e2.getText().toString().isEmpty()){
                    e2.setError("null");
                }
                if (e3.getText().toString().isEmpty()){
                    e3.setError("null");
                }
                if (e4.getText().toString().isEmpty()){
                    e4.setError("null");
                }
                if (e5.getText().toString().isEmpty()){
                    e5.setError("null");
                }
            }
        });


        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
// Toast.makeText(getApplicationContext(),dance[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }





    }



