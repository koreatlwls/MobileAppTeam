package com.example.gonggong;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<>() ;

    public ListViewAdapter(){

    }
    @Override
    public int getCount() {
       return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.listViewImg) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.listViewName) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.listViewAddress) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getName());
        descTextView.setText(listViewItem.getAddress());

        return convertView;
    }
    public void addItem(Drawable icon, String title, String desc,Double latitude,Double longitude,int code) {
        ListViewItem item = new ListViewItem();
        item.setIcon(icon);
        item.setName(title);
        item.setAddress(desc);
        item.setLatitude(latitude);
        item.setLongitude(longitude);
        item.setCode(code);
        listViewItemList.add(item);
    }
}
