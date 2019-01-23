package com.example.ideapad510.sherkatquestionear;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static android.media.CamcorderProfile.get;

public class Questions extends AppCompatActivity {
    String[] questionArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider" };
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.questions);

        QuestionListAdapter listAdapter = new QuestionListAdapter(this, questionArray);

        listView = (ListView) findViewById(R.id.questionListViewID);
        listView.setAdapter(listAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Questions.this,Answers.class);
                intent.putExtra("position",position);
                startActivity(intent);

            }
        });

    }
}
