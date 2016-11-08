package com.nilecon.musicparkacademy.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.MusicParkCourseAdapter;

/**
 * Created by Maximus on 31/5/2559.
 */
public class MusicParkCourseFragment extends AbstractFragment{
    private Activity activity;
    private MusicParkCourseAdapter musicParkCourseAdapter;
    private GridView gv_course;

    @Override
    protected int setContentView() {
        return R.layout.musicpark_course_laout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_MENU;
    }

    @Override
    protected void initView(View v) {
        gv_course = (GridView)v.findViewById(R.id.gridview_course);
    }

    @Override
    protected void setupUI() {
        final int[] course_img = {R.drawable.musicpark_guitar_bg,R.drawable.musicpark_piano_bg,
                R.drawable.musicpark_violin_bg,R.drawable.musicpark_mic_bg,R.drawable.musicpark_drums_bg,
                R.drawable.musicpark_saxophone_bg };
        final int[] course_label = {
                R.drawable.musicpark_guitar_course_label,R.drawable.musicpark_piano_course_label,
                R.drawable.musicpark_violin_course_label,R.drawable.musicpark_singer_course_label,
                R.drawable.musicpark_drums_course_label,R.drawable.musicpark_saxophone_course_label};
        musicParkCourseAdapter = new MusicParkCourseAdapter(getActivity(),course_img,course_label);
        gv_course.setAdapter(musicParkCourseAdapter);
        gv_course.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i =0; i<=course_img.length; i++){
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",position);
                    replaceFragment(new MusicParkCourseListFragment(),bundle);
                    break;
                }
            }
        });

    }
}
