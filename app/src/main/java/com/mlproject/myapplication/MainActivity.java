package com.mlproject.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    public static final String NAME = "com.mlproject.myapplication.NAME";
    public static final String LINK = "com.mlproject.myapplication.LINK";
    private ArrayList<YouTubeItem> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YouTubeItem item1 = new YouTubeItem("Elephant", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4");
        YouTubeItem item2 = new YouTubeItem("Blazes", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4");
        YouTubeItem item3 = new YouTubeItem("Escapes", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4");
        values.add(item1);
        values.add(item2);
        values.add(item3);
        // String[] names = getNames(values);
        BetterPerformanceAdapter adapter = new BetterPerformanceAdapter(this, values);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //String item = (String) getListAdapter().getItem(position);
        YouTubeItem video = values.get(position);
        Toast.makeText(this, video.getName() + " selected", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DetailedActivity.class);
        intent.putExtra(NAME, video.getName());
        intent.putExtra(LINK, video.getLink());
        startActivity(intent);
    }
}
