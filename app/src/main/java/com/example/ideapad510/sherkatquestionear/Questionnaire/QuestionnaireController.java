package com.example.ideapad510.sherkatquestionear.Questionnaire;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database2;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseGetMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseSearchMethods;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;

import java.util.ArrayList;

public class QuestionnaireController {
    private Database2 db;
    private DatabaseGetMethods databaseGetMethods;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseSearchMethods databaseSearchMethods;

    public QuestionnaireController(Context context){
        db = Database2.getInstance(context);
        databaseGetMethods = new DatabaseGetMethods(context);
        databaseInsertMethods = new DatabaseInsertMethods(context);
        databaseSearchMethods = new DatabaseSearchMethods(context);
    }

    //returns list of porseshnameha
    public ArrayList<String> getQuestionnaires(){return databaseSearchMethods.getQuestionnaires();
    }

    public void insertToDatabase(String name, String text, String qt, String at){
        databaseInsertMethods.insertRowQuestionnaire(name, text, qt, at);
    }

    public QuestionnaireTable getQuestionnaire(int id){
        return databaseGetMethods.getRowQuestionnaire(id);
    }

}
