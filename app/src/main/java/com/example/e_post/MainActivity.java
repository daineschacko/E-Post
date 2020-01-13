package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView t1,t2,t3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.uname);
        e2=findViewById(R.id.pass);
        t1=findViewById(R.id.signUp_text);
        t2=findViewById(R.id.empl_text);
        t3=findViewById(R.id.admn_text);
        b1=findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
                else if (e2.getText().toString().isEmpty()){
                    e2.setError("null");
                }
                else if (e1.getText().toString().equals("user")&&e2.getText().toString().equals("123")) {
                startActivity(new Intent(MainActivity.this,User_home.class));
                }
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ureg.class));
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Employe_reg.class));
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Admin_login.class));
            }
        });
    }
}
