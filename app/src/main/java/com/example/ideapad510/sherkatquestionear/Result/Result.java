package com.example.ideapad510.sherkatquestionear.Result;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.R;


public class Result extends Activity{
    ListView listView;
    ResultController saveController = new ResultController(this);
    String TAG = "REsult";
    Params params = Params.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

       String user = params.getUsername();
        String pasokhgoo = params.getPasokhgoo();

        listView = findViewById(R.id.resultList);
        ResultListAdapter saveListAdapter = new ResultListAdapter(this, saveController.getAllResults(user, pasokhgoo));
        listView.setAdapter(saveListAdapter);

    }


}
