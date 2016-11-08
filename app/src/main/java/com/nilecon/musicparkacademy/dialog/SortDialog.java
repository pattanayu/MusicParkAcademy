package com.nilecon.musicparkacademy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.R;

/**
 * Created by NILECONTHAILAND on 14/9/2558.
 */
public class SortDialog extends Dialog implements OnClickListener {

    ImageView btnClose;

    public SortDialog(Context context) {
        super(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_dialog_sort);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        BindUI();
        Setup();
    }

    private void BindUI() {
        btnClose = (ImageView) findViewById(R.id.btnClose);
    }

    private void Setup() {
        btnClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnClose){
            dismiss();
        }
    }
}
