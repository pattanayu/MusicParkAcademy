package com.nilecon.musicparkacademy.adapter;

import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends BaseAdapter{
	
	private List<View>views;
	 private SparseBooleanArray mSelectedItemsIds;

	public CustomListAdapter(){
		views = new ArrayList<View>();
		mSelectedItemsIds = new SparseBooleanArray();
	}

	@Override
	public int getCount() {
		return views.size();
		
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return views.get(position);
		
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		return views.get(position);
	}
	
	public void addView(View view){
		if(view != null)views.add(view);
	}
	
	public void removeView(View view){
		if(view != null)views.remove(view);
	}
	
	public void clear(){
		views.clear();
	}
	/// For multiSelection
	public SparseBooleanArray getSelectedIds() {
		return mSelectedItemsIds;
	}

	public void toggleSelection(int position) {
		selectView(position, !mSelectedItemsIds.get(position));
	}

	public void selectView(int position, boolean value) {
		if (value)
			mSelectedItemsIds.put(position, value);
		else
			mSelectedItemsIds.delete(position);
		notifyDataSetChanged();
	}

	public void removeSelection() {
		mSelectedItemsIds = new SparseBooleanArray();
		notifyDataSetChanged();
	}
}