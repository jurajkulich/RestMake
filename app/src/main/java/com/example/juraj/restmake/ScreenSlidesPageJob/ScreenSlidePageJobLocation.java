package com.example.juraj.restmake.ScreenSlidesPageJob;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.juraj.restmake.AddItemFragment;
import com.example.juraj.restmake.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageJobLocation extends Fragment {

    private ImageButton backButton;

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
                ((AddItemFragment) getParentFragment()).setSlide(2, true);
            }
        });

        return rootView;
    }

}
