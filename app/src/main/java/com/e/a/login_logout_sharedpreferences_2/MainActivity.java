package com.e.a.login_logout_sharedpreferences_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_name_MA, et_email_MA, et_mobile_number_MA;
    private Button bt_login_MA;

    public static final String MyPREFERENCE = "User_Details";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(MyPREFERENCE, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(Email,"");
        if (!email.equals("")){
            startActivity(new Intent(this,Next_Main_Activity.class));
        }
        setContentView(R.layout.activity_main);

        init();
        setListener();


    }

    private void setListener() {
        bt_login_MA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = et_name_MA.getText().toString();
                String email = et_email_MA.getText().toString();
                String mobile_number = et_mobile_number_MA.getText().toString();

                if (name.isEmpty()) {
                    et_name_MA.setError("Enter the Name");
                } else if (email.isEmpty()) {
                    et_email_MA.setError("Enter the name");
                } else if (mobile_number.isEmpty()) {
                    et_mobile_number_MA.setError("Enter the Mobile Number");
                } else {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Name, name);
                    editor.putString(Email, email);
                    editor.putString(Phone, mobile_number);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, Next_Main_Activity.class);
                    startActivity(intent);

                }


            }
        });

    }

    private void init() {

        et_name_MA = findViewById(R.id.et_name_MA_id);
        et_email_MA = findViewById(R.id.et_email_MA_id);
        et_mobile_number_MA = findViewById(R.id.et_mobileNumber_MA_id);
        bt_login_MA = findViewById(R.id.bt_save_MA_id);
    }
}
