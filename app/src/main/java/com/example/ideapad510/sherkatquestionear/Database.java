package com.example.ideapad510.sherkatquestionear;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ideapad510.sherkatquestionear.Answer.AnswerTable;
import com.example.ideapad510.sherkatquestionear.Answer.AnswerTable2;
import com.example.ideapad510.sherkatquestionear.Answer.LoginTable2;
import com.example.ideapad510.sherkatquestionear.Login.LoginTable;
import com.example.ideapad510.sherkatquestionear.Question.QuestionTable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static String DATABASE_NAME = "Table_db";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoginTable.CREATE_TABLE);
        db.execSQL(QuestionTable.CREATE_TABLE);
        db.execSQL(AnswerTable2.CREATE_TABLE);
//        db.execSQL(LoginTable2.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LoginTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AnswerTable2.TABLE_NAME);
        onCreate(db);
    }


    public long insertRowLogin(String note1, String note2) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(LoginTable.COLUMN_NOTE1, note1);
        values.put(LoginTable.COLUMN_NOTE2, note2);
        long id =db.insert(LoginTable.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public long insertRowQuestion(String question, String position, String part) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionTable.COLUMN_QUESTION, question);
        values.put(QuestionTable.COLUMN_POSITION, position);
        values.put(QuestionTable.COLUMN_PART, part);
        long id = db.insert(QuestionTable.TABLE_NAME, null, values);

        db.close();

        return id;
    }


    public long insertRowAnswer(String questionID, String answer, String mode, String position) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AnswerTable.COLUMN_QUESTION_ID, questionID);
        values.put(AnswerTable.COLUMN_ANSWER, answer);
        values.put(AnswerTable.COLUMN_MODE, mode);
        values.put(AnswerTable.COLUMN_POSITION, position);
        long id = db.insert(AnswerTable.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public long insertRowAnswer2(String questionID, String answer, String mode, String position) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AnswerTable2.COLUMN_QUESTION_ID, questionID);
        values.put(AnswerTable2.COLUMN_ANSWER, answer);
        values.put(AnswerTable2.COLUMN_MODE, mode);
        values.put(AnswerTable2.COLUMN_POSITION, position);
        long id = db.insert(AnswerTable2.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    private LoginTable getRowLogin(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(LoginTable.TABLE_NAME,
                new String[]{ LoginTable.COLUMN_NOTE1, LoginTable.COLUMN_NOTE2,
                        LoginTable.COLUMN_ID},
                LoginTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        LoginTable tableRow = new LoginTable(
                cursor.getString(cursor.getColumnIndex(LoginTable.COLUMN_NOTE1)),
                cursor.getString(cursor.getColumnIndex(LoginTable.COLUMN_NOTE2)),
                cursor.getInt(cursor.getColumnIndex(LoginTable.COLUMN_ID)));

        cursor.close();

        return tableRow;
    }

    public QuestionTable getRowQuestion(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(QuestionTable.TABLE_NAME,
                new String[]{QuestionTable.COLUMN_QUESTION, QuestionTable.COLUMN_POSITION,
                        QuestionTable.COLUMN_PART, QuestionTable.COLUMN_ID},
                QuestionTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        QuestionTable tableRow = new QuestionTable(
                cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)),
                cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_POSITION)),
                cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_PART)),
                cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_ID)));

        cursor.close();

        return tableRow;
    }

    public AnswerTable getRowAnswer(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(AnswerTable.TABLE_NAME,
                new String[]{ AnswerTable.COLUMN_ID, AnswerTable.COLUMN_QUESTION_ID, AnswerTable.COLUMN_ANSWER,
                        AnswerTable.COLUMN_MODE, AnswerTable.COLUMN_POSITION,},
                AnswerTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        AnswerTable tableRow = new AnswerTable(
                cursor.getInt(cursor.getColumnIndex(AnswerTable.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(AnswerTable.COLUMN_QUESTION_ID)),
                cursor.getString(cursor.getColumnIndex(AnswerTable.COLUMN_ANSWER)),
                cursor.getString(cursor.getColumnIndex(AnswerTable.COLUMN_MODE)),
                cursor.getString(cursor.getColumnIndex(AnswerTable.COLUMN_POSITION)));

        cursor.close();

        return tableRow;
    }

    public AnswerTable2 getRowAnswer2(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(AnswerTable2.TABLE_NAME,
                new String[]{ AnswerTable2.COLUMN_ID, AnswerTable2.COLUMN_QUESTION_ID, AnswerTable2.COLUMN_ANSWER,
                        AnswerTable2.COLUMN_MODE, AnswerTable2.COLUMN_POSITION,},
                AnswerTable2.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        AnswerTable2 tableRow = new AnswerTable2(
                cursor.getInt(cursor.getColumnIndex(AnswerTable2.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(AnswerTable2.COLUMN_QUESTION_ID)),
                cursor.getString(cursor.getColumnIndex(AnswerTable2.COLUMN_ANSWER)),
                cursor.getString(cursor.getColumnIndex(AnswerTable2.COLUMN_MODE)),
                cursor.getString(cursor.getColumnIndex(AnswerTable2.COLUMN_POSITION)));

        cursor.close();

        return tableRow;
    }

    public int getRowsCountLogin() {
        String countQuery = "SELECT  * FROM " + LoginTable.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public int getRowsCountLogin2() {
        String countQuery = "SELECT  * FROM " + LoginTable2.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public int getRowsCountQuestion() {
        String countQuery = "SELECT  * FROM " + QuestionTable.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public int getRowsCountAnswer() {
        String countQuery = "SELECT  * FROM " + AnswerTable.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public int getRowsCountAnswer2() {
        String countQuery = "SELECT  * FROM " + AnswerTable2.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }


    public boolean searchInDatabaseLogin(String username, String password){
        for(int i=1; i <= getRowsCountLogin(); i++){
            if((getRowLogin(i).getUsername().equals(username)) & (getRowLogin(i).getPassword().equals(password))) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<String> getPartedQuestions(int part){
        ArrayList<String> partedQuestions = new ArrayList<>();
        for(int i=1; i<=getRowsCountQuestion(); i++){
            if((getRowQuestion(i).getPart()).equals(String.valueOf(part))) {
                partedQuestions.add(getRowQuestion(i).getQuestion());
                System.out.println("there is part 1");
            }
        }
        return partedQuestions;
    }

    public ArrayList<String> getIdAnswers(int questionID){
        ArrayList<String> idAnswers = new ArrayList<>();
        for(int i = 1; i<= getRowsCountAnswer(); i++){
            if((getRowAnswer(i).getQuestionID()).equals(String.valueOf(questionID))) {
                idAnswers.add(getRowAnswer(i).getAnswer());
                System.out.println("this is working");
            }
        }
        return idAnswers;
    }

}