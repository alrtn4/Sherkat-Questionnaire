package com.example.ideapad510.sherkatquestionear.Questionnaire;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;

import java.util.ArrayList;

public class QuestionnaireController {
    private Database db;

    QuestionnaireController(Context context){
        db = Database.getInstance(context);
    }

    //returns list of porseshnameha
    public ArrayList<String> getQuestionnaires(){return db.getQuestionnaires();
    }

    public void insertToDatabase(String name, String text, String qt, String at){
        db.insertRowQuestionnaire(name, text, qt, at);
    }

    public QuestionnaireTable getQuestionnaire(int id){
        return db.getRowQuestionnaire(id);
    }

}
