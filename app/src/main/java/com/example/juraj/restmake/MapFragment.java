package com.example.juraj.restmake;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;


public class MapFragment extends Fragment {

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private MapView mMapView;
    private GoogleMap mGoogleMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.map_fragment, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mGoogleMap = googleMap;

                if ( ContextCompat.checkSelfPermission( getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
                        ActivityCompat.requestPermissions( getActivity(), new String[] {  Manifest.permission.ACCESS_FINE_LOCATION  }, MY_PERMISSIONS_REQUEST_LOCATION );

                }

                mGoogleMap.setMyLocationEnabled(true);
                mGoogleMap.setOnMyLocationChangeListener(mOnMyLocationChangeListener);
                LatLng slovak = new LatLng(48.738658, 17.720552);
                // mGoogleMap.addMarker(new MarkerOptions().position(slovak).title("Marker title").snippet("Marker description"));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(slovak).zoom(16).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
                {
                    @Override
                    public void onMapClick(LatLng arg0)
                    {
                        changeMapSize(getMapSize());
                    }
                });

            }


        });



        return rootView;
    }

    private GoogleMap.OnMyLocationChangeListener mOnMyLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            //mGoogleMap.addMarker(new MarkerOptions().position(latLng));
            if( mGoogleMap != null)
            {
                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
            }
        }
    };

    public boolean getMapSize()
    {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (250 * scale + 0.5f);
        if(mMapView.getHeight() == pixels )
        {
            return  true;
        }
        else
            return false;
    }

    public void changeMapSize(boolean b)
    {
        RelativeLayout.LayoutParams layoutParams;
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (250 * scale + 0.5f);
        if(b)
        {
            layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            mMapView.setLayoutParams(layoutParams);
            //((MainActivity)getActivity()).hideButtons();
        }
        else
        {
            layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, pixels);
            mMapView.setLayoutParams(layoutParams);
            // ((MainActivity)getActivity()).showButtons();
        }

    }

}
