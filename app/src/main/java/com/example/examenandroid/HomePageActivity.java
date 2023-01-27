package com.example.examenandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.examenandroid.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {


    Button general, ms, logout;
    DrawerLayout drawerLayout;
    //NavigationView navigationView;
    //NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        general = findViewById(R.id.btn_general);
        general.setOnClickListener(this);
        ms = findViewById(R.id.btn_ms);
        ms.setOnClickListener(this);
        logout = findViewById(R.id.button2);
        logout.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        /*navigationView = findViewById(R.id.nav_View);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id){
                    case R.id.menuHome:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.menuInfo:
                        replaceFragment(new InformationFragment());
                        break;
                    case R.id.menuLogout:
                        replaceFragment(new LogoutFragment());
                        break;
                }


                return false;
            }
        });

        navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);*/


    }

    /*private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.constraint, fragment);
        fragmentTransaction.commit();
    }*/


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_general:
                startActivity(new Intent(this, GeneralQuestionsActivity.class));
                break;
            case R.id.btn_ms:
                startActivity(new Intent(this, MoviesAndSeriesQuestionsActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, MainActivity.class));
        }
    }

}