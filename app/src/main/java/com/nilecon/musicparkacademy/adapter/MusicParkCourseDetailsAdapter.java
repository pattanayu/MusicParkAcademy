package com.nilecon.musicparkacademy.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nilecon.musicparkacademy.Model.Course;
import com.nilecon.musicparkacademy.Model.CourseAll;
import com.nilecon.musicparkacademy.Model.CourseID;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.utils.Fonts;

import java.util.List;

/**
 * Created by Maximus on 8/6/2559.
 */
public class MusicParkCourseDetailsAdapter extends BaseAdapter {
    private Activity activity;
    private String[] title;
    private String[] details;
    private List<CourseAll.CourseBean> courseIDs;


    public MusicParkCourseDetailsAdapter(FragmentActivity activity, List<CourseAll.CourseBean> courseList) {
        this.activity = activity;
        this.courseIDs = courseList;

    }


    @Override
    public int getCount() {
        return courseIDs.size();
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
            convertView = inflater.inflate(R.layout.musicpark_course_details_items, parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.str_details.setText(courseIDs.get(position).getFirst_name());
        holder.str_details.setText(courseIDs.get(position).getCourse_description());
        holder.str_details.setText(courseIDs.get(position).getCourse_start_date());
        holder.str_details.setText(courseIDs.get(position).getCourse_price());
        holder.str_details.setText(courseIDs.get(position).getCourse_type());

        holder.str_title.setText("Course name");
        holder.str_title.setText("Details");
        holder.str_title.setText("Time");
        holder.str_title.setText("Price");
        holder.str_title.setText("Teacher");
        return convertView;
    }
    public class Holder{
        private TextView str_title;
        private TextView str_details;
        public Holder(View v){
            new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
            str_title = (TextView)v.findViewById(R.id.title_course);
            str_details = (TextView) v.findViewById(R.id.details_course);
        }
    }
}
