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
public class CallFragment1 extends Fragment {
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



