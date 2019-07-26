package com.mlproject.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BetterPerformanceAdapter extends ArrayAdapter<YouTubeItem>{
        private final Activity context;
        private final  ArrayList<YouTubeItem> videos;
        //private final String[] names;

        static class ViewHolder {
            public TextView text;
            public ImageView image;
            public YouTubeItem item;
        }

        public BetterPerformanceAdapter(Activity context, ArrayList<YouTubeItem> items) {
            super(context, R.layout.rowlayout, items);
            this.context = context;
            //this.names = names;
            this.videos = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;
            // reuse views
            if (rowView == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                rowView = inflater.inflate(R.layout.rowlayout, null);
                // configure view holder
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.text = (TextView) rowView.findViewById(R.id.label);
                viewHolder.image = (ImageView) rowView
                        .findViewById(R.id.icon);
                rowView.setTag(viewHolder);
            }

            // fill data
            ViewHolder holder = (ViewHolder) rowView.getTag();
            YouTubeItem item = videos.get(position);
            holder.text.setText(item.getName());

            if (item.getName().startsWith("Windows7") || item.getName().startsWith("iPhone")
                    || item.getName().startsWith("Solaris")) {
                holder.image.setImageResource(R.drawable.red);
            } else {
                holder.image.setImageResource(R.drawable.blue);
            }

            return rowView;
        }
    }

