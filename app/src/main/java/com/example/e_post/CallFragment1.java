package com.example.e_post;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment1 extends Fragment implements
        AdapterView.OnItemSelectedListener {

    String[] weight = {"Round","Rectangle"};
    EditText e1,e2;
    Button btn1;
    Spinner s1;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.fragment_call1, container, false);
        e1=root.findViewById(R.id.stampsize);
        e2=root.findViewById(R.id.stamprs);
        btn1=root.findViewById(R.id.btn_stamp);
        s1=root.findViewById(R.id.sp_shape);
        img=root.findViewById(R.id.img_stamp);


        ArrayAdapter ab = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, weight);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s1.setAdapter(ab);






        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
                if (e2.getText().toString().isEmpty()){
                    e2.setError("null");
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



