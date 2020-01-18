package com.example.e_post;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {
EditText e1,e2,e3,e4,e5;
Button btn1,btn2,btn3;
String uname,uadd,uemail,uphone,accno;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.fragment_call, container, false);
        e1=root.findViewById(R.id.s_id_user);
        e2=root.findViewById(R.id.name_id_user);
        e3=root.findViewById(R.id.address_id_user);
        e4=root.findViewById(R.id.email_id_user);
        e5=root.findViewById(R.id.ph_id_user);
        btn1=root.findViewById(R.id.search_user);
        btn2=root.findViewById(R.id.update_user);
        btn3=root.findViewById(R.id.del_user);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
                else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/user_view.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                                    if (response.equals("Success")) {
                                        Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();
                                    }
                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");
uname=json_obj.getString("uname");
uadd=json_obj.getString("address");
uemail=json_obj.getString("email");
uphone=json_obj.getString("Ph_no");

e2.setText(uname);
e3.setText(uadd);
e4.setText(uemail);
e5.setText(uphone);
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


                            params.put("uname",e1.getText().toString());

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
                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    requestQueue.add(stringRequest);

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e2.getText().toString().isEmpty()){
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
                else if(e5.getText().toString().length()<10)
                {
                    e5.setError("Invalid Phone Number");
                }
                else
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/updateuser.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                                    if (response.equals("Success")) {
                                        Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();
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


                            params.put("name",e2.getText().toString());
                            params.put("address",e3.getText().toString());
                            params.put("email",e4.getText().toString());
                            params.put("phone",e5.getText().toString());
                            params.put("id",e1.getText().toString());
//params.put()
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
                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    requestQueue.add(stringRequest);
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e2.getText().toString().isEmpty()){
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

            }
        });


        return root;
    }



}



