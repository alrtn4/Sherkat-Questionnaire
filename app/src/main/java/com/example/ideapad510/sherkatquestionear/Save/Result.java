package com.example.ideapad510.sherkatquestionear.Save;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ideapad510.sherkatquestionear.R;


public class Result extends Activity{
    ListView listView;
    SaveController saveController = new SaveController(this);
    String TAG = "REsult";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);

        String user = getIntent().getStringExtra("user");

        listView = findViewById(R.id.resultList);
        SaveListAdapter saveListAdapter = new SaveListAdapter(this, saveController.getAllSaves(user));
        listView.setAdapter(saveListAdapter);
    }


}
