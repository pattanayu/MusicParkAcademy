package com.nilecon.musicparkacademy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nilecon.musicparkacademy.Model.Login;
import com.nilecon.musicparkacademy.Model.Register;
import com.nilecon.musicparkacademy.Model.RestManager;
import com.nilecon.musicparkacademy.Model.SearchService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends Activity {
    private AlertDialog alertDialog;
    private EditText email, username, password, firstname, lastname, nickname, phone;
    private String st_email, st_username, st_password, st_firstname, st_lastname, st_nickname, st_phone;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicpark_register);
        email = (EditText) findViewById(R.id.regis_email);
        username = (EditText) findViewById(R.id.regis_username);
        password = (EditText) findViewById(R.id.regis_password);
        firstname = (EditText) findViewById(R.id.regis_firstname);
        lastname = (EditText) findViewById(R.id.regis_lastname);
        nickname = (EditText) findViewById(R.id.regis_nickname);
        phone = (EditText) findViewById(R.id.regis_phone);
        button = (Button) findViewById(R.id.bt_signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st_email = email.getText().toString();
                st_username = username.getText().toString();
                st_password = password.getText().toString();
                st_firstname = firstname.getText().toString();
                st_lastname = lastname.getText().toString();
                st_password = lastname.getText().toString();
                st_nickname = nickname.getText().toString();
                st_phone = phone.getText().toString();
                apiService();

            }
        });

    }

    private void apiService() {

        final SearchService mManager = RestManager.getBuilder(this).create(SearchService.class);
        final Call<Register> listCall = mManager.sendRegister("JEJEJEJEJEJEJE","ได้เถอะ","JE","J","0","0","0","0","0","0","0");
        listCall.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                        if(response.body().isIsSuccess()){
                            Intent myIntent = new Intent(getApplication(), LoginActivity.class);
                            startActivity(myIntent);
                        }

                        else if(!response.body().isIsSuccess()){
                            alertDialog = new AlertDialog.Builder(RegisterActivity.this).create();
                            alertDialog.setMessage("บอกว่าเรียกไม่ได้ไง!");
                            alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alertDialog.show();
                        }
                    }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {

            }
        });



    }
}
