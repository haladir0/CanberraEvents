package com.example.listviewactionbarmenuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<CanberraEvent> events = new ArrayList<CanberraEvent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //creating instances of the CanberraEventClass for this .java file / class
        events.add(new CanberraEvent("Racing Carnival Canberra",R.drawable.racing_canberra, "13-14March2022"));
        events.add(new CanberraEvent("Enligthen Festival",R.drawable.enlighten_festival,"26 Feb 2022 - 14 Mar 2022"));
        events.add(new CanberraEvent("Canberra Balloon Spectacular ", R.drawable.balloon_canberra, "12 Mar 2022 - 20 Mar 2022"));
        events.add(new CanberraEvent("Sunset Cinema Canberra", R.drawable.sunset_canberra, "25 Nov 2021 - 26 Feb 2022"));

       // ArrayAdapter<CanberraEvent> adapter = new ArrayAdapter<CanberraEvent>(this, android.R.layout.simple_list_item_1, events);

        ArrayAdapter<CanberraEvent> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, events) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                CanberraEvent cbrevent = events.get(position);
                text1.setText(cbrevent.getTitle());
                text2.setText(cbrevent.getDates());
                return view;
            }
        };

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //handle click event when the user clicks on an item on the list view.
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        CanberraEvent cbrevent = events.get(position);
                        Intent intent = new Intent(view.getContext(), activity_event.class);
                        intent.putExtra("title", cbrevent.getTitle());
                        intent.putExtra("imageResource", cbrevent.getImageResource());
                        intent.putExtra("dates", cbrevent.getDates());
                        startActivity(intent);
                    }
                });
    }
}