package com.example.juraj.restmake;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.juraj.restmake.Authorization.RegisterVerifyFragment;
import com.example.juraj.restmake.NavigationBarFragments.ProfileFragment;
import com.example.juraj.restmake.NavigationBarFragments.ExploreFragment;
import com.example.juraj.restmake.NavigationBarFragments.SearchFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch(item.getItemId()) {
                    case R.id.bottom_nav_explore: {
                        fragment = ExploreFragment.newInstance();
                        //fragment = RegisterVerifyFragment.newInstance();
                        break;
                    }
                    case R.id.bottom_nav_profile: {
                        fragment = ProfileFragment.newInstance();
                        break;
                    }
                    case R.id.bottom_nav_inbox: {
                        fragment = AddItemFragment.newInstance();
                        break;
                    }
                    case R.id.bottom_nav_search: {
                        fragment = SearchFragment.newInstance();
                        break;
                    }
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();
                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, ExploreFragment.newInstance());
        transaction.commit();

    }



    @Override
    protected void onStop() {
        super.onStop();
        onBackPressed();
    }
}
