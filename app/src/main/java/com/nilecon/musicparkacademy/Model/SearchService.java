package com.nilecon.musicparkacademy.Model;

import junit.framework.Test;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by nilecon on 6/21/16 AD.
 */
public interface SearchService {


//    @FormUrlEncoded
//    @POST("login.php")
//    Call<Login> postLogin(@Field("username") String username,
//                          @Field("password") String password);

    @FormUrlEncoded
    @POST("login2.php")
    Call<Login> login(@Field("username") String username,
                       @Field("password") String password);


    @FormUrlEncoded
    @POST("courseall.php")
    Call<CourseAll> getAllCourse(@Field("course_id") int course_id);

    @FormUrlEncoded
    @POST("insertuser.php")
    Call<Register> sendRegister(@Field("member_id") String member_id, @Field("username") String username,
                                @Field("password") String password, @Field("first_name") String first_name,
                                @Field("last_name") String last_name, @Field("nick_name") String nick_name,
                                @Field("gender") String gender, @Field("phone_number") String phone_number,
                                @Field("email") String email,
                                @Field("pic_path") String pic_path, @Field("status") String status);


    @FormUrlEncoded
    @POST("courseall.php")
    Call<CourseAll> getCourseType(@Field("course_type") int course_type);

    @FormUrlEncoded
    @POST("book.php")
    Call<Books> searchBook(@Field("book_name") String book_name);


    @POST("book.php")
    Call<Books> getBooks();


    @POST("sheetid.php")
    Call<Sheets> getSheets();

    @FormUrlEncoded
    @POST("sheetid.php")
    Call<Sheets> searchSheet(@Field("sheet_name") String sheet_name);

    @FormUrlEncoded
    @POST("teachercourse.php")
    Call<Teacher> getTeacher(@Field("member_id") int member_id);


    @POST("teachercourse.php")
    Call<TeacherAll> getTeacherAll();


}
