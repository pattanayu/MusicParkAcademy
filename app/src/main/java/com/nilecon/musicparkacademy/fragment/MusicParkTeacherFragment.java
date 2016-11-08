package com.nilecon.musicparkacademy.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.nilecon.musicparkacademy.Model.CourseAll;
import com.nilecon.musicparkacademy.Model.RestManager;
import com.nilecon.musicparkacademy.Model.SearchService;
import com.nilecon.musicparkacademy.Model.Teacher;
import com.nilecon.musicparkacademy.Model.TeacherAll;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.MusicParkCourseDetailsAdapter;
import com.nilecon.musicparkacademy.adapter.MusicParkTeacherAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Maximus on 24/5/2559.
 */
public class MusicParkTeacherFragment extends AbstractFragment {
    private GridView gv_teacher;
    private MusicParkTeacherAdapter musicParkTeacherAdapter;
    private List<TeacherAll.TeacherBean> teacherList;
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
        gv_teacher = (GridView)v.findViewById(R.id.gv_teacher);
    }

    @Override
    protected void setupUI() {
        apiService();

//        final int[] teacher_img = {R.drawable.mc_user_login,R.drawable.teacher_one,
//                R.drawable.teacher_two,R.drawable.teacher_three,R.drawable.teacher_four,R.drawable.teacher_five };
//        final String[] teacher_name = getResources().getStringArray(R.array.teacher_name);
//        final String[] subject = getResources().getStringArray(R.array.subjects);
//        musicParkTeacherAdapter = new MusicParkTeacherAdapter(getActivity(),teacher_img,teacher_name,subject);
//        gv_teacher.setAdapter(musicParkTeacherAdapter);
//        gv_teacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Bundle bundle = new Bundle();
//                for(int i=0; i<=teacher_img.length; i++){
//                    replaceFragment(new MusicParkTeacherDetails(),bundle);
//                    break;
//                }
//            }
//        });
    }
    private void apiService() {
        final SearchService mManager = RestManager.getBuilder(getContext()).create(SearchService.class);
        final Call<TeacherAll> course = mManager.getTeacherAll();
        course.enqueue(new Callback<TeacherAll>() {
            @Override
            public void onResponse(Call<TeacherAll> call, Response<TeacherAll> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        teacherList = new ArrayList<>();
                        teacherList.addAll(response.body().getTeacher());
                        musicParkTeacherAdapter = new MusicParkTeacherAdapter(getActivity(),teacherList);
                        gv_teacher.setAdapter(musicParkTeacherAdapter);
                        gv_teacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Bundle bundle = new Bundle();
                                bundle.putString("data", new Gson().toJson(teacherList.get(position)));
                                bundle.putInt("id", Integer.parseInt(teacherList.get(position).getMember_id()));
                                replaceFragment(new MusicParkTeacherDetails(), bundle);
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
            public void onFailure(Call<TeacherAll> call, Throwable t) {

            }
        });

    }
}
