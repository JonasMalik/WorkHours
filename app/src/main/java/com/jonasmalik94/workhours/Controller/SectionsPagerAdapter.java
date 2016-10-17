package com.jonasmalik94.workhours.Controller;

/**
 * Created by jonas on 2016-10-11.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jonasmalik94.workhours.View.CalculatorFragment;
import com.jonasmalik94.workhours.View.CalendarFragment;
import com.jonasmalik94.workhours.View.NewDayFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {

            case 1: return NewDayFragment.newInstance(0);
            case 0: return CalendarFragment.newInstance(1);
            case 2: return CalculatorFragment.newInstance(2);
            default: return NewDayFragment.newInstance(0);
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "lägg till arbetsdag";
            case 1:
                return "ads";
            case 2:
                return "SECTION 3";
            case 3:
                return "SECTION 4";
        }
        return null;
    }
}
