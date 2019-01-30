package com.example.ideapad510.sherkatquestionear.Questions;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerListAdapter;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class Questions extends AppCompatActivity{
    private TextView questionTitle;
    private ListView answersList;
    private TextView part;
    private ArrayList<String> answers;
    private AnswerController answerControler = new AnswerController(this);
    private QuestionController questionControler = new QuestionController(this);
    private ArrayList<QuestionObject> questionObjectArrayList = new ArrayList<>();
    private int pageNumber = 0;
    private ArrayList<QuestionListDemandObject> qlda = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

//        new QuestionController(this).insertQuestionArray(new QuestionsAnswersArray());
//        new AnswerController(this).insertAnswerArray(new QuestionsAnswersArray());

        answersList = findViewById(R.id.answersList);
//        addRadioButtons(10);
        questionTitle = findViewById(R.id.questionTitle);
        part = findViewById(R.id.part);

//        findingPartedQuestions();
//        findingRandomPartedQuestions();
//        mergeFoundQuestions();

        getListOfQuestionTables();
        refreshPage();
        onClickListView();
    }

    private void onClickListView(){
        answersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //because start of database and list are different
                position++;
//                showPosDialog(position);
            }
        });
    }

/*    private void showPosDialog(int position) {
        FragmentManager fm = getSupportFragmentManager();
        Dialog_Fragment dialog_Fragment = Dialog_Fragment.newInstance(""+ position);
        dialog_Fragment.show(fm, "fragment_edit_name");
    }
*/


/*
    private void findingPartedQuestions() {
        if (part1State.equals("Y"))
            questionObjectArrayListPart1 = questionControler.getPartedQuestionObjects(1);
        if (part2State.equals("Y"))
            questionObjectArrayListPart2 = questionControler.getPartedQuestionObjects(2);
        if (part3State.equals("Y"))
            questionObjectArrayListPart3 = questionControler.getPartedQuestionObjects(3);
        if (part4State.equals("Y"))
            questionObjectArrayListPart4 = questionControler.getPartedQuestionObjects(4);
    }

     private void findingRandomPartedQuestions(){
        if(part1State.equals("R"))
            questionObjectArrayListPart1 = questionControler.getRandomQuestionObjects(1);
        if(part2State.equals("R"))
            questionObjectArrayListPart2 = questionControler.getRandomQuestionObjects(2);
        if(part3State.equals("R"))
            questionObjectArrayListPart3 = questionControler.getRandomQuestionObjects(3);
        if(part4State.equals("R"))
            questionObjectArrayListPart4 = questionControler.getRandomQuestionObjects(4);
     }

    private void mergeFoundQuestions(){
        questionObjectArrayList.addAll(questionObjectArrayListPart1);
        questionObjectArrayList.addAll(questionObjectArrayListPart2);
        questionObjectArrayList.addAll(questionObjectArrayListPart3);
        questionObjectArrayList.addAll(questionObjectArrayListPart4);
    }
*/
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
        int positionInArray = pageNumber;
        questionObjectArrayList = getQuestionObjectArrayList(qlda);

        part.setText("PART : " + questionObjectArrayList.get(positionInArray).getQuestionPart());
        questionTitle.setText((questionObjectArrayList.get(positionInArray)).getQuestionText());
        findingAnswers();
//        addRadioButtons(answers.size());
        AnswerListAdapter adapter = new AnswerListAdapter(this, answers);
        answersList.setAdapter(adapter);
    }
/*
    public void addRadioButtons(int number) {
        for (int row = 0; row < 1; row++) {
            RadioGroup ll = new RadioGroup(this);
//            ll.setOrientation(LinearLayout.VERTICAL);

            for (int i = 1; i <= number; i++) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(View.generateViewId());
                rdbtn.setScaleX((float)0.5);
                rdbtn.setScaleY((float)0.5);
                rdbtn.setTextSize(30);
//                rdbtn.setGravity(Gravity.LEFT);
                rdbtn.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                rdbtn.setText(answers.get(i - 1));
                ll.addView(rdbtn);
            }
            ((ViewGroup) findViewById(R.id.radioGroup)).addView(ll);
        }
    }
*/
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
//        System.out.println("the size of qlda: "+qlda.size());
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

}
