package com.nilecon.musicparkacademy.Service;

import com.nilecon.musicparkacademy.Model.NewsListOject;
import com.nilecon.musicparkacademy.Model.PromotionListObject;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by saenza on 3/2/2559.
 */
public interface RetrofitService {

    @FormUrlEncoded
    @POST("PromotionList")
    Call<PromotionListObject> postPromotionList(@Field("PageNumber") int PageNumber);




    @FormUrlEncoded
    @POST("NewsList")
    Call<NewsListOject> postNewsList(@Field("PageNumber") int PageNumber);



//    @Multipart
//    @POST("Register")
//    Call<UserObject> postRegister(@Part("Email") RequestBody Email,
//                                  @Part("Password") RequestBody Password,
//                                  @Part("Name") RequestBody Name,
//                                  @Part("Tel") RequestBody Tel,
//                                  @Part("file\"; filename=\"profile.png") RequestBody Image);

}
