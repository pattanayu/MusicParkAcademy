package com.nilecon.musicparkacademy.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.MusicParkClassroomAdapter;

/**
 * Created by Maximus on 23/5/2559.
 */
public class MusicParkClassroomFragment extends AbstractFragment {
    private MusicParkClassroomAdapter musicParkClassroomAdapter;
    private GridView lv_class;

    @Override
    protected int setContentView() {
        return R.layout.musicpark_classroom_layout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_MENU;
    }

    @Override
    protected void initView(View v) {
        lv_class = (GridView)v.findViewById(R.id.lv_classes);
    }

    @Override
    protected void setupUI() {
        final int[] room_img = {R.drawable.piano_room,R.drawable.guitar_room,
                R.drawable.mic_room,R.drawable.violin_room,R.drawable.drums_room,R.drawable.saxophone_room };
        final String[] room_item = getResources().getStringArray(R.array.classrooms);
        musicParkClassroomAdapter = new MusicParkClassroomAdapter(getActivity(),room_img,room_item);
        lv_class.setAdapter(musicParkClassroomAdapter);
        lv_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                for(int i=0;i<=position;i++){
                    replaceFragment(new MusicParkClassroomList(),bundle);
                    break;
                }
            }
        });
    }
}
