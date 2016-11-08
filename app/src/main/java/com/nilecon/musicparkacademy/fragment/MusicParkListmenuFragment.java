package com.nilecon.musicparkacademy.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;

/**
 * Created by Maximus on 12/5/2559.
 */
public class MusicParkListmenuFragment extends AbstractFragment {
    private ImageView course, teacher, event, classroom, video, location, about;
    private int menuType;

    @Override
    protected int setContentView() {
        return R.layout.musicpark_list_menu_layout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_MENU;
    }

    @Override
    protected void initView(View v) {
        course = (ImageView) v.findViewById(R.id.menu_course);
        teacher = (ImageView) v.findViewById(R.id.menu_teacher);
        event = (ImageView) v.findViewById(R.id.menu_event);
        classroom = (ImageView) v.findViewById(R.id.menu_classroom);
        video = (ImageView) v.findViewById(R.id.menu_video);
        location = (ImageView) v.findViewById(R.id.menu_location);
        about = (ImageView) v.findViewById(R.id.menu_about);
    }

    @Override
    protected void setupUI() {
        course.setOnClickListener(this);
        teacher.setOnClickListener(this);
        about.setOnClickListener(this);
        classroom.setOnClickListener(this);
        location.setOnClickListener(this);
        event.setOnClickListener(this);
        video.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.menu_about:
                replaceFragment(new MusicParkAboutFragment(), bundle);
                break;
            case R.id.menu_classroom:
                replaceFragment(new MusicParkClassroomFragment(), bundle);
                break;
            case R.id.menu_teacher:
                replaceFragment(new MusicParkTeacherFragment(), bundle);
                break;
            case R.id.menu_course:
                replaceFragment(new MusicParkCourseFragment(),bundle);
                break;
            case R.id.menu_location:
                replaceFragment(new MusicParkLocationFragment(),bundle);
                break;
            case R.id.menu_event:
                replaceFragment(new Calendar(),bundle);
                break;
            case R.id.menu_video:
                replaceFragment(new MusicParkVideoFragment(),bundle);
                break;
        }
    }

}
