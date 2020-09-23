package com.cell47.rento;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cell47.rento.Fragments.Clients;
import com.cell47.rento.Fragments.Projects;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HitecConsProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitec_cons_profile);

        Toolbar toolbar =  findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Q/A");

        TabLayout tablayout =  findViewById(R.id.tab);

        ViewPager viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter viewpagerAdap = new ViewPagerAdapter(getSupportFragmentManager());

        viewpagerAdap.addFragments(new Clients(), "Clients");

        viewpagerAdap.addFragments(new Projects(), "Projects");

        viewPager.setAdapter(viewpagerAdap);

        tablayout.setupWithViewPager(viewPager);
    }

    public static class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private final ArrayList<Fragment> fragments;

        private final ArrayList<String> titles;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {

            return fragments.size();
        }

        public void addFragments(Fragment fragment, String title) {
            fragments.add(fragment);

            titles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            return titles.get(position);
        }

    }
}
