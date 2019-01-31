package com.example.ideapad510.sherkatquestionear.Questions;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerListAdapter;
import com.example.ideapad510.sherkatquestionear.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Questions2 extends AppCompatActivity{
    private TextView questionTitle;
    private TextView part;
    private ArrayList<String> answers;
    private AnswerController answerControler = new AnswerController(this);
    private QuestionController questionControler = new QuestionController(this);
    private ArrayList<QuestionObject> questionObjectArrayList = new ArrayList<>();
    private int pageNumber = 0;
    private ArrayList<QuestionListDemandObject> qlda = new ArrayList<>();
    private static final String TAG = "question2";
    RadioGroup rg;
    Bundle b = new Bundle();


    @Override
    public void onCreate(Bundle savedInstanceState){
        b = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2);

//        new QuestionController(this).insertQuestionArray(new QuestionsAnswersArray());
//        new AnswerController(this).insertAnswerArray(new QuestionsAnswersArray());

//        rg= findViewById(R.id.radioGroup);

        getListOfQuestionTables();
        refreshPage();
    }


    private void findingAnswers(){
        //this method finds answers that belong to specific question based on
        // question id of question and answer's question id
        answers = new ArrayList<>();
        int positionInArray = pageNumber;
        answers = new ArrayList<>();
        for(int i = 1; i <= answerControler.getRowCount(); i++)
            if((answerControler.getRow(i).getQuestionID()).
                    equals(String.valueOf(questionObjectArrayList.get(positionInArray).getQuestionId())))
                answers.add(answerControler.getRow(i).getAnswer());
        System.out.println("answer size is : " + answers.size());
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
        setContentView(R.layout.question2);
        questionTitle = findViewById(R.id.questionTitle);
        part = findViewById(R.id.part);

        int positionInArray = pageNumber;
        questionObjectArrayList = getQuestionObjectArrayList(qlda);

        part.setText("PART : " + questionObjectArrayList.get(positionInArray).getQuestionPart());
        questionTitle.setText((questionObjectArrayList.get(positionInArray)).getQuestionText());
        findingAnswers();
//        MakeRadioButton rp = new MakeRadioButton(this);
//        rp.addRadioButtons(answers.size(), answers);
        addRadioButtons(answers.size());
//        addRadioButtons(2);

    }

    public void addRadioButtons(int number) {
        RadioGroup ll = findViewById(R.id.radioGroup);

        for (int i = 1; i <= number; i++) {
            RadioButton rdbtn = new RadioButton(this);
//                rdbtn.setId(View.generateViewId());
//                rdbtn.setScaleX((float)0.5);
//                rdbtn.setScaleY((float)0.5);
            rdbtn.setTextSize(20);
            rdbtn.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            rdbtn.setText(answers.get(i - 1));
            ll.addView(rdbtn);
        }
    }

    private void getListOfQuestionTables(){
        String demand = getIntent().getStringExtra("QT");
        String[] questionTables = demand.split("-");
        for(String s: questionTables) {
            String[] s1 = s.split("/");
            String startPosition = s1[1];
            String[] s2 = s1[0].split("\"");
            String questionTableName = s2[1];
            QuestionListDemandObject qldo = new QuestionListDemandObject(questionTableName, startPosition);
            qlda.add(qldo);
        }
    }

    private ArrayList<QuestionObject> getQuestionObjectArrayList(ArrayList<QuestionListDemandObject> qlda){
        ArrayList<QuestionObject> qoa = new ArrayList<>();

        for(QuestionListDemandObject qldo : qlda)
            switch(qldo.getQuestionTableName()){
                case QuestionTable1.TABLE_NAME:
                    qoa.addAll(questionControler.getQuestionsFromQuestionTable1(qldo.getStartPosition()));
            }

        return qoa;
    }






/*

    protected void onPostExecute(HashMap<String,String> mylist) {
        // TODO Auto-generated method stub
        super.onPostExecute(mylist);
        for(Integer z=0;z<mRG.getChildCount();z++){
            View o =mRG.getChildAt(z);
            ((RadioButton)o).setText(text[z]);

        }

        for(Integer z =0;z< mRG.getChildCount();z++){

            Set set = mylist.entrySet();
            Iterator i = set.iterator();
            View o = mRG.getChildAt(z);

            NumberFormat formatter = new DecimalFormat("#0.00");

            if (o instanceof RadioButton){


                int counted[] = new int[ mRG.getChildCount()];
                int j=0;
                while(i.hasNext()) {


                    enter code here
                    Map.Entry me = (Map.Entry)i.next();
                    String Value=String.valueOf(formatter.format(Double.valueOf(me.getValue().toString())*100/count))+"%";
                    if (Integer.valueOf(me.getKey().toString())==((RadioButton) o).getId())
                    {

                        ((RadioButton)o).setText(text[z]+" "+ Value);
                    }



                }
            }
        }
        progressDialog.hide();
    }

*/

}
