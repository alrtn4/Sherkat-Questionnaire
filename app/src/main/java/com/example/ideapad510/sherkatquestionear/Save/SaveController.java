package com.example.ideapad510.sherkatquestionear.Save;

//this class connects save classes to database

import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database2;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseGetMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseSearchMethods;
import com.example.ideapad510.sherkatquestionear.Database.Tables.SaveTable;

import java.util.ArrayList;

public class SaveController {
    private Database2 db;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseGetMethods databaseGetMethods;
    private DatabaseSearchMethods databaseSearchMethods;
    String TAG = "savecontroller";

    public SaveController(Context context){
        db = Database2.getInstance(context);
        databaseInsertMethods = new DatabaseInsertMethods(context);
        databaseGetMethods = new DatabaseGetMethods(context);
        databaseSearchMethods = new DatabaseSearchMethods(context);
    }

    public void insertToDatabase(String questionId, String answerId, String porseshnameId, String user, String delete){
        databaseInsertMethods.insertRowSave(questionId, answerId, porseshnameId, user, delete);
    }

    public SaveTable getRowSave(int id){
        return databaseGetMethods.getRowSave(id);
    }

    public ArrayList<SaveObject> getAllSaves(String user){
        return databaseSearchMethods.getAllSaves(user);
    }

    public ArrayList getAnswersCheckedFromDatabase(int questionId , String user){
        ArrayList arrayList = new ArrayList();
        for(SaveObject savobj : getAllSaves(user))
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

    public long idOfselectedAnswer(int questionId, int answerId, String user, String porseshnameId){
        return databaseSearchMethods.getIdOfSelectedAnswer(porseshnameId , user, String.valueOf(questionId),
                String.valueOf(answerId));
    }

    public void deleteSelectedAnswer(long id){
        databaseSearchMethods.deletSingleRowSaveTable(id);
    }


}
