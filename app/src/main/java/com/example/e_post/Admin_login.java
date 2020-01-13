package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {
    EditText ed1,ed2;
    Button btn_admn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        ed1=findViewById(R.id.name_txt);
        ed2=findViewById(R.id.pass_txt);
        btn_admn=findViewById(R.id.admin_btn);
        btn_admn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().isEmpty()||(ed2.getText().toString().isEmpty())){
                    ed1.setError("null");
                    ed2.setError("null");
                }
                else if (ed1.getText().toString().equals("admin")&&ed2.getText().toString().equals("123")){
                    startActivity(new Intent(Admin_login.this,Admin_home.class));
                }
                else
                    {
                        Toast.makeText(Admin_login.this,"Invalid Username Or Password",Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}
