package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Employe_reg extends AppCompatActivity {

    EditText e1,e2;
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe_reg);
        e1=findViewById(R.id.name_txt);
        e2=findViewById(R.id.pass_txt);
        t1=findViewById(R.id.signUp_text);
        b1=findViewById(R.id.admin_btn);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (e1.getText().toString().isEmpty()){
                   e1.setError("null");
               }
               else if (e2.getText().toString().isEmpty()){
                   e2.setError("null");
               }
           }
       });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Employe_reg.this,Empl_reg.class));
            }
        });
    }

}
