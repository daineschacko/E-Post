package com.example.e_post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Admin_home extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabChats;
    TabItem tabStatus;
    TabItem tabCalls;
    TabItem tabCall;
    TabItem tabCall1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainn);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        //setSupportActionBar(toolbar);
toolbar.inflateMenu(R.menu.menu);
toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.action_setting:startActivity(new Intent(Admin_home.this,MainActivity.class));
            break;
        }
        return false;
    }
});
        tabLayout = findViewById(R.id.tablayout);
        tabChats = findViewById(R.id.home_admn);
        tabStatus = findViewById(R.id.emp_admn);
        tabCalls = findViewById(R.id.Speed_admn);
        tabCall = findViewById(R.id.Money_admn);
        tabCall1 = findViewById(R.id.stamp_user);

        viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(Admin_home.this,
                            R.color.mycolor));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Admin_home.this,
                            R.color.mycolor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(Admin_home.this,
                                R.color.mycolor));
                    }
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(Admin_home.this,
                            R.color.mycolor));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Admin_home.this,
                            R.color.mycolor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(Admin_home.this,
                                R.color.mycolor));
                    }
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(Admin_home.this,
                            R.color.mycolor));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Admin_home.this,
                            R.color.mycolor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(Admin_home.this,
                                R.color.mycolor));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    }

