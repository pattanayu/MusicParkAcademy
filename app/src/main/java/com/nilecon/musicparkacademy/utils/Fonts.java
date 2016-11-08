package com.nilecon.musicparkacademy.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by SAMSUNG on 22-Jan-15.
 */
public class Fonts {


    Context context;

    public Fonts(Context context) {
        this.context = context;
    }

    public void SetTypeFaceAllTextView(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) instanceof TextView) {
                    setTypeface((TextView) viewGroup.getChildAt(i));
                } else if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                    SetTypeFaceAllTextView((ViewGroup) viewGroup.getChildAt(i));
                }
            }
        }
    }

    public void setTypeface(TextView textView) {
        if (textView != null) {
            if (textView.getTypeface() != null && textView.getTypeface().isBold()) {
                textView.setTypeface(getBoldFont());
            } else {
                textView.setTypeface(getNormalFont());
            }
        }
    }

    private Typeface getNormalFont() {
        Typeface normalFont = null;
        if (normalFont == null) {
            normalFont = Typeface.createFromAsset(context.getAssets(), "fonts/db_helvethaica_x_li.ttf");
        }
        return normalFont;
    }

    private Typeface getBoldFont() {
        Typeface boldFont = null;
        if (boldFont == null) {
            boldFont = Typeface.createFromAsset(context.getAssets(), "fonts/db_helvethaica_x_li.ttf");
        }
        return boldFont;
    }


}
