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
public class ScreenSlidePageJobDescription extends Fragment {

    private ImageButton nextButton;
    private ImageButton backButton;

    public ScreenSlidePageJobDescription() {
        // Required empty public constructor
    }

    public static ScreenSlidePageJobDescription newInstance() {
        
        Bundle args = new Bundle();
        
        ScreenSlidePageJobDescription fragment = new ScreenSlidePageJobDescription();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_screen_slide_page_job_description, container, false);

        nextButton = rootView.findViewById(R.id.description_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AddItemFragment)(getParentFragment())).setSlide(2, true);
            }
        });

        backButton = rootView.findViewById(R.id.description_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AddItemFragment) getParentFragment()).setSlide(0, true);
            }
        });
        return rootView;
    }

}
