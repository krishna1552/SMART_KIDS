package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ReadingActivity extends AppCompatActivity {

    ListView listView;
    String[] tstory , dstory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        tstory = getResources().getStringArray(R.array.title_story);
        dstory = getResources().getStringArray(R.array.detailed_story);


        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tstory);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = dstory[position];
                Intent intent = new Intent(ReadingActivity.this, ReadingActivity2.class);
                intent.putExtra("story", t);
                startActivity(intent);
            }
        });


    }
}