package com.example.ideapad510.sherkatquestionear;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class Answers extends AppCompatActivity{
    TextView qestionTitle;
    ListView answersList;
    String[] questionArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider" };
    String[][] answers = {{"1","2","3"},{"1","4"},{"5"},{"hi","bye"},{"apple","orange"},{"cut","but","hello"}};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.answers);

        qestionTitle = findViewById(R.id.questionTitle);
        answersList = findViewById(R.id.answersList);
        int questionId = getIntent().getIntExtra("position",1);
        AnswerListAdapter adapter = new AnswerListAdapter(this,answers,questionId);
        answersList.setAdapter(adapter);
        qestionTitle.setText(questionArray[questionId]);
    }
}
