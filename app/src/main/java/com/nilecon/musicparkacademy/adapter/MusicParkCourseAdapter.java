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
 * Created by Maximus on 31/5/2559.
 */
public class MusicParkCourseAdapter extends BaseAdapter {
    private Activity activity;
    private int[] course_images;
    private int[] course_items;
    public MusicParkCourseAdapter(Activity activity, int[] course_img, int[] course_label) {
        this.activity = activity;
        this.course_images = course_img;
        this.course_items = course_label;
    }

    @Override
    public int getCount() {
        return course_images.length;
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
            convertView = inflater.inflate(R.layout.musicpark_course_items_layout, parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.img_course_bg.setImageResource(course_images[position]);
        holder.img_course_label.setImageResource(course_items[position]);
        return convertView;
    }
    public class Holder{
        private ImageView img_course_bg;
        private ImageView img_course_label;
        public Holder(View v){
            new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
            img_course_bg = (ImageView)v.findViewById(R.id.img_course);
            img_course_label = (ImageView)v.findViewById(R.id.img_label_course);
        }
    }
}
