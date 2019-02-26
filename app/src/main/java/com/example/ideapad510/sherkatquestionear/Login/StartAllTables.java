package com.example.ideapad510.sherkatquestionear.Login;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Questionnaire.QuestionnaireController;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.QuestionsAnswersArray;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionController;
import com.example.ideapad510.sherkatquestionear.Result.ResultController;

public class StartAllTables {
    Context context;
    LoginController loginController = new LoginController(context);
    QuestionnaireController questionnaireController = new QuestionnaireController(context);
    ResultController resultController = new ResultController(context);
    DatabaseInsertMethods databaseInsertMethods = new DatabaseInsertMethods(context);

    StartAllTables(Context context){
        this.context = context;
        sampleUserPass();
        sampleQuestionnaires();
        new QuestionController(context).insertQuestionArray(new QuestionsAnswersArray());
        new AnswerController(context).insertAnswerArray(new QuestionsAnswersArray());
        sampleqltable();
    }





    private void sampleUserPass(){
        loginController.insertToDatabase("ali","123" , "code1");
        loginController.insertToDatabase("hamid","1234" , "code2");
        loginController.insertToDatabase("1","1" , "code3");

    }

    private void sampleQuestionnaires(){
        questionnaireController.insertToDatabase("پرسشنامه 1","درباره آب و هوا",
                "1:\"question1\"/1", "answer1");
        questionnaireController.insertToDatabase("پرسشنامه 2","درباره جغرافی",
                "1:\"question1\"/1", "answer1");
        questionnaireController.insertToDatabase("پرسشنامه 3","درباره سلامت",
                "1:\"question1\"/1", "answer1");
    }
/*
    private void sampleQuestionnaires(){
        questionnaireController.insertToDatabase("test1","about weather", "1:\"question1\"/1", "answer1");
        questionnaireController.insertToDatabase("test2","about geography","1:\"question1\"/1", "answer1");
        questionnaireController.insertToDatabase("test3","about health","1:\"question1\"/1", "answer1");
    }
*/


    private void sampleqltable(){
        databaseInsertMethods.insertqlTable("1-2-3","code1");
        databaseInsertMethods.insertqlTable("1","code2");
        databaseInsertMethods.insertqlTable("2-3","code3");
    }

}
