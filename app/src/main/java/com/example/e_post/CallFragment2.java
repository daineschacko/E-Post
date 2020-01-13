package com.example.e_post;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment2 extends Fragment {
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






    }



