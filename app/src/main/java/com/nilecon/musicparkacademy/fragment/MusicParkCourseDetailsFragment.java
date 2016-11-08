package com.nilecon.musicparkacademy.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nilecon.musicparkacademy.Model.Course;
import com.nilecon.musicparkacademy.Model.CourseAll;
import com.nilecon.musicparkacademy.Model.CourseID;
import com.nilecon.musicparkacademy.Model.RestManager;
import com.nilecon.musicparkacademy.Model.SearchService;
import com.nilecon.musicparkacademy.Model.TeacherAll;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.MusicParkCourseDetailsAdapter;
import com.nilecon.musicparkacademy.adapter.MusicParkCourseList;
import com.nilecon.musicparkacademy.adapter.MusicParkCourseMenuAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Maximus on 1/6/2559.
 */
public class MusicParkCourseDetailsFragment extends AbstractFragment {
    private MusicParkCourseMenuAdapter musicParkCourseMenuAdapter;
    private MusicParkCourseDetailsAdapter musicParkCourseDetailsAdapter;
    private GridView gv_menu;
    private CourseAll.CourseBean courseList;
    private ListView lv_course;
    private TextView course_name,course_detail,course_time,course_date,course_room,course_price,course_teacher;
    private String TAG = MusicParkCourseDetailsFragment.class.getSimpleName();
    private int courseID;
    @Override
    protected int setContentView() {
        return R.layout.musicpark_course_details_layout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_BACK;
    }

    @Override
    protected void initView(View v) {
        gv_menu =  (GridView)v.findViewById(R.id.gv_menu_course);
//        lv_course = (ListView)v.findViewById(R.id.lv_course);
        course_name = (TextView)v.findViewById(R.id.course_name);
        course_detail = (TextView)v.findViewById(R.id.course_detail);
        course_time = (TextView)v.findViewById(R.id.course_time);
        course_date = (TextView)v.findViewById(R.id.course_date);
        course_room = (TextView)v.findViewById(R.id.course_room);
        course_price = (TextView)v.findViewById(R.id.course_price);
        course_teacher = (TextView)v.findViewById(R.id.course_teacher);


    }

    @Override
    protected void setupUI() {
            if (getArguments() != null) {
                courseID = getArguments().getInt("id");
            }
        if (getArguments() != null) {
            courseList = new Gson().fromJson(getArguments().getString("data"), CourseAll.CourseBean.class);
            course_name.setText(courseList.getCourse_name());
            course_detail.setText(courseList.getCourse_description());
            course_date.setText(courseList.getCourse_start_date()+ " - " +  courseList.getCourse_end_date());
            course_time.setText(courseList.getTime_start()+ " - " + courseList.getTime_end());
            course_room.setText(courseList.getCourse_room());
            course_price.setText(courseList.getCourse_price());
            course_teacher.setText(courseList.getFirst_name());
        }


        final int[] course_img = {R.drawable.musicpark_coursebooking_menu,R.drawable.musicpark_studenbook_menu,
                R.drawable.musicpark_sheetmusic_menu,R.drawable.musicpark_contactteacher_menu,R.drawable.musicpark_classroom_menu,
                R.drawable.musicpark_video_menu };
        final String[] course_title = getResources().getStringArray(R.array.course_title);
        final String[] course_details = getResources().getStringArray(R.array.course_details);
//        apiService();
//        musicParkCourseDetailsAdapter = new MusicParkCourseDetailsAdapter(getActivity(),course_title,course_details);
//        lv_course.setAdapter(musicParkCourseDetailsAdapter);
        musicParkCourseMenuAdapter = new MusicParkCourseMenuAdapter(getActivity(),course_img);
        gv_menu.setAdapter(musicParkCourseMenuAdapter);
        gv_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                if(position==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT);
                    dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    // layout to display
                    dialog.setContentView(R.layout.musicpark_dialog_booking);

                    // set color transpartent
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    dialog.show();
//                    getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
//                    getActivity().getWindow().getAttributes().gravity = Gravity.CENTER;
//                    getActivity().getWindow().setBackgroundDrawable(
//                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
//
//                    final View dialogview = activity.getLayoutInflater().inflate(
//                            R.layout.musicpark_dialog_booking, null);
//                    getActivity().setContentView(dialogview);
//                    getActivity().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
//                            ViewGroup.LayoutParams.MATCH_PARENT);
                }
                else if(position==2){
                    replaceFragment(new MusicParkSheetmusicFragment(),bundle);
                }
                else if(position==1){

                    replaceFragment(new MusicParkStudentBookFragment(),bundle);
                }
                else if(position==5){
                    replaceFragment(new MusicParkVideoFragment(),bundle);
                }
            }
        });

    }
//    private void apiService() {
//        final SearchService mManager = RestManager.getBuilder(getContext()).create(SearchService.class);
//        final Call<CourseAll> course = mManager.getAllCourse(3);
//        course.enqueue(new Callback<CourseAll>() {
//            @Override
//            public void onResponse(Call<CourseAll> call, Response<CourseAll> response) {
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        Log.e(TAG, "Response from url: " + courseList);
//                        courseList = new ArrayList<>();
//                        courseList.addAll(response.body().getCourse());
//                        musicParkCourseDetailsAdapter = new MusicParkCourseDetailsAdapter(getActivity(),courseList);
//                        lv_course.setAdapter(musicParkCourseDetailsAdapter);
//                    } else {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                        builder.setMessage("ไม่พบข้อมูล");
//
//                        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                        builder.show();
//                    }
//
//                } else {
//
//                }
//            }
//
//
//
//
//            @Override
//            public void onFailure(Call<CourseAll> call, Throwable t) {
//
//            }
//        });
//
//    }
}
