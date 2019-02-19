package com.example.ideapad510.sherkatquestionear.Questionnaire;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

import java.util.ArrayList;

public class QuestionnaireController extends Controller{
/*    private Database db;
    private DatabaseGetMethods databaseGetMethods;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseSearchMethods databaseSearchMethods;
*/
    public QuestionnaireController(Context context){
        super(context);
/*        db = Database.getInstance(context);
        databaseGetMethods = newlayout DatabaseGetMethods(context);
        databaseInsertMethods = newlayout DatabaseInsertMethods(context);
        databaseSearchMethods = newlayout DatabaseSearchMethods(context);
*/    }

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
