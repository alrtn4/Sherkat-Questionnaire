package com.example.ideapad510.sherkatquestionear.Questionnaire;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

import java.util.ArrayList;

public class QuestionnaireController extends Controller{
    public QuestionnaireController(Context context){
        super(context);
    }

    //returns list of porseshnameha
    public ArrayList<String> getQuestionnaires(){return databaseOtherMethods.getQuestionnaires();
    }

    public void insertToDatabase(String name, String text, String qt, String at){
        databaseInsertMethods.insertRowQuestionnaire(name, text, qt, at);
    }

    public QuestionnaireTable getQuestionnaire(int id){
        return databaseGetMethods.getRowQuestionnaire(id);
    }

}
