package com.nilecon.musicparkacademy.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;

import com.nilecon.musicparkacademy.R;

public class AppRater {
    // Preference Constants
    private final static String PREF_NAME = "apprater";
    private final static String PREF_LAUNCH_COUNT = "launch_count";
    private final static String PREF_FIRST_LAUNCHED = "date_firstlaunch";
    private final static String PREF_DONT_SHOW_AGAIN = "dontshowagain";
    private final static String PREF_REMIND_LATER = "remindmelater";
    private final static String PREF_APP_VERSION_NAME = "app_version_name";
    private final static String PREF_APP_VERSION_CODE = "app_version_code";

    private final static int DAYS_UNTIL_PROMPT = 3;
    private final static int LAUNCHES_UNTIL_PROMPT = 7;
    private static int DAYS_UNTIL_PROMPT_FOR_REMIND_LATER = 3;
    private static int LAUNCHES_UNTIL_PROMPT_FOR_REMIND_LATER = 7;
    private static boolean isDark;
    private static boolean themeSet;
    private static boolean hideNoButton;
    private static boolean isVersionNameCheckEnabled;
    private static boolean isVersionCodeCheckEnabled;
    private static boolean isCancelable = true;


    public static void showRateDialog(final Context context) {
        showRateAlertDialog(context, null);
    }

    private static void showRateAlertDialog(final Context context, final SharedPreferences.Editor editor) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= 11 && themeSet) {
            builder = new AlertDialog.Builder(context, (isDark ? AlertDialog.THEME_HOLO_DARK : AlertDialog.THEME_HOLO_LIGHT));
        } else {
            builder = new AlertDialog.Builder(context);
        }
        ApplicationRatingInfo ratingInfo = ApplicationRatingInfo.createApplicationInfo(context);
        builder.setTitle(String.format(context.getString(R.string.rate_app_title), ratingInfo.getApplicationName()));

        builder.setMessage(context.getString(R.string.rate_app_message));

        builder.setCancelable(isCancelable);

        builder.setPositiveButton(context.getString(R.string.dialog_app_rate),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        rateNow(context);
                        if (editor != null) {
                            editor.putBoolean(PREF_DONT_SHOW_AGAIN, true);
                            commitOrApply(editor);
                        }
                        dialog.dismiss();
                    }
                });

        builder.setNeutralButton(context.getString(R.string.dialog_ask_later),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (editor != null) {
                            Long date_firstLaunch = System.currentTimeMillis();
                            editor.putLong(PREF_FIRST_LAUNCHED, date_firstLaunch);
                            editor.putLong(PREF_LAUNCH_COUNT, 0);
                            editor.putBoolean(PREF_REMIND_LATER, true);
                            editor.putBoolean(PREF_DONT_SHOW_AGAIN, false);
                            commitOrApply(editor);
                        }
                        dialog.dismiss();
                    }
                });
        if (!hideNoButton) {
            builder.setNegativeButton(context.getString(R.string.dialog_no_thankyou),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (editor != null) {
                                editor.putBoolean(PREF_DONT_SHOW_AGAIN, true);
                                editor.putBoolean(PREF_REMIND_LATER, false);
                                long date_firstLaunch = System.currentTimeMillis();
                                editor.putLong(PREF_FIRST_LAUNCHED, date_firstLaunch);
                                editor.putLong(PREF_LAUNCH_COUNT, 0);
                                commitOrApply(editor);
                            }
                            dialog.dismiss();
                        }
                    });
        }
        builder.show();
    }

    private static void commitOrApply(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT > 8) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
    public static void rateNow(final Context context) {
        String packageName = context.getPackageName();
        String google = "http://play.google.com/store/apps/details?id=";
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(google+packageName)));
    }


}
