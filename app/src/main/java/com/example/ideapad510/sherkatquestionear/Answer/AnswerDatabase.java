package com.example.ideapad510.sherkatquestionear.Answer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AnswerDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static String DATABASE_NAME = "Table_db";

    public AnswerDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AnswerTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AnswerTable.TABLE_NAME);
        onCreate(db);
    }


    public long insertRow(String questionID, String answer, String mode, String position) {
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


    private AnswerTable getRow(long id) {
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

    public int getRowsCount() {
        String countQuery = "SELECT  * FROM " + AnswerTable.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public ArrayList<String> getIdAnswers(int questionID){
        ArrayList<String> idAnswers = new ArrayList<>();
        for(int i=1; i<=getRowsCount(); i++){
            if(getRow(i).getQuestionID().equals(String.valueOf(questionID)))
                idAnswers.add(getRow(i).getAnswer());
        }
        return idAnswers;
    }

/*
    public ArrayList<SimpleRow> convertRowsToSimpleRows(){
        ArrayList<SimpleRow> items = new ArrayList<>();
        int count = getRowsCount();
        for(int i=1; i<=count; i++){
            items.add(new SimpleRow(this.getRow(i).getUsername(),this.getRow(i).getPassword(),this.getRow(i).getNote3(),
                    this.getRow(i).getNote4(),this.getRow(i).getNote5()));
        }

        return items;
    }
*/
/*
    public boolean searchInDatabase(String username, String password) {
        for (int i = 1; i <= getRowsCount(); i++) {
//            System.out.println(getRow(i).getUsername()"ali"+ getRow(i).getUsername());

            if ((getRow(i).getUsername().equals(username)) & (getRow(i).getPassword().equals(password))) {
                System.out.println("  its a match  ");
                return true;
            }
        }
//        System.out.println("  its not a match  ");

        return false;
    }
*/
}