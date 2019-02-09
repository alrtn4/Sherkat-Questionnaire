package com.example.ideapad510.sherkatquestionear.Database;

/**
 * Created by Ideapad 510 on 2/7/2019.
 */

public class DatabaseIgnoredMethods {
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
/*
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
*/

}
