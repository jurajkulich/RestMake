package com.example.juraj.restmake;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class AddItemFragment extends Fragment {

    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

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
                case 2: return ScreenSlidePageJobPrice.newInstance();
                case 3: return ScreenSlidePageJobLocation.newInstance();
                default: return ScreenSlidePageJobTitle.newInstance();
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

    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if( resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), data);
                Toast.makeText(getActivity(), place.getAddress(), Toast.LENGTH_SHORT).show();
            } else {
                Status status = PlaceAutocomplete.getStatus(getActivity(), data);
                Toast.makeText(getActivity(), "Couldn't get address", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void addJobToDb(Job job) {

        String id = mFirebaseDatabase.getReference("jobs").push().getKey();
        mFirebaseDatabase.getReference("jobs").child(id).setValue(job);
    }

    mFirebaseDatabase = FirebaseDatabase.getInstance();

    title = rootView.findViewById(R.id.title_text_input_edit_text);


    // addJobToDb(new Job("Pik", "Mám rád, deň jabloní stále chutí", 2.5));

    button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                AutocompleteFilter filter = new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS)
                        .build();
                Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY).
                        setFilter(filter).build(getActivity());
                startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
            } catch (GooglePlayServicesRepairableException e) {
                // TODO exception
            } catch (GooglePlayServicesNotAvailableException e) {
                // TODO exception
            }
        }
    });
    */
}
