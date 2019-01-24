package com.example.ideapad510.sherkatquestionear.Question;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ideapad510.sherkatquestionear.Login.LoginTable;

import java.util.ArrayList;

public class QuestionDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static String DATABASE_NAME = "Table_db";

    public QuestionDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoginTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + LoginTable.TABLE_NAME);
//        onCreate(db);
        if(newVersion>oldVersion){
            db.execSQL("DROP TABLE IF EXISTS " + LoginTable.TABLE_NAME);
            onCreate(db);

        }

    }


    public long insertRow(String question, String position, String part) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QuestionTable.COLUMN_QUESTION, question);
        values.put(QuestionTable.COLUMN_POSITION, position);
        values.put(QuestionTable.COLUMN_PART, part);
        long id = db.insert(LoginTable.TABLE_NAME, null, values);

        db.close();

        return id;
    }


    private QuestionTable getRow(long id) {
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

    public int getRowsCount() {
        String countQuery = "SELECT  * FROM " + QuestionTable.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public ArrayList<String> getPartedQuestions(int part){
        ArrayList<String> partedQuestions = new ArrayList<>();
        for(int i=1; i<=getRowsCount(); i++){
            if(getRow(i).getPart().equals(String.valueOf(part)))
                partedQuestions.add(getRow(i).getQuestion());
        }
        return partedQuestions;
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