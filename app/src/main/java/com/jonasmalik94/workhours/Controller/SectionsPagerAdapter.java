package com.jonasmalik94.workhours.Controller;

/**
 * Created by jonas on 2016-10-11.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jonasmalik94.workhours.View.CalculatorFragment;
import com.jonasmalik94.workhours.View.CalendarFragment;
import com.jonasmalik94.workhours.View.ListFragment;
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

            case 2: return NewDayFragment.newInstance();
            case 0: return CalendarFragment.newInstance();
            case 3: return CalculatorFragment.newInstance();
            case 1: return ListFragment.newInstance();
            default: return NewDayFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return null;
    }
}
