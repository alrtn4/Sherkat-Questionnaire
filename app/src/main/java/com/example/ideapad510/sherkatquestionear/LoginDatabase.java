package com.example.ideapad510.sherkatquestionear;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static String DATABASE_NAME = "Table_db";

    public LoginDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoginTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LoginTable.TABLE_NAME);
        onCreate(db);
    }


    public long insertRow(String note1, String note2) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(LoginTable.COLUMN_NOTE1, note1);
        values.put(LoginTable.COLUMN_NOTE2, note2);
        long id =db.insert(LoginTable.TABLE_NAME, null, values);

        db.close();

        return id;
    }


    private LoginTable getRow(long id) {
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

    public int getRowsCount() {
        String countQuery = "SELECT  * FROM " + LoginTable.TABLE_NAME;
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
            items.add(new SimpleRow(this.getRow(i).getUsername(),this.getRow(i).getPassword(),this.getRow(i).getNote3(),
                    this.getRow(i).getNote4(),this.getRow(i).getNote5()));
        }

        return items;
    }
*/

    public boolean searchInDatabase(String username, String password){
        for(int i=1; i <= getRowsCount(); i++){
//            System.out.println(getRow(i).getUsername()"ali"+ getRow(i).getUsername());

            if((getRow(i).getUsername().equals(username)) & (getRow(i).getPassword().equals(password))) {
                System.out.println("  its a match  ");
                return true;
            }
        }
//        System.out.println("  its not a match  ");

        return false;
    }
}