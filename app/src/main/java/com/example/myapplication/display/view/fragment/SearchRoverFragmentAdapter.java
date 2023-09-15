/**
 * @author rgiaquinto
 * */
package com.example.myapplication.display.view.fragment;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Classe SearchRoverFragmentAdapter
 *
 * Adapteur pour le fragment d'affichage de la recherche
 * */
public class SearchRoverFragmentAdapter extends FragmentPagerAdapter {

    public SearchRoverFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        return new SearchRoverFragment();
    }


    @Override
    public int getCount() {

        return 1;
    }
}
