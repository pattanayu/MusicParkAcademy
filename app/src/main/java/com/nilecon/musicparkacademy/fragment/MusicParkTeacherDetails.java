package com.nilecon.musicparkacademy.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nilecon.musicparkacademy.Model.CourseAll;
import com.nilecon.musicparkacademy.Model.TeacherAll;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;

import java.util.List;

/**
 * Created by Maximus on 24/5/2559.
 */
public class MusicParkTeacherDetails extends AbstractFragment {
    private TextView name,details,firstname,lastname,nickname,subject,email;
    private ImageView profile_pic,call_mobile,facebook;
    private int teacher_id;
    private TeacherAll.TeacherBean teacherBean;
    @Override
    protected int setContentView() {
        return R.layout.musicpark_teacher_details_layout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_BACK;
    }

    @Override
    protected void initView(View v) {
        name = (TextView)v.findViewById(R.id.member_name);
        details = (TextView)v.findViewById(R.id.member_details);
        firstname = (TextView)v.findViewById(R.id.firstname);
        lastname = (TextView)v.findViewById(R.id.lastname);
        nickname = (TextView)v.findViewById(R.id.nickname);
        subject = (TextView)v.findViewById(R.id.subject);
        email = (TextView)v.findViewById(R.id.email);
        profile_pic =(ImageView)v.findViewById(R.id.profile_pic);
        call_mobile = (ImageView)v.findViewById(R.id.call_mobile);
        facebook = (ImageView)v.findViewById(R.id.facebook_bt);

    }

    @Override
    protected void setupUI() {
        if (getArguments() != null) {
            teacher_id = getArguments().getInt("id");
            teacherBean = new Gson().fromJson(getArguments().getString("data"), TeacherAll.TeacherBean.class);
            name.setText(teacherBean.getFirst_name());
            details.setText(teacherBean.getStatus_detail());
            firstname.setText(teacherBean.getFirst_name());
            lastname.setText(teacherBean.getLast_name());
            nickname.setText(teacherBean.getNick_name());
            subject.setText(teacherBean.getCourse_type());
            email.setText(teacherBean.getEmail());


        }
    }
}
