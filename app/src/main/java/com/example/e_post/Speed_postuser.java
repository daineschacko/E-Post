package com.example.e_post;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Speed_postuser extends Fragment implements
        AdapterView.OnItemSelectedListener {

    String[] dist = { "Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pathanamthitta","Thiruvananthapuram","Thrissur","Wayanad"};

EditText e1,e2,e3,e4,e5;
Button btn1;
    private DatePicker datePicker;

    int year;
    int month;
    int dayOfMonth;
    DatePickerDialog datePickerDialog;

    Calendar calendar;
Spinner s1;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        final View root= inflater.inflate(R.layout.speed_post_user, container, false);
        e1=root.findViewById(R.id.date_user_speed);
        e2=root.findViewById(R.id.name_speed_user);
        e3=root.findViewById(R.id.pin_speed_user);
        e4=root.findViewById(R.id.we_speed_user);
        e5=root.findViewById(R.id.fee_speed_user);
        s1=root.findViewById(R.id.sp_dist_speed_user);
        btn1=root.findViewById(R.id.submit_speed_user);


        ArrayAdapter aa = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, dist);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s1.setAdapter(aa);



        e1.setOnClickListener(new View.OnClickListener()



        {



            @Override
            public void onClick(View v) {

                        datePickerDialog = new DatePickerDialog(getActivity(),
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                        e1.setText(day + "/" + (month + 1) + "/" + year);
                                    }
                                }, year, month, dayOfMonth);
                        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                        datePickerDialog.show();



            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
                if (e2.getText().toString().isEmpty()){
                    e2.setError("null");
                }
                if (e3.getText().toString().isEmpty()){
                    e3.setError("null");
                }
                if (e4.getText().toString().isEmpty()){
                    e4.setError("null");
                }
                if (e5.getText().toString().isEmpty()){
                    e5.setError("null");
                }



                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/speed_post_user.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//If we are getting success from server
                                Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();
                                if(response.equals("Success"))
                                {

                                    startActivity(new Intent(getContext(),Employe_reg.class));
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

                        params.put("sdat",e1.getText().toString());
                        params.put("snam",e2.getText().toString());
                        params.put("spin",e3.getText().toString());
                        params.put("swai",e4.getText().toString());
                        params.put("sfee",e5.getText().toString());
                        params.put("sdist",s1.getSelectedItem().toString());
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
        });


        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
// Toast.makeText(getApplicationContext(),dance[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }





    }



