package com.example.ideapad510.sherkatquestionear.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ideapad510.sherkatquestionear.Database.Tables.LoginTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.SaveTable;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionObject;
import com.example.ideapad510.sherkatquestionear.Save.SaveObject;

import java.util.ArrayList;

/**
 * Created by Ideapad 510 on 2/7/2019.
 */

public class DatabaseSearchMethods {
    Database database2;
    DatabaseGetMethods databaseGetMethods;



    public DatabaseSearchMethods(Context context){
        database2 = Database.getInstance(context);
        databaseGetMethods = new DatabaseGetMethods(context);
    }

    public boolean searchInDatabaseLogin(String username, String password){
//        Log.d(TAG, "searchInDatabaseLogin: "+username+" "+password);
        String searchQuery = " SELECT * FROM " + LoginTable.TABLE_NAME + " WHERE " +
                LoginTable.jmr_user +" = '"+ username +"' AND " + LoginTable.jmr_pass + " = '"+ password+ "' ;";
        SQLiteDatabase db = database2.getReadableDatabase();
//        Log.d(TAG, "searchInDatabaseLogin: "+searchQuery);
        Cursor cursor = db.rawQuery(searchQuery, null);
//        Log.d(TAG, "searchInDatabaseLogin: "+(cursor == null));
        int count = cursor.getCount();
//        Log.d(TAG, "searchInDatabaseLogin: " +count);
        cursor.close();

        return count > 0 ;
    }

    public ArrayList<QuestionObject> getQuestionsFromQuestionTable2(String start){
        int startt = Integer.valueOf(start);
        ArrayList<QuestionObject> questionObjectArrayList = new ArrayList<>();
        String query = " SELECT * FROM " + QuestionTable.TABLE_NAME + " WHERE " +
                QuestionTable.COLUMN_ID +" >= "+ startt +" ;";
        SQLiteDatabase db = database2.getReadableDatabase();
        Cursor cursor = db.rawQuery(query , null);

        while(cursor.moveToNext()) {
            QuestionObject questionObject = new QuestionObject(
                    cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)),
                    cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_ID)),
                    Integer.valueOf(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_PART))));

            questionObjectArrayList.add(questionObject);
        }

        return questionObjectArrayList;
    }

    public ArrayList<String> getQuestionnaires(){
        ArrayList<String> questionnaires = new ArrayList<>();
        String query = " SELECT * FROM " + QuestionnaireTable.TABLE_NAME + " ;";
        SQLiteDatabase db = database2.getReadableDatabase();
        Cursor cursor = db.rawQuery(query , null);

        while(cursor.moveToNext()) {
            String questionnaire =
                    cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_NAME))+"\n"+
                    cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_TEXT));


            questionnaires.add(questionnaire);
        }

        return questionnaires;

    }


    public ArrayList<SaveObject> getAllSaves(String user, String pasokhgoo){
        ArrayList<SaveObject>  saveObjectArrayList= new ArrayList<>();
        String query = " SELECT * FROM " + SaveTable.TABLE_NAME + " WHERE "+ SaveTable.COLUMN_USER +" = '"+user+"' AND "
                +SaveTable.PASOKHGOO+" = '"+pasokhgoo+"' ;";
        SQLiteDatabase db = database2.getReadableDatabase();
        Cursor cursor = db.rawQuery(query , null);

        while(cursor.moveToNext()) {
            SaveObject saveObject = new SaveObject(
                    cursor.getString(cursor.getColumnIndex(SaveTable.COLUMN_QUESTION_ID)),
                    cursor.getString(cursor.getColumnIndex(SaveTable.COLUMN_ANSWER_ID)),
                    cursor.getString(cursor.getColumnIndex(SaveTable.COLUMN_PORSESHNAME_ID)),
                    cursor.getString(cursor.getColumnIndex(SaveTable.COLUMN_USER)),
                    cursor.getString(cursor.getColumnIndex(SaveTable.PASOKHGOO)));



                    saveObjectArrayList.add(saveObject);
        }

        return saveObjectArrayList;

    }

    public void deletSingleRowSaveTable(long id){
        SQLiteDatabase db = database2.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM  saveResult" + " WHERE id="
                    + id + ";");
        } catch (Exception e) {
        }

    }

    public long getIdOfSelectedAnswer(String porseshnameId, String username, String questionId, String answerId, String pasokhgoo){
        String searchQuery = " SELECT * FROM " + SaveTable.TABLE_NAME + " WHERE " +
                SaveTable.COLUMN_PORSESHNAME_ID +" = '"+ porseshnameId +"' AND " + SaveTable.COLUMN_USER + " = '"+ username
                +"' AND "+ SaveTable.COLUMN_QUESTION_ID+ " = '"+ questionId+ "' AND "
                + SaveTable.COLUMN_ANSWER_ID +" = '"+ answerId+"' AND "+ SaveTable.PASOKHGOO + " = '"+pasokhgoo+"' ;";
        SQLiteDatabase db = database2.getReadableDatabase();

        Cursor cursor = db.rawQuery(searchQuery, null);
        long id = -1;
        if(cursor != null && cursor.moveToFirst()) {
            id = cursor.getLong(cursor.getColumnIndex(SaveTable.COLUMN_ID));

            cursor.close();
        }
        return id ;

    }

    public void deletSavedAnswer(String porseshnameId, String username, String questionId, String answerId, String pasokhgoo){
        int id = (int) getIdOfSelectedAnswer(porseshnameId ,username, questionId, answerId, pasokhgoo);
        deletSingleRowSaveTable(id);
    }

    public boolean searchInSave(String porseshnameId, String username, String questionId, String answerId, String pasokhgoo){
        String searchQuery = " SELECT * FROM " + SaveTable.TABLE_NAME + " WHERE " +
                SaveTable.COLUMN_PORSESHNAME_ID +" = '"+ porseshnameId +"' AND " + SaveTable.COLUMN_USER + " = '"+ username
                +"' AND "+ SaveTable.COLUMN_QUESTION_ID+ " = '"+ questionId+ "' AND "+ SaveTable.COLUMN_ANSWER_ID +" = '"+ answerId+"' AND "
                +SaveTable.PASOKHGOO+" = '"+pasokhgoo+"' ;";
        SQLiteDatabase db = database2.getReadableDatabase();

        Cursor cursor = db.rawQuery(searchQuery, null);
        long cunt = -1;
        if(cursor != null && cursor.moveToFirst()) {
            cunt = cursor.getCount();

            cursor.close();
        }

        if(cunt>=1)
            return false;
        return true ;

    }


}
