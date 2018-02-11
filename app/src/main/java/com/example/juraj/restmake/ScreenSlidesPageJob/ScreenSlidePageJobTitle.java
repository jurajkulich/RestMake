package com.example.juraj.restmake.ScreenSlidesPageJob;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.juraj.restmake.AddItemFragment;
import com.example.juraj.restmake.R;

import static com.example.juraj.restmake.AddItemFragment.JOB_PREFERENCES;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageJobTitle extends Fragment {

    public static final String TITLE = "TITLE";

    private ImageButton nextButton;
    private EditText titleEditText;

    public ScreenSlidePageJobTitle() {
        // Required empty public constructor
    }

    public static ScreenSlidePageJobTitle newInstance() {
        
        Bundle args = new Bundle();
        
        ScreenSlidePageJobTitle fragment = new ScreenSlidePageJobTitle();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_screen_slide_page_job_title, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        nextButton = rootView.findViewById(R.id.title_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkTitle())
                    ((AddItemFragment)(getParentFragment())).setSlide(1, true);
            }
        });

        titleEditText = rootView.findViewById(R.id.title_text_input_edit_text);

        return rootView;
    }

    private boolean checkTitle() {
        titleEditText.setError(null);
        View focusView;
        String title = titleEditText.getText().toString();
        if(title.length() < 5) {
            titleEditText.setError("Title should have at least 5 characters!");
            focusView = titleEditText;
            focusView.requestFocus();
            return false;
        } else {
            SharedPreferences.Editor editor = getContext().getSharedPreferences(JOB_PREFERENCES, Context.MODE_PRIVATE).edit();
            editor.putString(TITLE, title);
            editor.commit();
        }
        return true;
    }

}
