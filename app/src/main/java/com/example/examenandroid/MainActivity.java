package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button startBtn;
    TextView tv_signUp;
    EditText et_name;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.btnStart);
        startBtn.setOnClickListener(this);

        et_name = findViewById(R.id.editTextName);
        tv_signUp = findViewById(R.id.tv_reg);

        DB = new DBHelper(this);



        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View v) {
        String name = et_name.getText().toString().trim();

        if (name.isEmpty()){
            Toast.makeText(MainActivity.this, "All informations are required!", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean checkName = DB.checkName(name);
            if (checkName) {
                Toast.makeText(MainActivity.this, "Successfully Signed In", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intent);
            }
            else {
                    Toast.makeText(MainActivity.this, "Signing In Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
}