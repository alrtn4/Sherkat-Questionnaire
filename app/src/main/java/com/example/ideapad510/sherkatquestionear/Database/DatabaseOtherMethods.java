package com.example.ideapad510.sherkatquestionear.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ideapad510.sherkatquestionear.Database.Tables.LoginTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.ResultTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.phone;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionObject;
import com.example.ideapad510.sherkatquestionear.Result.ResultObject;

import java.util.ArrayList;

/**
 * Created by Ideapad 510 on 2/7/2019.
 */

public class DatabaseOtherMethods {
    Database database;
    DatabaseGetMethods databaseGetMethods;



    public DatabaseOtherMethods(Context context){
        database = Database.getInstance(context);
        databaseGetMethods = new DatabaseGetMethods(context);
    }

    public boolean searchInDatabaseLogin(String username, String password){
//        Log.d(TAG, "searchInDatabaseLogin: "+username+" "+password);
        String searchQuery = " SELECT * FROM " + LoginTable.TABLE_NAME + " WHERE " +
                LoginTable.jmr_user +" = '"+ username +"' AND " + LoginTable.jmr_pass + " = '"+ password+ "' ;";
        SQLiteDatabase db = database.getReadableDatabase();
//        Log.d(TAG, "searchInDatabaseLogin: "+searchQuery);
        Cursor cursor = db.rawQuery(searchQuery, null);
//        Log.d(TAG, "searchInDatabaseLogin: "+(cursor == null));
        int count = cursor.getCount();
//        Log.d(TAG, "searchInDatabaseLogin: " +count);
        cursor.close();

        return count > 0 ;
    }

    public ArrayList<QuestionObject> getQuestionsFromQuestionTable(String start){
        int startt = Integer.valueOf(start);
        ArrayList<QuestionObject> questionObjectArrayList = new ArrayList<>();
        String query = " SELECT * FROM " + QuestionTable.TABLE_NAME + " WHERE " +
                QuestionTable.COLUMN_ID +" >= "+ startt +" ;";
        SQLiteDatabase db = database.getReadableDatabase();
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
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(query , null);

        while(cursor.moveToNext()) {
            String questionnaire =
                    cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_NAME))+"\n"+
                    cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_TEXT));


            questionnaires.add(questionnaire);
        }

        return questionnaires;

    }


    public ArrayList<ResultObject> getAllResults(String user, String pasokhgoo){
        ArrayList<ResultObject>  saveObjectArrayList= new ArrayList<>();
        String query = " SELECT * FROM " + ResultTable.TABLE_NAME + " WHERE "+ ResultTable.COLUMN_USER +" = '"+user+"' AND "
                + ResultTable.PASOKHGOO+" = '"+pasokhgoo+"' ;";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(query , null);

        while(cursor.moveToNext()) {
            ResultObject saveObject = new ResultObject(
                    cursor.getString(cursor.getColumnIndex(ResultTable.COLUMN_QUESTION_ID)),
                    cursor.getString(cursor.getColumnIndex(ResultTable.COLUMN_ANSWER_ID)),
                    cursor.getString(cursor.getColumnIndex(ResultTable.COLUMN_PORSESHNAME_ID)),
                    cursor.getString(cursor.getColumnIndex(ResultTable.COLUMN_USER)),
                    cursor.getString(cursor.getColumnIndex(ResultTable.PASOKHGOO)));



                    saveObjectArrayList.add(saveObject);
        }

        return saveObjectArrayList;

    }

    public void deleteSingleRowResultTable(long id){
        SQLiteDatabase db = database.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM  Result" + " WHERE id="
                    + id + ";");
        } catch (Exception e) {
        }

    }

    public long getIdOfSelectedAnswer(String porseshnameId, String username, String questionId, String answerId, String pasokhgoo){
        String searchQuery = " SELECT * FROM " + ResultTable.TABLE_NAME + " WHERE " +
                ResultTable.COLUMN_PORSESHNAME_ID +" = '"+ porseshnameId +"' AND " + ResultTable.COLUMN_USER + " = '"+ username
                +"' AND "+ ResultTable.COLUMN_QUESTION_ID+ " = '"+ questionId+ "' AND "
                + ResultTable.COLUMN_ANSWER_ID +" = '"+ answerId+"' AND "+ ResultTable.PASOKHGOO + " = '"+pasokhgoo+"' ;";
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor cursor = db.rawQuery(searchQuery, null);
        long id = -1;
        if(cursor != null && cursor.moveToFirst()) {
            id = cursor.getLong(cursor.getColumnIndex(ResultTable.COLUMN_ID));

            cursor.close();
        }
        return id ;

    }

    public void deletSavedResult(String porseshnameId, String username, String questionId, String answerId, String pasokhgoo){
        int id = (int) getIdOfSelectedAnswer(porseshnameId ,username, questionId, answerId, pasokhgoo);
        deleteSingleRowResultTable(id);
    }

    public boolean searchInResult(String porseshnameId, String username, String questionId, String answerId, String pasokhgoo){
        String searchQuery = " SELECT * FROM " + ResultTable.TABLE_NAME + " WHERE " +
                ResultTable.COLUMN_PORSESHNAME_ID +" = '"+ porseshnameId +"' AND " + ResultTable.COLUMN_USER + " = '"+ username
                +"' AND "+ ResultTable.COLUMN_QUESTION_ID+ " = '"+ questionId+ "' AND "+ ResultTable.COLUMN_ANSWER_ID +" = '"+ answerId+"' AND "
                + ResultTable.PASOKHGOO+" = '"+pasokhgoo+"' ;";
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor cursor = db.rawQuery(searchQuery, null);
        long cunt = -1;
        if(cursor != null && cursor.moveToFirst()) {
            cunt = cursor.getCount();

            cursor.close();
        }

        if(cunt>=1)
            return true;
        return false ;

    }

    public boolean searchInPhone(String number){
        String searchQuery = " SELECT * FROM " + phone.TABLE_NAME + " WHERE " +
                phone.phoneNumber +" = '"+ number +"' ;";
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor cursor = db.rawQuery(searchQuery, null);
        long cunt = -1;
        if(cursor != null && cursor.moveToFirst()) {
            cunt = cursor.getCount();

            cursor.close();
        }

        if(cunt>=1)
            return true;
        return false ;

    }


}
