package com.example.movieapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


class TabPagerAdapter extends FragmentPagerAdapter {


    public TabPagerAdapter(MainActivity mainActivity, @NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        MoviesFragment tabFragment = new MoviesFragment();
        Bundle bundle = new Bundle();
        if (position == 0) bundle.putString("genre", "Action");
        else if (position == 1) {
            bundle.putString("genre", "Sci-Fi");
        } else if (position == 2) {
            bundle.putString("genre","Comedy");
        } else if (position == 3) {
            bundle.putString("genre", "Drama");
        }
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

   public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Action";
            case 1:
                return "Sci-Fi";
            case 2:
                return "Comedy";
            case 3:
                return "Drama";
            default:
                return null;

        }        }
    }



