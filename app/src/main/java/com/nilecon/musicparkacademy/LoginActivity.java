package com.nilecon.musicparkacademy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nilecon.musicparkacademy.Model.Login;
import com.nilecon.musicparkacademy.Model.Login1;
import com.nilecon.musicparkacademy.Model.RestManager;
import com.nilecon.musicparkacademy.Model.SearchService;
import com.nilecon.musicparkacademy.utils.ChecksupportPlayservice;
import com.nilecon.musicparkacademy.utils.Fonts;
import com.nilecon.musicparkacademy.utils.RegistrationIntentService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
    private Button signin_bt;
    private EditText username;
    private EditText password;
    private TextView forgot;
    private TextView donothave;
    private TextView signup;
    private String udid;
    private AlertDialog alertDialog;
    private String token;
    private List login;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicpark_activity_login);
        signin_bt = (Button) findViewById(R.id.musicpark_signin_button);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        forgot = (TextView) findViewById(R.id.forgot);
        donothave = (TextView) findViewById(R.id.dont);
        signup = (TextView) findViewById(R.id.signup);
//        signup_bt.setOnClickListener(this);
//        signup.setOnClickListener(this);
        Fonts fonts = new Fonts(getApplicationContext());
        fonts.setTypeface(signin_bt);
        fonts.setTypeface(username);
        fonts.setTypeface(password);
        fonts.setTypeface(forgot);
        fonts.setTypeface(donothave);
        fonts.setTypeface(signup);
        udid = android.provider.Settings.System.getString(super.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        if (ChecksupportPlayservice.checkPlayServices(this)) {
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
            token = RegistrationIntentService.token;
            startService(intent);

        }

//        passreset.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), PasswordReset.class);
//                startActivityForResult(myIntent, 0);
//                finish();
//            }});

        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RegisterActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        signin_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
//                startActivityForResult(myIntent, 0);
//                finish();
                apiService();
            }
        });

    }


    private void apiService() {
        final SearchService mManager = RestManager.getBuilder(this).create(SearchService.class);
        final Call<Login> loginCall = mManager.login(username.getText().toString(), password.getText().toString());
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()) {

                    if (response.body().isIsSuccess()) {
                        alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
                        alertDialog.setMessage("Login Success");
                        Intent myIntent = new Intent(getApplication(), MainActivity.class);
                        myIntent.putExtra("memID", response.body().getMember_id());
                        startActivity(myIntent);
                    } else if (!response.body().isIsSuccess()) {
                        alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
                        alertDialog.setMessage("Login Fail Please try again later");
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alertDialog.show();
                    }
                }
            }


            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Log.e("API", t.toString());
//                progressDialog.dismiss();
//                alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
//                alertDialog.setTitle("Error!");
//                alertDialog.setMessage("Error Not Found!");
//                alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                alertDialog.show();
            }
        });

    }


}
