package com.example.android.miwok.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.miwok.fragments.ColorsFragment;
import com.example.android.miwok.fragments.FamilyFragment;
import com.example.android.miwok.fragments.NumbersFragment;
import com.example.android.miwok.fragments.PhrasesFragment;

/**
 * Created by MaNoOoz on 3/12/2018.
 */

public class mFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] {"Numbers", "Colors", "Family", "Phrases"};
    private Context context;

    public mFragmentPagerAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new ColorsFragment();
        }
         else if (position == 2) {
        return new FamilyFragment();
        }
        else
        {
            return new PhrasesFragment();
        }
        //return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        return tabTitles[position];
    }
}
