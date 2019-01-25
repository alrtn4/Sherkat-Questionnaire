package com.example.ideapad510.sherkatquestionear.Question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ideapad510.sherkatquestionear.Answer.Answers;
import com.example.ideapad510.sherkatquestionear.Database;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Questions extends AppCompatActivity {
    String[] questionArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider" };
    ListView listView;
    public static ArrayList<String> partedQuestions  = new ArrayList<>();
    Database db = new Database(this);
    int part=1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.questions);



        db.insertRowQuestion("1+1?","0","1");
        db.insertRowQuestion("2+3","0","1");
        db.insertRowQuestion("3+4","0","1");
        partedQuestions = db.getPartedQuestions(part);
//        partedQuestions.add("2+3");
//        partedQuestions.add("1+2");
//        partedQuestions.add("1+1");
//        partedQuestions.add("1+2");

        db.getRowsCountQuestion();


        QuestionListAdapter listAdapter = new QuestionListAdapter(this, partedQuestions);
        listView = findViewById(R.id.questionListViewID);
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
