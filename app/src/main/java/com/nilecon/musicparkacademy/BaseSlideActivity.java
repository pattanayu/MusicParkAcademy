package com.nilecon.musicparkacademy;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.nilecon.musicparkacademy.fragment.MenuFragment;

public abstract class BaseSlideActivity extends SlidingFragmentActivity {

    private long backPressed =1;
    protected Fragment mContent = null;

    protected abstract void setActionBar();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the Behind View
        setBehindContentView(R.layout.menu_frame);

        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
        sm.setMode(SlidingMenu.LEFT);
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        setBehindContentView(R.layout.menu_frame);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.menu_frame, new MenuFragment()).commit();
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

//		getActionBar().setDisplayHomeAsUpEnabled(true);
//		getActionBar().setDisplayShowTitleEnabled(false);
        setActionBar();
    }


    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }
//        if (Indicator.isDetail && mContent.getChildFragmentManager().getBackStackEntryCount() > 0) {
//                mContent.getChildFragmentManager().popBackStack();
//        }else{
//            if (backPressed + 2000 > System.currentTimeMillis()) {
//                finish();
//            } else {
//                Toast.makeText(getBaseContext(), getResources().getString(R.string.back_again), Toast.LENGTH_SHORT).show();
//            }
//            backPressed = System.currentTimeMillis();
//        }
    }

    public  void switchContent(Fragment fragment,Bundle bundle) {
        fragment.setArguments(bundle);
        MainActivity.isDetail = false;
        mContent = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.tab_content_main, mContent).commit();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getSlidingMenu().showContent();
            }
        }, 500);
    }
}
