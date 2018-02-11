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
import android.widget.RadioGroup;

import com.example.juraj.restmake.AddItemFragment;
import com.example.juraj.restmake.R;

import static com.example.juraj.restmake.AddItemFragment.JOB_PREFERENCES;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageJobPrice extends Fragment {

    private static final String SALARY_TYPE = "SALARY_TYPE";
    private static final String SALARY = "SALARY";

    private EditText priceEditText;
    private RadioGroup mRadioGroup;

    private ImageButton nextButton;
    private ImageButton backButton;

    private boolean salary;

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

        priceEditText = rootView.findViewById(R.id.price_text_input_edit_text);

        salary = false;

        nextButton = rootView.findViewById(R.id.price_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( checkPrice())
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

        mRadioGroup = rootView.findViewById(R.id.salary_radio_group);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch(id) {
                    case R.id.salary_salaried: {
                        salary = false;
                        break;
                    }
                    case R.id.salary_hourly: {
                        salary = true;
                        break;
                    }
                    default: {
                        salary = false;
                        break;
                    }
                }

            }
        });

        return rootView;
    }

    private boolean checkPrice() {
        priceEditText.setError(null);
        View focusView;
        String textPrice = priceEditText.getText().toString();
        if (TextUtils.isEmpty(textPrice)) {
            priceEditText.setError("You didn't set price!");
            focusView = priceEditText;
            focusView.requestFocus();
            return false;
        }
        Double price = Double.parseDouble(textPrice);
        if(price < 0){
            priceEditText.setError("Price shouldn't be negative!");
            focusView = priceEditText;
            focusView.requestFocus();
            return false;
        } else {
            SharedPreferences.Editor editor = getContext().getSharedPreferences(JOB_PREFERENCES, Context.MODE_PRIVATE).edit();
            editor.putBoolean(SALARY_TYPE, salary);
            editor.putString(SALARY, textPrice);
            editor.commit();
        }
        return true;
    }

}
