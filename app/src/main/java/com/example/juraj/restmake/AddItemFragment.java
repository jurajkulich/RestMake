package com.example.juraj.restmake;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juraj.restmake.ScreenSlidesPageJob.ScreenSlidePageJobDescription;
import com.example.juraj.restmake.ScreenSlidesPageJob.ScreenSlidePageJobLocation;
import com.example.juraj.restmake.ScreenSlidesPageJob.ScreenSlidePageJobPrice;
import com.example.juraj.restmake.ScreenSlidesPageJob.ScreenSlidePageJobTitle;
import com.example.juraj.restmake.ScreenSlidesPageJob.ScreenSlidePageJobToDb;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddItemFragment extends Fragment {

    public static final String JOB_PREFERENCES = "JobSharedPreference" ;

    private static final int NUM_PAGES = 5;

    private NonSwipeViewPager mViewPager;

    public static AddItemFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AddItemFragment fragment = new AddItemFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_item, container, false);

        mViewPager = rootView.findViewById(R.id.add_item_view_pager);
        mViewPager.setAdapter(new ScreenSlidePagerAdapter(getChildFragmentManager()));
        mViewPager.setOffscreenPageLimit(0);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(JOB_PREFERENCES, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
        return rootView;
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return ScreenSlidePageJobTitle.newInstance();
                case 1: return ScreenSlidePageJobDescription.newInstance();
                case 2: return ScreenSlidePageJobLocation.newInstance();
                case 3: return ScreenSlidePageJobPrice.newInstance();
                case 4: return ScreenSlidePageJobToDb.newInstance();
                default: return ScreenSlidePageJobToDb.newInstance();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public void setSlide(int slide, boolean scroll) {
        mViewPager.setCurrentItem(slide, scroll);
    }

    public int getItem() {
        return mViewPager.getCurrentItem();
    }

}
