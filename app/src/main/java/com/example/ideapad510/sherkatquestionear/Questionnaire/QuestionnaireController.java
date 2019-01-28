package com.example.ideapad510.sherkatquestionear.Questionnaire;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;

import java.util.ArrayList;

public class QuestionnaireController {
    private Database db;

    QuestionnaireController(Context context){
        db = Database.getInstance(context);
    }

    public ArrayList<String> getQuestionnaires(){
        return db.getQuestionnaires();
    }

    public void insertToDatabase(String name, String text, String part1, String part2,
                                 String part3, String part4){
        db.insertRowQuestionnaire(name, text, part1, part2, part3, part4);
    }

    public QuestionnaireTable getQuestionnaire(int id){
        return db.getRowQuestionnaire(id);
    }

}
