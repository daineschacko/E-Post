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
               StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/Registration_employee.php",
                       new Response.Listener<String>() {
                           @Override
                           public void onResponse(String response) {
//If we are getting success from server
                               Toast.makeText(Employe_reg.this, response, Toast.LENGTH_LONG).show();
                               if(response.equals("Success"))
                               {
                                   startActivity(new Intent(Employe_reg.this,Employee_home.class));
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
               RequestQueue requestQueue = Volley.newRequestQueue(Employe_reg.this);
               requestQueue.add(stringRequest);

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
