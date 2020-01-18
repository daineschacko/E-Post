package com.example.e_post;


import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment1 extends Fragment implements
        AdapterView.OnItemSelectedListener {


    String[] weight = {"Round","Rectangle"};
    EditText e1,e2;
    Button btn1,gallery;
    Spinner s1;
    ImageView img;

    private Object Menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root = inflater.inflate(R.layout.fragment_call1, container, false);
        e1 = root.findViewById(R.id.stampsize);
        e2 = root.findViewById(R.id.stamprs);
        btn1 = root.findViewById(R.id.btn_stamp);
        img = (ImageView) root.findViewById(R.id.img_stamp);
        s1 = root.findViewById(R.id.sp_shape);
gallery=root.findViewById(R.id.button);
gallery.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setType("image/*"); intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }
});











        ArrayAdapter ab = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, weight);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s1.setAdapter(ab);






        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty()){
                    e1.setError("null");
                }
                else if (e2.getText().toString().isEmpty()){
                    e2.setError("null");
                }
                else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojecttechsays.000webhostapp.com/E-Post/stamp.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                                    if(response.equals("Success"))
                                    {
                                        Toast.makeText(getActivity(), "Stamp added", Toast.LENGTH_LONG).show();

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

                            params.put("siz",e1.getText().toString());
                            params.put("rup",e2.getText().toString());
                            params.put("shp",s1.getSelectedItem().toString());

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


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
// Toast.makeText(getApplicationContext(),dance[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }


    }







