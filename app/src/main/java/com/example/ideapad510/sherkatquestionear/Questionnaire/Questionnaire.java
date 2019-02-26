package com.example.ideapad510.sherkatquestionear.Questionnaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.New.New;
import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.R;
import com.example.ideapad510.sherkatquestionear.ql.qlController;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static com.example.ideapad510.sherkatquestionear.Database.Tables.qlTable.jmrcode;

public class Questionnaire extends Activity {

    private ListView listView;
    private static ArrayList<String> questionnaires  = new ArrayList<>();
    private QuestionnaireController questionnaireController = new QuestionnaireController(this);
    private qlController qlControllerr = new qlController(this);
    String TAG = "porseshname";
    private Params params = Params.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire);


        //get List of porseshnameha
        String username = params.getUsername();
        String jmrCode = qlControllerr.getJmrcode(username);
        String function = qlControllerr.getFunction(jmrCode);
//        Log.d(TAG, "onCreate: function "+(function == null)+ " "+jmrCode);
//        Log.d(TAG, "onCreate: count is "+qlControllerr.getCount());
        questionnaires = functionParse(function);

        listView = findViewById(R.id.questionnaireListView2);
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

                Intent intent = new Intent(Questionnaire.this, New.class);

                //get username from last activity (login) and set it to next activity
                String username = getIntent().getStringExtra("user");

                //sending porseshnameId to next activity (question)
                params.setQT(questionnaireController.getQuestionnaire(position).getQT());
                params.setAT(questionnaireController.getQuestionnaire(position).getAT());
                params.setPorseshnameId(String.valueOf(position));

                startActivity(intent);
            }
        });
    }



    private ArrayList functionParse(String function){
        String[] questionnaireId = function.split("-");

        ArrayList<String> questionnaires = questionnaireController.getQuestionnaires();
        ArrayList<String> qtArray = new ArrayList<>();

        for(String id : questionnaireId){
            int idd = Integer.valueOf(id);
            qtArray.add(questionnaires.get(idd-1));
        }

        return qtArray;
    }

}
