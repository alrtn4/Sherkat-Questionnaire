package com.example.ideapad510.sherkatquestionear.Answer;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class Answers extends AppCompatActivity{
    private TextView questionTitle;
    private ListView answersList;
    private ArrayList<String> answers = new ArrayList<>();
    private AnswerControler ac = new AnswerControler(this);
    private int questionId;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answers);

//        sampleAnswers();

        answersList = findViewById(R.id.answersList);
        questionId = getIntent().getIntExtra("position",1);
        //because of difference between start in listview and database
        questionId++;

        findingAnswers();

        AnswerListAdapter adapter = new AnswerListAdapter(this, answers);
        answersList.setAdapter(adapter);

        questionTitle = findViewById(R.id.questionTitle);
        questionTitle.setText((ac.getRowQuestion(questionId)));
    }

    private void sampleAnswers(){
        ac.insertRow("1", "2","3","4");
        ac.insertRow("2", "28","3","4");
        ac.insertRow("3", "26","3","4");
        ac.insertRow("4", "27","3","4");
        ac.insertRow("5", "26","3","4");
        ac.insertRow("6", "29","3","4");
        ac.insertRow("7", "24","3","4");
        ac.insertRow("8", "26","3","4");
        ac.insertRow("9", "29","3","4");
    }

    private void findingAnswers(){
//        answers = db.getIdAnswers(questionId);
        for(int i = 1; i <= ac.getRowCount(); i++)
            if((ac.getRow(i).getQuestionID()).equals(String.valueOf(questionId)))
                answers.add(ac.getRow(i).getAnswer());
    }
}
