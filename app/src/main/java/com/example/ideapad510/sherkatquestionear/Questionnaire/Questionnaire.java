package com.example.ideapad510.sherkatquestionear.Questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerListAdapter;
import com.example.ideapad510.sherkatquestionear.Questions.Questions;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Questionnaire extends AppCompatActivity {
    private ListView listView;
    private static ArrayList<String> questionnaires  = new ArrayList<>();
    private QuestionnaireController qac= new QuestionnaireController(this);

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire);

        sampleQuestionnaires();
        questionnaires = qac.getQuestionnaires();

        listView = findViewById(R.id.questionnaireListView);
        AnswerListAdapter adapter = new AnswerListAdapter(this, questionnaires);
        listView.setAdapter(adapter);


        onClickListView();
    }

    private void onClickListView(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //because start of database and list are different
                position++;
                Intent intent = new Intent(Questionnaire.this,Questions.class);
                intent.putExtra("part1",qac.getQuestionnaire(position).getPart1());
                intent.putExtra("part2",qac.getQuestionnaire(position).getPart2());
                intent.putExtra("part3",qac.getQuestionnaire(position).getPart3());
                intent.putExtra("part4",qac.getQuestionnaire(position).getPart4());
                startActivity(intent);
            }
        });
    }

    private void sampleQuestionnaires(){
        qac.insertToDatabase("test1","about weather","Y", "Y" , "N", "R");
        qac.insertToDatabase("test2","about geography","Y", "N", "R", "R");
        qac.insertToDatabase("test3","about health","Y", "N", "N", "N");
    }
}
