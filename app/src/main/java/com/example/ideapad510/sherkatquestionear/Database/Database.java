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
import com.example.ideapad510.sherkatquestionear.Questions.QuestionTable;
import com.example.ideapad510.sherkatquestionear.Questions.InsertQuestionsAnswers;

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
        db.execSQL(QuestionTable.CREATE_TABLE);
        db.execSQL(AnswerTable.CREATE_TABLE);
        db.execSQL(QuestionnaireTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LoginTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
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

    public void insertRowQuestionnaire(String name, String text, String part1,  String part2,
                                       String part3, String part4){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionnaireTable.COLUMN_NAME, name);
        values.put(QuestionnaireTable.COLUMN_TEXT, text);
        values.put(QuestionnaireTable.COLUMN_PART_1, part1);
        values.put(QuestionnaireTable.COLUMN_PART_2, part2);
        values.put(QuestionnaireTable.COLUMN_PART_3, part3);
        values.put(QuestionnaireTable.COLUMN_PART_4, part4);

        long id = db.insert(QuestionnaireTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowQuestion(String question, String position, String part) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionTable.COLUMN_QUESTION, question);
        values.put(QuestionTable.COLUMN_POSITION, position);
        values.put(QuestionTable.COLUMN_PART, part);
        long id = db.insert(QuestionTable.TABLE_NAME, null, values);

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
                new String[]{ QuestionnaireTable.COLUMN_NAME,
                        QuestionnaireTable.COLUMN_TEXT, QuestionnaireTable.COLUMN_PART_1,
                        QuestionnaireTable.COLUMN_PART_2, QuestionnaireTable.COLUMN_PART_3,
                        QuestionnaireTable.COLUMN_PART_4, QuestionnaireTable.COLUMN_ID},
                QuestionnaireTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        QuestionnaireTable tableRow = new QuestionnaireTable(
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_TEXT)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_PART_1)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_PART_2)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_PART_3)),
                cursor.getString(cursor.getColumnIndex(QuestionnaireTable.COLUMN_PART_4)),
                cursor.getInt(cursor.getColumnIndex(QuestionnaireTable.COLUMN_ID)));

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


    private int getRowsCountQuestion() {
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

    public ArrayList<QuestionObject> getPartedQuestionObjects(int part){
        ArrayList<QuestionObject> partedQuestions = new ArrayList<>();
        QuestionObject questionObject;
        for(int i=1; i<=getRowsCountQuestion(); i++){
            if((getRowQuestion(i).getPart()).equals(String.valueOf(part))) {
                questionObject = new QuestionObject(getRowQuestion(i).getQuestion(), getRowQuestion(i).getId(),
                        Integer.valueOf(getRowQuestion(i).getPart()));
                partedQuestions.add(questionObject);
            }
        }
        return partedQuestions;
    }

    public ArrayList<QuestionObject> getRandomPartedQuestionObjects(int part){
        ArrayList<QuestionObject> partedQuestions = new ArrayList<>();
        QuestionObject questionObject;
        for(int i=1; i<=getRowsCountQuestion(); i++){
            if((getRowQuestion(i).getPart()).equals(String.valueOf(part))) {
                questionObject = new QuestionObject(getRowQuestion(i).getQuestion(), getRowQuestion(i).getId(),
                        Integer.valueOf(getRowQuestion(i).getPart()));
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
