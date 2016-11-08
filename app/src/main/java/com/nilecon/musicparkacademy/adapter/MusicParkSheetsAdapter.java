package com.nilecon.musicparkacademy.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilecon.musicparkacademy.Model.Books;
import com.nilecon.musicparkacademy.Model.Sheets;
import com.nilecon.musicparkacademy.R;
import com.nilecon.musicparkacademy.utils.Fonts;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 5/11/2559.
 */
public class MusicParkSheetsAdapter extends BaseAdapter {
    private Activity activity;
    private int[] books;
    private List<Sheets.SheetBean> sheetList;

    public MusicParkSheetsAdapter(Activity activity, List<Sheets.SheetBean> sheetBeanList) {
        this.activity =activity;
        this.sheetList = sheetBeanList;
    }

    @Override
    public int getCount() {
        return sheetList.size();
    }

    @Override
    public Object getItem(int position) {
        return sheetList.size();
    }

    @Override
    public long getItemId(int position) {
    return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            LayoutInflater inflater = (activity).getLayoutInflater();
            convertView = inflater.inflate(R.layout.musicpark_studentbook_items, parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.book_name.setText(sheetList.get(position).getSheet_name());
        Picasso.with(holder.student_books.getContext())
                .load(sheetList.get(position).getSheet_path())
                .placeholder(R.drawable.img_book_one)
                .error(R.drawable.img_book_one)
                .into(holder.student_books);
//        holder.book_details.setText(booklist.get(position).getBook_detail());
        return convertView;
    }
    public class Holder{
        private ImageView student_books;
        private TextView book_name;
        private TextView book_details;
        public Holder(View v){
            new Fonts(activity).SetTypeFaceAllTextView((ViewGroup) v);
            student_books = (ImageView)v.findViewById(R.id.books_item);
            book_name = (TextView)v.findViewById(R.id.book_name);
            book_details = (TextView)v.findViewById(R.id.book_details);

        }
    }
}
