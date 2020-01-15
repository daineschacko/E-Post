package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Employee_home extends AppCompatActivity {
   TextView t1,t2,t3,t4,t5;
   Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);
        t1=findViewById(R.id.address);
        t2=findViewById(R.id.place);
        t3=findViewById(R.id.loc);
        t4=findViewById(R.id.phone);
        t5=findViewById(R.id.lg_ot_emp);
        b1=findViewById(R.id.strt_btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Employee_home.this,"Start work",Toast.LENGTH_LONG).show();
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Employee_home.this,MainActivity.class));
            }
        });


    }
}
