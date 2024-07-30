package com.example.agriprovisionelite.Krishi_Officer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.agriprovisionelite.Attendance.AddLaborFragment;
import com.example.agriprovisionelite.Krishi_Officer.fragments.AddBlog;
import com.example.agriprovisionelite.Krishi_Officer.fragments.AddGov;
import com.example.agriprovisionelite.Krishi_Officer.fragments.KrishiHomePageFragment;
import com.example.agriprovisionelite.R;
import com.example.agriprovisionelite.comman.News2;
import com.example.agriprovisionelite.testing.FragTest;
import com.google.android.material.navigation.NavigationView;

public class Farmer_DashBoard extends AppCompatActivity {



    private DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_dash_board);

        drawerLayout = findViewById(R.id.drawer_layout);

        AddBlog addBlog=new AddBlog();
        AddGov addGov=new AddGov();
        KrishiHomePageFragment krishiHomePageFragment=new KrishiHomePageFragment();


        FragmentTransaction defaultTransaction = getSupportFragmentManager().beginTransaction();
        defaultTransaction.replace(R.id.main_content, krishiHomePageFragment).commit(); // Replace the default content with adminHomeFragment

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_item_fragment1) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_content,addBlog).commit();


                //switchToFragment(new AddLaborFragment());
            } else if (item.getItemId() == R.id.menu_item_fragment2) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_content,addGov).commit();
            }
            else if (item.getItemId() == R.id.home_id) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_content,krishiHomePageFragment).commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

    }
//    private void switchToFragment(Fragment fragment) {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.main_content, fragment)
//                .commit();
//    }


}
