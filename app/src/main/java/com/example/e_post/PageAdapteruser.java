package com.example.e_post;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by abdalla on 2/18/18.
 */

public class PageAdapteruser extends FragmentPagerAdapter {

    private int numOfTabs;

    PageAdapteruser(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Home_user();
            case 1:
                return new Poatcard_user();
            case 2:
                return new Speed_post_user();
            case 3:
                return new Money_order();
            case 4:
                return new Stamp_user();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
