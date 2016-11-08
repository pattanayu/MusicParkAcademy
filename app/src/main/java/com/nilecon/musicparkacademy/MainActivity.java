package com.nilecon.musicparkacademy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.fragment.MusicParkListmenuFragment;

public class MainActivity extends BaseSlideActivity implements View.OnClickListener{
    public static boolean isDetail = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_frame);
        if (savedInstanceState != null)
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
        if (mContent == null) {
            Bundle bundle = new Bundle();
//            bundle.putInt("index",0);
            switchContent(new MusicParkListmenuFragment(), bundle);
        }

    }

    @Override
    protected void setActionBar() {
        getActionBar().setCustomView(R.layout.navbar_layout);
        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        ImageView menuLeft = (ImageView) getActionBar().getCustomView().findViewById(R.id.navbar_button_left);
        ImageView menuRight = (ImageView) getActionBar().getCustomView().findViewById(R.id.navbar_button_right);
        menuRight.setVisibility(View.VISIBLE);
        menuLeft.setVisibility(View.VISIBLE);
        menuLeft.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.navbar_button_left)
            toggle();
    }

    public void switchTabContent(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        MainActivity.isDetail = false;
        fm.beginTransaction()
                .add(R.id.tab_content_main, fragment).addToBackStack(null)
                .commit();
    }
}
