package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ureg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ureg);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.acc_no);
        e3=findViewById(R.id.ph_no);
        e4=findViewById(R.id.email_i_d);
        e5=findViewById(R.id.addr_es);
        t1=findViewById(R.id.signIn_text);
        b1=findViewById(R.id.sign_up_button);
        b1.setOnClickListener(new View.OnClickListener() {
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
                if (e3.getText().toString().length()<10){
                    e3.setError("Enter a valid phone Number");
                }
                if (e4.getText().toString().isEmpty()){
                    e4.setError("null");
                }
                if (e5.getText().toString().isEmpty()){
                    e5.setError("null");
                }
                else{
                    startActivity(new Intent(ureg.this,userreg2.class));
                }

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ureg.this,MainActivity.class));
            }
        });
    }
}
