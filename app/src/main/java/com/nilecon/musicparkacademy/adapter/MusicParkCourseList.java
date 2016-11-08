package com.nilecon.musicparkacademy.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilecon.musicparkacademy.Model.Course;
import com.nilecon.musicparkacademy.Model.CourseAll;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.utils.Fonts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Maximus on 29/10/2559.
 */
public class MusicParkCourseList extends BaseAdapter {
    private Activity activity;
    private List<CourseAll.CourseBean> courseList;
    private String[] details;


    public MusicParkCourseList(FragmentActivity activity, List<CourseAll.CourseBean> courseList) {
        this.activity = activity;
        this.courseList = courseList;
    }


    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseList.size();
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
            convertView = inflater.inflate(R.layout.musicpark_teacher_items, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.name_teacher.setText(courseList.get(position).getCourse_name());
        holder.subject.setText(courseList.get(position).getCourse_description());
        return convertView;
    }

    public class Holder {
        private ImageView img_teacher;
        private TextView name_teacher;
        private TextView subject;

        public Holder(View v) {
            new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
            img_teacher = (ImageView) v.findViewById(R.id.teacher_img);
            name_teacher = (TextView) v.findViewById(R.id.idteacher_name);
            subject = (TextView) v.findViewById(R.id.subject);
        }
    }
}
