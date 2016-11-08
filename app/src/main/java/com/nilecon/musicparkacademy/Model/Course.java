package com.nilecon.musicparkacademy.Model;

import java.util.List;

/**
 * Created by Maximus on 3/11/2559.
 */
public class Course {
    /**
     * course_id : 1
     * course_type : 1
     * create_date : 2016-11-05
     * course_name : testหกหกห
     * course_price : 300
     * course_room : 11
     * pic_pathc :
     * course_description : des
     * course_start_date : 0000-00-00
     * course_end_date : 0000-00-00
     * day0 : 1
     * day1 : 0
     * day2 : 0
     * day3 : 1
     * day4 : 0
     * day5 : 0
     * day6 : 0
     */

    private List<CourseBean> course;

    public List<CourseBean> getCourse() {
        return course;
    }

    public void setCourse(List<CourseBean> course) {
        this.course = course;
    }

    public static class CourseBean {
        private String course_id;
        private String course_type;
        private String create_date;
        private String course_name;
        private String course_price;
        private String course_room;
        private String pic_pathc;
        private String course_description;
        private String course_start_date;
        private String course_end_date;
        private String day0;
        private String day1;
        private String day2;
        private String day3;
        private String day4;
        private String day5;
        private String day6;

        public String getCourse_id() {
            return course_id;
        }

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public String getCourse_type() {
            return course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getCourse_price() {
            return course_price;
        }

        public void setCourse_price(String course_price) {
            this.course_price = course_price;
        }

        public String getCourse_room() {
            return course_room;
        }

        public void setCourse_room(String course_room) {
            this.course_room = course_room;
        }

        public String getPic_pathc() {
            return pic_pathc;
        }

        public void setPic_pathc(String pic_pathc) {
            this.pic_pathc = pic_pathc;
        }

        public String getCourse_description() {
            return course_description;
        }

        public void setCourse_description(String course_description) {
            this.course_description = course_description;
        }

        public String getCourse_start_date() {
            return course_start_date;
        }

        public void setCourse_start_date(String course_start_date) {
            this.course_start_date = course_start_date;
        }

        public String getCourse_end_date() {
            return course_end_date;
        }

        public void setCourse_end_date(String course_end_date) {
            this.course_end_date = course_end_date;
        }

        public String getDay0() {
            return day0;
        }

        public void setDay0(String day0) {
            this.day0 = day0;
        }

        public String getDay1() {
            return day1;
        }

        public void setDay1(String day1) {
            this.day1 = day1;
        }

        public String getDay2() {
            return day2;
        }

        public void setDay2(String day2) {
            this.day2 = day2;
        }

        public String getDay3() {
            return day3;
        }

        public void setDay3(String day3) {
            this.day3 = day3;
        }

        public String getDay4() {
            return day4;
        }

        public void setDay4(String day4) {
            this.day4 = day4;
        }

        public String getDay5() {
            return day5;
        }

        public void setDay5(String day5) {
            this.day5 = day5;
        }

        public String getDay6() {
            return day6;
        }

        public void setDay6(String day6) {
            this.day6 = day6;
        }
    }
}
