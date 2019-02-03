package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class qlcode_r {
    public static final String TABLE_NAME = "qlcode_r";
    public static final String COLUMN_ID = "id";
    public static final String rcode = "rcode";
    public static final String qcode = "qcode";
    public static final String jmrcode = "jmrcode";
    public static final String ucode = "ucode";
    public static final String acode = "acode";
    public static final String rtime = "rtime";

    private int id;
    private String Rcode;
    private String Qcode;
    private String Jmrcode;
    private String Ucode;
    private String Acode;
    private String Rtime;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + rcode + " TEXT,"
                    + qcode + " TEXT,"
                    + jmrcode + " TEXT,"
                    + ucode + " TEXT,"
                    + acode + " TEXT,"
                    + rtime + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public qlcode_r(String Rcode, String Qcode, String Jmrcode , String Ucode, String Acode, String Rtime , int id) {
        this.id = id;
        this.Rcode = Rcode;
        this.Qcode = Qcode;
        this.Jmrcode = Jmrcode;
        this.Ucode = Ucode;
        this.Acode = Acode;
        this.Rtime = Rtime;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getRcode() {return Rcode;}

    public String getQcode() {return Qcode;}

    public String getJmrcode() {return Jmrcode;}
}