package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button startBtn;
    EditText et_name;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        startBtn = findViewById(R.id.btnStart);
        startBtn.setOnClickListener(this);

        et_name = findViewById(R.id.etName);


        DB = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String name = et_name.getText().toString().trim();

        if (name.isEmpty()){
            Toast.makeText(RegisterActivity.this, "All informations are required!", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean checkName = DB.checkName(name);
            if (!checkName){
                Boolean insert = DB.insertData(name);
                if (insert){
                    Toast.makeText(RegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(RegisterActivity.this, "Name already is used", Toast.LENGTH_SHORT).show();
            }
        }
    }
}