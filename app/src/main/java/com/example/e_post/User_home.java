package com.example.e_post;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class User_home extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapteruser pageAdapter;
    TabItem tabChats;
    TabItem tabStatus;
    TabItem tabCalls;
    TabItem tabCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umain);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        //setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);
        tabChats = findViewById(R.id.stamp_user);
        tabStatus = findViewById(R.id.Speed_user);
        tabCalls = findViewById(R.id.post_user);
        tabCall = findViewById(R.id.Money_user);
        viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PageAdapteruser(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(User_home.this,
                            R.color.mycolor));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(User_home.this,
                            R.color.mycolor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(User_home.this,
                                R.color.mycolor));
                    }
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(User_home.this,
                            R.color.mycolor));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(User_home.this,
                            R.color.mycolor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(User_home.this,
                                R.color.mycolor));
                    }
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(User_home.this,
                            R.color.mycolor));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(User_home.this,
                            R.color.mycolor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(User_home.this,
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

