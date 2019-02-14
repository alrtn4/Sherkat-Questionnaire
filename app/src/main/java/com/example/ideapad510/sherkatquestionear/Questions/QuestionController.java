package com.example.ideapad510.sherkatquestionear.Questions;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseSearchMethods;
import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionAnswerArray.ShortedAnswer;

import java.util.ArrayList;

public class QuestionController extends Controller{
/*    private Database db;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseSearchMethods databaseSearchMethods;
*/
    public QuestionController(Context context){
        super(context);
/*        db = Database.getInstance(context);
        databaseInsertMethods = newlayout DatabaseInsertMethods(context);
        databaseSearchMethods = newlayout DatabaseSearchMethods(context);
*/    }

    public void insertToDatabase(String question, String position, String part){
        databaseInsertMethods.insertRowQuestion(question, position, part);
    }

    public void insertQuestionArray(ArrayList<ShortedAnswer> array){
        for(int i = 0; i < array.size(); i++)
            insertToDatabase(array.get(i).getQuestion(),
                    "0", "1");
    }

    public ArrayList<QuestionObject> getQuestionsFromQuestionTable(String start){
        return databaseSearchMethods.getQuestionsFromQuestionTable2( start);
    }

    public boolean searchInSave(String porseshnameId, String username, String questionId, String answerId, String pasokhgoo){
        return !databaseSearchMethods.searchInSave(porseshnameId, username, questionId, answerId, pasokhgoo);
    }

}
