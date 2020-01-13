package com.example.e_post;


import android.app.Activity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class ChatFragment extends Fragment {
    EditText e1,e2,e3,e4,e5,e6;
    Button btn1,btn2,btn3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.fragment_chat, container, false);

        e1=root.findViewById(R.id.s_id_emp);
        e2=root.findViewById(R.id.name_id_emp);
        e3=root.findViewById(R.id.address_id_emp);
        e4=root.findViewById(R.id.email_id_emp);
        e5=root.findViewById(R.id.ph_id_emp);
        e6=root.findViewById(R.id.Quli_id_emp);
        btn1=root.findViewById(R.id.search_emp);
        btn2=root.findViewById(R.id.update_emp);
        btn3=root.findViewById(R.id.delete_emp);
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

                if (e6.getText().toString().isEmpty()){
                e6.setError("null");
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
                if (e6.getText().toString().isEmpty()){
                    e6.setError("null");
                }


            }
        });
        return root;

    }

}
