package com.example.e_post;


import android.content.Context;
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
public class CallFragment2 extends Fragment implements
        AdapterView.OnItemSelectedListener {

    String[] weight = {"Standard","Premium"};
    String[] orintation = {"Horizontal","Vertical"};
    EditText e1,e2,e3;
    Button btn1;
    ImageView img;
    Spinner s1,s2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.fragment_call2, container, false);
        e1=root.findViewById(R.id.card_view);
        e2=root.findViewById(R.id.size);
        e3=root.findViewById(R.id.rs);
        s1=root.findViewById(R.id.sp_paper_weight);
        s2=root.findViewById(R.id.sp_orint);
        img=root.findViewById(R.id.img_post);
        btn1=root.findViewById(R.id.btn_stamp);


        ArrayAdapter ab = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, weight);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s1.setAdapter(ab);

        ArrayAdapter aba = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,orintation);
        aba.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s2.setAdapter(aba);








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



