package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class qlcode_t {
    public static final String TABLE_NAME = "n1001_a";
    public static final String COLUMN_ID = "id";
    public static final String jmrcode = "jmrcode";
    public static final String ucode = "ucode";
    public static final String n1001 = "n1001";
    public static final String n1002 = "n1002";
    public static final String n1003 = "n1003";

    private int id;
    private String Jmrcode;
    private String Ucode;
    private String N1001;
    private String N1002;
    private String N1003;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + jmrcode + " TEXT,"
                    + ucode + " TEXT,"
                    + n1001 + " TEXT,"
                    + n1002 + " TEXT,"
                    + n1003 + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public qlcode_t(String Jmrcode, String Ucode, String N1001 , String N1002, String N1003, int id) {
        this.id = id;
        this.Jmrcode = jmrcode;
        this.Ucode = Ucode;
        this.N1001 = N1001;
        this.N1002 = N1002;
        this.N1003 = N1003;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getJmrcode() {return Jmrcode;}

    public String getUcode() {return Ucode;}

    public String getN1001() {return N1001;}
}