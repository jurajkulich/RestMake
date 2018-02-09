package com.example.juraj.restmake;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.firebase.database.FirebaseDatabase;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddItemFragment extends Fragment {

    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    private Button button;

    private FirebaseDatabase mFirebaseDatabase;

    private TextInputEditText title;

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


        return rootView;
    }

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
}
