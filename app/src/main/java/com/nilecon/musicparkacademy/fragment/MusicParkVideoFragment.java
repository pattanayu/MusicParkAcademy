package com.nilecon.musicparkacademy.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.MusicParkVideoAdapter;

/**
 * Created by Maximus on 7/7/2559.
 */
public class MusicParkVideoFragment extends AbstractFragment {
    RecyclerView recyclerView;
    MusicParkVideoAdapter mCustomAdapter;
    @Override
    protected int setContentView() {
        return R.layout.musicpark_video_layout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_BACK;
    }

    @Override
    protected void initView(View v) {
        recyclerView = (RecyclerView)v.findViewById(R.id.rv_video);

    }

    @Override
    protected void setupUI() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        final int[]img = {R.drawable.mc_festival_1,R.drawable.mc_festival_2,R.drawable.mc_festival_3};
        mCustomAdapter = new MusicParkVideoAdapter(getActivity(),img);

        recyclerView.setAdapter(mCustomAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }
}
