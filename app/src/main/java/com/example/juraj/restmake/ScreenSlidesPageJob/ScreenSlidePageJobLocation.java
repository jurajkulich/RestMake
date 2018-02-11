package com.example.juraj.restmake.ScreenSlidesPageJob;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.juraj.restmake.AddItemFragment;
import com.example.juraj.restmake.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLng;

import static android.app.Activity.RESULT_OK;
import static com.example.juraj.restmake.AddItemFragment.JOB_PREFERENCES;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageJobLocation extends Fragment {

    private static final String LATITUDE = "LATITUDE";
    private static final String LONGITUDE = "LONGITUDE";

    private int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    Place mPlace;

    private ImageButton backButton;
    private ImageButton nextButton;
    private Button button;

    public ScreenSlidePageJobLocation() {
        // Required empty public constructor
    }

    public static ScreenSlidePageJobLocation newInstance() {
        
        Bundle args = new Bundle();
        
        ScreenSlidePageJobLocation fragment = new ScreenSlidePageJobLocation();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_screen_slide_page_job_location, container, false);

        backButton = rootView.findViewById(R.id.location_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AddItemFragment) getParentFragment()).setSlide(4, true);
            }
        });

        nextButton = rootView.findViewById(R.id.location_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkLocation())
                    ((AddItemFragment)(getParentFragment())).setSlide(3, true);
            }
        });

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

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if( resultCode == RESULT_OK) {
                mPlace = PlaceAutocomplete.getPlace(getActivity(), data);
                Toast.makeText(getActivity(), mPlace.getAddress(), Toast.LENGTH_SHORT).show();
            } else {
                Status status = PlaceAutocomplete.getStatus(getActivity(), data);
                Toast.makeText(getActivity(), "Couldn't get address", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkLocation()
    {
        if( mPlace ==  null) {
            Toast.makeText(getContext(), "You didn't select location!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            LatLng latLng = mPlace.getLatLng();
            String lat = String.valueOf(latLng.latitude);
            String lng = String.valueOf(latLng.longitude);
            SharedPreferences.Editor editor = getContext().getSharedPreferences(JOB_PREFERENCES, Context.MODE_PRIVATE).edit();
            editor.putString(LATITUDE, lat);
            editor.putString(LONGITUDE, lng);
            editor.commit();
            return true;
        }
    }
}
