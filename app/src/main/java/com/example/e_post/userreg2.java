package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class userreg2 extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;
    Spinner s1,s2,s3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userreg2);
        e1=findViewById(R.id.pin_no);
        e2=findViewById(R.id.pass1);
        e3=findViewById(R.id.pass2);
        s1=findViewById(R.id.sp_state);
        s2=findViewById(R.id.sp_dist);
        s3=findViewById(R.id.sp_city);
        b1=findViewById(R.id.signup_button_txt);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e2.getText().toString().isEmpty()){
                    e2.setError("null");
                }
                if (e3.getText().toString().isEmpty()){
                    e3.setError("null");
                }

                if (!(e2.getText().toString().equals(e3.getText().toString()))) {

                    e3.setError("Password Unmached");
                    e3.setText("");


                }
            }
        });
    }
}
