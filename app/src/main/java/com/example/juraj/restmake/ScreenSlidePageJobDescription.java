package com.example.juraj.restmake;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageJobDescription extends Fragment {


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
        return inflater.inflate(R.layout.fragment_screen_slide_page_job_description, container, false);
    }

}
