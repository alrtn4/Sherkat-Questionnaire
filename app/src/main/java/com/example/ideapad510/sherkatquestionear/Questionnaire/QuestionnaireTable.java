package com.example.ideapad510.sherkatquestionear.Questionnaire;

public class QuestionnaireTable {
    public static final String TABLE_NAME = "qqq";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "questionnaireName";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_PART_1 = "part1";
    public static final String COLUMN_PART_2 = "part2";
    public static final String COLUMN_PART_3 = "part3";
    public static final String COLUMN_PART_4 = "part4";

    private int id;
    private String name;
    private String text;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TEXT + " TEXT,"
                    + COLUMN_PART_1 + " TEXT,"
                    + COLUMN_PART_2 + " TEXT,"
                    + COLUMN_PART_3 + " TEXT,"
                    + COLUMN_PART_4 + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public QuestionnaireTable(String name, String text, String part1,  String part2, String part3,
                              String part4, int id) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public String getText() {return text;}

    public String getPart1() {return part1;}

    public String getPart2() {return part2;}

    public String getPart3() {return part3;}

    public String getPart4() {return part4;}

}