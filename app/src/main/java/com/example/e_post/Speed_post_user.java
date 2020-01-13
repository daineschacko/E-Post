package com.example.e_post;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Speed_post_user extends Fragment {
EditText e1,e2,e3,e4,e5;
Button btn1;
Spinner s1,s2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.speed_post_user, container, false);
        e1=root.findViewById(R.id.date_user_speed);
        e2=root.findViewById(R.id.name_speed_user);
        e3=root.findViewById(R.id.pin_speed_user);
        e4=root.findViewById(R.id.we_speed_user);
        e5=root.findViewById(R.id.fee_speed_user);
        s1=root.findViewById(R.id.sp_dist_speed_user);
        s2=root.findViewById(R.id.sp_city_speed_user);
        btn1=root.findViewById(R.id.submit_speed_user);

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






    }



