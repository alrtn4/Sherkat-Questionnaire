package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class n2001_a {
    public static final String TABLE_NAME = "n2001_a";
    public static final String COLUMN_ID = "id";
    public static final String acode = "acode";
    public static final String atype = "atype";
    public static final String apos = "apos";
    public static final String aqoute = "aqoute";
    public static final String afunc = "afunc";
    public static final String agoto = "agoto";
    public static final String ascour = "ascour";

    private int id;
    private String Acode;
    private String Atype;
    private String Apos;
    private String Aqoute;
    private String Afunc;
    private String Agoto;
    private String Ascour;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + acode + " TEXT,"
                    + atype + " TEXT,"
                    + apos + " TEXT,"
                    + aqoute + " TEXT,"
                    + afunc + " TEXT,"
                    + agoto + " TEXT,"
                    + ascour + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public n2001_a(String acode, String atype, String apos , String aqoute, String afunc, String agoto , String ascour, int id) {
        this.id = id;
        this.Acode = acode;
        this.Atype = atype;
        this.Apos = apos;
        this.Aqoute = aqoute;
        this.Afunc = afunc;
        this.Agoto = agoto;
        this.Ascour = ascour;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getAcode() {return Acode;}

    public String getAtype() {return Atype;}

    public String getApos() {return Apos;}
}