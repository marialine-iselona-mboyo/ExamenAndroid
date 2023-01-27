package com.example.examenandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{


    Button general, ms;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController navController;
    //NavHostFragment host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        general = findViewById(R.id.btn_general);
        general.setOnClickListener(this);
        ms = findViewById(R.id.btn_ms);
        ms.setOnClickListener(this);


        drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        //host = getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        navigationView = findViewById(R.id.nav_View);
        navigationView.setItemIconTintList(null);
        navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);



    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_general:
                startActivity(new Intent(this, GeneralQuestionsActivity.class));
                break;
            case R.id.btn_ms:
                startActivity(new Intent(this, MoviesAndSeriesQuestionsActivity.class));
                break;
        }
    }

}