package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Empl_reg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empl_reg);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.acc_no);
        e3=findViewById(R.id.ph_no);
        e4=findViewById(R.id.email_i_d);
        e5=findViewById(R.id.addr_es);
        e6=findViewById(R.id.pass1);
        e7=findViewById(R.id.pass2);
        btn1=findViewById(R.id.sign_up_button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
                else if (e2.getText().toString().isEmpty()){
                    e2.setError("null");
                }
                else if (e3.getText().toString().isEmpty()){
                    e3.setError("null");
                }
                else if (e4.getText().toString().isEmpty()){
                    e4.setError("null");
                }
                else if (e5.getText().toString().isEmpty()){
                    e5.setError("null");
                }
                else if (e6.getText().toString().isEmpty()){
                    e6.setError("null");
                }
                else if (e7.getText().toString().isEmpty()){
                    e7.setError("null");
                }

                else if (!(e6.getText().toString().equals(e7.getText().toString()))) {

                    e7.setError("Password Unmached");
                    e7.setText("");

                }
                else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/Registration_employee.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(Empl_reg.this, response, Toast.LENGTH_LONG).show();
if(response.equals("Success"))
{
    startActivity(new Intent(Empl_reg.this,Employe_reg.class));
}
                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");


                                        }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                                    } catch (JSONException e) {
                                        e.printStackTrace();

                                    }


                                }
                            },

                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                                }

                            }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
//Adding parameters to request

                            params.put("en",e1.getText().toString());
                            params.put("eac",e2.getText().toString());
                            params.put("eph",e3.getText().toString());
                            params.put("ee",e4.getText().toString());
                            params.put("ead",e5.getText().toString());
                            params.put("epass",e7.getText().toString());
// params.put("confpass", confpass.getText().toString());
// params.put("phone", phone.getText().toString());
// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                            return params;
                        }

                    };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(Empl_reg.this);
                    requestQueue.add(stringRequest);
                }
                }


        });

    }

}
