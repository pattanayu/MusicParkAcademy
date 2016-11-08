package com.nilecon.musicparkacademy.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilecon.musicparkacademy.Model.Teacher;
import com.nilecon.musicparkacademy.Model.TeacherAll;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.utils.Fonts;

import java.util.List;

/**
 * Created by Maximus on 24/5/2559.
 */
public class MusicParkTeacherAdapter extends BaseAdapter {
    private Activity activity;
    private int[] teacher_img;
    private String[] teacher_name;
   private List<TeacherAll.TeacherBean> teacherBeanList;
    private String[] subject;

    public MusicParkTeacherAdapter(FragmentActivity activity, List<TeacherAll.TeacherBean> teacherList) {
        this.activity =activity;
        this.teacherBeanList = teacherList;
    }

    @Override
    public int getCount() {
        return teacherBeanList.size();
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
            convertView = inflater.inflate(R.layout.musicpark_teacher_items, parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.name_teacher.setText(teacherBeanList.get(position).getFirst_name());

        return convertView;
    }
    public class Holder{
        private ImageView img_teacher;
        private TextView name_teacher;
        private TextView subject;
        public Holder(View v){
            new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
            img_teacher = (ImageView)v.findViewById(R.id.teacher_img);
            name_teacher = (TextView)v.findViewById(R.id.idteacher_name);
            subject = (TextView)v.findViewById(R.id.subject);
        }
    }
}
