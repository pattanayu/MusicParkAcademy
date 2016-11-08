package com.nilecon.musicparkacademy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.fragment.MusicParkClassroomFragment;
import com.nilecon.musicparkacademy.utils.Fonts;

/**
 * Created by Maximus on 23/5/2559.
 */
public class MusicParkClassroomAdapter extends BaseAdapter {
    private Activity activity;
    private int [] img;
    private MusicParkClassroomFragment musicParkClassroomFragment;
    private String [] items;
    private LayoutInflater inflater;

    public MusicParkClassroomAdapter(Activity activity, int[] room_img, String[] room_item) {
        this.activity = activity;
        this.img = room_img;
        this.items = room_item;

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
            convertView = inflater.inflate(R.layout.musicpark_classroom_items, parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.img_classroom.setImageResource(img[position]);
        holder.txt_classroom.setText(items[position]);
        return convertView;
    }
    public class Holder{
        private ImageView img_classroom;
        private TextView txt_classroom;
        public Holder(View v){
            new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
            img_classroom = (ImageView)v.findViewById(R.id.img_class);
            txt_classroom = (TextView)v.findViewById(R.id.txt_class);
        }
    }
}
