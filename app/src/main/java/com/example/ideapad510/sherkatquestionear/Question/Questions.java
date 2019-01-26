package com.example.ideapad510.sherkatquestionear.Question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ideapad510.sherkatquestionear.Answer.Answers;
import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Questions extends AppCompatActivity {
    private ListView listView;
    private static ArrayList<String> partedQuestions  = new ArrayList<>();
    private QuestionControler qc= new QuestionControler(this);
    private int part=1;
    private int previousPagesItemsCount =0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

//        sampleQuestions();
        partedQuestions = qc.getPartedQuestions(part);

        refreshScreen();
        onClickListView();
    }

    public void onBackClicked(View view){
        part--;
        partedQuestions = qc.getPartedQuestions(part);
        refreshScreen();
        previousPagesItemsCount -= partedQuestions.size();
    }

    public void onForwardClicked(View view){
        part++;
        partedQuestions = qc.getPartedQuestions(part);
        refreshScreen();
        previousPagesItemsCount += partedQuestions.size();
    }

    private void onClickListView(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(Questions.this,Answers.class);
                position += previousPagesItemsCount;
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }

    private void refreshScreen(){
        QuestionListAdapter listAdapter = new QuestionListAdapter(this, partedQuestions);
        listView = findViewById(R.id.questionListViewID);
        listView.setAdapter(listAdapter);

    }

    private void sampleQuestions(){
        qc.insertToDatabase("1+1?","0","1");
        qc.insertToDatabase("2+3?","0","1");
        qc.insertToDatabase("3+4?","0","1");
        qc.insertToDatabase("1+19?","0","2");
        qc.insertToDatabase("2+31?","0","2");
        qc.insertToDatabase("3+40?","0","2");
        qc.insertToDatabase("18+1?","0","3");
        qc.insertToDatabase("25+3?","0","3");
        qc.insertToDatabase("37+4?","0","3");

    }
}
