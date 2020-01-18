package com.example.e_post;


import android.app.Activity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


public class ChatFragment extends Fragment {
    EditText e1,e2,e3,e4,e5;
    Button btn1,btn2,btn3;
    String emname,emadd,ememail,emphone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.fragment_chat, container, false);

        e1=root.findViewById(R.id.s_id_emp);
        e2=root.findViewById(R.id.name_id_emp);
        e3=root.findViewById(R.id.address_id_emp);
        e4=root.findViewById(R.id.email_id_emp);
        e5=root.findViewById(R.id.ph_id_emp);
           btn1=root.findViewById(R.id.search_emp);
        btn2=root.findViewById(R.id.update_emp);
        btn3=root.findViewById(R.id.delete_emp);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
                else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/Registration_employee.php",
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
                                            emname=json_obj.getString("emname");
                                            emadd=json_obj.getString("emaddress");
                                            ememail=json_obj.getString("ememail");
                                            emphone=json_obj.getString("emPh_no");

                                            e2.setText(emname);
                                            e3.setText(emadd);
                                            e4.setText(ememail);
                                            e5.setText(emphone);

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


                            params.put("emid",e1.getText().toString());

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
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/update_emp.php",
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


                            params.put("emname",e2.getText().toString());
                            params.put("emaddress",e3.getText().toString());
                            params.put("ememail",e4.getText().toString());
                            params.put("emphone",e5.getText().toString());

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

                else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/deleteuser.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                                    if (response.equals("Success")) {
                                        Toast.makeText(getActivity(),"Deleted",Toast.LENGTH_LONG).show();
                                    }
//                                    try {
//                                        JSONArray jsonArray = new JSONArray(response);
//                                        for (int i = 0; i < jsonArray.length(); i++) {
//                                            JSONObject json_obj = jsonArray.getJSONObject(i);
////ba = json_obj.getString("balance");
//                                            emname=json_obj.getString("emname");
//                                            emadd=json_obj.getString("emaddress");
//                                            ememail=json_obj.getString("ememail");
//                                            emphone=json_obj.getString("emPh_no");
//
//
//
//                                        }
////Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//
//                                    }


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


                            params.put("emid",e1.getText().toString());

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
        return root;

    }

}
