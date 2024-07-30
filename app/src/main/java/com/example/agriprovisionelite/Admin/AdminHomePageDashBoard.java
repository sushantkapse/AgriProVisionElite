package com.example.agriprovisionelite.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.example.agriprovisionelite.R;
import com.example.agriprovisionelite.testing.BarPlotTesting;
import com.example.agriprovisionelite.testing.FragTest;
import com.example.agriprovisionelite.testing.PdfFragment;
import com.google.android.material.navigation.NavigationView;


public class AdminHomePageDashBoard extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page_dash_board);
        drawerLayout = findViewById(R.id.admin_drawer_layout);


        FarmerDetails farmerDetails=new FarmerDetails();
        KrishiDetails krishiDetails =new KrishiDetails();
admin_home_fragment adminHomeFragment=new admin_home_fragment();
EmailAutomation emailAutomation =new EmailAutomation();
        FragTest fragTest=new FragTest();
        BarPlotTesting barPlotTesting=new BarPlotTesting();
        PdfFragment pdfFragment=new PdfFragment();




        FragmentTransaction defaultTransaction = getSupportFragmentManager().beginTransaction();
        defaultTransaction.replace(R.id.admin_main_content, adminHomeFragment).commit();
      NavigationView navigationView = findViewById(R.id.admin_navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_item_fragment1) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.admin_main_content,pdfFragment).commit();


                //switchToFragment(new AddLaborFragment());
            } else if (item.getItemId() == R.id.menu_item_fragment2) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.admin_main_content,barPlotTesting).commit();
            }
            else if (item.getItemId() == R.id.home_id) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.admin_main_content,emailAutomation).commit();
            }
            else if (item.getItemId() == R.id.EmailMenuId) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.admin_main_content,fragTest).commit();
            }


            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });


    }
}