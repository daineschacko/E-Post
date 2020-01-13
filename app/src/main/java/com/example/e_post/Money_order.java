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
public class Money_order extends Fragment {
    EditText e1,e2;
    Button btn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.money_order_user, container, false);
        e1=root.findViewById(R.id.user_money_name);
        e2=root.findViewById(R.id.user_ac_money);

        btn1=root.findViewById(R.id.user_send_money);

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



