package com.nilecon.musicparkacademy.fragment;

import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;

/**
 * Created by Maximus on 1/6/2559.
 */
public class MusicParkLocationFragment extends AbstractFragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private int menuType;
    @Override
    protected int setContentView() {
        return R.layout.activity_maps;
    }


    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_MENU;
    }

    @Override
    protected void initView(View v) {

    }

    @Override
    protected void setupUI() {
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
