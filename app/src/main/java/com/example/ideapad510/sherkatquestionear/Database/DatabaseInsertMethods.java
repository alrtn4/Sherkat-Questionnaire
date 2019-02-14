package com.example.ideapad510.sherkatquestionear.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ideapad510.sherkatquestionear.Database.Tables.AnswerTable1;
import com.example.ideapad510.sherkatquestionear.Database.Tables.LoginTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.SaveTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.phone;

/**
 * Created by Ideapad 510 on 2/7/2019.
 */

public class DatabaseInsertMethods {
    Context context;
    Database database2;
    DatabaseSearchMethods databaseSearchMethods;

    public DatabaseInsertMethods(Context context){
        database2 = Database.getInstance(context);
        databaseSearchMethods = new DatabaseSearchMethods(context);
    }

    public void insertRowLogin(String username, String password, String code) {
        SQLiteDatabase db = database2.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(LoginTable.jmr_user, username);
        values.put(LoginTable.jmr_pass, password);
        values.put(LoginTable.jmr_code, code);
        db.insert(LoginTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowQuestionnaire(String name, String text, String qt, String at){
        SQLiteDatabase db = database2.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionnaireTable.COLUMN_NAME, name);
        values.put(QuestionnaireTable.COLUMN_TEXT, text);
        values.put(QuestionnaireTable.COLUMN_QT, qt);
        values.put(QuestionnaireTable.COLUMN_AT, at);

        db.insert(QuestionnaireTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowQuestion(String question, String position, String part) {
        SQLiteDatabase db = database2.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionTable.COLUMN_QUESTION, question);
        values.put(QuestionTable.COLUMN_POSITION, position);
        values.put(QuestionTable.COLUMN_PART, part);
        db.insert(QuestionTable.TABLE_NAME, null, values);

        db.close();

//        System.out.println("something added to db");
    }


    public void insertRowAnswer(String questionID, String answer, String mode, String position) {
        SQLiteDatabase db = database2.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AnswerTable1.COLUMN_QUESTION_ID, questionID);
        values.put(AnswerTable1.COLUMN_ANSWER, answer);
        values.put(AnswerTable1.COLUMN_MODE, mode);
        values.put(AnswerTable1.COLUMN_POSITION, position);
        db.insert(AnswerTable1.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowSave(String questionID, String answerId, String porseshnameId, String user, String pasokhgoo) {
        SQLiteDatabase db = database2.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SaveTable.COLUMN_QUESTION_ID, questionID);
        values.put(SaveTable.COLUMN_ANSWER_ID, answerId);
        values.put(SaveTable.COLUMN_PORSESHNAME_ID, porseshnameId);
        values.put(SaveTable.COLUMN_USER, user);
        values.put(SaveTable.PASOKHGOO, pasokhgoo);
        if(databaseSearchMethods.searchInSave(porseshnameId, user, questionID, answerId, pasokhgoo))
            db.insert(SaveTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowPhone(String phoneNumber) {
        SQLiteDatabase db = database2.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(phone.phoneNumber, phoneNumber);
        db.insert(phone.TABLE_NAME, null, values);

        db.close();
    }


}
