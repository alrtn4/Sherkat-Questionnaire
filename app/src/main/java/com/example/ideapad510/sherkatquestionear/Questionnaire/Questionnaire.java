package com.example.ideapad510.sherkatquestionear.Questionnaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ideapad510.sherkatquestionear.Questions.Question;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static android.media.CamcorderProfile.get;

public class Questionnaire extends Activity {
    private ListView listView;
    private static ArrayList<String> questionnaires  = new ArrayList<>();
    private QuestionnaireController questionnaireController = new QuestionnaireController(this);
    String TAG = "porseshname";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire);


        //        sampleQuestionnaires();

        //get List of porseshnameha
        questionnaires = questionnaireController.getQuestionnaires();

        listView = findViewById(R.id.questionnaireListView);
        QuestionnaireListAdapter adapter = new QuestionnaireListAdapter(this, questionnaires);
        listView.setAdapter(adapter);


        onClickListView();
    }

    private void onClickListView(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //because start of database and list are different
                position++;
                Intent intent = new Intent(Questionnaire.this,Question.class);
                intent.putExtra("QT", questionnaireController.getQuestionnaire(position).getQT());
                intent.putExtra("AT", questionnaireController.getQuestionnaire(position).getAT());
                //get username from last activity (login) and set it to next activity
                String username = getIntent().getStringExtra("user");
                intent.putExtra("user", username);
                //sending porseshnameId to next activity (question)
                intent.putExtra("porseshnameId", String.valueOf(position));
                Log.d(TAG, "position is "+position);
                System.out.println(" position = "+position);
                startActivity(intent);
            }
        });
    }

    private void sampleQuestionnaires(){
        questionnaireController.insertToDatabase("test1","about weather", "1:\"question1\"/1", "answer1");
        questionnaireController.insertToDatabase("test2","about geography","1:\"question1\"/1", "answer1");
        questionnaireController.insertToDatabase("test3","about health","1:\"question1\"/1", "answer1");
    }

//    private void getLastExtra(){
//        getIntent().geExtra("user")
//    }
}
