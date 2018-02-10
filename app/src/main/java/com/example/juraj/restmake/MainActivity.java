package com.example.juraj.restmake;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.example.juraj.restmake.NavigationBarFragments.InboxFragment;
import com.example.juraj.restmake.NavigationBarFragments.ProfileFragment;
import com.example.juraj.restmake.NavigationBarFragments.ExploreFragment;

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
                        break;
                    }
                    case R.id.bottom_nav_profile: {
                        fragment = ProfileFragment.newInstance();
                        break;
                    }
                    case R.id.bottom_nav_inbox: {
                        fragment = InboxFragment.newInstance();
                        break;
                    }
                    case R.id.bottom_nav_add_item: {
                        fragment = AddItemFragment.newInstance();
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
