package com.example.ideapad510.sherkatquestionear.Questions;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.R;
import com.example.ideapad510.sherkatquestionear.Result.Result;

import java.util.ArrayList;

public class Question extends Activity {
    private ArrayList<QuestionObject> questionObjectArray = new ArrayList<>();
    private int pageNumber = 0;
    private static final String TAG = "question";
    private String username;
    private String porseshnameId;

    private RadioButtons buttons2;
    private Params params= Params.getInstance();


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);


        username = params.getUsername();
        porseshnameId = params.getPorseshnameId();

        buttons2 = new RadioButtons(Question.this, this, username,
                porseshnameId, pageNumber);
        buttons2.refreshPage(pageNumber);

        Database db = Database.getInstance(this);

        buttons2.checkedListener();
    }

    @Override
    public void onResume(){
        super.onResume();

        buttons2.refreshPage(pageNumber);
    }



    public void onBackClicked(View view){
        if(!(pageNumber == 0)) {
            pageNumber--;
            buttons2.refreshPage(pageNumber);
        }
    }

    public void onForwardClicked(View view){
        if(!(pageNumber == questionObjectArray.size() - 1)) {
            pageNumber++;
            buttons2.refreshPage(pageNumber);
        }
    }

    public  void onDoneClicked(View view){
        Intent intent = new Intent(Question.this, Result.class);
        intent.putExtra("user",username);
        startActivity(intent);
    }

}
