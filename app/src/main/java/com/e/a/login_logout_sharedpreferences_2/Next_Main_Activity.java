package com.e.a.login_logout_sharedpreferences_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Next_Main_Activity extends AppCompatActivity {
    private TextView tv_name_NA,tv_email_NA,tv_mobileNumber_NA;
    private Button bt_logout_NA;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next__main_);

        sharedPreferences=getSharedPreferences(MainActivity.MyPREFERENCE, Context.MODE_PRIVATE);
        inti();
        setListener();
    }

    private void setListener() {
        bt_logout_NA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                finish();
            }
        });
    }

    private void inti() {


        tv_name_NA=findViewById(R.id.tv_name_NA_id);
        tv_email_NA=findViewById(R.id.tv_email_NA_id);
        tv_mobileNumber_NA=findViewById(R.id.tv_mobilenumber_NA_id);
        bt_logout_NA=findViewById(R.id.bt_logout_NA_id);

        String name=sharedPreferences.getString(MainActivity.Name,null);
        String email=sharedPreferences.getString(MainActivity.Email,null);
        String phn=sharedPreferences.getString(MainActivity.Phone,null);

        tv_name_NA.setText(name);
        tv_email_NA.setText(email);
        tv_mobileNumber_NA.setText(phn);


    }
    }
