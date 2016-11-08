package com.nilecon.musicparkacademy.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import com.google.zxing.qrcode.encoder.QRCode;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.ScanCode;
import com.nilecon.musicparkacademy.abstracts.AbstractFragment;
import com.nilecon.musicparkacademy.adapter.CustomListAdapter;
import com.nilecon.musicparkacademy.utils.Fonts;
import com.nilecon.musicparkacademy.view.RoundedImageView;

/**
 * Created by tum on 28-Jan-15.
 */



public class MenuFragment extends AbstractFragment implements ListView.OnItemClickListener {
    private LinearLayout menuListProfileLl;
    private RoundedImageView imgProfileMenu;
    private TextView txtNameMenu;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        if (position==0){
            replaceFragment(new MusicParkListmenuFragment(),bundle);

        }
        else if(position==1){

        }
        else if(position==2){
            replaceFragment(new MusicParkTeacherFragment(),bundle);

        }
        else if(position==3){

        }
        else if(position==4){

        }
        else if(position==5){
            replaceFragment(new MusicParkClassroomFragment(),bundle);
//            ((Indicator)getActivity()).switchContent(new MusicParkClassroomFragment(),bundle);
        }
        else if(position==6){
            Intent intent = new Intent(getActivity(), ScanCode.class);
            startActivity(intent);
        }
        else if(position==7){
            AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                alertDialog.setTitle("Contact MusicPark Academy");
                alertDialog.setMessage("Do you want to call Music Park?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Call",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:+66985845570"));
                                startActivity(callIntent);
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
//
        }
        else if(position==8){
            replaceFragment(new MusicParkFacebookFragment(),bundle);
        }
        else if(position==9){
           replaceFragment(new MusicParkAboutFragment(),bundle);
        }
    }

    private TextView txtEmailMenu;
    private TextView txtPackageMenu;
    private ListView lvMenu;
    private CustomListAdapter adapter;



    @Override
    protected int setContentView() {
        return R.layout.menu_list;
    }

    @Override
    protected int bindActionbar(ImageView menuLeft, ImageView menuRight) {
        return this.TYPE_BLANK;
    }

    @Override
    protected void initView(View v) {
        menuListProfileLl = (LinearLayout) v.findViewById(R.id.menu_list_profile_ll);
        imgProfileMenu = (RoundedImageView) v.findViewById(R.id.img_profile_menu);
        txtNameMenu = (TextView) v.findViewById(R.id.txt_name_menu);
        txtEmailMenu = (TextView) v.findViewById(R.id.txt_email_menu);
//        txtPackageMenu = (TextView) v.findViewById(R.id.txt_package_menu);
        lvMenu = (ListView) v.findViewById(R.id.lv_menu);
    }

    @Override
    protected void setupUI() {
//        imageLoader.displayImage("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xpf1/v/t1.0-1/p48x48/10310117_234060270121536_9018550882750561436_n.png?oh=40166c52c8c35b0733b1ded46ff62c29&oe=55676FA0&__gda__=1431389195_43b9de6f5c96c511a1a316f4dbed7a40",imgProfileMenu);
        adapter = new CustomListAdapter();
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(this);
        setListItem();
    }
    private void setListItem(){
        TypedArray imgs = getResources().obtainTypedArray(R.array.menu_image);
        String[] txt = getResources().getStringArray(R.array.menu_text);
        for (int i = 0; i < txt.length; i++) {
            View view = inflater.inflate(R.layout.menu_list_item,null);
            new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) view);
            ImageView imageView = (ImageView) view.findViewById(R.id.menu_item_image);
            TextView textView = (TextView) view.findViewById(R.id.menu_item_text);
            imageView.setImageResource(imgs.getResourceId(i, -1));
            textView.setText(txt[i]);
            adapter.addView(view);
        }
        adapter.notifyDataSetChanged();

    }
}
