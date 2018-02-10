package com.example.juraj.restmake.NavigationBarFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juraj.restmake.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InboxFragment extends Fragment {


    public static InboxFragment newInstance() {

        Bundle args = new Bundle();
        
        InboxFragment fragment = new InboxFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inbox, container, false);
    }

}
