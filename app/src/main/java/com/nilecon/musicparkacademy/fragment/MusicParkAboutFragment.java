package com.nilecon.musicparkacademy.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.utils.Fonts;

/**
 * Created by Maximus on 23/5/2559.
 */
public class MusicParkAboutFragment extends AbstractFragment {
    private TextView about;
    private ImageView logo;
    @Override
    protected int setContentView() {
        return R.layout.musicpark_about_layout ;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_MENU;
    }

    @Override
    protected void initView(View v) {
        new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
        about = (TextView)v.findViewById(R.id.musicpark_about);


    }

    @Override
    protected void setupUI() {
        about.setText(R.string.about);
    }

}
