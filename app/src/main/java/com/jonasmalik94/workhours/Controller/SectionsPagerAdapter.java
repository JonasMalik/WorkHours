package com.jonasmalik94.workhours.Controller;

/**
 * Created by jonas on 2016-10-11.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jonasmalik94.workhours.View.CalculatorFragment;
import com.jonasmalik94.workhours.View.CalenderFragment;
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
        // getItem is called to instantiate the fragment for the given page.
        // Return a NewDayFragment (defined as a static inner class below).
        switch(position) {

            case 0: return NewDayFragment.newInstance(0);
            case 1: return CalculatorFragment.newInstance(1);
            case 2: return CalenderFragment.newInstance(2);
            //case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
            //case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
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
