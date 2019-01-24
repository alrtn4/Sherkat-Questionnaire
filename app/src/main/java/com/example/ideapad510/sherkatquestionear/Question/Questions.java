package com.example.ideapad510.sherkatquestionear.Question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ideapad510.sherkatquestionear.Answer.Answers;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Questions extends AppCompatActivity {
    String[] questionArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider" };
    ListView listView;
    public static ArrayList<String> partedQuestions  = new ArrayList<>();
    QuestionDatabase db = new QuestionDatabase(this);
    int part=1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.questions);

        partedQuestions.add("23");
        partedQuestions.add("12");


//        db.insertRow("1+1?","0","1");
//        db.insertRow("2+3","0","2");
//        db.insertRow("3+4","0","3");
//        partedQuestions = db.getPartedQuestions(part);


        QuestionListAdapter listAdapter = new QuestionListAdapter(this, partedQuestions);
        listView = (ListView) findViewById(R.id.questionListViewID);
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Questions.this,Answers.class);
                intent.putExtra("position",position);
                startActivity(intent);
                finish();
            }
        });

    }

    public void onBackClicked(View view){
        part--;
        partedQuestions = db.getPartedQuestions(part);
    }
}
