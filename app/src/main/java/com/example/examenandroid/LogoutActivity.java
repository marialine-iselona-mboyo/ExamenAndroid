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

public class LogoutActivity extends AppCompatActivity {

    DrawerLayout drawerLayout2;
    NavigationView navigationView2;
    NavController navController2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        drawerLayout2 = findViewById(R.id.drawerLayout);
        navigationView2 = findViewById(R.id.nav_View);
        navigationView2.setItemIconTintList(null);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout2.openDrawer(GravityCompat.START);
            }
        });

        navController2 = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView2, navController2);
    }
}