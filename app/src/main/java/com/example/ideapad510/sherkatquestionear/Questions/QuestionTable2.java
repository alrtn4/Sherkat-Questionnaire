package com.example.ideapad510.sherkatquestionear.Questions;

public class QuestionTable2 {
    public static final String TABLE_NAME = "question2";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUESTION = "questionTXT";
    public static final String COLUMN_POSITION = "position";
    public static final String COLUMN_PART = "part";
    public static final String COLUMN_NAMAYESH = "namayesh";
    public static final String COLUMN_FUNCTION = "function";

    private int id;
    private String question;
    private String position;
    private String part;
    private String namayesh;
    private String function;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_QUESTION + " TEXT,"
                    + COLUMN_POSITION + " TEXT,"
                    + COLUMN_PART + " TEXT,"
                    + COLUMN_NAMAYESH + " TEXT,"
                    + COLUMN_FUNCTION + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";

    public QuestionTable2(String question, String position, String part, String namayesh, String function, int id) {
        this.id = id;
        this.question = question;
        this.position = position;
        this.part = part;
        this.namayesh = namayesh;
        this.function = function;
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getQuestion() {return question;}

    public String getPosition() {return position;}

    public String getPart() {return part;}

}