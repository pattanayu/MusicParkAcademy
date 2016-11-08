package com.nilecon.musicparkacademy.Model;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.securepreferences.SecurePreferences;

/**
 * Created by saenza on 26/1/2559.
 */
public class SharedPrefs {
    protected final static String TAG = SharedPrefs.class.getSimpleName();

    private static SharedPrefs instance;

    private Context context;
    private SharedPreferences prefsUserdata;

    private SharedPrefs(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }

        prefsUserdata = new SecurePreferences(context, "rama", "userdata");
    }

    public static SharedPrefs getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefs(context);
        }
        return instance;
    }

    public void clearPrefs() {
        SharedPreferences.Editor editorUserdata = prefsUserdata.edit();
        editorUserdata.clear();
        editorUserdata.apply();
    }

//    StartUserdata --------------------------------//

    public void setId(int userId) {
        SharedPreferences.Editor editor = prefsUserdata.edit();
        editor.putInt("userId", userId);
        editor.apply();
    }

    public void setCostName(String costName) {

        SharedPreferences.Editor costNameEditor = prefsUserdata.edit();
        costNameEditor.putString("costname", costName);
        costNameEditor.apply();
    }

    public void setCostId(String costId) {

        SharedPreferences.Editor costNameEditor = prefsUserdata.edit();
        costNameEditor.putString("costId", costId);
        costNameEditor.apply();
    }

    public void setNotiCount(int notiCount) {
        SharedPreferences.Editor editor = prefsUserdata.edit();
        editor.putInt("notiCount", notiCount);
        editor.apply();
    }

    public void setNoti(boolean noti) {
        SharedPreferences.Editor editor = prefsUserdata.edit();
        editor.putBoolean("noti", noti);
        editor.apply();
    }


    public int getId() {
        return prefsUserdata.getInt("userId", 0);
    }

//    EndUserdata --------------------------------//

    public String getCostName() {
        return prefsUserdata.getString("costname", "A-คณะแพทยศาสตร์");
    }

    public String getCostId() {
        return prefsUserdata.getString("costId", "2์");
    }

    public int getNotiCount() {
        return prefsUserdata.getInt("notiCount", 0);
    }

    public boolean getNoti() {
        return prefsUserdata.getBoolean("noti", true);
    }


}
