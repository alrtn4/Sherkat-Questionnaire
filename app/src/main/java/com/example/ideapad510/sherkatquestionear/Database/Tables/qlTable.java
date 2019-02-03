package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class qlTable {
    public static final String TABLE_NAME = "qlTable";
    public static final String COLUMN_ID = "id";
    public static final String qlcode = "qlcode";
    public static final String qlname = "qlname";
    public static final String qltext = "qltext";

    private int id;
    private String Qlcode;
    private String Qlname;
    private String Qltext;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + qlcode + " TEXT,"
                    + qlname + " TEXT,"
                    + qltext + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public qlTable(String Qlcode, String Qlname, String Qltext, int id) {
        this.id = id;
        this.Qlcode = Qlcode;
        this.Qlname = Qlname;
        this.Qltext = Qltext;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getQlcode() {return Qlcode;}

    public String getQlname() {return Qlname;}

    public String getQltext() {return Qltext;}
}