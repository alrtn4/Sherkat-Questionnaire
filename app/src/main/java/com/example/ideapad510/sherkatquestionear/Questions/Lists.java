package com.example.ideapad510.sherkatquestionear.Questions;

import android.app.Activity;
import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionTable;
import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;

import java.util.ArrayList;

/**
 * Created by Ideapad 510 on 2/7/2019.
 */

public class Lists {
    Activity activity;
    int pageNumber;
    QuestionController questionController;
    AnswerController answerController;
    String TAG = "listcontroller";
    Params params = Params.getInstance();

    public Lists(Activity activity, int pageNumber, Context context) {
        this.activity = activity;
        this.pageNumber = pageNumber;
        questionController = new QuestionController(context);
        answerController = new AnswerController(context);

    }

    public ArrayList<QuestionDemand> getListOfQuestionTables(){
        ArrayList<QuestionDemand> questionDemandArray = new ArrayList<>();

        String demand = activity.getIntent().getStringExtra("QT");
        demand = params.getQT();
        String[] questionTables = demand.split("-");
        for(String s: questionTables) {
            String[] s1 = s.split("/");
            String startPosition = s1[1];

            String[] s2 = s1[0].split("\"");
            String questionTableName = s2[1];

            QuestionDemand questionDemand = new QuestionDemand(questionTableName, startPosition);
            questionDemandArray.add(questionDemand);
        }

        return questionDemandArray;
    }


    public ArrayList<QuestionObject> getQuestionArray(ArrayList<QuestionDemand> questionDemandArray){
        ArrayList<QuestionObject> questionArray = new ArrayList<>();

        for(QuestionDemand questionDemand : questionDemandArray)
            switch(questionDemand.getQuestionTableName()){
                case QuestionTable.TABLE_NAME:
                    questionArray.addAll(questionController.getQuestionsFromQuestionTable(questionDemand.getStartPosition()));
            }

        return questionArray;
    }

    public ArrayList<String> findingAnswers(int pageNumber){
        //this method finds answers that belong to specific question based on
        // question id of question and answer's question id
        ArrayList<String> answers = new ArrayList<>();
        int positionInArray = pageNumber;
        ArrayList<QuestionObject> questionObjectArray = getQuestionArray(getListOfQuestionTables());
        for(int i = 1; i <= answerController.getRowCount(); i++) {
            boolean answerIdEqualsQuestionId = (answerController.getRow(i).getQuestionID()).
                    equals(String.valueOf(questionObjectArray.get(positionInArray).getQuestionId()));
            if (answerIdEqualsQuestionId)
                answers.add(answerController.getRow(i).getAnswer());
        }
        return answers;
    }


}
