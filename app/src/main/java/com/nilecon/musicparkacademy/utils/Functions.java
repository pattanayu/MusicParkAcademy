package com.nilecon.musicparkacademy.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by tum on 12-Feb-15.
 */
public class Functions {

  public static ProgressDialog getProgressDialog(Context context){
      ProgressDialog progressDialog = new ProgressDialog(context);
      progressDialog.setMessage("Now Loading...");
      progressDialog.setCancelable(false);
      return progressDialog;
  }
}
