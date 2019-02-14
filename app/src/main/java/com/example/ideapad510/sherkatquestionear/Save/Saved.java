package com.example.ideapad510.sherkatquestionear.Save;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.R;


public class Saved extends Activity{
    ListView listView;
    SaveController saveController = new SaveController(this);
    String TAG = "REsult";
    Params params = Params.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);

//        String user = getIntent().getStringExtra("user");
        String user = params.getUsername();
        String pasokhgoo = params.getPasokhgoo();
//        Log.d(TAG, "onCreate: user is "+user);

        listView = findViewById(R.id.resultList);
        SaveListAdapter saveListAdapter = new SaveListAdapter(this, saveController.getAllSaves(user, pasokhgoo));
        listView.setAdapter(saveListAdapter);
    }


}
