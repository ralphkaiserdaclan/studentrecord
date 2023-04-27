package com.example.studentrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText userinput1, userinput2, userinput3, userinput4, userinput5, userinput6, userinput7;
    TextView bOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bOutput = (TextView) findViewById(R.id.resp);
        userinput1 = (EditText) findViewById(R.id.inp1);
        userinput2 = (EditText) findViewById(R.id.inp2);
        userinput3 = (EditText) findViewById(R.id.inp3);
        userinput4 = (EditText) findViewById(R.id.inp4);
        userinput5 = (EditText) findViewById(R.id.inp5);
        userinput6 = (EditText) findViewById(R.id.inp6);
        userinput7 = (EditText) findViewById(R.id.inp7);
    }
    public void Add(View view)
    {

        if(userinput1.getText().toString().isEmpty() || userinput2.getText().toString().isEmpty() || userinput3.getText().toString().isEmpty() || userinput4.getText().toString().isEmpty() || userinput5.getText().toString().isEmpty() || userinput6.getText().toString().isEmpty() || userinput7.getText().toString().isEmpty()) {

            Toast.makeText(this, "Input incomplete!", Toast.LENGTH_SHORT).show();

        }else {

            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            String url ="http://192.168.254.127/StudRec/create.php";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String Response) {
                            bOutput.setText("Added Successfully..."+ Response);

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    bOutput.setText("That didn't work!");
                }
            }){
                class Listener<T> {
                }

                class ErrorListener {
                }

                protected Map<String, String> getParams(){
                    Map<String, String> paramV = new HashMap<>();
                    paramV.put("i1", userinput1.getText().toString());
                    paramV.put("i2", userinput2.getText().toString());
                    paramV.put("i3", userinput3.getText().toString());
                    paramV.put("i4", userinput4.getText().toString());
                    paramV.put("i5", userinput5.getText().toString());
                    paramV.put("i6", userinput6.getText().toString());
                    paramV.put("i7", userinput7.getText().toString());
                    return paramV;
                }
            };
            queue.add(stringRequest);
        }
    }
