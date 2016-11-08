package com.nilecon.musicparkacademy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.utils.Fonts;

/**
 * Created by Maximus on 1/6/2559.
 */
public class MusicParkCourseMenuAdapter extends BaseAdapter {
    private Activity activity;
    private int img[];
    public MusicParkCourseMenuAdapter(Activity activity, int[] course_img) {
        this.activity = activity;
        this.img = course_img;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            LayoutInflater inflater = (activity).getLayoutInflater();
            convertView = inflater.inflate(R.layout.musicpark_course_menu_items, parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.img_course_bg.setImageResource(img[position]);
        return convertView;
    }
    public class Holder{
        private ImageView img_course_bg;
        public Holder(View v){
            new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
            img_course_bg = (ImageView)v.findViewById(R.id.img_course_items);
        }
    }
}
