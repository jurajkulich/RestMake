package com.example.juraj.restmake.Authorization;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.juraj.restmake.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterVerifyFragment extends Fragment {

    private static final String TAG = "RegisterVerifyFragment";
    private FirebaseAuth firebaseAuth;

    public static RegisterVerifyFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RegisterVerifyFragment fragment = new RegisterVerifyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();
        verifyUser();
        return inflater.inflate(R.layout.fragment_register_verify, container, false);
    }

    void verifyUser() {
        final FirebaseUser user = firebaseAuth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if( task.isSuccessful()) {
                    Toast.makeText(getContext(), "Verification email send: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "Verifying failed: ", task.getException());
                    Toast.makeText(getContext(), "Failed to send verification email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
