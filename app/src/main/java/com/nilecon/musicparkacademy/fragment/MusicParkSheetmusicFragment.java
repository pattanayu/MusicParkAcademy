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

import com.nilecon.musicparkacademy.Model.Books;
import com.nilecon.musicparkacademy.Model.CourseAll;
import com.nilecon.musicparkacademy.Model.RestManager;
import com.nilecon.musicparkacademy.Model.SearchService;
import com.nilecon.musicparkacademy.Model.Sheets;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.MusicParkCourseList;
import com.nilecon.musicparkacademy.adapter.MusicParkSheetsAdapter;
import com.nilecon.musicparkacademy.adapter.MusicParkStudentBookAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Maximus on 13/6/2559.
 */
public class MusicParkSheetmusicFragment extends AbstractFragment {
    private GridView gv_sheet;
    private MusicParkSheetsAdapter musicParkSheetsAdapter;
    private List<Sheets.SheetBean> sheetBeanList;
    private EditText et_search;
    private Button bt_search;
    private String string;
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
        gv_sheet = (GridView) v.findViewById(R.id.gv_studentbook);
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
        final Call<Sheets> courseCall = mManager.getSheets();
        courseCall.enqueue(new Callback<Sheets>() {
            @Override
            public void onResponse(Call<Sheets> call, Response<Sheets> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
//                        Log.e(TAG, "Response from url: " + courseList.toString());
                        sheetBeanList = new ArrayList<>();
                        sheetBeanList.addAll(response.body().getSheet());
                        musicParkSheetsAdapter = new MusicParkSheetsAdapter(getActivity(),sheetBeanList);
                        gv_sheet.setAdapter(musicParkSheetsAdapter);
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
            public void onFailure(Call<Sheets> call, Throwable t) {

            }
        });

    }

    private void apiSearchService() {
        final SearchService mManager = RestManager.getBuilder(getContext()).create(SearchService.class);
        final Call<Sheets> listCall = mManager.searchSheet(string);
        listCall.enqueue(new Callback<Sheets>() {
            @Override
            public void onResponse(Call<Sheets> call, Response<Sheets> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        sheetBeanList = new ArrayList<>();
                        sheetBeanList.addAll(response.body().getSheet());
                        musicParkSheetsAdapter = new MusicParkSheetsAdapter(getActivity(),sheetBeanList);
                        gv_sheet.setAdapter(musicParkSheetsAdapter);
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
            public void onFailure(Call<Sheets> call, Throwable t) {
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
