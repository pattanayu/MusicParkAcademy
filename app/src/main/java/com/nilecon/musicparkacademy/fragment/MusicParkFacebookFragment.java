package com.nilecon.musicparkacademy.fragment;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;

/**
 * Created by Maximus on 20/4/2559.
 */
public class MusicParkFacebookFragment extends AbstractFragment {
    private WebView mwebviewFacebook;
    @Override
    protected int setContentView() {
        return R.layout.setting_webview_layout;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return TYPE_MENU;
    }

    @Override
    protected void initView(View v) {
        mwebviewFacebook = (WebView)v.findViewById(R.id.setting_webview);

    }

    @Override
    protected void setupUI() {
        String url = "https://www.facebook.com/Musicpark?fref=ts";
        WebSettings webSettings = mwebviewFacebook.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        mwebviewFacebook.setWebViewClient(new WebViewClient());
        mwebviewFacebook.setWebChromeClient(new WebChromeClient());
        mwebviewFacebook.loadUrl(url);
    }
}
