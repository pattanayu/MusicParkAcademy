package com.nilecon.musicparkacademy.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilecon.musicparkacademy.R;

/**
 * Created by Maximus on 7/7/2559.
 */
public class MusicParkVideoAdapter extends RecyclerView.Adapter<MusicParkVideoAdapter.Holder>  {
    private Activity activity;
    private int[]img_title;
    public MusicParkVideoAdapter(Activity activity, int[] img) {
        this.activity = activity;
        this.img_title = img;
    }

    @Override
    public MusicParkVideoAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.musicpark_video_items ,parent ,false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(MusicParkVideoAdapter.Holder holder, int position) {
            holder.mPhoto.setImageResource(img_title[position]);
    }

    @Override
    public int getItemCount() {
        return img_title.length;
    }
    public  class Holder extends RecyclerView.ViewHolder{
        private ImageView mPhoto;
        public Holder(View itemView) {
            super(itemView);
            mPhoto = (ImageView)itemView.findViewById(R.id.vidPhoto);

        }
    }
}
