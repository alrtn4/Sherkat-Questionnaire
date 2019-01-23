package com.example.ideapad510.sherkatquestionear;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Table_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableRow.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableRow.TABLE_NAME);
        onCreate(db);
    }


    public long insertRow(String note1, String note2, String note3, String note4, String note5) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TableRow.COLUMN_NOTE1, note1);
        values.put(TableRow.COLUMN_NOTE2, note2);
        long id =db.insert(TableRow.TABLE_NAME, null, values);

        db.close();

        return id;
    }


    private TableRow getRow(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TableRow.TABLE_NAME,
                new String[]{ TableRow.COLUMN_NOTE1, TableRow.COLUMN_NOTE2,
                    TableRow.COLUMN_ID},
                TableRow.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        TableRow tableRow = new TableRow(
                cursor.getString(cursor.getColumnIndex(TableRow.COLUMN_NOTE1)),
                cursor.getString(cursor.getColumnIndex(TableRow.COLUMN_NOTE2)),
                cursor.getInt(cursor.getColumnIndex(TableRow.COLUMN_ID)));

        cursor.close();

        return tableRow;
    }

    public int getRowsCount() {
        String countQuery = "SELECT  * FROM " + TableRow.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }
/*
    public ArrayList<SimpleRow> convertRowsToSimpleRows(){
        ArrayList<SimpleRow> items = new ArrayList<>();
        int count = getRowsCount();
        for(int i=1; i<=count; i++){
            items.add(new SimpleRow(this.getRow(i).getNote1(),this.getRow(i).getNote2(),this.getRow(i).getNote3(),
                    this.getRow(i).getNote4(),this.getRow(i).getNote5()));
        }

        return items;
    }
*/
}