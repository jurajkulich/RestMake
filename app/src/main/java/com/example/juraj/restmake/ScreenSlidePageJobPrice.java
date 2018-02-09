package com.example.juraj.restmake;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageJobPrice extends Fragment {


    public ScreenSlidePageJobPrice() {
        // Required empty public constructor
    }

    public static ScreenSlidePageJobPrice newInstance() {
        
        Bundle args = new Bundle();
        
        ScreenSlidePageJobPrice fragment = new ScreenSlidePageJobPrice();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_slide_page_job_price, container, false);
    }

}
