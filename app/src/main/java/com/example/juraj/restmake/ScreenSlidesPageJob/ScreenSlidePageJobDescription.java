package com.example.juraj.restmake.ScreenSlidesPageJob;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.juraj.restmake.AddItemFragment;
import com.example.juraj.restmake.R;

import static com.example.juraj.restmake.AddItemFragment.JOB_PREFERENCES;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageJobDescription extends Fragment {

    public static final String DESCRIPTION = "DESCRIPTION";

    private ImageButton nextButton;
    private ImageButton backButton;

    private EditText descriptionEditText;

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

        descriptionEditText = rootView.findViewById(R.id.description_text_input_edit_text);

        nextButton = rootView.findViewById(R.id.description_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkDescription())
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

    private boolean checkDescription() {
        descriptionEditText.setError(null);
        View focusView;
        String description = descriptionEditText.getText().toString();
        if (description.length() == 0) {
            descriptionEditText.setError("Description shouldn't be empty!");
            focusView = descriptionEditText;
            focusView.requestFocus();
            return false;
        } else {
            SharedPreferences.Editor editor = getContext().getSharedPreferences(JOB_PREFERENCES, Context.MODE_PRIVATE).edit();
            editor.putString(DESCRIPTION, description);
            editor.commit();
        }
        return true;
    }

}
