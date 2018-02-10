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
public class ScreenSlidePageJobPrice extends Fragment {

    private ImageButton nextButton;
    private ImageButton backButton;

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
        View rootView = inflater.inflate(R.layout.fragment_screen_slide_page_job_price, container, false);

        nextButton = rootView.findViewById(R.id.price_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AddItemFragment)(getParentFragment())).setSlide(3, true);
            }
        });

        backButton = rootView.findViewById(R.id.price_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AddItemFragment) getParentFragment()).setSlide(1, true);
            }
        });

        return rootView;
    }

}
