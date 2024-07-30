package com.example.agriprovisionelite;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.agriprovisionelite.Attendance.AttendaceHome;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agriprovisionelite.databinding.ActivityAdminDrawerBinding;

public class adminDrawer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityAdminDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdminDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarAdminDrawer.toolbar);
        binding.appBarAdminDrawer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_drawer, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.newsid) {
//            startActivity(new Intent(adminDrawer.this, MainActivity.class));
//            return true;
//        } else if (id == R.id.feedbackid) {
//            startActivity(new Intent(adminDrawer.this, AttendaceHome.class));
//            return true;
//        } else if (id == R.id.nav_slideshow) {
//            // Handle nav_slideshow item click (if needed)
//            return true;
//        } else if (id == R.id.newsid) {
//            // Handle newsid item click (if needed)
//            return true;
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//
//import com.example.agriprovisionelite.Attendance.AttendaceHome;
//import com.example.agriprovisionelite.databinding.ActivityAdminDrawerBinding;
//import com.google.android.material.snackbar.Snackbar;
//import com.google.android.material.navigation.NavigationView;
//
//public class adminDrawer extends AppCompatActivity {
//
//    private AppBarConfiguration mAppBarConfiguration;
//    private ActivityAdminDrawerBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityAdminDrawerBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.appBarAdminDrawer.toolbar);
//        binding.appBarAdminDrawer.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
//
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setOpenableLayout(drawer)
//                .build();
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_drawer);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.admin_drawer, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id) {
//            case R.id.nav_home:
//                // Handle Home item click
//                startActivity(new Intent(adminDrawer.this, MainActivity.class));
//                return true;
//            case R.id.nav_gallery:
//                // Handle Expenses item click
//                startActivity(new Intent(adminDrawer.this, AttendaceHome.class));
//                return true;
//            case R.id.nav_slideshow:
//                // Handle Attendance item click
//                startActivity(new Intent(adminDrawer.this, AttendaceHome.class));
//                return true;
//            case R.id.nav_home:
//                // Handle News item click
//                startActivity(new Intent(adminDrawer.this, AttendaceHome.class));
//                return true;
//            case R.id.nav_home:
//                // Handle Weather item click
//                startActivity(new Intent(adminDrawer.this, AttendaceHome.class));
//                return true;
//            case R.id.nav_home:
//                // Handle Disease Detection item click
//                startActivity(new Intent(adminDrawer.this, AttendaceHome.class));
//                return true;
//            case R.id.nav_home:
//                // Handle Feedback item click
//                startActivity(new Intent(adminDrawer.this, AttendaceHome.class));
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_drawer);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}