package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class InformationActivity extends AppCompatActivity {

    DrawerLayout drawerLayout1;
    NavigationView navigationView1;
    NavController navController1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        drawerLayout1 = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout1.openDrawer(GravityCompat.START);
            }
        });

        navigationView1 = findViewById(R.id.nav_View);
        navigationView1.setItemIconTintList(null);

        navController1 = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView1, navController1);
    }
}