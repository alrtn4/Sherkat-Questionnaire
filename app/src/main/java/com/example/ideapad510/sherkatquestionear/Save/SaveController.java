package com.example.ideapad510.sherkatquestionear.Save;

//this class connects save classes to database

import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Tables.SaveTable;
import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

import java.util.ArrayList;

public class SaveController extends Controller{
/*    private Database db;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseGetMethods databaseGetMethods;
    private DatabaseSearchMethods databaseSearchMethods;
    String TAG = "savecontroller";
*/
    public SaveController(Context context){
        super(context);
/*        db = Database.getInstance(context);
        databaseInsertMethods = newlayout DatabaseInsertMethods(context);
        databaseGetMethods = newlayout DatabaseGetMethods(context);
        databaseSearchMethods = newlayout DatabaseSearchMethods(context);
*/    }

    public void insertToDatabase(String questionId, String answerId, String porseshnameId, String user, String delete){
        databaseInsertMethods.insertRowSave(questionId, answerId, porseshnameId, user, delete);
    }

    public SaveTable getRowSave(int id){
        return databaseGetMethods.getRowSave(id);
    }

    public ArrayList<SaveObject> getAllSaves(String user, String pasokhgoo){
        return databaseSearchMethods.getAllSaves(user, pasokhgoo);
    }
/*
    public ArrayList getAnswersCheckedFromDatabase(int questionId , String user, String pasokhgoo){
        ArrayList arrayList = new ArrayList();
        for(SaveObject savobj : getAllSaves(user, pasokhgoo))
            if(savobj.getQuestionId().equals(String.valueOf(questionId)))
                arrayList.add(savobj.getAnswerId());
        return arrayList;
    }

    public boolean isAnswerSelected(int questionId, int answerId, String user){
        boolean answerSelected = false;
        int numberOfAnswersForThisQuestion = getAnswersCheckedFromDatabase(questionId, user).size();
        for(int i = 0; i < numberOfAnswersForThisQuestion; i++) {
            boolean isThisAnswerRecordedInDatabase = getAnswersCheckedFromDatabase(questionId, user).get(i).
                    equals(String.valueOf(answerId));
            if (isThisAnswerRecordedInDatabase) {
                answerSelected = true;
            }
        }
        return answerSelected;
    }

    public long idOfselectedAnswer(int questionId, int answerId, String user, String porseshnameId, String pasokhgoo){
        return databaseSearchMethods.getIdOfSelectedAnswer(porseshnameId , user, String.valueOf(questionId),
                String.valueOf(answerId), pasokhgoo);
    }

    public void deleteSelectedAnswer(long id){
        databaseSearchMethods.deletSingleRowSaveTable(id);
    }
*/

}
