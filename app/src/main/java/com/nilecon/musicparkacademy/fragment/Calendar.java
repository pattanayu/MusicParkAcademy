package com.nilecon.musicparkacademy.fragment;

import android.view.View;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;


/**
 * Created by Maximus on 5/7/2559.
 */
public class Calendar extends AbstractFragment  {

    protected int setContentView() {
        return R.layout.calendar;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_BACK;
    }

    @Override
    protected void initView(View v) {

    }

    @Override
    protected void setupUI() {



    }


}
