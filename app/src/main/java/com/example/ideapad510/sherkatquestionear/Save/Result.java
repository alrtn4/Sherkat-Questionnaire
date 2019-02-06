package com.example.ideapad510.sherkatquestionear.Save;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.ideapad510.sherkatquestionear.Questions.Question;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class Result extends Activity{
    ListView listView;
    SaveController saveController = new SaveController(this);
    String TAG = "REsult";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);
/*
        Log.d(TAG, "is empty "+ (saveController.getAllSaves() == null));
        ArrayList<SaveObject> saveObjectArrayList = new ArrayList<>();
        SaveObject saveObject = new SaveObject("1", "2", "3", "4");
        saveObjectArrayList.add(saveObject);
        saveObject = new SaveObject("1", "2", "3", "4");
        saveObjectArrayList.add(saveObject);
        saveObject = new SaveObject("1", "2", "3", "4");
        saveObjectArrayList.add(saveObject);
*/
        String user = getIntent().getStringExtra("user");

        listView = findViewById(R.id.resultList);
        SaveListAdapter saveListAdapter = new SaveListAdapter(this, saveController.getAllSaves(user));
//        SaveListAdapter saveListAdapter = new SaveListAdapter(this, saveObjectArrayList);
        listView.setAdapter(saveListAdapter);
    }


}
