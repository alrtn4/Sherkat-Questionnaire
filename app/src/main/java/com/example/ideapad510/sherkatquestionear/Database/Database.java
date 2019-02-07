package com.example.ideapad510.sherkatquestionear.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ideapad510.sherkatquestionear.Database.Tables.LogTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.AnswerTable1;
import com.example.ideapad510.sherkatquestionear.Database.Tables.LoginTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.n1001_a;
import com.example.ideapad510.sherkatquestionear.Database.Tables.n1001_q;
import com.example.ideapad510.sherkatquestionear.Database.Tables.n2001_a;
import com.example.ideapad510.sherkatquestionear.Database.Tables.n2001_q;
import com.example.ideapad510.sherkatquestionear.Database.Tables.n3001_a;
import com.example.ideapad510.sherkatquestionear.Database.Tables.n3001_q;
import com.example.ideapad510.sherkatquestionear.Database.Tables.qlTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.qlcode_r;
import com.example.ideapad510.sherkatquestionear.Database.Tables.qlcode_t;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionObject;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionTable1;
import com.example.ideapad510.sherkatquestionear.Save.SaveObject;
import com.example.ideapad510.sherkatquestionear.Database.Tables.SaveTable;

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
        db.execSQL(AnswerTable1.CREATE_TABLE);
        db.execSQL(QuestionnaireTable.CREATE_TABLE);
        db.execSQL(SaveTable.CREATE_TABLE);
//        db.execSQL(LogTable.CREATE_TABLE);
//        db.execSQL(n1001_a.CREATE_TABLE);
//        db.execSQL(n2001_a.CREATE_TABLE);
//        db.execSQL(n3001_a.CREATE_TABLE);
//        db.execSQL(n1001_q.CREATE_TABLE);
//        db.execSQL(n2001_q.CREATE_TABLE);
//        db.execSQL(n3001_q.CREATE_TABLE);
//        db.execSQL(qlcode_r.CREATE_TABLE);
//        db.execSQL(qlcode_t.CREATE_TABLE);
//        db.execSQL(qlTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LoginTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable1.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AnswerTable1.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SaveTable.TABLE_NAME);
        onCreate(db);
    }


    public void insertRowLogin(String username, String password, String code) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(LoginTable.jmr_user, username);
        values.put(LoginTable.jmr_pass, password);
        values.put(LoginTable.jmr_code, code);
        db.insert(LoginTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowQuestionnaire(String name, String text, String qt, String at){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionnaireTable.COLUMN_NAME, name);
        values.put(QuestionnaireTable.COLUMN_TEXT, text);
        values.put(QuestionnaireTable.COLUMN_QT, qt);
        values.put(QuestionnaireTable.COLUMN_AT, at);

        db.insert(QuestionnaireTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowQuestion(String question, String position, String part) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionTable1.COLUMN_QUESTION, question);
        values.put(QuestionTable1.COLUMN_POSITION, position);
        values.put(QuestionTable1.COLUMN_PART, part);
        db.insert(QuestionTable1.TABLE_NAME, null, values);

        db.close();

//        System.out.println("something added to db");
    }


    public void insertRowAnswer(String questionID, String answer, String mode, String position) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AnswerTable1.COLUMN_QUESTION_ID, questionID);
        values.put(AnswerTable1.COLUMN_ANSWER, answer);
        values.put(AnswerTable1.COLUMN_MODE, mode);
        values.put(AnswerTable1.COLUMN_POSITION, position);
        db.insert(AnswerTable1.TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowSave(String questionID, String answerId, String porseshnameId, String user, String delete) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SaveTable.COLUMN_QUESTION_ID, questionID);
        values.put(SaveTable.COLUMN_ANSWER_ID, answerId);
        values.put(SaveTable.COLUMN_PORSESHNAME_ID, porseshnameId);
        values.put(SaveTable.COLUMN_USER, user);
        values.put(SaveTable.DELETE, delete);
        if(searchInSave(porseshnameId, user, questionID, answerId))
            db.insert(SaveTable.TABLE_NAME, null, values);

        Log.d(TAG, " porseshname id is "+ porseshnameId);

        db.close();
    }


/*
    public void insertRowLogTable(String Jmr_code, String Time, String Column_do) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(LogTable.Jmr_code, Jmr_code);
        values.put(LogTable.Time, Time);
        values.put(LogTable.Column_do, Column_do);
        db.insert(LogTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertqlcode_r(String rcode, String qcode, String jmrcode, String ucode, String acode, String rtime) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(qlcode_r.rcode, rcode);
        values.put(qlcode_r.qcode, qcode);
        values.put(qlcode_r.jmrcode, jmrcode);
        values.put(qlcode_r.ucode, ucode);
        values.put(qlcode_r.acode, acode);
        values.put(qlcode_r.rtime, rtime);
        db.insert(qlcode_r.TABLE_NAME, null, values);

        db.close();
    }

    public void insertqlcode_t(String jmrcode, String ucode, String n1001, String n1002, String n1003) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(qlcode_t.jmrcode, jmrcode);
        values.put(qlcode_t.ucode, ucode);
        values.put(qlcode_t.n1001, n1001);
        values.put(qlcode_t.n1002, n1002);
        values.put(qlcode_t.n1003, n1003);
        db.insert(qlcode_t.TABLE_NAME, null, values);

        db.close();
    }

    public void insertqlTable(String qlcode, String qlname, String qltext) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(qlTable.qlcode, qlcode);
        values.put(qlTable.qlname, qlname);
        values.put(qlTable.qltext, qltext);
        db.insert(qlTable.TABLE_NAME, null, values);

        db.close();
    }

    public void insertn1001_a(String acode, String atype, String apos, String aqoute, String afunc, String agoto, String ascour) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(n1001_a.acode, acode);
        values.put(n1001_a.atype, atype);
        values.put(n1001_a.apos, apos);
        values.put(n1001_a.aqoute, aqoute);
        values.put(n1001_a.afunc, afunc);
        values.put(n1001_a.agoto, agoto);
        values.put(n1001_a.ascour, ascour);
        db.insert(n1001_a.TABLE_NAME, null, values);

        db.close();
    }

    public void insertn2001_a(String acode, String atype, String apos, String aqoute, String afunc, String agoto, String ascour) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(n2001_a.acode, acode);
        values.put(n2001_a.atype, atype);
        values.put(n2001_a.apos, apos);
        values.put(n2001_a.aqoute, aqoute);
        values.put(n2001_a.afunc, afunc);
        values.put(n2001_a.agoto, agoto);
        values.put(n2001_a.ascour, ascour);
        db.insert(n2001_a.TABLE_NAME, null, values);

        db.close();
    }

    public void insertn3001_a(String acode, String atype, String apos, String aqoute, String afunc, String agoto, String ascour) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(n3001_a.acode, acode);
        values.put(n3001_a.atype, atype);
        values.put(n3001_a.apos, apos);
        values.put(n3001_a.aqoute, aqoute);
        values.put(n3001_a.afunc, afunc);
        values.put(n3001_a.agoto, agoto);
        values.put(n3001_a.ascour, ascour);
        db.insert(n3001_a.TABLE_NAME, null, values);

        db.close();
    }

    public void insertn1001_q(String qcode, String qtype, String qpos, String qqoute, String qfunc, String qgoto, String qscour) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(n1001_q.qcode, qcode);
        values.put(n1001_q.qtype, qtype);
        values.put(n1001_q.qpos, qpos);
        values.put(n1001_q.qqoute, qqoute);
        values.put(n1001_q.qfunc, qfunc);
        values.put(n1001_q.qgoto, qgoto);
        values.put(n1001_q.qscour, qscour);
        db.insert(n1001_q.TABLE_NAME, null, values);

        db.close();
    }

    public void insertn2001_q(String qcode, String qtype, String qpos, String qqoute, String qfunc, String qgoto, String qscour) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(n2001_q.qcode, qcode);
        values.put(n2001_q.qtype, qtype);
        values.put(n2001_q.qpos, qpos);
        values.put(n2001_q.qqoute, qqoute);
        values.put(n2001_q.qfunc, qfunc);
        values.put(n2001_q.qgoto, qgoto);
        values.put(n2001_q.qscour, qscour);
        db.insert(n2001_q.TABLE_NAME, null, values);

        db.close();
    }

    public void insertn3001_q(String qcode, String qtype, String qpos, String qqoute, String qfunc, String qgoto, String qscour) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(n3001_q.qcode, qcode);
        values.put(n3001_q.qtype, qtype);
        values.put(n3001_q.qpos, qpos);
        values.put(n3001_q.qqoute, qqoute);
        values.put(n3001_q.qfunc, qfunc);
        values.put(n3001_q.qgoto, qgoto);
        values.put(n3001_q.qscour, qscour);
        db.insert(n3001_q.TABLE_NAME, null, values);

        db.close();
    }
*/
    private LoginTable getRowLogin(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(LoginTable.TABLE_NAME,
                new String[]{ LoginTable.jmr_user, LoginTable.jmr_pass, LoginTable.jmr_code,
                        LoginTable.COLUMN_ID},
                LoginTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        LoginTable tableRow = new LoginTable(
                cursor.getString(cursor.getColumnIndex(LoginTable.jmr_user)),
                cursor.getString(cursor.getColumnIndex(LoginTable.jmr_pass)),
                cursor.getString(cursor.getColumnIndex(LoginTable.jmr_code)),
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
                        QuestionTable1.COLUMN_PART, QuestionTable1.COLUMN_ID,
                        QuestionTable1.COLUMN_CODE, QuestionTable1.COLUMN_FUNC},
                QuestionTable1.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        QuestionTable1 tableRow = new QuestionTable1(
                cursor.getString(cursor.getColumnIndex(QuestionTable1.COLUMN_QUESTION)),
                cursor.getString(cursor.getColumnIndex(QuestionTable1.COLUMN_POSITION)),
                cursor.getString(cursor.getColumnIndex(QuestionTable1.COLUMN_PART)),
                cursor.getInt(cursor.getColumnIndex(QuestionTable1.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(QuestionTable1.COLUMN_CODE)),
                cursor.getString(cursor.getColumnIndex(QuestionTable1.COLUMN_FUNC)));
        cursor.close();

        return tableRow;
    }


    public AnswerTable1 getRowAnswer(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(AnswerTable1.TABLE_NAME,
                new String[]{ AnswerTable1.COLUMN_ID, AnswerTable1.COLUMN_QUESTION_ID, AnswerTable1.COLUMN_ANSWER,
                        AnswerTable1.COLUMN_MODE, AnswerTable1.COLUMN_POSITION,
                        AnswerTable1.COLUMN_GOTO, AnswerTable1.COLUMN_SCOUR, AnswerTable1.COLUMN_FUNCTION},
                AnswerTable1.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        AnswerTable1 tableRow = new AnswerTable1(
                cursor.getInt(cursor.getColumnIndex(AnswerTable1.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(AnswerTable1.COLUMN_QUESTION_ID)),
                cursor.getString(cursor.getColumnIndex(AnswerTable1.COLUMN_ANSWER)),
                cursor.getString(cursor.getColumnIndex(AnswerTable1.COLUMN_MODE)),
                cursor.getString(cursor.getColumnIndex(AnswerTable1.COLUMN_POSITION)),
                cursor.getString(cursor.getColumnIndex(AnswerTable1.COLUMN_GOTO)),
                cursor.getString(cursor.getColumnIndex(AnswerTable1.COLUMN_SCOUR)),
                cursor.getString(cursor.getColumnIndex(AnswerTable1.COLUMN_FUNCTION)));
        cursor.close();

        return tableRow;
    }

    public SaveTable getRowSave(long id) {
//        if(id==0)
//            id++;
//        Log.d(TAG, " id is  "+id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(SaveTable.TABLE_NAME,
                new String[]{ SaveTable.COLUMN_ID, SaveTable.COLUMN_QUESTION_ID, SaveTable.COLUMN_ANSWER_ID,
                        SaveTable.COLUMN_PORSESHNAME_ID, SaveTable.COLUMN_USER, SaveTable.DELETE},
                SaveTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        SaveTable tableRow = null;

        if (cursor != null)
            if(cursor.moveToFirst()) {
//                Log.d(TAG, "getRowSave: cursor is not null");

                 tableRow = new SaveTable(
                        cursor.getInt(cursor.getColumnIndex(SaveTable.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(SaveTable.COLUMN_QUESTION_ID)),
                        cursor.getString(cursor.getColumnIndex(SaveTable.COLUMN_ANSWER_ID)),
                        cursor.getString(cursor.getColumnIndex(SaveTable.COLUMN_PORSESHNAME_ID)),
                        cursor.getString(cursor.getColumnIndex(SaveTable.COLUMN_USER)),
                        cursor.getString(cursor.getColumnIndex(SaveTable.DELETE)));

           }
        cursor.close();
//        Log.d(TAG, "getRowSave: table row is null "+(tableRow == null));

        return tableRow;
    }
/*
    public LogTable getLogTable(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(LogTable.TABLE_NAME,
                new String[]{ LogTable.COLUMN_ID, LogTable.Jmr_code, LogTable.Time,
                        LogTable.Column_do},
                LogTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        LogTable tableRow = new LogTable(
                cursor.getInt(cursor.getColumnIndex(LogTable.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(LogTable.Jmr_code)),
                cursor.getString(cursor.getColumnIndex(LogTable.Time)),
                cursor.getString(cursor.getColumnIndex(LogTable.Column_do)));
        cursor.close();

        return tableRow;
    }

    public qlcode_r getqlcode_r(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(qlcode_r.TABLE_NAME,
                new String[]{ qlcode_r.COLUMN_ID, qlcode_r.rcode, qlcode_r.qcode,
                        qlcode_r.jmrcode, qlcode_r.ucode, qlcode_r.acode, qlcode_r.rtime},
                qlcode_r.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        qlcode_r tableRow = new qlcode_r(
                cursor.getString(cursor.getColumnIndex(qlcode_r.rcode)),
                cursor.getString(cursor.getColumnIndex(qlcode_r.qcode)),
                cursor.getString(cursor.getColumnIndex(qlcode_r.jmrcode)),
                cursor.getString(cursor.getColumnIndex(qlcode_r.ucode)),
                cursor.getString(cursor.getColumnIndex(qlcode_r.acode)),
                cursor.getString(cursor.getColumnIndex(qlcode_r.rtime)),
                cursor.getInt(cursor.getColumnIndex(qlcode_r.COLUMN_ID)));
                cursor.close();

        return tableRow;
    }

    public qlcode_t getqlcode_t(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(qlcode_t.TABLE_NAME,
                new String[]{ qlcode_t.COLUMN_ID, qlcode_t.jmrcode, qlcode_t.ucode,
                        qlcode_t.n1001, qlcode_t.n1002, qlcode_t.n1003},
                qlcode_t.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        qlcode_t tableRow = new qlcode_t(
                cursor.getString(cursor.getColumnIndex(qlcode_t.jmrcode)),
                cursor.getString(cursor.getColumnIndex(qlcode_t.ucode)),
                cursor.getString(cursor.getColumnIndex(qlcode_t.n1001)),
                cursor.getString(cursor.getColumnIndex(qlcode_t.n1002)),
                cursor.getString(cursor.getColumnIndex(qlcode_t.n1003)),
                cursor.getInt(cursor.getColumnIndex(qlcode_t.COLUMN_ID)));
        cursor.close();

        return tableRow;
    }

    public qlTable getqlTable(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(qlTable.TABLE_NAME,
                new String[]{ qlTable.COLUMN_ID, qlTable.qlcode, qlTable.qlname,
                        qlTable.qltext},
                qlTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        qlTable tableRow = new qlTable(
                cursor.getString(cursor.getColumnIndex(qlTable.qlcode)),
                cursor.getString(cursor.getColumnIndex(qlTable.qlname)),
                cursor.getString(cursor.getColumnIndex(qlTable.qltext)),
                cursor.getInt(cursor.getColumnIndex(qlTable.COLUMN_ID)));
        cursor.close();

        return tableRow;
    }
*/
    private int getRowsCount(String tableName) {
        String countQuery = "SELECT  * FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
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
        String countQuery = "SELECT  * FROM " + AnswerTable1.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public int getRowsCountSave() {
        String countQuery = "SELECT  * FROM " + SaveTable.TABLE_NAME;
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
                LoginTable.jmr_user +" = '"+ username +"' AND " + LoginTable.jmr_pass + " = '"+ password+ "' ;";
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


    public ArrayList<String> getQuestionnaires(){
        ArrayList<String> questionnaires = new ArrayList<>();
        for(int i = 1; i<=getRowsCountQuestionnaire(); i++)
            questionnaires.add(getRowQuestionnaire(i).getName()+"\n"+getRowQuestionnaire(i).getText());
        return questionnaires;
    }

    public ArrayList<SaveObject> getAllSaves(String user){
        ArrayList<SaveObject> array = new ArrayList<>();
        for(int i = 1; i <= getRowsCountSave(); i++){
//        for(int i = 1; i <=7 ; i++){
//            Log.d(TAG, "row count save "+getRowsCountSave());
//            Log.d(TAG, " i is  "+i);
            SaveTable svtbl = getRowSave(i);
//            Log.d(TAG, "svtbl is null "+ (svtbl==null));
            SaveObject saveObject = null;
            if(svtbl != null) {
                saveObject = new SaveObject(svtbl.getColumnQuestionId(), svtbl.getColumnAnswerId(),
                        svtbl.getColumnPorseshnameId(), svtbl.getColumnUser(), svtbl.getDelete());

                if (saveObject.getUser().equals(user))
//                    if(saveObject.getDelete().equals("saved"))
                    array.add(saveObject);
            }
        }
        return array;
    }

    public void deletSingleRowSaveTable(long id){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(SaveTable.TABLE_NAME, SaveTable.COLUMN_ID + " = " + id, null);

//        String DeleteQuery = "DELETE * FROM " + SaveTable.TABLE_NAME ;
//        String DeleteQuery = "DELETE FROM " + SaveTable.TABLE_NAME ;
//        String DeleteQuery = "";
//        String DeleteQuery = "DELETE FROM " + SaveTable.TABLE_NAME +" WHERE "+ SaveTable.COLUMN_ID +" = "+id;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(DeleteQuery, null);

//       cursor.close();
            try {
                db.execSQL("DELETE FROM  saveResult" + " WHERE id="
                        + id + ";");
                Log.d(TAG, "deletSingleRowSaveTable:  this id is deleted "+id);
            } catch (Exception e) {
                Log.d(TAG, "deletSingleRowSaveTable: is has a exception"+ e);
            }

    }

    public long getIdOfSelectedAnswer(String porseshnameId, String username, String questionId, String answerId){
        String searchQuery = " SELECT * FROM " + SaveTable.TABLE_NAME + " WHERE " +
                SaveTable.COLUMN_PORSESHNAME_ID +" = '"+ porseshnameId +"' AND " + SaveTable.COLUMN_USER + " = '"+ username
                +"' AND "+ SaveTable.COLUMN_QUESTION_ID+ " = '"+ questionId+ "' AND "+ SaveTable.COLUMN_ANSWER_ID +" = '"+ answerId+"' ;";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(searchQuery, null);
        long id = -1;
        if(cursor != null && cursor.moveToFirst()) {
            id = cursor.getLong(cursor.getColumnIndex(SaveTable.COLUMN_ID));

            cursor.close();
        }
        return id ;

    }

    public void setSavedToDelete(String id) {
        int idd = Integer.valueOf(id);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SaveTable.DELETE, "deleted"); //These Fields should be your String values of actual column names
        db.update(SaveTable.TABLE_NAME, cv, "id=" + id, null);
//        Log.d(TAG, "setSavedToDelete: answer is set to delet : " + getRowSave(idd).getDelete());
    }

    public void setSavedToSaved(String id) {
        int idd = Integer.valueOf(id);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SaveTable.DELETE, "saved"); //These Fields should be your String values of actual column names
        db.update(SaveTable.TABLE_NAME, cv, "id=" + id, null);
//        Log.d(TAG, "setSavedToDelete: answer is set to delet : " + getRowSave(idd).getDelete());
    }

    private boolean searchInSave(String porseshnameId, String username, String questionId, String answerId){
        String searchQuery = " SELECT * FROM " + SaveTable.TABLE_NAME + " WHERE " +
                SaveTable.COLUMN_PORSESHNAME_ID +" = '"+ porseshnameId +"' AND " + SaveTable.COLUMN_USER + " = '"+ username
                +"' AND "+ SaveTable.COLUMN_QUESTION_ID+ " = '"+ questionId+ "' AND "+ SaveTable.COLUMN_ANSWER_ID +" = '"+ answerId+"' ;";
        SQLiteDatabase db = this.getReadableDatabase();

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
