package com.example.e_post;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {
EditText e1,e2,e3,e4,e5;
Button btn1,btn2,btn3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.fragment_call, container, false);
        e1=root.findViewById(R.id.s_id_user);
        e2=root.findViewById(R.id.name_id_user);
        e3=root.findViewById(R.id.address_id_user);
        e4=root.findViewById(R.id.email_id_user);
        e5=root.findViewById(R.id.ph_id_user);
        btn1=root.findViewById(R.id.search_user);
        btn2=root.findViewById(R.id.update_user);
        btn3=root.findViewById(R.id.del_user);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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






    }



