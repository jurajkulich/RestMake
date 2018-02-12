package com.example.juraj.restmake.ScreenSlidesPageJob;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.juraj.restmake.Instances.Job;
import com.example.juraj.restmake.R;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.juraj.restmake.AddItemFragment.JOB_PREFERENCES;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageJobToDb extends Fragment {

    public static final String TITLE = "TITLE";
    public static final String DESCRIPTION = "DESCRIPTION";
    private static final String SALARY_TYPE = "SALARY_TYPE";
    private static final String SALARY = "SALARY";
    private static final String LATITUDE = "LATITUDE";
    private static final String LONGITUDE = "LONGITUDE";

    private FirebaseDatabase mFirebaseDatabase;
    private SharedPreferences sharedPreferences;

    public ScreenSlidePageJobToDb() {
        // Required empty public constructor
    }

    public static ScreenSlidePageJobToDb newInstance() {

        Bundle args = new Bundle();

        ScreenSlidePageJobToDb fragment = new ScreenSlidePageJobToDb();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_screen_slide_page_job_to_db, container, false);
        sharedPreferences = getActivity().getSharedPreferences(JOB_PREFERENCES, Context.MODE_PRIVATE);
        return rootView;
    }

    private void addJobToDb(Job job) {
        String id = mFirebaseDatabase.getReference("jobs").push().getKey();
        mFirebaseDatabase.getReference("jobs").child(id).setValue(job);
        Toast.makeText(getContext(), "Job is added!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        sharedPreferences.edit().clear().commit();
        super.onDestroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if( isVisibleToUser ) {
            mFirebaseDatabase = FirebaseDatabase.getInstance();

            String title = sharedPreferences.getString(TITLE,null );
            String description = sharedPreferences.getString(DESCRIPTION, null);
            String salary = sharedPreferences.getString(SALARY, null);
            boolean salary_type = sharedPreferences.getBoolean(SALARY_TYPE, false);
            String latitude = sharedPreferences.getString(LATITUDE, null);
            String longitude = sharedPreferences.getString(LONGITUDE, null);

            Job job = new Job(title, description, Double.parseDouble(salary), salary_type, latitude, longitude);
            addJobToDb(job);
        } else {

        }
    }
}
