package com.example.ideapad510.sherkatquestionear.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ideapad510.sherkatquestionear.Questionnaire.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerTable;
import com.example.ideapad510.sherkatquestionear.Login.LoginTable;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionObject;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionTable1;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private static final String TAG = "Database";

    private static Database instance;
    private static final int DATABASE_VERSION = 1;

    private static String DATABASE_NAME = "Table_db";

    private Context context;

    private Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static Database getInstance(Context context){
        if (instance == null){
            instance = new Database(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoginTable.CREATE_TABLE);
        db.execSQL(QuestionTable1.CREATE_TABLE);
        db.execSQL(AnswerTable.CREATE_TABLE);
        db.execSQL(QuestionnaireTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LoginTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable1.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AnswerTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireTable.TABLE_NAME);
        onCreate(db);
    }


    public void insertRowLogin(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(LoginTable.COLUMN_USERNAME, username);
        values.put(LoginTable.COLUMN_PASSWORD, password);
        long id =db.insert(LoginTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowQuestionnaire(String name, String text, String qt, String at){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionnaireTable.COLUMN_NAME, name);
        values.put(QuestionnaireTable.COLUMN_TEXT, text);
        values.put(QuestionnaireTable.COLUMN_QT, qt);
        values.put(QuestionnaireTable.COLUMN_AT, at);

        long id = db.insert(QuestionnaireTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowQuestion(String question, String position, String part) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionTable1.COLUMN_QUESTION, question);
        values.put(QuestionTable1.COLUMN_POSITION, position);
        values.put(QuestionTable1.COLUMN_PART, part);
        long id = db.insert(QuestionTable1.TABLE_NAME, null, values);

        db.close();

        System.out.println("something added to db");
    }


    public void insertRowAnswer(String questionID, String answer, String mode, String position) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AnswerTable.COLUMN_QUESTION_ID, questionID);
        values.put(AnswerTable.COLUMN_ANSWER, answer);
        values.put(AnswerTable.COLUMN_MODE, mode);
        values.put(AnswerTable.COLUMN_POSITION, position);
        long id = db.insert(AnswerTable.TABLE_NAME, null, values);

        db.close();
    }

    private LoginTable getRowLogin(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(LoginTable.TABLE_NAME,
                new String[]{ LoginTable.COLUMN_USERNAME, LoginTable.COLUMN_PASSWORD,
                        LoginTable.COLUMN_ID},
                LoginTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        LoginTable tableRow = new LoginTable(
                cursor.getString(cursor.getColumnIndex(LoginTable.COLUMN_USERNAME)),
                cursor.getString(cursor.getColumnIndex(LoginTable.COLUMN_PASSWORD)),
                cursor.getInt(cursor.getColumnIndex(LoginTable.COLUMN_ID)));

        cursor.close();

        return tableRow;
    }

    public QuestionnaireTable getRowQuestionnaire(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(QuestionnaireTable.TABLE_NAME,
                new String[]{QuestionnaireTable.COLUMN_ID, QuestionnaireTable.COLUMN_NAME,
                        QuestionnaireTable.COLUMN_TEXT, QuestionnaireTable.COLUMN_QT,
                        QuestionnaireTable.COLUMN_AT },
                QuestionnaireTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        QuestionnaireTable tableRow = new QuestionnaireTable(
                cursor.getInt(cursor.getColumnIndex(QuestionnaireTable.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_TEXT)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_QT)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_AT)));


        cursor.close();

        return tableRow;
    }


    public QuestionTable1 getRowQuestion1(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(QuestionTable1.TABLE_NAME,
                new String[]{QuestionTable1.COLUMN_QUESTION, QuestionTable1.COLUMN_POSITION,
                        QuestionTable1.COLUMN_PART, QuestionTable1.COLUMN_ID},
                QuestionTable1.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        QuestionTable1 tableRow = new QuestionTable1(
                cursor.getString(cursor.getColumnIndex(QuestionTable1.COLUMN_QUESTION)),
                cursor.getString(cursor.getColumnIndex(QuestionTable1.COLUMN_POSITION)),
                cursor.getString(cursor.getColumnIndex(QuestionTable1.COLUMN_PART)),
                cursor.getInt(cursor.getColumnIndex(QuestionTable1.COLUMN_ID)));

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

    private int getRowsCountQuestionnaire() {
        String countQuery = "SELECT  * FROM " + QuestionnaireTable.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }


    private int getRowsCountLogin() {
        String countQuery = "SELECT  * FROM " + LoginTable.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }


    private int getRowsCountQuestion1() {
        String countQuery = "SELECT  * FROM " + QuestionTable1.TABLE_NAME;
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


    public boolean searchInDatabaseLogin(String username, String password){
        for(int i=1; i <= getRowsCountLogin(); i++){
            if((getRowLogin(i).getUsername().equals(username)) & (getRowLogin(i).getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    public boolean searchInDatabaseLogin2(String username, String password){
        Log.d(TAG, "searchInDatabaseLogin2: "+username+" "+password);
        String searchQuery = " SELECT * FROM " + LoginTable.TABLE_NAME + " WHERE " +
                LoginTable.COLUMN_USERNAME +" = "+ username +" AND " + LoginTable.COLUMN_PASSWORD + " = "+ password;
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d(TAG, "searchInDatabaseLogin2: "+searchQuery);
        Cursor cursor = db.rawQuery(searchQuery, null);
        Log.d(TAG, "searchInDatabaseLogin2: "+(cursor == null));
        int count = cursor.getCount();
        Log.d(TAG, "searchInDatabaseLogin2: " +count);
        cursor.close();

        return count > 0 ;
    }


    public ArrayList<QuestionObject> getQuestionsFromQuestionTable1( String start){
        ArrayList<QuestionObject> questions = new ArrayList<>();
        for(int i = Integer.valueOf(start); i <= getRowsCountQuestion1(); i++){
            QuestionObject questionObject = new QuestionObject(getRowQuestion1(i).getQuestion(), getRowQuestion1(i).getId(),
                    Integer.valueOf(getRowQuestion1(i).getPart()));
                questions.add(questionObject);
            }
        return questions;
    }

    public ArrayList<QuestionObject> getPartedQuestionObjects(int part){
        ArrayList<QuestionObject> partedQuestions = new ArrayList<>();
        QuestionObject questionObject;
        for(int i = 1; i<= getRowsCountQuestion1(); i++){
            if((getRowQuestion1(i).getPart()).equals(String.valueOf(part))) {
                questionObject = new QuestionObject(getRowQuestion1(i).getQuestion(), getRowQuestion1(i).getId(),
                        Integer.valueOf(getRowQuestion1(i).getPart()));
                partedQuestions.add(questionObject);
            }
        }
        return partedQuestions;
    }

    public ArrayList<QuestionObject> getRandomPartedQuestionObjects(int part){
        ArrayList<QuestionObject> partedQuestions = new ArrayList<>();
        QuestionObject questionObject;
        for(int i = 1; i<= getRowsCountQuestion1(); i++){
            if((getRowQuestion1(i).getPart()).equals(String.valueOf(part))) {
                questionObject = new QuestionObject(getRowQuestion1(i).getQuestion(), getRowQuestion1(i).getId(),
                        Integer.valueOf(getRowQuestion1(i).getPart()));
                if(Math.random() > 0.5)
                     partedQuestions.add(questionObject);
            }
        }
        return partedQuestions;
    }

    public ArrayList<String> getQuestionnaires(){
        ArrayList<String> questionnaires = new ArrayList<>();
        for(int i = 1; i<=getRowsCountQuestionnaire(); i++)
            questionnaires.add(getRowQuestionnaire(i).getName()+"\n"+getRowQuestionnaire(i).getText());
        return questionnaires;
    }

/*    public void insertQA_ArrayList(SQLiteDatabase db, Context context){
        InsertQuestionsAnswers insertQuestionsAnswers = new InsertQuestionsAnswers(context);
        db.execSQL("INSERT INTO " +
                QuestionTable.TABLE_NAME +
//                " Values('"+LastName.get(i)+"','"+FirstName.get(i)+"',"+Age.get(i)+");");
//                " Values('"+insertQuestionsAnswers.getQuestionAndAnswerObjectArrayList().get(i)+"','"+FirstName.get(i)+"',"+Age.get(i)+");");

    }
*/
}
