package com.example.e_post;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
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
public class StatusFragment extends Fragment {
View root;
    EditText e1,e2;
    Button btn1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
         root= inflater.inflate(R.layout.fragment_status, container, false);
        e1=root.findViewById(R.id.card_details);
        e2=root.findViewById(R.id.emp_add);
        btn1=root.findViewById(R.id.submit_emp);
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


    }

