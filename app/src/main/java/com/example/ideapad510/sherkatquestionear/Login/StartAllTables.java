package com.example.ideapad510.sherkatquestionear.Login;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Questionnaire.QuestionnaireController;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionAnswerArray.QuestionsAnswersArray;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionController;
import com.example.ideapad510.sherkatquestionear.Save.SaveController;

public class StartAllTables {
    Context context;
    LoginController loginController = new LoginController(context);
    QuestionnaireController questionnaireController = new QuestionnaireController(context);
    SaveController saveController = new SaveController(context);

    StartAllTables(Context context){
        this.context = context;
        sampleUserPass();
        sampleQuestionnaires();
        new QuestionController(context).insertQuestionArray(new QuestionsAnswersArray());
        new AnswerController(context).insertAnswerArray(new QuestionsAnswersArray());
//        sampleResults();
    }





    private void sampleUserPass(){
        loginController.insertToDatabase("ali","123" , "1");
        loginController.insertToDatabase("hamid","1234" , "2");
        loginController.insertToDatabase("1","1" , "3");

    }

    private void sampleQuestionnaires(){
        questionnaireController.insertToDatabase("test1","about weather", "1:\"question1\"/1", "answer1");
        questionnaireController.insertToDatabase("test2","about geography","1:\"question1\"/1", "answer1");
        questionnaireController.insertToDatabase("test3","about health","1:\"question1\"/1", "answer1");
    }

    private void sampleResults(){
        saveController.insertToDatabase("1","2","3","1" ,"false");
        saveController.insertToDatabase("1","3","3","1", "false");
        saveController.insertToDatabase("1","4","3","1", "false");
    }
}
