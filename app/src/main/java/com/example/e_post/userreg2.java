package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class userreg2 extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] State = { "Andhra Pradesh ", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh ","Goa","Gujarat","Haryana","Karnataka","Kerala","Tamil Nadu","Telangana","Uttar Pradesh","West Bengal"};
    String[] dist = { "Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pathanamthitta","Thiruvananthapuram","Thrissur","Wayanad"};

    EditText e1,e2,e3;
    Button b1;
    SharedPreferences sharedPreferences;
    Spinner s1,s2;
    String str1,str2,str3,str4,str5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userreg2);
        e1=findViewById(R.id.pin_no);
        e2=findViewById(R.id.pass1);
        e3=findViewById(R.id.pass2);
        s1=findViewById(R.id.sp_state);
        s2=findViewById(R.id.sp_dist);
        sharedPreferences=getSharedPreferences("asd",MODE_PRIVATE);

        b1=findViewById(R.id.signup_button_txt);

        ArrayAdapter aa = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, State);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s1.setAdapter(aa);

        ArrayAdapter aaa = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, dist);
        aaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s2.setAdapter(aaa);


        str1=sharedPreferences.getString("unm","*****");
        str2=sharedPreferences.getString("uac","*****");
        str3=sharedPreferences.getString("uph","*****");
        str4=sharedPreferences.getString("uem","*****");
        str5=sharedPreferences.getString("uadr","*****");




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(userreg2.this,str1,Toast.LENGTH_LONG).show();

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
                else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/epostuser_reg.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(userreg2.this, response, Toast.LENGTH_LONG).show();
                                    if(response.equals("Success"))
                                    {
                                        startActivity(new Intent(userreg2.this,User_home.class));
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

                            params.put("upin",e1.getText().toString());
                            params.put("ups",e3.getText().toString());
                            params.put("stt",s1.getSelectedItem().toString());
                            params.put("dst",s2.getSelectedItem().toString());
params.put("unm",str1);
params.put("uac",str2);
params.put("uph",str3);
params.put("uem",str4);
params.put("uadr",str5);
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
                    RequestQueue requestQueue = Volley.newRequestQueue(userreg2.this);
                    requestQueue.add(stringRequest);
                }

            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
// Toast.makeText(getApplicationContext(),dance[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
