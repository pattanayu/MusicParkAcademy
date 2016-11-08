package com.nilecon.musicparkacademy.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.nilecon.musicparkacademy.Model.Course;
import com.nilecon.musicparkacademy.Model.CourseAll;
import com.nilecon.musicparkacademy.Model.RestManager;
import com.nilecon.musicparkacademy.Model.SearchService;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.MusicParkCourseList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Maximus on 29/10/2559.
 */
public class MusicParkCourseListFragment extends AbstractFragment {
    private GridView gv_teacher;
    private MusicParkCourseList musicParkCourseList;
    private int id;
    private ProgressDialog pDialog;
    private List<CourseAll.CourseBean> courseList;
    private String TAG = MusicParkCourseListFragment.class.getSimpleName();

    @Override
    protected int setContentView() {
        return R.layout.musicpark_teacher_layout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_MENU;
    }

    @Override
    protected void initView(View v) {
        gv_teacher = (GridView) v.findViewById(R.id.gv_teacher);
    }

    @Override
    protected void setupUI() {
        if (getArguments() != null) {
            id = getArguments().getInt("id");
        }
        apiService();
    }

    private void apiService() {
        final SearchService mManager = RestManager.getBuilder(getContext()).create(SearchService.class);
        final Call<CourseAll> courseCall = mManager.getCourseType(id);
        courseCall.enqueue(new Callback<CourseAll>() {
            @Override
            public void onResponse(Call<CourseAll> call, Response<CourseAll> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
//                        Log.e(TAG, "Response from url: " + courseList.toString());
                        courseList = new ArrayList<>();
                        courseList.addAll(response.body().getCourse());
                        musicParkCourseList = new MusicParkCourseList(getActivity(), courseList);
                        gv_teacher.setAdapter(musicParkCourseList);
                        gv_teacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Bundle bundle = new Bundle();
                                bundle.putString("data", new Gson().toJson(courseList.get(position)));
                                bundle.putInt("id", Integer.parseInt(courseList.get(position).getCourse_id()));
                                replaceFragment(new MusicParkCourseDetailsFragment(), bundle);
                            }
                        });
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("ไม่พบข้อมูล");

                        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                    }

                } else {

                }
            }




            @Override
            public void onFailure(Call<CourseAll> call, Throwable t) {

            }
        });

    }
}