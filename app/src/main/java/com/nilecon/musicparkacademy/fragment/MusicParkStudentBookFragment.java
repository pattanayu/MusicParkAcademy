package com.nilecon.musicparkacademy.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.nilecon.musicparkacademy.Model.Books;
import com.nilecon.musicparkacademy.Model.CourseAll;
import com.nilecon.musicparkacademy.Model.RestManager;
import com.nilecon.musicparkacademy.Model.SearchBook;
import com.nilecon.musicparkacademy.Model.SearchService;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.MusicParkCourseList;
import com.nilecon.musicparkacademy.adapter.MusicParkStudentBookAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Maximus on 13/6/2559.
 */
public class MusicParkStudentBookFragment extends AbstractFragment {
    private GridView gv_books;
    private List<Books.BookBean> bookBeanList;
    private EditText et_search;
    private Button bt_search;
    private String string;
    private List<SearchBook.BookBean> bookBeen;
    private MusicParkStudentBookAdapter musicParkStudentBookAdapter;

    @Override
    protected int setContentView() {
        return R.layout.musicpark_studentbook_layout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_BACK;
    }

    @Override
    protected void initView(View v) {
        gv_books = (GridView) v.findViewById(R.id.gv_studentbook);
        et_search = (EditText)v.findViewById(R.id.edit_search);
        bt_search = (Button)v.findViewById(R.id.bt_search);

    }

    @Override
    protected void setupUI() {
        apiService();

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = et_search.getText().toString();
                apiSearchService();
            }
        });

    }



    private void apiService() {
        final SearchService mManager = RestManager.getBuilder(getContext()).create(SearchService.class);
        final Call<Books> courseCall = mManager.getBooks();
        courseCall.enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
//                        Log.e(TAG, "Response from url: " + courseList.toString());
                        bookBeanList = new ArrayList<>();
                        bookBeanList.addAll(response.body().getBook());
                        musicParkStudentBookAdapter = new MusicParkStudentBookAdapter(getActivity(), bookBeanList);
                        gv_books.setAdapter(musicParkStudentBookAdapter);
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
            public void onFailure(Call<Books> call, Throwable t) {

            }
        });

    }
    private void apiSearchService() {
        final SearchService mManager = RestManager.getBuilder(getContext()).create(SearchService.class);
        final Call<Books> listCall = mManager.searchBook(string);
        listCall.enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        bookBeanList = new ArrayList<>();
                        bookBeanList.addAll(response.body().getBook());
                        musicParkStudentBookAdapter = new MusicParkStudentBookAdapter(getActivity(), bookBeanList);
                        gv_books.setAdapter(musicParkStudentBookAdapter);
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
            public void onFailure(Call<Books> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Error Not Found");

                builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

    }
}
