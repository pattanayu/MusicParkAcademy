package com.nilecon.musicparkacademy.abstracts;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.nilecon.musicparkacademy.MainActivity;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.utils.Fonts;
import com.nostra13.universalimageloader.core.ImageLoader;

public abstract class AbstractFragment extends Fragment implements View.OnClickListener {

    protected AQuery aq;
    protected Context context;
    protected Activity activity;
    protected LayoutInflater inflater;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    public static final int TYPE_BACK = 0;
    public static final int TYPE_MENU = 1;
    public static final int TYPE_BLANK = 2;
    private int menuType;
    ProgressDialog progressDialog ;

    protected abstract int setContentView();

    protected abstract int bindActionbar(ImageView menuLeft, ImageView menuRight);

    protected abstract void initView(View v);

    protected abstract void setupUI();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(setContentView(), container, false);
        setHasOptionsMenu(true);
        this.inflater = inflater;
        aq = new AQuery(v);
        activity = getActivity();
        initActionbar();
		new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
        setProgressDialog();
        initView(v);
        setupUI();
        return v;
    }

    private void initActionbar() {
        ImageView menuLeft = (ImageView) getActivity().getActionBar().getCustomView().findViewById(R.id.navbar_button_left);
        ImageView menuRight = (ImageView) getActivity().getActionBar().getCustomView().findViewById(R.id.navbar_button_right);
        menuRight.setVisibility(View.INVISIBLE);
        menuType = bindActionbar(menuLeft, menuRight);
        menuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menuType== TYPE_MENU){
                    ((MainActivity) getActivity()).toggle();
                }
                else if(menuType==TYPE_BACK){
                    getActivity().onBackPressed();
                }
            }
        });
        if (menuType == TYPE_BACK) {
            menuLeft.setVisibility(View.VISIBLE);
            menuLeft.setImageResource(R.drawable.img_navbar_icon_back);
        } else if (menuType == TYPE_MENU) {
            menuLeft.setVisibility(View.VISIBLE);
            menuLeft.setImageResource(R.drawable.img_navbar_icon_menu);
        } else {
            menuLeft.setVisibility(View.INVISIBLE);
        }


    }

    public void replaceFragment(final Fragment fragment, Bundle bundle) {
        fragment.setArguments(bundle);
        MainActivity.isDetail = true;
        getFragmentManager().beginTransaction()
                .replace(R.id.tab_content_main, fragment).addToBackStack(null)
                .commit();

    }

    @Override
    public void onClick(View v) {
        switch (menuType) {
            case TYPE_BACK:
                getActivity().onBackPressed();
                break;
            case TYPE_MENU:
                ((MainActivity) getActivity()).toggle();
                break;
        }
    }
    private void setProgressDialog() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
    }
}
