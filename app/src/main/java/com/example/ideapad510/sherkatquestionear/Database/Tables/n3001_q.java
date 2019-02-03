package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class n3001_q {
    public static final String TABLE_NAME = "n3001_q";
    public static final String COLUMN_ID = "id";
    public static final String qcode = "qcode";
    public static final String qtype = "qtype";
    public static final String qpos = "qpos";
    public static final String qqoute = "qqoute";
    public static final String qfunc = "qfunc";
    public static final String qgoto = "qgoto";
    public static final String qscour = "qscour";

    private int id;
    private String Qcode;
    private String Qtype;
    private String Qpos;
    private String Qqoute;
    private String Qfunc;
    private String Qgoto;
    private String Qscour;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + qcode + " TEXT,"
                    + qtype + " TEXT,"
                    + qpos + " TEXT,"
                    + qqoute + " TEXT,"
                    + qfunc + " TEXT,"
                    + qgoto + " TEXT,"
                    + qscour + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public n3001_q(String Qcode, String Qtype, String Qpos , String Qqoute, String Qfunc, String Qgoto , String Qscour, int id) {
        this.id = id;
        this.Qcode = Qcode;
        this.Qtype = Qtype;
        this.Qpos = Qpos;
        this.Qqoute = Qqoute;
        this.Qfunc = Qfunc;
        this.Qgoto = Qgoto;
        this.Qscour = Qscour;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getQcode() {return Qcode;}

    public String getQtype() {return Qtype;}

    public String getQpos() {return Qpos;}
}