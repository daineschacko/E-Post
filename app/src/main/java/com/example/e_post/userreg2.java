package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class userreg2 extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] State = { "Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pathanamthitta","Thiruvananthapuram","Thrissur","Wayanad"};
    String[] dist = { "Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pathanamthitta","Thiruvananthapuram","Thrissur","Wayanad"};

    EditText e1,e2,e3;
    Button b1;
    Spinner s1,s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userreg2);
        e1=findViewById(R.id.pin_no);
        e2=findViewById(R.id.pass1);
        e3=findViewById(R.id.pass2);
        s1=findViewById(R.id.sp_state);
        s2=findViewById(R.id.sp_dist);

        b1=findViewById(R.id.signup_button_txt);

        ArrayAdapter aa = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, State);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s1.setAdapter(aa);

        ArrayAdapter aaa = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, dist);
        aaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s2.setAdapter(aaa);





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
