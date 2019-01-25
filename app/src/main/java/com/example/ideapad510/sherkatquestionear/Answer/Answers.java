package com.example.ideapad510.sherkatquestionear.Answer;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class Answers extends AppCompatActivity{
    private TextView questionTitle;
    private ListView answersList;
    private ArrayList<String> answers = new ArrayList<>();
    private Database db = new Database(this);
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
        questionTitle.setText((db.getRowQuestion(questionId)).getQuestion());
    }

    private void sampleAnswers(){
        db.insertRowAnswer("1", "2","3","4");
        db.insertRowAnswer("2", "28","3","4");
        db.insertRowAnswer("3", "26","3","4");
        db.insertRowAnswer("4", "27","3","4");
        db.insertRowAnswer("5", "26","3","4");
        db.insertRowAnswer("6", "29","3","4");
        db.insertRowAnswer("7", "24","3","4");
        db.insertRowAnswer("8", "26","3","4");
        db.insertRowAnswer("9", "29","3","4");
    }

    private void findingAnswers(){
//        answers = db.getIdAnswers(questionId);
        for(int i = 1; i <= db.getRowsCountAnswer(); i++)
            if((db.getRowAnswer(i).getQuestionID()).equals(String.valueOf(questionId)))
                answers.add(db.getRowAnswer(i).getAnswer());
    }
}
