package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class qlTable {
    public static final String TABLE_NAME = "qlTable";
    public static final String COLUMN_ID = "id";
    public static final String qlfunction = "qlfunction";
    public static final String jmrcode = "jmrcode";

    private int id;
    private String Qlfunction;
    private String Jmrcode;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + qlfunction + " TEXT,"
                    + jmrcode + " TEXT "
                    + ")";


    public qlTable(String Qlfunction, String Jmrcode, int id) {
        this.id = id;
        this.Qlfunction = Qlfunction;
        this.Jmrcode = Jmrcode;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getQlfunction() {return Qlfunction;}

    public String getJmrcode() {return Jmrcode;}

}