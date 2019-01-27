package com.example.ideapad510.sherkatquestionear.Questions;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class Questions extends AppCompatActivity{
    private TextView questionTitle;
    private ListView answersList;
    private ArrayList<String> answers;
    private AnswerControler answerControler = new AnswerControler(this);
    private QuestionControler questionControler = new QuestionControler(this);
    private ArrayList<QuestionObject> questionObjectArrayList = new ArrayList<>();
    private ArrayList<QuestionObject> questionObjectArrayListPart1 = new ArrayList<>();
    private ArrayList<QuestionObject> questionObjectArrayListPart2 = new ArrayList<>();
    private ArrayList<QuestionObject> questionObjectArrayListPart3 = new ArrayList<>();
    private ArrayList<QuestionObject> questionObjectArrayListPart4 = new ArrayList<>();
    private int questionId;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private int pageNumber = 0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

//        sampleAnswers();
//        sampleQuestions();

        answersList = findViewById(R.id.answersList);
//        questionId = getIntent().getIntExtra("position",1);
        //because of difference between start in listview and database
//        questionId++;

        part1 = getIntent().getStringExtra("part1");
        part2 = getIntent().getStringExtra("part2");
        part3 = getIntent().getStringExtra("part3");
        part4 = getIntent().getStringExtra("part4");

        findingPartedQuestions();
        findingRandomPartedQuestions();
        mergeFoundQuestions();

        questionTitle = findViewById(R.id.questionTitle);

        refreshPage();
    }

    private void sampleQuestions(){
        questionControler.insertToDatabase("1+2?", "0", "1");
        questionControler.insertToDatabase("12+2?", "0", "1");
        questionControler.insertToDatabase("1+24?", "0", "2");
        questionControler.insertToDatabase("15+26?", "0", "2");
        questionControler.insertToDatabase("17+26?", "0", "3");
        questionControler.insertToDatabase("17+2?", "0", "3");
        questionControler.insertToDatabase("1+29?", "0", "4");
        questionControler.insertToDatabase("16+23?", "0", "4");
    }

    private void sampleAnswers(){
        answerControler.insertRow("1", "2","3","4");
        answerControler.insertRow("2", "28","3","4");
        answerControler.insertRow("3", "26","3","4");
        answerControler.insertRow("4", "27","3","4");
        answerControler.insertRow("5", "263","3","4");
        answerControler.insertRow("6", "29","3","4");
        answerControler.insertRow("7", "24","3","4");
        answerControler.insertRow("8", "226","3","4");
        answerControler.insertRow("9", "219","3","4");
        answerControler.insertRow("1", "267","3","4");
        answerControler.insertRow("2", "287","3","4");
        answerControler.insertRow("3", "266","3","4");
        answerControler.insertRow("4", "275","3","4");
        answerControler.insertRow("5", "264","3","4");
        answerControler.insertRow("6", "293","3","4");
        answerControler.insertRow("7", "246","3","4");
        answerControler.insertRow("8", "269","3","4");
        answerControler.insertRow("9", "299","3","4");
    }

    private void findingPartedQuestions() {
        if (part1.equals("Y"))
            questionObjectArrayListPart1 = questionControler.getPartedQuestionObjects(1);
        if (part2.equals("Y"))
            questionObjectArrayListPart2 = questionControler.getPartedQuestionObjects(2);
        if (part3.equals("Y"))
            questionObjectArrayListPart3 = questionControler.getPartedQuestionObjects(3);
        if (part4.equals("Y"))
            questionObjectArrayListPart4 = questionControler.getPartedQuestionObjects(4);
    }

     private void findingRandomPartedQuestions(){
        if(part1.equals("R"))
            questionObjectArrayListPart1 = questionControler.getRandomQuestionObjects(1);
        if(part2.equals("R"))
            questionObjectArrayListPart2 = questionControler.getRandomQuestionObjects(2);
        if(part3.equals("R"))
            questionObjectArrayListPart3 = questionControler.getRandomQuestionObjects(3);
        if(part4.equals("R"))
            questionObjectArrayListPart4 = questionControler.getRandomQuestionObjects(4);
     }

    private void mergeFoundQuestions(){
        questionObjectArrayList.addAll(questionObjectArrayListPart1);
        questionObjectArrayList.addAll(questionObjectArrayListPart2);
        questionObjectArrayList.addAll(questionObjectArrayListPart3);
        questionObjectArrayList.addAll(questionObjectArrayListPart4);
    }

    private void findingAnswers(){
//        question = db.getIdAnswers(questionId);
        int positionInArray = pageNumber;
        answers = new ArrayList<>();
        for(int i = 1; i <= answerControler.getRowCount(); i++)
            if((answerControler.getRow(i).getQuestionID()).
                    equals(String.valueOf(questionObjectArrayList.get(positionInArray).getQuestionId())))
                answers.add(answerControler.getRow(i).getAnswer());
    }

    public void onBackClicked(View view){
        if(!(pageNumber == 0)) {
            pageNumber--;
            refreshPage();
        }
    }

    public void onForwardClicked(View view){
        if(!(pageNumber == questionObjectArrayList.size() - 1)) {
            pageNumber++;
            refreshPage();
        }
    }

    private void refreshPage(){
        questionTitle.setText("Question : "+(questionObjectArrayList.get(pageNumber)).getQuestionText());
        findingAnswers();
        AnswerListAdapter adapter = new AnswerListAdapter(this, answers);
        answersList.setAdapter(adapter);
    }

    public void addRadioButtons(int number) {
        for (int row = 0; row < 1; row++) {
            RadioGroup ll = new RadioGroup(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            for (int i = 1; i <= number; i++) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(View.generateViewId());
                rdbtn.setText("Radio " + rdbtn.getId());
                ll.addView(rdbtn);
            }
//            ((ViewGroup) findViewById(R.id.radiogroup)).addView(ll);
        }
    }

}
