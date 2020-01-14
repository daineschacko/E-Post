package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ureg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    TextView t1;
    SharedPreferences sharedPreferences;
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

        sharedPreferences=getSharedPreferences("asd",MODE_PRIVATE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
               else if (e2.getText().toString().isEmpty()){
                    e2.setError("null");
                }
              else  if (e3.getText().toString().isEmpty()){
                    e3.setError("null");
                }
              else  if (e3.getText().toString().length()<10){
                    e3.setError("Enter a valid phone Number");
                }
               else if (e4.getText().toString().isEmpty()){
                    e4.setError("null");
                }
              else  if (e5.getText().toString().isEmpty()){
                    e5.setError("null");
                }
                else{
                    startActivity(new Intent(ureg.this,userreg2.class));
                    SharedPreferences.Editor e=sharedPreferences.edit();
                    e.putString("unm",e1.getText().toString());
                    e.putString("uac",e2.getText().toString());
                    e.putString("uph",e3.getText().toString());
                    e.putString("uem",e4.getText().toString());
                    e.putString("uadr",e5.getText().toString());
                    e.apply();
                }

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
}
