package com.example.ideapad510.sherkatquestionear.Answer;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Database;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class Answers extends AppCompatActivity{
    TextView questionTitle;
    ListView answersList;
    String[] questionArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider" };
    String[][] answers = {{"1","2","3"},{"1","4"},{"5"},{"hi","bye"},{"apple","orange"},{"cut","but","hello"}};
    ArrayList<String> answers2 = new ArrayList<>();
    Database db = new Database(this);

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.answers);

//        db.insertRowAnswer2("1", "2","3","4");
//        db.insertRowAnswer2("1", "2+6","3","4");
        db.insertRowAnswer2("1", "2+9","3","4");

        questionTitle = findViewById(R.id.questionTitle);
        answersList = findViewById(R.id.answersList);
        int questionId = getIntent().getIntExtra("position",1);
//        AnswerListAdapter adapter = new AnswerListAdapter(this,answers,questionId);
        System.out.println("question id is :"+questionId);
        answers2 = db.getIdAnswers(questionId);
/*        for(int i = 1; i <= db.getRowsCountAnswer2(); i++)
            if((db.getRowAnswer2(i).getQuestionID()).equals(String.valueOf(questionId)))
                answers2.add(db.getRowAnswer2(i).getAnswer());
        db.getRowsCountAnswer2();
//        db.getRowsCountLogin2();
*/
        AnswerListAdapter2 adapter = new AnswerListAdapter2(this,answers2,questionId);
        answersList.setAdapter(adapter);
        questionTitle.setText(db.getRowQuestion(questionId).getQuestion());
    }
}
